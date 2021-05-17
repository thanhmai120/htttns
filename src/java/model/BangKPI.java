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
public class BangKPI {
    private int id;
    private String ten;
    private boolean daChot;
    private boolean daSudung;
    private Phongban phongban;
    private ArrayList<CotKPI> listCot;
    private ArrayList<DanhgiaKPI> listDanhgia;

    public BangKPI() {
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

    public boolean isDaChot() {
        return daChot;
    }

    public void setDaChot(boolean daChot) {
        this.daChot = daChot;
    }

    public boolean isDaSudung() {
        return daSudung;
    }

    public void setDaSudung(boolean daSudung) {
        this.daSudung = daSudung;
    }

    public Phongban getPhongban() {
        return phongban;
    }

    public void setPhongban(Phongban phongban) {
        this.phongban = phongban;
    }

    public ArrayList<CotKPI> getListCot() {
        return listCot;
    }

    public void setListCot(ArrayList<CotKPI> listCot) {
        this.listCot = listCot;
    }

    public ArrayList<DanhgiaKPI> getListDanhgia() {
        return listDanhgia;
    }

    public void setListDanhgia(ArrayList<DanhgiaKPI> listDanhgia) {
        this.listDanhgia = listDanhgia;
    }
    
}
