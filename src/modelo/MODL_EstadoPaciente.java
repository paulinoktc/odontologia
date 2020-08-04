/**
 * Esta clase lleva el control de los estados del paciente
 * embarazada,
 * hospitalizado y tratamiento
 */
package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SandraElizabet
 */
public class MODL_EstadoPaciente {

    /**
     * Sentencias que se va a usar
     */
    private String scr_embarazada = "SELECT meses FROM embarazada WHERE id_antecedente=";
    private String scr_hospitalizado = "SELECT motivo FROM hospitalizado WHERE id_antecedente=";

    /**
     * Guarda el estado actual de una paciente si esta embarazada
     *
     * @param embarazada OBJ_EstadoPaciente donde se define los meses de
     * embarazo
     */
    public void GuardarEmbarazo(OBJ_EstadoPaciente embarazada) {
        
     
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();

            cc.setAutoCommit(false);
            //realiza la llamada al procedure que realiza la accion de guardar ducho atributo
            CallableStatement llamada = cc.prepareCall("{call saveEmbarazo(?,?)}");
            llamada.setInt(1, embarazada.getId_antecedente());
            llamada.setString(2, embarazada.getEstado());
            llamada.execute();

            cc.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Antecedentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Se encarga de guardar si un paciente ha sido hospitalizado
     *
     * @param hospitalizado OBJ_EstadoPaciente donde se define cuales son los
     * atributos del estado hospitalizado
     */
    public void GuardarHospitalizado(OBJ_EstadoPaciente hospitalizado) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();

            cc.setAutoCommit(false);
            CallableStatement llamada = cc.prepareCall("{call saveHospitalizado(?,?)}");
            llamada.setInt(1, hospitalizado.getId_antecedente());
            llamada.setString(2, hospitalizado.getEstado());
            llamada.execute();
            cc.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Antecedentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
