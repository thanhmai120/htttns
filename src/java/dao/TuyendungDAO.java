/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Tuyendung;

/**
 *
 * @author Administrator
 */
public class TuyendungDAO extends DAO{

    public TuyendungDAO() {
        super();
    }
    public ArrayList<Tuyendung> getListTuyendung(String ten){
        ArrayList<Tuyendung> listTuyendung = null;
        String sql ="SELECT * FROM tuyendung WHERE INSTR(vitri,?)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(listTuyendung == null){
                    listTuyendung = new ArrayList<>();
                }
                Tuyendung tintd = new Tuyendung();
                if(rs.getDate("han")==null){
                    tintd.setHan(rs.getDate("han"));
                }
                tintd.setId(rs.getInt("id"));
                if(rs.getString("motayc")==null){
                    tintd.setMotayc(rs.getString("motayc"));
                }
                tintd.setSoluong(rs.getInt("soluong"));
                tintd.setVitri(rs.getString("vitri"));
                listTuyendung.add(tintd);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listTuyendung;
    }
    
    public boolean updateTuyendung(Tuyendung tintd){
        String sql = "UPDATE tuyendung SET vitri=?, soluong=?, motayc=?, han=? WHERE id = ?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps  = con.prepareStatement(sql);
            ps.setString(1,tintd.getVitri());
            ps.setInt(2,tintd.getSoluong());
            ps.setString(3, tintd.getMotayc());
            ps.setDate(4, tintd.getHan());
            ps.setInt(5,tintd.getId());
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
    
    public boolean addTuyendung(Tuyendung tintd){
        String sql ="INSERT INTO tuyendung(vitri,soluong,motayc,han) values(?,?,?,?)";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tintd.getVitri());
            ps.setInt(2, tintd.getSoluong());
            ps.setString(3, tintd.getMotayc());
            ps.setDate(4, tintd.getHan());
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
    
    public boolean deleteTuyendung(Tuyendung tintd){
        String sql ="DELETE FROM tuyendung WHERE id = ?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, tintd.getId());
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
