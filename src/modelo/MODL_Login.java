/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author zomby
 */
public class MODL_Login {

    /**
     * Rellema los items del JComboBox de usuarios
     * @param items JComboBox a llenar de nombres de usuarios
     */
    public void cargarItems(JComboBox items) {
        try {
            ResultSet result = new Conexion().crearConexion().createStatement().executeQuery("SELECT nombre_user FROM USUARIOS");
            while (result.next()) {
                items.addItem(result.getString(1));
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Ejecuta la sentencia SQL para la validacion del usuario
     * @param nombreUsuario Nombre del usuario a comprobar
     * @param pass Contraseña del usuario
     * @return Si es correcto o no la validacion
     */
    public boolean validarPass(String nombreUsuario, String pass) {
        boolean passCorrect = false;
        Connection conected = new Conexion().crearConexion();
        try {
            PreparedStatement prepareState = conected.prepareStatement("SELECT nombre_user,PASS FROM USUARIOS WHERE nombre_user=?"
                    + "AND PASS =?");

            prepareState.setString(1, nombreUsuario);
            prepareState.setString(2, pass);

            ResultSet rs = prepareState.executeQuery();

            if (rs.next()) {
                if (rs.getString(2).equalsIgnoreCase(pass)) {
                    passCorrect = true;
                }
            }
            prepareState.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return passCorrect;
    }
}
