/**
 * Reliza las consultas para el logeo de la aplicacions
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author SandraElizabet
 */
public class MODL_Login {

    /**
     * Rellema los items del JComboBox de usuarios
     *
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
//            Logger.getLogger(MODL_Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Ejecuta la sentencia SQL para la validacion del usuario
     *
     * @param nombreUsuario Nombre del usuario a comprobar
     * @param pass Contraseña del usuario
     * @return Si es correcto o no la validacion
     */
    public boolean validarPass(String nombreUsuario, String pass) {

        String textoSinEncriptar = pass;
        //texto encriptado con la contraseña
        String textoEncriptadoConSHA = DigestUtils.sha1Hex(textoSinEncriptar);

        boolean passCorrect = false;
        Connection conected = new Conexion().crearConexion();
        try {
            PreparedStatement prepareState = conected.prepareStatement("SELECT nombre_user,pass FROM usuarios WHERE nombre_user=?");

            prepareState.setString(1, nombreUsuario);

            ResultSet rs = prepareState.executeQuery();
            if (rs.next()) {
                //verifica que los textos encriptados sean iguales
                if (rs.getString(2).equalsIgnoreCase(textoEncriptadoConSHA)) {
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
