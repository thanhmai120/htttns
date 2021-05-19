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
import model.Bacluong;
import model.Bangluong;
import model.Chucvu;
import model.Nhanvien;
import model.Phieuluong;
import model.Phongban;

/**
 *
 * @author Administrator
 */
public class PhieuluongDAO extends DAO{

    public PhieuluongDAO() {
        super();
    }
    public ArrayList<Phieuluong> getListPhieuluong(Bangluong bl){
        ArrayList<Phieuluong> listPhieuluong=null;
        String sql="SELECT * FROM phieuluong,bacluong,phongban,chucvu,nhanvien"
                + " WHERE phieuluong.nhanvienid=nhanvien.id AND phieuluong.bacluongid=bacluong.id"
                + " AND phieuluong.phongbanid=phongban.id AND phieuluong.chucvuid=chucvu.id"
                + " AND phieuluong.bangluongid=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bl.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(listPhieuluong==null){
                    listPhieuluong=new ArrayList<>();
                }
                Bacluong bacluong = new Bacluong();
                bacluong.setMucluong(rs.getFloat("bacluong.sotien"));
                Phongban pb = new Phongban();
                pb.setTen(rs.getString("phongban.ten"));
                Chucvu cv = new Chucvu();
                cv.setTen(rs.getString("chucvu.ten"));
                Nhanvien nv = new Nhanvien();
                nv.setDc(rs.getString("nhanvien.dc"));
                nv.setSdt(rs.getString("nhanvien.sdt"));
                nv.setEmail(rs.getString("nhanvien.email"));
                nv.setHoten(rs.getString("nhanvien.hoten"));
                nv.setId(rs.getInt("nhanvien.id"));
                nv.setCongviec(rs.getString("nhanvien.congviec"));
                nv.setTrinhdo(rs.getString("nhanvien.trinhdo"));
                Phieuluong pl = new Phieuluong();
                pl.setId(rs.getInt("phieuluong.id"));
                pl.setKpi(rs.getFloat("phieuluong.kpi"));
                pl.setSocong(rs.getFloat("phieuluong.socong"));
                pl.setTienthuong(rs.getFloat("phieuluong.tienthuong"));
                pl.setThanhtien(rs.getFloat("phieuluong.thanhtien"));
                pl.setBacluong(bacluong);
                pl.setChucvu(cv);
                pl.setNhanvien(nv);
                pl.setPhongban(pb);
                listPhieuluong.add(pl);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listPhieuluong;
    }
}
