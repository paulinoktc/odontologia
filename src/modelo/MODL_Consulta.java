/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author zomby
 */
public class MODL_Consulta {
    
        public void cargarItems(JComboBox item){
        try {
            ResultSet result = new Conexion().crearConexion().createStatement().executeQuery("SELECT nombre_consulta FROM consulta");
            while (result!=null && result.next()) {
                item.addItem(result.getString("nombre_consulta"));
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
