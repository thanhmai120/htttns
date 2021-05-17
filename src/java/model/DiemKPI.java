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
public class DiemKPI {
    private int id;
    private int giatri;
    private float diem;
    private CotKPI cot;

    public DiemKPI() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGiatri() {
        return giatri;
    }

    public void setGiatri(int giatri) {
        this.giatri = giatri;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public CotKPI getCot() {
        return cot;
    }

    public void setCot(CotKPI cot) {
        this.cot = cot;
    }
    
}
