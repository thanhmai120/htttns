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
import model.DanhgiaKPI;
/**
 *
 * @author Administrator
 */
public class CotKPIDAO {
    //Ham 1: Them cot (them cac diem tuongung)
    //Ham 2: Xoa cot (xoa diem tuong ung)
    //Ham 3: Sua cot (Sua ten, donvi, hs, chitieu,khong co diem)
    //Lay danh sach cot kpi cua bang kpi
    public ArrayList<CotKPI> getListCotKPI(BangKPI b){
        ArrayList<CotKPI> listCot=null;
        String sql="SELECT * FROM cot WHERE bangkpiid=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,b.getId() );
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(listCot==null){
                    listCot=new ArrayList<>();
                }
                CotKPI cot = new CotKPI();
                cot.setChitieu(rs.getInt("chitieu"));
                cot.setDonvi(rs.getString("donvi"));
                cot.setHeso(rs.getFloat("heso"));
                cot.setId(rs.getInt("id"));
                cot.setTen(rs.getString("ten"));
                listCot.add(cot);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listCot;
    }
    
    public boolean addCotKPI(CotKPI cot,BangKPI b){
        String sql ="INSERT INTO cotkpi(bangkpiid,chitieu,heso,ten,donvi) values(?,?,?,?,?)";
        String sql1="SELECT id FROM cot WHERE bangkpiid=? AND chitieu=? AND heso=? AND ten=? AND donvi=?";
        String sql2 = "INSERT INTO diemkpi(cotkpiid,danhgiakpiid,giatri) VALUES(?,?,0)";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, b.getId());
            ps.setInt(2, cot.getChitieu());
            ps.setFloat(3, cot.getHeso());
            ps.setString(4, cot.getTen());
            ps.setString(5,cot.getDonvi());
            int r = ps.executeUpdate();
            if(r<1){
                con.rollback();
                return false;
            }
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, b.getId());
            ps1.setInt(2, cot.getChitieu());
            ps1.setFloat(3, cot.getHeso());
            ps1.setString(4, cot.getTen());
            ps1.setString(5,cot.getDonvi());
            ResultSet rs = ps1.executeQuery();
            while(rs.next()){
                cot.setId(rs.getInt("id"));
            }
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ArrayList<DanhgiaKPI> listDanhgia = b.getListDanhgia();
            int s =listDanhgia.size();
            for(int i=0;i<s;i++){
                ps2.setInt(1, cot.getId());
                ps2.setInt(2, listDanhgia.get(i).getId());
                r = ps2.executeUpdate();
                if(r<1){
                    con.rollback();
                    return false;
                }
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
    public boolean updateCotKPI(CotKPI cot){
        String sql = "UPDATE cotkpi SET chitieu=?,heso=?,ten=?,donvi=? WHERE id = ?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps  = con.prepareStatement(sql);
            ps.setInt(1, cot.getChitieu());
            ps.setFloat(2, cot.getHeso());
            ps.setString(3, cot.getTen());
            ps.setString(4,cot.getDonvi());
            ps.setInt(5, cot.getId());
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
    
    public boolean deleteCotKPI(CotKPI cot){
        String sql ="DELETE FROM diemkpi WHERE cotkpiid = ?";
        String sql1 = "DELETE FROM cotkpi WHERE id=?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cot.getId());
            int r = ps.executeUpdate();
            if(r<1){
                con.rollback();
                return false;
            }
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, cot.getId());
            r = ps1.executeUpdate();
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
}
