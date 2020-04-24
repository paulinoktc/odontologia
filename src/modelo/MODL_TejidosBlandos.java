/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zomby
 */
public class MODL_TejidosBlandos {

    private String scr_tejidBlands = "SELECT frenillo,mejilla,labios,paladar,encia,lengua FROM tejidos_blandos "
            + "WHERE id_paciente='";

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

    public OBJ_TejidosBlandos getListTejidos(String id_paciente) {

        OBJ_TejidosBlandos tejidos = new OBJ_TejidosBlandos();
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();
            PreparedStatement ps = cc.prepareStatement(scr_tejidBlands + id_paciente + "';");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tejidos.setFrenillo(rs.getString(1));
                tejidos.setMejilla(rs.getString(2));
                tejidos.setLabios(rs.getString(3));
                tejidos.setPaladar(rs.getString(4));
                tejidos.setEncia(rs.getString(5));
                tejidos.setLengua(rs.getString(6));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tejidos;
    }
}
