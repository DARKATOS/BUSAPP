/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author NIYIRETH_OSORIO
 */
public class CRUDBus {

    public boolean registrarBus(Bus bus) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();
        try {
            CallableStatement resultado = conexion.ejecutarCall("call registrar_buses(?,?,?,?)");

            // se crea instancia a procedimiento, los parametros de entrada y salida se simbolizan con el signo ?
            //se cargan los parametros de entrada
            resultado.setString("placa", bus.getPlaca());//Tipo String
            resultado.setString("nombre_Conductor", bus.getNombreConductor());//Tipo entero
            resultado.setString("tipo", bus.getTipo());//Tipo entero
            resultado.setInt("valor_Pasaje", bus.getValorPasaje());//Tipo entero
            // parametros de salida
            // Se ejecuta el procedimiento almacenado
            // devuelve el valor del parametro de salida del procedimiento
        } catch (Exception e) {
            System.out.println("Error al ejecutar el procedimiento!" + e.getMessage());
        }

        return false;
    }

    public ArrayList<Bus> mostrarBuses() {
        try {
            Conexion conexion = new Conexion();
            ArrayList<Bus> buses = new ArrayList();
            conexion.establecerConexion();
            ResultSet resultado = conexion.ejecutarConsulta("call mostrar_buses()");

            while (resultado.next()) {
                int idbus = resultado.getInt("idbus");
                String placa = resultado.getString("placa");
                String nombre_Conductor = resultado.getString("nombre_conductor");
                String tipo = resultado.getString("tipo");
                int valor_Pasaje = resultado.getInt("valor_pasaje");
                Bus bus = new Bus(idbus, placa, nombre_Conductor, tipo, valor_Pasaje);
                buses.add(bus);
            }
            conexion.desconectar();
            return buses;

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar el procedimiento: " + ex.getMessage());
        }
        return null;
    }

}
