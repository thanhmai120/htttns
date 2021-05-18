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
    private String ten;
    private Date ngaybd;
    private Date ngaykt;
    private float quythuong;
    private Chinhanh chinhanh;
    private ArrayList<BangKPI> listBangKPI;
    private ArrayList<Phieuluong> listPhieuluong;

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

    public float getQuythuong() {
        return quythuong;
    }

    public void setQuythuong(float quythuong) {
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

    public ArrayList<Phieuluong> getListPhieuluong() {
        return listPhieuluong;
    }

    public void setListPhieuluong(ArrayList<Phieuluong> listPhieuluong) {
        this.listPhieuluong = listPhieuluong;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    
}
