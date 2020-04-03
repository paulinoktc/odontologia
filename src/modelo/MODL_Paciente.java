/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdoelo;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zomby
 */
public class MODL_Paciente {
    
    public void GuardarDatospacienteDB(OBJ_Paciente el_paciente){
          try {
            Statement state = new Conexion().crearConexion().createStatement();
            state.executeUpdate("INSERT INTO paciente VALUES(NULL,'" + 
                    el_paciente.getNombre()+ "','" + 
                    el_paciente.getAp_paterno()+ "','" + 
                    el_paciente.getAp_materno()+ "','" + 
                    el_paciente.getSexo()+ "','" + 
                    el_paciente.getFechaNaciemiento()+ "','" + 
                    el_paciente.getEstadoCivil()+ "'," + 
                    el_paciente.getOcupacion()+ ",'" + 
                    el_paciente.getEscolaridad()+ "'," + 
                    el_paciente.getId_domicilio()+ ",'" + 
                    el_paciente.getId_tejidos()+ "')");
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
