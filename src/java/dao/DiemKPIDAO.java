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
import model.CotKPI;
import model.DanhgiaKPI;
import model.DiemKPI;

/**
 *
 * @author Administrator
 */
public class DiemKPIDAO extends DAO{

    public DiemKPIDAO() {
        super();
    }
    
    public ArrayList<DiemKPI> getListDiemKPI(DanhgiaKPI dg){
        ArrayList<DiemKPI> listDiemKPI=null;
        String sql="SELECT * FROM diemkpi,cotkpi WHERE diemkpi.danhgiakpi=? AND diemkpi.cotkpiid=cotkpi.id";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,dg.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(listDiemKPI==null){
                    listDiemKPI=new ArrayList<>();
                }
                CotKPI cot = new CotKPI();
                cot.setTen(rs.getString("cotkpi.ten"));
                cot.setChitieu(rs.getInt("cotkpi.chitieu"));
                cot.setDonvi(rs.getString("cotkpi.donvi"));
                cot.setHeso(rs.getFloat("cotkpi.heso"));
                DiemKPI d = new DiemKPI();
                d.setCot(cot);
                d.setGiatri(rs.getInt("diemkpi.giatri"));
                d.setId(rs.getInt("diemkpi.id"));
                d.setDiem(d.getGiatri()*cot.getHeso()/cot.getChitieu());
                listDiemKPI.add(d);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listDiemKPI;
    }
    
}
