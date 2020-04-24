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

/**
 *
 * @author zomby
 */
public class MODL_EstadoPaciente {

    private String scr_embarazada = "SELECT meses FROM embarazada WHERE id_antecedente=";
    private String scr_hospitalizado = "SELECT motivo FROM hospitalizado WHERE id_antecedente=";

    public void GuardarEmbarazo(OBJ_EstadoPaciente embarazada) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();

            cc.setAutoCommit(false);
            CallableStatement llamada = cc.prepareCall("{call saveEmbarazo(?,?)}");
            llamada.setInt(1, embarazada.getId_antecedente());
            llamada.setString(2, embarazada.getEstado());
            llamada.execute();

            cc.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Antecedentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
