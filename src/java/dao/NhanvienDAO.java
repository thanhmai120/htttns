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
import model.Bacluong;
import model.Chinhanh;
import model.Chucvu;
import model.Nhanvien;
import model.Phongban;

/**
 *
 * @author Administrator
 */
public class NhanvienDAO extends DAO{

    public NhanvienDAO() {
        super();
    }
    public boolean kiemtraDangnhap(Nhanvien nv){
        String sql ="SELECT * FROM nhanvien,chucvu,phongban,bacluong,chinhanh WHERE tdn = ? AND mk = ?"
                +" AND nhanvien.chucvuid=chucvu.id AND nhanvien.phongbanid=phongban.id AND nhanvien.bacluongid=bacluong.id"
                +" AND nhanvien.chinhanhid = chinhanh.id";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getTdn());
            ps.setString(2, nv.getMk());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Chucvu cv = new Chucvu();
                cv.setId(rs.getInt("chucvu.id"));
                cv.setTen(rs.getString("chucvu.ten"));
                Phongban pb = new Phongban();
                pb.setId(rs.getInt("phongban.id"));
                pb.setTen(rs.getString("phongban.ten"));
                Bacluong bl = new Bacluong();
                bl.setId(rs.getInt("bacluong.id"));
                bl.setMucluong(rs.getFloat("bacluong.sotien"));
                Chinhanh cn = new Chinhanh();
                cn.setId(rs.getInt("chinhanh.id"));
                cn.setTen(rs.getString("chinhanh.ten"));
                nv.setDc(rs.getString("nhanvien.dc"));
                nv.setSdt(rs.getString("nhanvien.sdt"));
                nv.setEmail(rs.getString("nhanvien.email"));
                nv.setHoten(rs.getString("nhanvien.hoten"));
                nv.setId(rs.getInt("nhanvien.id"));
                nv.setCongviec(rs.getString("nhanvien.congviec"));
                nv.setTrinhdo(rs.getString("nhanvien.trinhdo"));
                nv.setChucvu(cv);
                nv.setPhongban(pb);
                nv.setBacluong(bl);
                nv.setChinhanh(cn);
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<Nhanvien> getListNhanvien(String ten){
        ArrayList<Nhanvien> listNhanvien=null;
        String sql ="SELECT * FROM nhanvien,chucvu,phongban,bacluong,chinhanh WHERE INSTR(nhanvien.hoten,?)"
                +" AND nhanvien.chucvuid=chucvu.id AND nhanvien.phongbanid=phongban.id AND nhanvien.bacluongid=bacluong.id"
                +" AND nhanvien.chinhanhid = chinhanh.id";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(listNhanvien==null){
                    listNhanvien=new ArrayList<>();
                }
                Nhanvien nv = new Nhanvien();
                Chucvu cv = new Chucvu();
                cv.setId(rs.getInt("chucvu.id"));
                cv.setTen(rs.getString("chucvu.ten"));
                Phongban pb = new Phongban();
                pb.setId(rs.getInt("phongban.id"));
                pb.setTen(rs.getString("phongban.ten"));
                Bacluong bl = new Bacluong();
                bl.setId(rs.getInt("bacluong.id"));
                bl.setMucluong(rs.getFloat("bacluong.sotien"));
                Chinhanh cn = new Chinhanh();
                cn.setId(rs.getInt("chinhanh.id"));
                cn.setTen(rs.getString("chinhanh.ten"));
                nv.setDc(rs.getString("nhanvien.dc"));
                nv.setSdt(rs.getString("nhanvien.sdt"));
                nv.setEmail(rs.getString("nhanvien.email"));
                nv.setHoten(rs.getString("nhanvien.hoten"));
                nv.setId(rs.getInt("nhanvien.id"));
                nv.setCongviec(rs.getString("nhanvien.congviec"));
                nv.setTrinhdo(rs.getString("nhanvien.trinhdo"));
                nv.setChucvu(cv);
                nv.setPhongban(pb);
                nv.setBacluong(bl);
                nv.setChinhanh(cn);
                listNhanvien.add(nv);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listNhanvien;
    }
    
    public boolean addNhanvien(Nhanvien nv){
        String sql ="INSERT INTO nhanvien(hoten,sdt,dc,email,tdn,mk,trinhdo,congviec,phongbanid,chucvuid,bacluongid,chinhanhid)"
                + " values(?,?,?,?,?,?)";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getHoten());
            ps.setString(2, nv.getSdt());
            ps.setString(3, nv.getDc());
            ps.setString(4, nv.getEmail());
            ps.setString(5, nv.getTdn());
            ps.setString(6, nv.getMk());
            ps.setString(7, nv.getTrinhdo());
            ps.setString(8,nv.getCongviec());
            ps.setInt(9,nv.getPhongban().getId());
            ps.setInt(10, nv.getChucvu().getId());
            ps.setInt(11,nv.getBacluong().getId());
            ps.setInt(12,nv.getChinhanh().getId());
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
    
    public boolean updateUngvien(Nhanvien nv){
        String sql = "UPDATE nhanvien SET hoten=?,sdt=?,dc=?,email=?,tdn=?,mk=?,trinhdo=?,"
                + "congviec=?,phongbanid=?,"
                + "chucvuid=?,bacluongid=?,chinhanhid=? WHERE id = ?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps  = con.prepareStatement(sql);
            ps.setString(1, nv.getHoten());
            ps.setString(2, nv.getSdt());
            ps.setString(3, nv.getDc());
            ps.setString(4, nv.getEmail());
            ps.setString(5, nv.getTdn());
            ps.setString(6, nv.getMk());
            ps.setString(7, nv.getTrinhdo());
            ps.setString(8,nv.getCongviec());
            ps.setInt(9,nv.getPhongban().getId());
            ps.setInt(10, nv.getChucvu().getId());
            ps.setInt(11,nv.getBacluong().getId());
            ps.setInt(12,nv.getChinhanh().getId());
            ps.setInt(13, nv.getId());
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
    
    public boolean deleteNhanvien(Nhanvien nv){
        String sql ="DELETE FROM nhanvien WHERE id = ?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nv.getId());
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
    
    public static void main(String[] args) {
        Nhanvien nv = new Nhanvien();
        nv.setMk("nhanvien1");
        nv.setTdn("nhanvien1");
        System.out.println(new NhanvienDAO().kiemtraDangnhap(nv));
        System.out.println(nv.getId());
    }
}
