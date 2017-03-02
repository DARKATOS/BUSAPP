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
public class Bus {
    private int id;
    private String plate;
    private String password;
    private String driverName;
    private String busType;
    private int ticketPrice;

    public Bus(int id, String plate, String password, String driverName, String busType, int ticketPrice) {
        this.id = id;
        this.plate = plate;
        this.password = password;
        this.driverName = driverName;
        this.busType = busType;
        this.ticketPrice = ticketPrice;
    }

    
    
    public int getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }
    

    public String getDriverName() {
        return driverName;
    }

    public String getbusType() {
        return busType;
    }

    public String getPassword() {
        return password;
    }
   

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setbusType(String busType) {
        this.busType = busType;
    }
    

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
