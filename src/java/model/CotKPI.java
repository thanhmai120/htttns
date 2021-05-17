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
public class CotKPI {
    private int id;
    private int chitieu;
    private int mucduoi;
    private float heso;
    private KPI kpi;

    public CotKPI() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChitieu() {
        return chitieu;
    }

    public void setChitieu(int chitieu) {
        this.chitieu = chitieu;
    }

    public int getMucduoi() {
        return mucduoi;
    }

    public void setMucduoi(int mucduoi) {
        this.mucduoi = mucduoi;
    }

    public float getHeso() {
        return heso;
    }

    public void setHeso(float heso) {
        this.heso = heso;
    }

    public KPI getKpi() {
        return kpi;
    }

    public void setKpi(KPI kpi) {
        this.kpi = kpi;
    }
    
}
