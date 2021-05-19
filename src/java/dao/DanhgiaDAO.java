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
import model.Chucvu;
import model.CotKPI;
import model.DanhgiaKPI;
import model.DiemKPI;
import model.Nhanvien;
import model.Phongban;

/**
 *
 * @author Administrator
 */
public class DanhgiaDAO extends DAO{
//lay danh sach danh gia kpi cua bang kpi
//them danhgia(diem lien quan- them danh gia nv)
//xoa danh gia(diem lien quan)
//sua danh gia(diem lien quan)
    public DanhgiaDAO() {
        super();
    }
    
    public ArrayList<DanhgiaKPI> getListDanhgia(BangKPI b){
        ArrayList<DanhgiaKPI> listDanhgia=null;
        String sql="SELECT danhgia.id,nhanvien.hoten,chucvu.ten,phongban.ten, "
                + " sum(diemkpi.giatri*cotkpi.heso/cotkpi.chitieu) AS diemtb"
                + " FROM danhgiakpi,nhanvien,chucvu,phongban,diemkpi,cotkpi WHERE danhgiakpi.bangkpiid=? AND "
                + " danhgiakpi.nhanvienid=nhanvien.id AND nhanvien.chucvuid=chucvu.id AND "
                + " nhanvien.phongbanid=phongban.id  AND danhgiakpi.id=diemkpi.danhgiakpiid"
                + " AND diemkpi.cotkpiid=cotkpi.id GROUP BY(danhgia.id,nhanvien.hoten,chucvu.ten,phongban.ten)";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,b.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(listDanhgia==null){
                    listDanhgia=new ArrayList<>();
                }
                Chucvu cv = new Chucvu();
                cv.setTen(rs.getString("chucvu.ten"));
                Phongban pb = new Phongban();
                pb.setTen(rs.getString("phongban.ten"));
                Nhanvien nv = new Nhanvien();
                nv.setHoten(rs.getString("nhanvien.hoten"));
                nv.setChucvu(cv);
                nv.setPhongban(pb);
                DanhgiaKPI dg = new DanhgiaKPI();
                dg.setDiemtb(rs.getFloat("diemtb"));
                dg.setId(rs.getInt("danhgiakpi.id"));
                listDanhgia.add(dg);
            }           
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listDanhgia;
    }
    
    public boolean addDanhgia(DanhgiaKPI dg,BangKPI b ){
        String sql ="INSERT INTO danhgiakpi(bangkpiid,nhanvienid) values(?,?)";
        String sql1="SELECT id FROM danhgiakpi WHERE bangkpiid=? AND nhanvienid=?";
        String sql2="INSERT INTO diemkpi(cotkpiid,danhgiakpiid,giatri) VALUES(?,?,0)";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,b.getId());
            ps.setInt(2,dg.getNhanvien().getId());
            int r = ps.executeUpdate();
            if(r<1){
                con.rollback();
                return false;
            }
            
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1,b.getId());
            ps1.setInt(2,dg.getNhanvien().getId());
            ResultSet rs = ps1.executeQuery();
            while(rs.next()){
                dg.setId(rs.getInt("id"));
            }
            
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ArrayList<CotKPI> listCot = b.getListCot();
            int s = listCot.size();
            for(int i=0;i<s;i++){
                ps2.setInt(1, listCot.get(i).getId());
                ps2.setInt(2, dg.getId());
                r = ps2.executeUpdate();
                if(r<1){
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
    
    public boolean updateDanhgia(DanhgiaKPI dg){
        String sql = "UPDATE diemkpi SET giatri=? WHERE id = ?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps  = con.prepareStatement(sql);
            ArrayList<DiemKPI> listDiem = dg.getListDiemkpi();
            int s = listDiem.size();
            for(int i=0;i<s;i++){
                DiemKPI d = listDiem.get(i);
                ps.setInt(1, d.getGiatri());
                ps.setInt(2, d.getId());
                int r = ps.executeUpdate();
                if(r<1){
                    con.rollback();
                    return false;
                }
            }
            con.commit();
            return true;
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
    
    public boolean deleteDanhgia(DanhgiaKPI dg){
        String sql ="DELETE FROM diemkpi WHERE danhgiakpiid = ?";
        String sql1 ="DELETE FROM danhgiakpi WHERE id = ?";
        try{
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dg.getId());
            int r = ps.executeUpdate();
            if(r<1){
                con.rollback();
                return false;
            }
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, dg.getId());
            r = ps.executeUpdate();
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
