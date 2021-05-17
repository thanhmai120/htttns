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
public class Ungvien {
    //id ten sdt email dc gd
    private int id;
    private String ten;
    private String sdt;
    private String email;
    private String dc;
    private String giaidoan;
    private Tuyendung tuyendung;

    public Ungvien() {
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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

    public String getGiaidoan() {
        return giaidoan;
    }

    public void setGiaidoan(String giaidoan) {
        this.giaidoan = giaidoan;
    }

    public Tuyendung getTuyendung() {
        return tuyendung;
    }

    public void setTuyendung(Tuyendung tuyendung) {
        this.tuyendung = tuyendung;
    }
    
}
