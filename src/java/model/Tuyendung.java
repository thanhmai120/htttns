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
public class Tuyendung {
    //id vitri sl han motayc
    private int id;
    private String vitri;
    private int soluong;
    private  Date han;
    private String motayc;

    public Tuyendung() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVitri() {
        return vitri;
    }

    public void setVitri(String vitri) {
        this.vitri = vitri;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Date getHan() {
        return han;
    }

    public void setHan(Date han) {
        this.han = han;
    }

    public String getMotayc() {
        return motayc;
    }

    public void setMotayc(String motayc) {
        this.motayc = motayc;
    }
    
}
