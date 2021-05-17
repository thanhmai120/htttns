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
public class DanhgiaKPI {
    private int id;
    private float diemtb;
    private ArrayList<DiemKPI> listDiemkpi;
    private Nhanvien nhanvien;

    public DanhgiaKPI() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDiemtb() {
        return diemtb;
    }

    public void setDiemtb(float diemtb) {
        this.diemtb = diemtb;
    }

    public ArrayList<DiemKPI> getListDiemkpi() {
        return listDiemkpi;
    }

    public void setListDiemkpi(ArrayList<DiemKPI> listDiemkpi) {
        this.listDiemkpi = listDiemkpi;
    }

    public Nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }
    
}
