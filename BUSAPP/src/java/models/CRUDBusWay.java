/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class CRUDBusWay {
    
    public ArrayList<BusWay> busWayShow(int idBus)
    {
        try {
            EnableConnection connection = new EnableConnection();
            ArrayList<BusWay> busWay = new ArrayList();
            connection.setConnection();
            CallableStatement execute = connection.executeCall("call bus_way_show(?)");
            execute.setInt(1, idBus);//Tipo String
            ResultSet result = execute.executeQuery();
            while (result.next()) {
                int idbusWay = result.getInt("idbus_way");
                String wayName = result.getString("way_name");
                int idBusLocation=result.getInt("bus_location_idbus_location");
                BusWay bw = new BusWay(idbusWay, wayName, new BusLocation(idBusLocation, new Bus(idBus)));
                busWay.add(bw);
            }
            connection.disconnect();
            return busWay;

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar el procedimiento: " + ex.getMessage());
            return null;
        }
    }

    public String busWayRegister(String wayName, int idBus, int idBusLocation) {
        BusWay busWay=new BusWay(-1, wayName, new BusLocation(idBusLocation, new Bus(idBus)));
        EnableConnection connection = new EnableConnection();
        connection.setConnection();
        try {
            CallableStatement execute = connection.executeCall("call bus_way_register(?, ?, ?)");
            execute.setString(1, busWay.getWayName());
            execute.setInt(2, busWay.getBusLocation().getBus().getId());
            execute.setInt(3, busWay.getBusLocation().getId());
            execute.executeUpdate();
            return "Success";

        } catch (SQLException e) {
            System.out.println("Error al ejecutar el procedimiento: " + e.getMessage());
            return "Failure: "+e.getMessage();
        }
    }

    public String busWayDelete(int idBusWay) {
        BusWay busWay=new BusWay(idBusWay);
        EnableConnection connection = new EnableConnection();
        connection.setConnection();
        try {
                CallableStatement execute = connection.executeCall("call bus_way_delete(?)");
                execute.setInt(1, busWay.getIdbusWay());
                execute.executeUpdate();
                return "Success";
        } catch (SQLException e) {
            System.out.println("Error al ejecutar el procedimiento: " + e.getMessage());
            return "Failure: "+e.getMessage();
        }
    }
}
