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
public class Nhanvien {
    //id hoten sdt email dc tdn mk trinhdo congviec chucvu phongban bacluong
    private int id;
    private String hoten;
    private String email;
    private String dc;
    private String sdt;
    private String tdn;
    private String mk;
    private String trinhdo;
    private String congviec;
    private Chucvu chucvu;
    private Phongban phongban;
    private Bacluong bacluong;
    private Chinhanh chinhanh;

    public Nhanvien() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getTdn() {
        return tdn;
    }

    public void setTdn(String tdn) {
        this.tdn = tdn;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }

    public String getCongviec() {
        return congviec;
    }

    public void setCongviec(String congviec) {
        this.congviec = congviec;
    }

    public Chucvu getChucvu() {
        return chucvu;
    }

    public void setChucvu(Chucvu chucvu) {
        this.chucvu = chucvu;
    }

    public Phongban getPhongban() {
        return phongban;
    }

    public void setPhongban(Phongban phongban) {
        this.phongban = phongban;
    }

    public Bacluong getBacluong() {
        return bacluong;
    }

    public void setBacluong(Bacluong bacluong) {
        this.bacluong = bacluong;
    }

    public Chinhanh getChinhanh() {
        return chinhanh;
    }

    public void setChinhanh(Chinhanh chinhanh) {
        this.chinhanh = chinhanh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}
