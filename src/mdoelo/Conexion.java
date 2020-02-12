/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdoelo;

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
    /**
     * Queda pendiente la coneccion con postgres para migrar en un futuro
     */
/*
    String cadena = "jdbc:postgresql://localhost:5432/";
    String baseDeDatos = "clase04";
    String user = "pedro";
    String pass = "PEDRO";
*/
    /*
    public  void POSTGRES() {
        String cadena = "jdbc:postgresql://localhost:5432/";
        String baseDeDatos = "clase04";
        String user = "pedro";
        String pass = "PEDRO";

        try {
            //  Class.forName("org.postgresql.Driver");
            Connection conex = DriverManager.getConnection(cadena + baseDeDatos, user, pass);
            Statement st = conex.createStatement();
            String sql
                    = "SELECT * FROM propietarios ";
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                String usuario = result.getString("nom_nombres");
                String clave = result.getString("nom_apellidos");
                System.out.println("Name: " + usuario + " LastName " + clave);
            }
            result.close();
            st.close();
            conex.close();
        } catch (Exception exc) {
            System.out.println("Errorx:" + exc.getMessage());
        }
    }
    */
/*CONEXION POSTGRES
    public Connection conectarPostgres(String usuario,String password) {
        Connection conex = null;
        try {
            conex = DriverManager.getConnection(cadena + baseDeDatos, usuario, password);
        } catch (SQLException ex) {
           // Logger.getLogger(MOD_login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conex;
    }
*/
    String baseDatos="odontologia";
    String usuario="root";
    String contraseña="zomby";
    String direccion = "jdbc:mysql://localhost/"+baseDatos+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";//+baseDatos;
    Connection conectarDB;
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
