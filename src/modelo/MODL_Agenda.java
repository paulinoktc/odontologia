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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zomby
 */
public class MODL_Agenda {

    private String buscaTodos = "SELECT paciente.id_paciente, paciente.nombre, paciente.ap_apellido,paciente.am_apellido,agenda.fecha_agenda,agenda.motivo"
            + "    FROM paciente INNER JOIN agenda"
            + "    WHERE paciente.id_paciente=agenda.id_paciente;";
    private String buscaAtendidos = "SELECT paciente.id_paciente, paciente.nombre, paciente.ap_apellido,paciente.am_apellido,agenda.fecha_agenda,agenda.motivo"
            + "    FROM paciente INNER JOIN agenda"
            + "    WHERE paciente.id_paciente=agenda.id_paciente"
            + "     AND agenda.atendido=1 AND fecha_agenda='";
    private String buscaNoAtendidos = "SELECT paciente.id_paciente, paciente.nombre, paciente.ap_apellido,paciente.am_apellido,agenda.fecha_agenda,agenda.motivo"
            + "    FROM paciente INNER JOIN agenda"
            + "    WHERE paciente.id_paciente=agenda.id_paciente"
            + "     AND agenda.atendido=0 AND fecha_agenda='";

    public void agendarCita(String id_paciente, String fecha, String motivo) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();
            cc.setAutoCommit(false);

            CallableStatement llamada = cc.prepareCall("{call saveCita(?,?,?)}");

            llamada.setString(1, id_paciente);
            llamada.setString(2, fecha);
            llamada.setString(3, motivo);
            llamada.execute();

            cc.commit();
        } catch (SQLException ex) {

            Logger.getLogger(MODL_Antecedentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param buscarPor
     * @param fecha
     * @param defModel
     */
    public void EnlistarAgenda(int buscarPor, String fecha, DefaultTableModel defModel) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();

            PreparedStatement ps = cc.prepareStatement(usarScript(buscarPor, fecha));

            ResultSet rs = ps.executeQuery();
            String elementos[] = new String[6];
            while (rs.next()) {
                elementos[0] = rs.getString(1);
                elementos[1] = rs.getString(2);
                elementos[2] = rs.getString(3);
                elementos[3] = rs.getString(4);
                elementos[4] = rs.getString(5);
                elementos[5] = rs.getString(6);
                defModel.addRow(elementos);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String usarScript(int buscarPor, String fecha) {
        switch (buscarPor) {
            case 0:
                return buscaTodos;
            case 1:
                return buscaAtendidos += fecha + "';";
            case 2:
                return buscaNoAtendidos += fecha + "';";
        }
        return buscaTodos;
    }
}
