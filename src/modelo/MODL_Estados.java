/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class MODL_Estados {

    public void GuardarEmbarazoDB(OBJ_Estado estadoEmbarazo) {
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
