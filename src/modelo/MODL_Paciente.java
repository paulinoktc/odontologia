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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zomby
 */
public class MODL_Paciente {

    Conexion cn = new Conexion();
    Connection cc = cn.crearConexion();

    public void guardarDatosPaciente(OBJ_Paciente paciente) {
        try {
            cc.setAutoCommit(false);
            CallableStatement llamada = cc.prepareCall("{call guardaPaciente(?,?,?,?,?,?,?,?,?)}");//---paciente
            llamada.setString(1, paciente.getId_paciente());
            llamada.setString(2, paciente.getNombre());
            llamada.setString(3, paciente.getAp_paterno());
            llamada.setString(4, paciente.getAp_materno());
            llamada.setString(5, paciente.getSexo());
            llamada.setString(6, paciente.getFechaNaciemiento());
            llamada.setString(7, paciente.getEstadoCivil());
            llamada.setString(8, paciente.getOcupacion());
            llamada.setString(9, paciente.getEscolaridad());
            llamada.execute();

            llamada = cc.prepareCall("{call saveTelefono(?,?)}");//---------------telefono
            llamada.setString(1, paciente.getId_paciente());
            llamada.setString(2, paciente.getTelefono());
            llamada.execute();

            llamada = cc.prepareCall("{call saveCorreo(?,?)}");//-----------------correo
            llamada.setString(1, paciente.getId_paciente());
            llamada.setString(2, paciente.getCorreo());
            llamada.execute();

            llamada = cc.prepareCall("{call saveTutor(?,?)}");//------------------tutor
            llamada.setString(1, paciente.getId_paciente());
            llamada.setString(2, paciente.getTutor());
            llamada.execute();

            llamada = cc.prepareCall("{call saveDomicilio(?,?)}");//--------------direccion
            llamada.setString(1, paciente.getId_paciente());
            llamada.setString(2, paciente.getDomicilio());
            llamada.execute();

            cc.commit();
            llamada.close();
        } catch (SQLException ex) {
            try {
                cc.rollback();
            } catch (SQLException ex1) {

                Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
