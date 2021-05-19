/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import static dao.DAO.con;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Ca;
import model.Canhanvien;
import model.Chucvu;
import model.Nhanvien;
import model.Phongban;

/**
 *
 * @author Administrator
 */
public class CanhanvienDAO extends DAO{

    public CanhanvienDAO() {
        super();
    }
    public ArrayList<Canhanvien> getListCanhanvien(String tennv, Date date){
        ArrayList<Canhanvien> listCanhanvien=null;
        String sql="SELECT * FROM canhanvien,ca,nhanvien,chucvu,phongban WHERE canhanvien.ngay=? "
                + " AND canhanvien.nhanvienid=nhanvien.id AND canhanvien.caid=ca.id"
                + " AND INSTR(nhanvien.hoten,?) AND nhanvien.chucvuid=chucvu.id AND nhanvien.phongbanid=phongban.id";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1,date);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(listCanhanvien==null){
                    listCanhanvien=new ArrayList<>();
                }
                Chucvu cv = new Chucvu();
                cv.setId(rs.getInt("chucvu.id"));
                cv.setTen(rs.getString("chucvu.ten"));
                Phongban pb = new Phongban();
                pb.setId(rs.getInt("phongban.id"));
                pb.setTen(rs.getString("phongban.ten"));
                Nhanvien nv = new Nhanvien();
                nv.setId(rs.getInt("nhanvien.id"));
                nv.setSdt(rs.getString("nhanvien.sdt"));
                nv.setChucvu(cv);
                nv.setPhongban(pb);
                Ca c = new Ca();
                c.setId(rs.getInt("ca.id"));
                c.setTen(rs.getString("ca.ten"));
                Canhanvien canv = new Canhanvien();
                canv.setCong(rs.getFloat("canhanvien.tinhcong"));
                canv.setCa(c);
                canv.setDen(rs.getTime("canhanvien.gioden"));
                canv.setVe(rs.getTime("canhanvien.giove"));
                canv.setId(rs.getInt("canhanvien.id"));
                canv.setNghiphep(rs.getBoolean("canhanvien.nghiphep"));
                canv.setPheduyet(rs.getBoolean("canhanvien.pheduyet"));
                listCanhanvien.add(canv);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listCanhanvien;
    }
    
    public boolean addCanhanvien(Canhanvien canv){
        String sql ="INSERT INTO canhanvien(caid,nhanvienid,ngay,gioden,giove,tinhcong,nghiphep,pheduyet)"
                + " values(?,?,?,?,?,?,?,?)";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, canv.getCa().getId());
            ps.setInt(2, canv.getNhanvien().getId());
            ps.setDate(3, canv.getNgay());
            ps.setTime(4,canv.getCa().getGiobd());
            ps.setTime(5, canv.getCa().getGiokt());
            ps.setFloat(6, canv.getCa().getSocong());
            ps.setBoolean(7, false);
            ps.setBoolean(8, false);
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
    
    public boolean updateChamcong(Canhanvien canv){
        String sql = "UPDATE canhanvien SET gioden=?,giove=?,tinhcong=? WHERE id = ?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps  = con.prepareStatement(sql);
            ps.setTime(1,canv.getCa().getGiobd());
            ps.setTime(2, canv.getCa().getGiokt());
            ps.setFloat(3, canv.getCa().getSocong());
            ps.setInt(4,canv.getId());
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
    
    public boolean deleteCanhanvien(Canhanvien canv){
        String sql ="DELETE FROM canhanvien WHERE id = ?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, canv.getId());
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
