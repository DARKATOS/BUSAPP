/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class CRUDBus {

    public boolean registrarBus(Bus bus) {

        return false;
    }

    public ArrayList<Bus> mostrarBuses() {
        try {
            Conexion conexion = new Conexion();
            ArrayList<Bus> buses = new ArrayList();
            conexion.establecerConexion();
            ResultSet resultado=conexion.ejecutarConsulta("call mostrar_buses()");

            while (resultado.next()) {
                int idbus = resultado.getInt("idbus");
                String placa = resultado.getString("placa");
                String nombreConductor = resultado.getString("nombre_conductor");
                String tipo = resultado.getString("tipo");
                int valorPasaje = resultado.getInt("valor_pasaje");
                Bus bus = new Bus(idbus, placa, nombreConductor, tipo, valorPasaje);
                buses.add(bus);
            }
            conexion.desconectar();
            return buses;

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar el procedimiento: "+ex.getMessage());
        }
        return null;
    }

}
