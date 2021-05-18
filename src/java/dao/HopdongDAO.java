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
import model.Hopdong;
import model.Nhanvien;

/**
 *
 * @author Administrator
 */
public class HopdongDAO extends DAO{

    public HopdongDAO() {
        super();
    }
    
    public ArrayList<Hopdong> getListHopdong(String ten){
        ArrayList<Hopdong> listHopdong=null;
        String sql="SELECT * FROM hopdong,nhanvien WHERE INSTR(hopdong.so,?) OR INSTR(nhanvien.hoten,?)"
                + " AND hopdong.nhanvienid=nhanvien.id";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ps.setString(2, ten);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(listHopdong==null){
                    listHopdong=new ArrayList<>();
                }
                Nhanvien nv = new Nhanvien();
                nv.setDc(rs.getString("nhanvien.dc"));
                nv.setSdt(rs.getString("nhanvien.sdt"));
                nv.setEmail(rs.getString("nhanvien.email"));
                nv.setHoten(rs.getString("nhanvien.hoten"));
                nv.setId(rs.getInt("nhanvien.id"));
                nv.setCongviec(rs.getString("nhanvien.congviec"));
                nv.setTrinhdo(rs.getString("nhanvien.trinhdo"));
                Hopdong hd = new Hopdong();
                hd.setHethan(rs.getDate("hopdong.hethan"));
                hd.setId(rs.getInt("hopdong.id"));
                hd.setNgayky(rs.getDate("hopdong.ngayky"));
                hd.setNoidung(rs.getString("hopdong.noidung"));
                hd.setNv(nv);
                hd.setSohd(rs.getString("hopdong.so"));
                listHopdong.add(hd);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listHopdong;
    }
    
    public boolean addHopdong(Hopdong hd){
        String sql ="INSERT INTO hopdong(so,ngayky,hethan,noidung,nhanvienid) values(?,?,?,?,?)";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, hd.getSohd());
            ps.setDate(2, hd.getNgayky());
            ps.setDate(3, hd.getHethan());
            ps.setString(4, hd.getNoidung());
            ps.setInt(5, hd.getNv().getId());
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
    
    public boolean updateHopdong(Hopdong hd){
        String sql = "UPDATE hopdong SET so=?,ngayky=?,hethan=?,noidung=?,nhanvienid=? WHERE id = ?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps  = con.prepareStatement(sql);
            ps.setString(1, hd.getSohd());
            ps.setDate(2, hd.getNgayky());
            ps.setDate(3, hd.getHethan());
            ps.setString(4, hd.getNoidung());
            ps.setInt(5, hd.getNv().getId());
            ps.setInt(6, hd.getId());
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
    
    public boolean deleteHopdong(Hopdong hd){
        String sql ="DELETE FROM ungvien WHERE id = ?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, hd.getId());
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
        HopdongDAO d = new HopdongDAO();
        ArrayList<Hopdong> list = d.getListHopdong("mai");
        Hopdong hd = list.get(0);
        boolean success = d.updateHopdong(hd);
        System.out.println(success);
        
    }
}
