/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class Hopdong {
    //id sohd ngayky hethan nd
    private int id;
    private String sohd;
    private Date ngayky;
    private Date hethan;
    private String noidung;
    private Nhanvien nv;

    public Hopdong() {
    }

    public Nhanvien getNv() {
        return nv;
    }

    public void setNv(Nhanvien nv) {
        this.nv = nv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSohd() {
        return sohd;
    }

    public void setSohd(String sohd) {
        this.sohd = sohd;
    }

    public Date getNgayky() {
        return ngayky;
    }

    public void setNgayky(Date ngayky) {
        this.ngayky = ngayky;
    }

    public Date getHethan() {
        return hethan;
    }

    public void setHethan(Date hethan) {
        this.hethan = hethan;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
    
}
