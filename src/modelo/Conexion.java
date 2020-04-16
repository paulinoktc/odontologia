/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ZOMBY
 */
public class Conexion {

    String baseDatos="dentista";
    String usuario="root";
    String contraseña="zomby";
    String direccion = "jdbc:mysql://localhost/"+baseDatos+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";//+baseDatos;
    private Connection conectarDB;
    public Connection crearConexion(){
        try {
            conectarDB=DriverManager.getConnection(direccion,usuario,contraseña);
        Statement my_state=conectarDB.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.conectarDB;

    }
    public static void main(String[] args) {
        new Conexion().crearConexion();
    }
}
