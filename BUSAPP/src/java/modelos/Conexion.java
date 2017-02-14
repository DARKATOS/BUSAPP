/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JORGE_ALEJANDRO
 */
public class Conexion {
    private final String url = "jdbc:mysql://localhost:3306/busapp";
    private final String user = "root";
    private final String password = "";

    private Connection conectar;
    private CallableStatement fop;

    public void establecerConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(url, user, password); // getting Statement object to execute query
            fop=null;
        } catch (SQLException ex) {
            System.out.println("error en la conexion");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en la clase");
        }
    }
    
    public ResultSet ejecutarConsulta(String sql)
    {
        try {
            fop=conectar.prepareCall(sql);
            ResultSet resultado=fop.executeQuery();
            return resultado;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public boolean ejecutarActualizacion(String sql)
    {
        try {
            fop=conectar.prepareCall(sql);
            fop.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public void desconectar() {
        try {
            fop.close();
            conectar.close();
        } catch (SQLException ex) {
            System.out.println("error al desconectar");
        }
    }
}
