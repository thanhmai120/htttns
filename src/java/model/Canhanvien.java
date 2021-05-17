/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Time;

/**
 *
 * @author Administrator
 */
public class Canhanvien {
    //ngay den ve tinhcong nghiphep pheduyet nhanvien loai np
    private int id;
    private Time den;
    private Time ve;
    private float cong;
    private boolean nghiphep;
    private boolean pheduyet;
    private Nghiphep loainp;
    private Nhanvien nhanvien;
    private Ca ca;

    public Canhanvien() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getDen() {
        return den;
    }

    public void setDen(Time den) {
        this.den = den;
    }

    public Time getVe() {
        return ve;
    }

    public void setVe(Time ve) {
        this.ve = ve;
    }

    public float getCong() {
        return cong;
    }

    public void setCong(float cong) {
        this.cong = cong;
    }

    public boolean isNghiphep() {
        return nghiphep;
    }

    public void setNghiphep(boolean nghiphep) {
        this.nghiphep = nghiphep;
    }

    public boolean isPheduyet() {
        return pheduyet;
    }

    public void setPheduyet(boolean pheduyet) {
        this.pheduyet = pheduyet;
    }

    public Nghiphep getLoainp() {
        return loainp;
    }

    public void setLoainp(Nghiphep loainp) {
        this.loainp = loainp;
    }

    public Nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public Ca getCa() {
        return ca;
    }

    public void setCa(Ca ca) {
        this.ca = ca;
    }
    
}
