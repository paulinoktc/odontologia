/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zomby
 */
public class MODL_Domicilio {
    public void GuardarDomicilioDB(OBJ_Domicilio direccion){
          try {
            Statement state = new Conexion().crearConexion().createStatement();
            state.executeUpdate("INSERT INTO domicilio (id_paciente,nombre_domicilio)"
                    + "VALUES('"
                    +direccion.getId_paciente()+"','"
                    +direccion.getDireccion()+"')");
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Recorre todos los id y obtiene el ultimo
     * @return 
     */
    public String getUltimoId() {

        String id = "";
        try {
            ResultSet result = new Conexion().crearConexion().createStatement().executeQuery("SELECT id_domicilio FROM domicilio");
            while (result != null & result.next()) {
                id = result.getString("id_domicilio");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MODL_TejidosBlandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
}
