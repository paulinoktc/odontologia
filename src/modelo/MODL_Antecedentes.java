/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zomby
 */
public class MODL_Antecedentes {

    Conexion cn = new Conexion();
    Connection cc = cn.crearConexion();

    public void GuardarAntecedente(OBJ_Antecedentes antecedente) {
        try {
            cc.setAutoCommit(false);
            CallableStatement llamada = cc.prepareCall("{call saveAntecedentes(?,?,?)}");
            llamada.setString(1, antecedente.getHigiene_bucal());
            llamada.setString(2, antecedente.getAlimentacion());
            llamada.setString(3, antecedente.getId_paciente());

            llamada.execute();

            cc.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Antecedentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveTipoConsulta(OBJ_Antecedentes antecedente) {
        try {
            cc.setAutoCommit(false);

            CallableStatement llamada = cc.prepareCall("{call saveTratamiento(?,?,?)}");

            llamada.setInt(1, antecedente.getId_antecedente());
            llamada.setString(2, antecedente.getTipo_tratamiento());
            llamada.setString(3, antecedente.getObservaciones());
            llamada.execute();

            llamada = cc.prepareCall("{call saveTipoConsulta(?,?)}");
            llamada.setInt(1, antecedente.getId_antecedente());
            llamada.setInt(2, antecedente.getId_consulta());

           llamada.execute();
           
           cc.commit();
            
        } catch (SQLException ex) {
            try {
                cc.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MODL_Antecedentes.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MODL_Antecedentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Recorre todos los id y obtiene el ultimo
     *
     * @return
     */
    public int getIdAntecedente(OBJ_Antecedentes antecedente) {

        int id = 0;
        try {
            ResultSet result = new Conexion().crearConexion().createStatement().executeQuery(
                    "SELECT id_antecedente FROM antecedentes where id_paciente='" + antecedente.getId_paciente() + "'");
            while (result != null & result.next()) {
                id = result.getInt("id_antecedente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MODL_TejidosBlandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public int getIdConsulta(OBJ_Antecedentes antecedente) {

        int id = 0;
        try {
            ResultSet result = new Conexion().crearConexion().createStatement().executeQuery(
                    "SELECT id_consulta FROM consulta where nombre_consulta='" + antecedente.getId_consulta() + "'");
            while (result != null & result.next()) {
                id = result.getInt("id_consulta");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MODL_TejidosBlandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
}
