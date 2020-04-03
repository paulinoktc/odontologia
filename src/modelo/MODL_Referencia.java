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
public class MODL_Referencia {

    public void GuardarListaMedicamentos(ArrayList<OBJ_Referencia> listaReferencia) {
        try {
            Statement state = new Conexion().crearConexion().createStatement();
            for (OBJ_Referencia listaReferencia1 : listaReferencia) {
                System.out.println(listaReferencia1.getId_antecedente() + " - " + listaReferencia1.getNombre());
                state.executeUpdate("INSERT INTO medicamento(id_antecedente,nombre_medicamento) VALUES ("
                        + listaReferencia1.getId_antecedente() + ",'"
                        + listaReferencia1.getNombre()
                        + "');");

            }
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void GuardarListaAlergia(ArrayList<OBJ_Referencia> listaReferencia) {
        try {
            Statement state = new Conexion().crearConexion().createStatement();
            for (OBJ_Referencia listaReferencia1 : listaReferencia) {

                state.executeUpdate("INSERT INTO alergia(id_antecedente,nombre_alergia) VALUES("
                        + listaReferencia1.getId_antecedente() + ",'"
                        + listaReferencia1.getNombre() + "')");

            }
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void GuardarHospitalizado(OBJ_Referencia hospitalizado) {
        try {
            Statement state = new Conexion().crearConexion().createStatement();

            state.executeUpdate("INSERT INTO hospitalizado(id_antecedente,motivo) VALUES("
                    + hospitalizado.getId_antecedente() + ",'"
                    + hospitalizado.getNombre() + "')");
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void GuardarAnticoncp(OBJ_Referencia antic) {
        try {
            Statement state = new Conexion().crearConexion().createStatement();

            state.executeUpdate("INSERT INTO anticonceptivo(id_antecedente,nombre_antico) VALUES("
                    + antic.getId_antecedente() + ",'"
                    + antic.getNombre() + "')");
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
