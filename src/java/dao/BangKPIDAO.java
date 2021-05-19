/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.BangKPI;
import model.CotKPI;

/**
 *
 * @author Administrator
 */
public class BangKPIDAO extends DAO{
    //Ham 1: Lay ds bangkpi
    //Ham 2: Them bangkpi (khong co cot, hang)
    //Ham4: Sua bangkpi (khong sua hang, cot)
    public BangKPIDAO() {
        super();
    }
    public ArrayList<BangKPI> getListBangKPI(String ten){
        ArrayList<BangKPI> listBangKPI=null;
        String sql="SELECT * FROM bangKPI WHERE INSTR(ten,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(listBangKPI==null){
                    listBangKPI=new ArrayList<>();
                }
                BangKPI b = new BangKPI();
                b.setDaChot(rs.getBoolean("dachot"));
                b.setId(rs.getInt("id"));
                b.setTen(rs.getString("ten"));
                b.setDaSudung(rs.getBoolean("dasudung"));
                listBangKPI.add(b);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listBangKPI;
    }
    
    public boolean addBangKPI(BangKPI b){
        String sql ="INSERT INTO bangkpi(ten,dachot,dasudung) values(?,false,false)";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, b.getTen());
            int r = ps.executeUpdate();
            if(r<1){
                con.rollback();
                return false;
            }
            con.commit();
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            try{
                con.rollback();
            }catch(SQLException ex2){
                ex2.printStackTrace();
            }
        }
        return false;
    }
    
    public boolean updateBangKPI(BangKPI b){
        String sql = "UPDATE bangkpi SET ten=?,dachot=? WHERE id = ?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps  = con.prepareStatement(sql);
            ps.setString(1, b.getTen());
            ps.setBoolean(2, b.isDaChot());
            ps.setInt(3, b.getId());
            int r = ps.executeUpdate();
            if(r==1){
                con.commit();
                return true;
            }else{
                con.rollback();
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
            try{
                con.rollback();
            }catch(SQLException ex2){
                ex2.printStackTrace();
            }
        }
        return false;
    }
    
    public boolean deleteBangKPI(BangKPI b){
        String sql ="DELETE FROM bangkpi WHERE id = ? AND bangluongid is null";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, b.getId());
            int r = ps.executeUpdate();
            if(r==1){
                con.commit();
                return true;
            }else{
                con.rollback();
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            try{
                con.rollback();
            }catch(SQLException ex2){
                ex2.printStackTrace();
            }
        }
        return false;
    }
}
