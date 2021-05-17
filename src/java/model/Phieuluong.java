/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Administrator
 */
public class Phieuluong {
    //id phongban chucvu bacluong socong kpi tienthuong thanhtien nv
    private int id;
    private Phongban phongban;
    private Chucvu chucvu;
    private Bacluong bacluong;
    private float socong;
    private float kpi;
    private float tienthuong;
    private float thanhtien;
    private Nhanvien nhanvien;

    public Phieuluong() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Phongban getPhongban() {
        return phongban;
    }

    public void setPhongban(Phongban phongban) {
        this.phongban = phongban;
    }

    public Chucvu getChucvu() {
        return chucvu;
    }

    public void setChucvu(Chucvu chucvu) {
        this.chucvu = chucvu;
    }

    public Bacluong getBacluong() {
        return bacluong;
    }

    public void setBacluong(Bacluong bacluong) {
        this.bacluong = bacluong;
    }

    public float getSocong() {
        return socong;
    }

    public void setSocong(float socong) {
        this.socong = socong;
    }

    public float getKpi() {
        return kpi;
    }

    public void setKpi(float kpi) {
        this.kpi = kpi;
    }

    public float getTienthuong() {
        return tienthuong;
    }

    public void setTienthuong(float tienthuong) {
        this.tienthuong = tienthuong;
    }

    public float getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }

    public Nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }
    
}
