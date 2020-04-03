/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdoelo;

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
    public void GuardarDomicilioDB(OBJ_Referencia direccion){
          try {
            Statement state = new Conexion().crearConexion().createStatement();
            state.executeUpdate("INSERT INTO domicilio (nombre_domicilio) VALUES('"+direccion.getNombreDomicilio()+"')");
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ExtraerUltimoID(OBJ_Referencia direccion){
           String id="";
        try {
            ResultSet result = new Conexion().crearConexion().createStatement().executeQuery(
                    "SELECT MAX(id_domicilio)FROM domicilio;");
            if(result!=null && result.next()){
                id=result.getString("id_domicilio");
            }
            
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Domicilio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
