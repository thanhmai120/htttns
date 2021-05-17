/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Bangluong {
    //id ngaybd kt quythuong chinhanh bangkpilist
    private int id;
    private Date ngaybd;
    private Date ngaykt;
    private double quythuong;
    private Chinhanh chinhanh;
    private ArrayList<BangKPI> listBangKPI;

    public Bangluong() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgaybd() {
        return ngaybd;
    }

    public void setNgaybd(Date ngaybd) {
        this.ngaybd = ngaybd;
    }

    public Date getNgaykt() {
        return ngaykt;
    }

    public void setNgaykt(Date ngaykt) {
        this.ngaykt = ngaykt;
    }

    public double getQuythuong() {
        return quythuong;
    }

    public void setQuythuong(double quythuong) {
        this.quythuong = quythuong;
    }

    public Chinhanh getChinhanh() {
        return chinhanh;
    }

    public void setChinhanh(Chinhanh chinhanh) {
        this.chinhanh = chinhanh;
    }

    public ArrayList<BangKPI> getListBangKPI() {
        return listBangKPI;
    }

    public void setListBangKPI(ArrayList<BangKPI> listBangKPI) {
        this.listBangKPI = listBangKPI;
    }
    
}
