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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zomby
 */
public class MODL_RelacionTB {

    private String src_habitos = "SELECT habito.nombre_habito  "
            + "FROM habito INNER JOIN anteced_habit "
            + "WHERE habito.id_habito=anteced_habit.id_habito "
            + "AND anteced_habit.id_antecedente=";

    public int getIdPaHabito(OBJ_Relacion habito) {

        int id = 0;
        try {
            ResultSet result = new Conexion().crearConexion().createStatement().executeQuery(
                    "SELECT id_habito FROM habito WHERE nombre_habito='" + habito.getNombre() + "'");
            if (result != null & result.next()) {
                id = result.getInt("id_habito");
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_TejidosBlandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public void saveListHabitos(ArrayList<OBJ_Relacion> listaHabitos) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();
            cc.setAutoCommit(false);
            CallableStatement llamada = cc.prepareCall("{call saveAntecHabit(?,?)}");

            for (OBJ_Relacion lista : listaHabitos) {
                llamada.setInt(1, lista.getId_antecedente());
                llamada.setInt(2, lista.getId_Relacion());
                llamada.execute();
            }

            cc.commit();
        } catch (SQLException ex) {

            Logger.getLogger(MODL_Antecedentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> getListaHabitos(int id_antecedente) {

        ArrayList<String> listaHabitos = new ArrayList<>();
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();
            PreparedStatement ps = cc.prepareStatement(src_habitos + id_antecedente + ";");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listaHabitos.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaHabitos;
    }

}
