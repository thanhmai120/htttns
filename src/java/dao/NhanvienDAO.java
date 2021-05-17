/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Bacluong;
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
        String sql ="SELECT * FROM nhanvien,chucvu,phongban,bacluong WHERE tdn = ? AND mk = ?"
                +" AND nhanvien.chucvuid=chucvu.id AND nhanvien.phongbanid=phongban.id AND nhanvien.bacluongid=bacluong.id";
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
                nv.setDc(rs.getString("nhanvien.dc"));
                nv.setEmail(rs.getString("nhanvien.email"));
                nv.setHoten(rs.getString("nhanvien.hoten"));
                nv.setId(rs.getInt("nhanvien.id"));
                nv.setCongviec(rs.getString("nhanvien.congviec"));
                nv.setTrinhdo(rs.getString("nhanvien.trinhdo"));
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) {
        Nhanvien nv = new Nhanvien();
        nv.setMk("mai");
        nv.setTdn("mai");
        System.out.println(new NhanvienDAO().kiemtraDangnhap(nv));
        System.out.println(nv.getId());
    }
}
