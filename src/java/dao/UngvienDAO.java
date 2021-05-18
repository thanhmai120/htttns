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
import model.Ungvien;

/**
 *
 * @author Administrator
 */
public class UngvienDAO extends DAO{

    public UngvienDAO() {
        super();
    }
    public ArrayList<Ungvien> getListUngvien(String ten){
        ArrayList<Ungvien> listUngvien=null;
        String sql="SELECT * FROM ungvien,tuyendung WHERE INSTR(ten,?)AND ungvien.tuyendungid=tuyendung.id";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(listUngvien==null){
                    listUngvien=new ArrayList<>();
                }
                Tuyendung tintd = new Tuyendung();
                tintd.setId(rs.getInt("tintuyendung.id"));
                tintd.setVitri(rs.getString("tintuyendung.vitri"));
                Ungvien uv = new Ungvien();
                uv.setId(rs.getInt("ungvien.id"));
                uv.setGiaidoan(rs.getString("ungvien.giaidoan"));
                uv.setTen(rs.getString("ungvien.ten"));
                uv.setTuyendung(tintd);
                uv.setDc(rs.getString("ungvien.dc"));
                uv.setSdt(rs.getString("ungvien.sdt"));
                uv.setEmail(rs.getString("ungvien.email"));
                listUngvien.add(uv);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listUngvien;
    }
    
    public ArrayList<Ungvien> getListUngvienTuyendung(String ten,int tuyendungid){
        ArrayList<Ungvien> listUngvien=null;
        String sql="SELECT * FROM ungvien,tuyendung WHERE INSTR(ten,?)AND ungvien.tuyendungid=tuyendung.id"
                +" AND tuyendung.id=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ps.setInt(2, tuyendungid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(listUngvien==null){
                    listUngvien=new ArrayList<>();
                }
                Tuyendung tintd = new Tuyendung();
                tintd.setId(rs.getInt("tintuyendung.id"));
                tintd.setVitri(rs.getString("tintuyendung.vitri"));
                Ungvien uv = new Ungvien();
                uv.setId(rs.getInt("ungvien.id"));
                uv.setGiaidoan(rs.getString("ungvien.giaidoan"));
                uv.setTen(rs.getString("ungvien.ten"));
                uv.setTuyendung(tintd);
                uv.setDc(rs.getString("ungvien.dc"));
                uv.setSdt(rs.getString("sdt"));
                uv.setEmail(rs.getString("email"));
                listUngvien.add(uv);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listUngvien;
    }
    
    public boolean addUngvien(Ungvien uv){
        String sql ="INSERT INTO ungvien(ten,sdt,dc,email,giaidoan,tuyendungid) values(?,?,?,?,?,?)";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, uv.getTen());
            ps.setString(2, uv.getSdt());
            ps.setString(3, uv.getDc());
            ps.setString(4, uv.getEmail());
            ps.setString(5, uv.getGiaidoan());
            ps.setInt(6, uv.getTuyendung().getId());
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
    
    public boolean updateUngvien(Ungvien uv){
        String sql = "UPDATE ungvien SET ten=?, dc=?, sdt=?, email=?, giaidoan=?, tuyendungid=? WHERE id = ?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps  = con.prepareStatement(sql);
            ps.setString(1, uv.getTen());
            ps.setString(2, uv.getSdt());
            ps.setString(3, uv.getDc());
            ps.setString(4, uv.getEmail());
            ps.setString(5, uv.getGiaidoan());
            ps.setInt(6, uv.getTuyendung().getId());
            ps.setInt(7, uv.getId());
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
    
    public boolean deleteUngvien(Ungvien uv){
        String sql ="DELETE FROM ungvien WHERE id = ?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, uv.getId());
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
