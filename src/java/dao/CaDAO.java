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
import model.Ca;

/**
 *
 * @author Administrator
 */
public class CaDAO extends DAO{

    public CaDAO() {
        super();
    }
    public ArrayList<Ca> getListCa(String ten){
        ArrayList<Ca> listCa=null;
        String sql="SELECT * FROM ca WHERE INSTR(ten,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(listCa==null){
                    listCa=new ArrayList<>();
                }
                Ca c = new Ca();
                c.setCodinh(rs.getBoolean("codinh"));
                c.setTen(rs.getString("ten"));
                c.setGiobd(rs.getTime("giobd"));
                c.setGiokt(rs.getTime("giokt"));
                c.setId(rs.getInt("id"));
                c.setSocong(rs.getFloat("socong"));
                c.setT2(rs.getBoolean("t2"));
                c.setT3(rs.getBoolean("t3"));
                c.setT4(rs.getBoolean("t4"));
                c.setT5(rs.getBoolean("t5"));
                c.setT6(rs.getBoolean("t6"));
                c.setT7(rs.getBoolean("t7"));
                c.setCn(rs.getBoolean("cn"));
                listCa.add(c);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listCa;
    }
    
    
    public boolean addCa(Ca c){
        String sql ="INSERT INTO ca(ten,socong,giobd,giokt,codinh,t2,t3,t4,t5,t6,t7,cn)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getTen());
            ps.setFloat(2, c.getSocong());
            ps.setTime(3,c.getGiobd());
            ps.setTime(4,c.getGiokt());
            ps.setBoolean(5, c.isCodinh());
            ps.setBoolean(6,c.isT2());
            ps.setBoolean(7,c.isT3());
            ps.setBoolean(8,c.isT4());
            ps.setBoolean(9,c.isT5());
            ps.setBoolean(10,c.isT6());
            ps.setBoolean(11,c.isT7());
            ps.setBoolean(12,c.isCn());
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
    
    public boolean updateCa(Ca c){
        String sql = "UPDATE ca SET ten=?,socong=?,giobd=?,giokt=?,codinh=?,t2=?,t3=?,t4=?,t5=?,"
                + "t6=?,t7=?,cn=? WHERE id = ?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps  = con.prepareStatement(sql);
            ps.setString(1, c.getTen());
            ps.setFloat(2, c.getSocong());
            ps.setTime(3,c.getGiobd());
            ps.setTime(4,c.getGiokt());
            ps.setBoolean(5, c.isCodinh());
            ps.setBoolean(6,c.isT2());
            ps.setBoolean(7,c.isT3());
            ps.setBoolean(8,c.isT4());
            ps.setBoolean(9,c.isT5());
            ps.setBoolean(10,c.isT6());
            ps.setBoolean(11,c.isT7());
            ps.setBoolean(12,c.isCn());
            ps.setInt(13, c.getId());
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
    
    public boolean deleteCa(Ca c){
        String sql ="DELETE FROM ca WHERE id = ?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId());
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
