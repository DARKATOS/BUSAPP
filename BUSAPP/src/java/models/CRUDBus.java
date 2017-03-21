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

/**
 *
 * @author NIYIRETH_OSORIO
 */
public class CRUDBus {
    
    /**
     * bus Register: Metodo que permite el registro de un bus desde al aplicación de servidor.
     * @param plate Es la placa del bus.
     * @param password Contraseña con la que el conductor del bus puede acceder a la aplicacion BUSAPP
     * @param driverName Nombre del conductor con el que esta relacionado el bus.
     * @param busType Tipo de bus (básico, ejecutivo o especial).
     * @param ticketPrice Precio del pasaje del bus.
     * @return True si se realizo correctamente el registro. False si hubo un error al registrar el bus.
     */
    public boolean busRegister(String plate, String password, String driverName, String busType, int ticketPrice) {
        Bus bus = new Bus(-1, plate,password, driverName, busType, ticketPrice);
        EnableConnection connection = new EnableConnection();
        connection.setConnection();
        try {
            CallableStatement execute = connection.executeCall("call bus_register(?,?,?,?,?)");

            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            //se cargan los parametros de entrada
            execute.setString(1, bus.getPlate());//Tipo String
            execute.setString(2, bus.getPassword());//Tipo String
            execute.setString(3, bus.getDriverName());//Tipo entero
            execute.setString(4, bus.getBusType());//Tipo entero
            execute.setInt(5, bus.getTicketPrice());//Tipo entero
            // parametros de salida
            // Se ejecuta el procedimiento almacenado
            execute.executeUpdate();
            return true;
            // devuelve el valor del parametro de salida del procedimiento
        } catch (SQLException e) {
            System.out.println("Error al ejecutar el procedimiento: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * bus Show: Permite la visualización de los buses registrados en la aplicación del servidor.
     * @return ArrayList<Bus> retorna un lista de buses si se hizo la consulta correctamente. o null si hubo un error.
     */
    public ArrayList<Bus> busShow() {
        try {
            EnableConnection connection = new EnableConnection();
            ArrayList<Bus> buses = new ArrayList();
            connection.setConnection();
            ResultSet result = connection.executeQuery("call bus_show()");

            while (result.next()) {
                int idbus = result.getInt("idbus");
                String plate = result.getString("plate");
                String driverName = result.getString("driver_name");
                String busType = result.getString("bus_type");
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
    
    /**
     * bus password: Metodo que permite obtener el password de alguna de las cuentas de los buses.
     * @param idbus Es la identificación del bus dentro de la base de datos del servidor.
     * @return String que es password de la cuenta del bus.
     */
    public String busPassword(int idbus)
    {
        Bus bus=new Bus(idbus, null, null, null, null, -1);
        EnableConnection connection = new EnableConnection();
        try {
            CallableStatement execute = connection.executeCall("call bus_password(?)");

            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            //se cargan los parametros de entrada
            execute.setInt(1, bus.getId());//Tipo String
            // parametros de salida
            // Se ejecuta el procedimiento almacenado
            ResultSet result = execute.executeQuery();
            String password=null;
            while (result.next()) {
                password = result.getString("password");
            }
            connection.disconnect();
            return password;
            // devuelve el valor del parametro de salida del procedimiento
        } catch (SQLException e) {
            System.out.println("Error al ejecutar el procedimiento: " + e.getMessage());
            return null;
        }
        
    }
    
    
    /**
     * bus update: Metodo que permite la actualización de todos los datos de un bus.
     * @param plate Placa del bus.
     * @param password Contraseña de la cuenta del bus.
     * @param passwordRepeat Repetición de la contraseña que debe coincidir con el parametro password.
     * @param driverName Nombre del conductor del bus.
     * @param busType Tipo de bus (básico, ejecutivo o especial).
     * @param ticketPrice Precio del pasaje del bus.
     * @return True si se realizo correctamente la actualización de datos. False si hubo un error en la actualización de datos.
     */
    public boolean busUpdate(String plate, String password, String passwordRepeat, String driverName, String busType, int ticketPrice)
    {
        if (password.equals(passwordRepeat))
        {
            Bus bus=new Bus(-1, plate, password, driverName, busType, ticketPrice);
            return true;
        }
        else
        { 
            return false;
        }
    }
    
    /**
     * bus location register service: Servicio para recibir y registrar la primera ubicación del bus, Con esto se considera activo dentro del sistema BUSAPP, Este servicio es consumido desde la aplicacion BusesBUSAPP
     * @param id identificador del bus en el sistema.
     * @return String informando si se realizo correctamente el registro de la ubicación del bus.
     */
    public String busLocationRegisterService(int id)
    {
        Bus bus = new Bus(id, null, null, null, null, -1);
        EnableConnection connection = new EnableConnection();
        connection.setConnection();
        try {
            CallableStatement execute = connection.executeCall("{?=call bus_location_register_service(?)}");
            execute.registerOutParameter(1, Types.BOOLEAN);
            execute.setInt(2, bus.getId());
            execute.execute();
            boolean flag = execute.getBoolean(1);
            if (flag) {
                return "Success";
            } else {
                return "Failure";
            }
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar el procedimiento: " + ex.getMessage());
            return "Failure: " + ex.getMessage();
        }
    }
    
    /**
     * bus location update service: Servicio que permite la actualización de la ubicación del bus segun su recorrido, este servicio es consumido desde laaplicación BusesBUSAPP.
     * @param id Identificador del bus en el sistema. 
     * @param latitude Nueva latitud que tiene el bus.
     * @param longitude Nueva longitud que tiene el bus.
     * @return String si se realizo correctamente la actualización de la ubicación del bus.
     */
    public String busLocationUpdateService(int id, double latitude, double longitude)
    {
        Bus bus = new Bus(id, null, null, null, null, -1);
        EnableConnection connection = new EnableConnection();
        connection.setConnection();
        try {
            CallableStatement execute = connection.executeCall("{?=call bus_location_update_service(?,?,?)}");
            execute.registerOutParameter(1, Types.BOOLEAN);
            execute.setInt(2, bus.getId());
            execute.setDouble(3, latitude);
            execute.setDouble(4, longitude);
            execute.execute();
            boolean flag = execute.getBoolean(1);
            if (flag) {
                return "Success";
            } else {
                return "Failure";
            }
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar el procedimiento: " + ex.getMessage());
            return "Failure: " + ex.getMessage();
        }
    }
    
    /**
     * bus location delete service: Servicio que permite eliminar la ubicación de un bus, se consume el servicio cuando el usuario se ha salido de la aplicación BusesBUSAPP.
     * @param id Identificador del bus en el sistema.
     * @return String indicando si se realizo correctamente el borrado de la ubicacion del bus.
     */
    public String busLocationDeleteService(int id)
    {
        Bus bus = new Bus(id, null, null, null, null, -1);
        EnableConnection connection = new EnableConnection();
        connection.setConnection();
        try {
            CallableStatement execute = connection.executeCall("{?=call bus_location_delete_service(?)}");
            execute.registerOutParameter(1, Types.BOOLEAN);
            execute.setInt(2, bus.getId());
            execute.execute();
            boolean flag = execute.getBoolean(1);
            if (flag) {
                return "Success";
            } else {
                return "Failure";
            }
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar el procedimiento: " + ex.getMessage());
            return "Failure: " + ex.getMessage();
        }
    }

    /**
     * bus login register service: Servicio que permite el inicio de sesión de un bus y retorna los datos para guardar la sesión en un archivo de configuración en la aplicación BusesBUSAPP, este servicio es consumido desde la aplicación BusesBUSAPP. 
     * @param plate Placa del bus.
     * @param password Contraseña de la cuenta del bus.
     * @return Bus con los datos del bus que ha iniciado sesión. null si no se encontro el bus en el sistema.
     */
    public Bus busLoginRegisterService(String plate, String password) {
        Bus bus = new Bus(-1, plate, password, null, null, -1);
        EnableConnection connection = new EnableConnection();
        connection.setConnection();
        try {
            CallableStatement execute = connection.executeCall("call bus_login_register_service(?,?)");
            execute.setString(1, bus.getPlate());//Tipo String
            execute.setString(2, bus.getPassword());//Tipo String
            ResultSet result = execute.executeQuery();
            bus = null;
            while (result.next()) {
                int idbus = result.getInt("idbus");
                String plateR = result.getString("plate");
                String driverName = result.getString("driver_name");
                String busType = result.getString("bus_type");
                int ticketPrice = result.getInt("ticket_price");
                bus = new Bus(idbus, plateR, null, driverName, busType, ticketPrice);
            }
            connection.disconnect();
            return bus;
            // devuelve el valor del parametro de salida del procedimiento
        } catch (SQLException e) {
            System.out.println("Error al ejecutar el procedimiento: " + e.getMessage());
            return null;
        }
    }

    /**
     * bus login service; Servicio que permite el inicio de sesión de un bus a traves de los datos almacenados en un archivo de configuración de la aplicación BusesBUSAPP, el servicio es consumido desde la aplicación BusesBUSAPP.
     * @param id Identificador del bus en el sistema.
     * @param plate Placa del bus.
     * @return String indicando si fue posible el inicio de sesión.
     */
    public String busLoginService(int id, String plate) {
        Bus bus = new Bus(id, plate, null, null, null, -1);
        EnableConnection connection = new EnableConnection();
        connection.setConnection();
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
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar el procedimiento: " + ex.getMessage());
            return "Failure: " + ex.getMessage();
        }
    }

}
