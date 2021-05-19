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
import model.BangKPI;
import model.Bangluong;
import model.Chinhanh;
import model.Chucvu;
import model.Nhanvien;
import model.Phieuluong;
import model.Phongban;

/**
 *
 * @author Administrator
 */
public class BangluongDAO extends DAO{

    public BangluongDAO() {
        super();
    }
    
    public ArrayList<Bangluong> getListBangluong(String ten){
        ArrayList<Bangluong> listBangluong=null;
        String sql="SELECT * FROM bangluong,chinhanh WHERE INSTR(bangluong.ten,?)"
                + " AND bangluong.chinhanhid=chinhanh.id";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(listBangluong==null){
                    listBangluong=new ArrayList<>();
                }
                Bangluong bl = new Bangluong();
                Chinhanh cn = new Chinhanh();
                cn.setTen(rs.getString("chinhanh.ten"));
                cn.setId(rs.getInt("chinhanh.id"));
                bl.setChinhanh(cn);
                bl.setTen(rs.getString("bangluong.ten"));
                bl.setId(rs.getInt("bangluong.id"));
                bl.setNgaybd(rs.getDate("bangluong.ngaybd"));
                bl.setNgaykt(rs.getDate("bangluong.ngaykt"));
                bl.setQuythuong(rs.getFloat("bangluong.quythuong"));
                listBangluong.add(bl);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listBangluong;
    }
    
    public boolean addBangluong(Bangluong bl){
        String sql ="INSERT INTO bangluong(ten,ngaybd,ngaykt,quythuong,chinhanhid) values(?,?,?,?,?)";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bl.getTen());
            ps.setDate(2, bl.getNgaybd());
            ps.setDate(3, bl.getNgaykt());
            ps.setDouble(4, bl.getQuythuong());
            ps.setInt(5, bl.getChinhanh().getId());
            int r = ps.executeUpdate();
            if(r<1){
                con.rollback();
                return false;
            }
            //lay id 
            String sql1 ="SELECT id FROM bangluong WHERE ten=? AND ngaybd=? "
                    + " AND ngaykt=? AND quythuong=? AND chinhanhid=?";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps.setString(1, bl.getTen());
            ps.setDate(2, bl.getNgaybd());
            ps.setDate(3, bl.getNgaykt());
            ps.setDouble(4, bl.getQuythuong());
            ps.setInt(5, bl.getChinhanh().getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                bl.setId(rs.getInt("id"));
            }
            // them bangkpi
            String sql2 = "UPDATE bangkpi SET bangluongid=?,dasudung=true WHERE id=?";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, bl.getId());
            ArrayList<BangKPI> listBangkpi = bl.getListBangKPI();
            int s = listBangkpi.size();
            for(int i=0; i<s; i++){
                ps2.setInt(2, listBangkpi.get(i).getId());
                int r1 = ps2.executeUpdate();
                if(r1<1){
                    con.rollback();
                    return false;
                }
            }
            //lay phieu luong
            String sql3 ="SELECT nhanvien.id,nhanvien.phongbanid,nhanvien.chucvuid,nhanvien.bacluongid,bacluong.sotien,"
                    + "sum(canhanvien.tinhcong) as socong, avg(danhgiakpi.diemtb) as kpi"
                    + " FROM nhanvien,canhanvien,danhgiakpi,bangkpi WHERE nhanvien.chinhanhid=?"
                    + " AND nhanvien.id=canhanvien.nhanvienid AND nhanvien.id=danhgiakpi.nhanvienid"
                    + " AND danhgiakpi.bangkpiid=bangkpi.id AND bangkpi.bangluongid=?"
                    + " GROUP BY (nhanvien.id,nhanvien.phongbanid,nhanvien.chucvuid,nhanvien.bacluongid,bacluong.sotien)";
            PreparedStatement ps3 = con.prepareStatement(sql3);
            ps3.setInt(1, bl.getChinhanh().getId());
            ps3.setInt(2, bl.getId());
            ResultSet rs1 = ps3.executeQuery();
            ArrayList<Phieuluong> listPhieuluong = null;
            while(rs1.next()){
                if(listPhieuluong==null){
                    listPhieuluong= new ArrayList<>();
                }
                Phieuluong pl = new Phieuluong();
                Bacluong bacluong = new Bacluong();
                bacluong.setId(rs.getInt("nhanvien.bacluongid"));
                bacluong.setMucluong(rs.getFloat("bacluong.sotien"));
                Phongban pb = new Phongban();
                pb.setId(rs.getInt("nhanvien.phongbanid"));
                Chucvu cv = new Chucvu();
                cv.setId(rs.getInt("nhanvien.chucvuid"));
                Nhanvien nv = new Nhanvien();
                nv.setId(rs.getInt("nhanvien.id"));
                pl.setBacluong(bacluong);
                pl.setPhongban(pb);
                pl.setChucvu(cv);
                pl.setNhanvien(nv);
                pl.setSocong(rs.getFloat("socong"));
                pl.setKpi(rs.getFloat("kpi"));
                pl.setTienthuong(pl.getKpi()*bl.getQuythuong());
                float thanhtien = pl.getBacluong().getMucluong()*pl.getSocong()/30+pl.getTienthuong();
                pl.setThanhtien(thanhtien);
                listPhieuluong.add(pl);
            }
            bl.setListPhieuluong(listPhieuluong);
            //luu phieu luongs
            String sql4 = "INSERT INTO phieuluong(bangluongid,nhanvienid,phongbanid,chucvuid,bacluongid,socong,kpi,tienthuong,thanhtien)"
                    + " VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps4 = con.prepareStatement(sql4);
            ps4.setInt(1, bl.getId());
            s = listPhieuluong.size();
            for(int i=0;i<s;i++){
                Phieuluong pl1 = listPhieuluong.get(i);
                ps4.setInt(2, pl1.getNhanvien().getId());
                ps4.setInt(3, pl1.getPhongban().getId());
                ps4.setInt(4, pl1.getChucvu().getId());
                ps4.setInt(5, pl1.getBacluong().getId());
                ps4.setFloat(6, pl1.getSocong());
                ps4.setFloat(7,pl1.getKpi());
                ps4.setFloat(8,pl1.getTienthuong());
                ps4.setFloat(9,pl1.getThanhtien());
                int r1 = ps4.executeUpdate();
                if(r1<1){
                    con.rollback();
                    return false;
                }
                con.commit();
                return true;
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
    
    public boolean deleteBangluong(Bangluong bl){
        String sql ="DELETE FROM phieuluong WHERE bangluongid = ?";
        String sql1 = "UPDATE bangkpi SET bangluongid=null WHERE bangluongid=?";
        String sql2 = "DELETE FROM bangluong WHERE id=?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bl.getId());
            int r = ps.executeUpdate();
            if(r<1){
                con.rollback();
                return false;
            }
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, bl.getId());
            r = ps1.executeUpdate();
            if(r<1){
                con.rollback();
                return false;
            }
            
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, bl.getId());
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
