/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import javafx.animation.KeyValue;

/**
 *
 * @author NIYIRETH_OSORIO
 */
public class CRUDBus {

    public boolean busRegister(Bus bus) {
        PrimaryConnection connection = new PrimaryConnection();
        connection.SetConnection();
        try {
            CallableStatement execute = connection.executeCall("call bus_register(?,?,?,?,?)");

            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            //se cargan los parametros de entrada
            execute.setString("plate", bus.getPlate());//Tipo String
            execute.setString("password", bus.getPassword());//Tipo String
            execute.setString("driver_name", bus.getDriverName());//Tipo entero
            execute.setString("type", bus.getbusType());//Tipo entero
            execute.setInt("ticket_price", bus.getTicketPrice());//Tipo entero
            // parametros de salida
            // Se ejecuta el procedimiento almacenado
            execute.executeUpdate();
            return true;
            // devuelve el valor del parametro de salida del procedimiento
        } catch (Exception e) {
            System.out.println("Error al ejecutar el procedimiento: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Bus> busShow() {
        try {
            PrimaryConnection connection = new PrimaryConnection();
            ArrayList<Bus> buses = new ArrayList();
            connection.SetConnection();
            ResultSet result = connection.executeQuery("call bus_show()");

            while (result.next()) {
                int idbus = result.getInt("idbus");
                String plate = result.getString("plate");
                String driverName = result.getString("driver_name");
                String busType = result.getString("busType");
                int ticketPrice = result.getInt("ticket_price");
                System.out.println("Nombre: " + driverName);
                Bus bus = new Bus(idbus, plate, null, driverName, busType, ticketPrice);
                buses.add(bus);
            }
            connection.disconnect();
            return buses;

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar el procedimiento: " + ex.getMessage());
            return null;
        }

    }

    public Bus busLoginRegisterService(String plate, String password) {
        Bus bus = new Bus(-1, plate, password, null, null, -1);
        PrimaryConnection connection = new PrimaryConnection();
        connection.SetConnection();
        try {
            CallableStatement execute = connection.executeCall("call bus_login_register_service(?,?)");

            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            //se cargan los parametros de entrada
            execute.setString(1, bus.getPlate());//Tipo String
            execute.setString(2, bus.getPassword());//Tipo String
            // parametros de salida
            // Se ejecuta el procedimiento almacenado
            ResultSet result = execute.executeQuery();
            bus = null;
            while (result.next()) {
                int idbus = result.getInt("idbus");
                String plateR = result.getString("plate");
                String driverName = result.getString("driver_name");
                String busType = result.getString("busType");
                int ticketPrice = result.getInt("ticket_price");
                bus = new Bus(idbus, plateR, null, driverName, busType, ticketPrice);
            }
            connection.disconnect();
            return bus;
            // devuelve el valor del parametro de salida del procedimiento
        } catch (Exception e) {
            System.out.println("Error al ejecutar el procedimiento: " + e.getMessage());
            return null;
        }
    }

    public String busLoginService(int idbus, String plate) {
        Bus bus = new Bus(idbus, plate, null, null, null, -1);
        PrimaryConnection connection = new PrimaryConnection();
        connection.SetConnection();
        try {
            CallableStatement execute = connection.executeCall("{?=call bus_login_service(?,?)}");

            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            //se cargan los parametros de entrada
            execute.registerOutParameter(1, Types.INTEGER);
            execute.setInt(2, bus.getId());//Tipo String
            execute.setString(3, bus.getPlate());//Tipo String
            // parametros de salida
            // Se ejecuta el procedimiento almacenado
            execute.execute();
            int count = execute.getInt(1);
            if (count > 0) {
                return "Success";
            } else {
                return "Failure";
            }
            // devuelve el valor del parametro de salida del procedimiento
        } catch (Exception ex) {
            System.out.println("Error al ejecutar el procedimiento: " + ex.getMessage());
            return "Failure: " + ex.getMessage();
        }
    }

}
