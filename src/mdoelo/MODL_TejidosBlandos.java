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
public class MODL_TejidosBlandos {
        public void GuardarTejidosDB(OBJ_TejidosBlandos tejido){
          try {
            Statement state = new Conexion().crearConexion().createStatement();
            state.executeUpdate("INSERT INTO tejidos_blandos VALUES(NULL,'" + 
                    tejido.getFrenillo()+ "','"+
                    tejido.getMejilla()+"','"+
                    tejido.getLabios()+"','"+
                    tejido.getPaladar()+"','"+
                    tejido.getEncia()+"','"+
                    tejido.getLengua()+"',"
                    +"')");
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ExtraerUltimoID(OBJ_TejidosBlandos tejidos){
           String id="";
        try {
            ResultSet result = new Conexion().crearConexion().createStatement().executeQuery(
                    "SELECT max (id_tejidos)FROM tejidos_blandos;");
            if(result!=null && result.next()){
                id=result.getString("0");
            }
            
            result.close();
            
            tejidos.setId_tejido(Integer.parseInt(id));
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Domicilio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
