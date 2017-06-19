/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class BusWay {
    private int idbusWay;
    private String wayName;
    private Bus bus;

    public BusWay(int idbusWay, String wayName, Bus bus) {
        this.idbusWay = idbusWay;
        this.wayName = wayName;
        this.bus = bus;
    }

    public BusWay(int idbusWay) {
        this.idbusWay = idbusWay;
    }

    public int getIdbusWay() {
        return idbusWay;
    }
    

    public Bus getBus() {
        return bus;
    }

    public String getWayName() {
        return wayName;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public void setWayName(String wayName) {
        this.wayName = wayName;
    }
    
    
}
