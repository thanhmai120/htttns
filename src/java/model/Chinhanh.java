/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Chinhanh {
    //id ten dc sdt
    private int id;
    private String ten;
    private String dc;
    private String sdt;
    private ArrayList<Tuyendung> listTuyendung;
    private ArrayList<Bacluong> listBacluong;
    private ArrayList<Nhanvien> listNhanvien;

    public Chinhanh() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public ArrayList<Tuyendung> getListTuyendung() {
        return listTuyendung;
    }

    public void setListTuyendung(ArrayList<Tuyendung> listTuyendung) {
        this.listTuyendung = listTuyendung;
    }

    public ArrayList<Bacluong> getListBacluong() {
        return listBacluong;
    }

    public void setListBacluong(ArrayList<Bacluong> listBacluong) {
        this.listBacluong = listBacluong;
    }

    public ArrayList<Nhanvien> getListNhanvien() {
        return listNhanvien;
    }

    public void setListNhanvien(ArrayList<Nhanvien> listNhanvien) {
        this.listNhanvien = listNhanvien;
    }
    
}
