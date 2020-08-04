/**
 * Establece la conexion con la base de datos
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sandra
 */
public class Conexion {

    String baseDatos = "odontologia";
    String usuario = "root";
    String contraseña = "zomby";
    String direccion = "jdbc:mysql://localhost/" + baseDatos + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";//+baseDatos;
    private Connection conectarDB;

    public Connection crearConexion() {
        try {
            conectarDB = DriverManager.getConnection(direccion, usuario, contraseña);
            Statement my_state = conectarDB.createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se encontro la base de datos");
        }
        return this.conectarDB;

    }

    public static void main(String[] args) {
        new Conexion().crearConexion();
    }
}
