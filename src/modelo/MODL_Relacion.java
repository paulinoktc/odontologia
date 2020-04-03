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
public class MODL_Relacion {

    public void GuardarListaHabitos(ArrayList<OBJ_Relacion> listaReHabitos) {
        try {
            Statement state = new Conexion().crearConexion().createStatement();
            for (OBJ_Relacion listaReferencia1 : listaReHabitos) {
                state.executeUpdate("INSERT INTO anteced_abit(id_antecedente,id_habito) VALUES ("
                        + listaReferencia1.getId_antecedente() + ",'"
                        + listaReferencia1.getId_nombreAntecedente()
                        + "') where ;");

            }
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getIdHabito(String nombreHabito) {
         String id = "";
        try {
            ResultSet result = new Conexion().crearConexion().createStatement().executeQuery("SELECT id_tratamiento FROM tratamiento");
            while (result != null & result.next()) {
                id = result.getString("id_tratamiento");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MODL_TejidosBlandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;  
    }

}
