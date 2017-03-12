/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class CRUDLocation {
    
    /**
     * bus update get service: Servicio que permite obtener las actualización de ubicacion de los buses registrados y conectados al sistema, Servicio consumido desde la aplicación UsuariosBUSAPP.
     * @return ArrayList<Location> ubicaciones de los buses. Null si hubo error al obtener las ubicaciones.
     */
    public ArrayList<Location> busUpdateGetService()
    {
        try {
            PrimaryConnection connection = new PrimaryConnection();
            ArrayList<Location> locations = new ArrayList();
            connection.SetConnection();
            ResultSet result = connection.executeQuery("call bus_update_get_service()");

            while (result.next()) {
                int id = result.getInt("idbus_location");
                double latitude = result.getDouble("latitude");
                double longitude = result.getDouble("longitude");
                int idbus = result.getInt("bus_idbus");
                Bus bus= new Bus(idbus, null, null, null, null,-1);
                Location location= new Location(id, latitude, longitude, bus);
                locations.add(location);
            }
            connection.disconnect();
            return locations;

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar el procedimiento: " + ex.getMessage());
            return null;
        }
    }
}
