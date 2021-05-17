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
public class Ca {
    // ten, socong giobd giokt codinh t2 t3 t...
    private int id;
    private String ten;
    private int socong;
    private Time giobd;
    private Time giokt;
    private boolean codinh;
    private boolean t2;
    private boolean t3;
    private boolean t4;
    private boolean t5;
    private boolean t6;
    private boolean t7;
    private boolean cn;

    public Ca() {
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

    public int getSocong() {
        return socong;
    }

    public void setSocong(int socong) {
        this.socong = socong;
    }

    public Time getGiobd() {
        return giobd;
    }

    public void setGiobd(Time giobd) {
        this.giobd = giobd;
    }

    public Time getGiokt() {
        return giokt;
    }

    public void setGiokt(Time giokt) {
        this.giokt = giokt;
    }

    public boolean isCodinh() {
        return codinh;
    }

    public void setCodinh(boolean codinh) {
        this.codinh = codinh;
    }

    public boolean isT2() {
        return t2;
    }

    public void setT2(boolean t2) {
        this.t2 = t2;
    }

    public boolean isT3() {
        return t3;
    }

    public void setT3(boolean t3) {
        this.t3 = t3;
    }

    public boolean isT4() {
        return t4;
    }

    public void setT4(boolean t4) {
        this.t4 = t4;
    }

    public boolean isT5() {
        return t5;
    }

    public void setT5(boolean t5) {
        this.t5 = t5;
    }

    public boolean isT6() {
        return t6;
    }

    public void setT6(boolean t6) {
        this.t6 = t6;
    }

    public boolean isT7() {
        return t7;
    }

    public void setT7(boolean t7) {
        this.t7 = t7;
    }

    public boolean isCn() {
        return cn;
    }

    public void setCn(boolean cn) {
        this.cn = cn;
    }
    
}
