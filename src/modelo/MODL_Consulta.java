/**
 * LLena los itemos con las consultas actuales con las que cuenta el consultorio
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author BereniceAnai
 */
public class MODL_Consulta {

    /**
     * llena los items de JComboBox que recibe
     *
     * @param item JComboBox que se van a llenar con los datos
     */
    public void cargarItems(JComboBox item) {
        try {
            ResultSet result = new Conexion().crearConexion().createStatement().executeQuery("SELECT nombre_consulta FROM consulta");
            while (result != null && result.next()) {
                item.addItem(result.getString("nombre_consulta"));
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
