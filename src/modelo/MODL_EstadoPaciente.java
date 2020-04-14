/**
 * Esta clase lleva el control de los estados del paciente 
 * embarazada, 
 * hospitalizado y tratamiento
 */
package modelo;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zomby
 */
public class MODL_EstadoPaciente {

    public void GuardarEmbarazoDB(OBJ_EstadoPaciente estadoEmbarazo) {
        try {
            Statement state = new Conexion().crearConexion().createStatement();

            state.executeUpdate("INSERT INTO embarazada(id_antecedente,dias) VALUES("
                    + estadoEmbarazo.getId_antecedente() + ",'"
                    + estadoEmbarazo.getEstado() + "')");

            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
