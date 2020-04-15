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
public class MODL_TejidosBlandos {

    public void GuardarTejidosDB(OBJ_TejidosBlandos tejido) {

        Conexion conexion = new Conexion();
        Connection conectar = conexion.crearConexion();
        
        try {
            conectar.setAutoCommit(false);
            CallableStatement llamada = conectar.prepareCall("{call saveTejidos(?,?,?,?,?,?,?)}");//---paciente
            llamada.setString(1, tejido.getId_paciente());
            llamada.setString(2, tejido.getFrenillo());
            llamada.setString(3, tejido.getMejilla());
            llamada.setString(4, tejido.getLabios());
            llamada.setString(5, tejido.getPaladar());
            llamada.setString(6, tejido.getEncia());
            llamada.setString(7, tejido.getLengua());
            llamada.execute();
            conectar.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_TejidosBlandos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
