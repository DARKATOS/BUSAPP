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
    private BusLocation busLocation;

    public BusWay(int idbusWay, String wayName, BusLocation busLocation) {
        this.idbusWay = idbusWay;
        this.wayName = wayName;
        this.busLocation = busLocation;
    }
    
    

    public BusWay(int idbusWay) {
        this.idbusWay = idbusWay;
    }

    public int getIdbusWay() {
        return idbusWay;
    }

    public String getWayName() {
        return wayName;
    }
    public void setWayName(String wayName) {
        this.wayName = wayName;
    }

    public BusLocation getBusLocation() {
        return busLocation;
    }

    public void setBusLocation(BusLocation busLocation) {
        this.busLocation = busLocation;
    }
    
    
    
}
