/**
 * Extrae y agrega a la base de datos todo lo referente a la agenda (citas)
 */
package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SandraElizabet
 */
public class MODL_Agenda {

    /**
     * Consultas SQL a usar
     */
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

    /**
     *
     * @param id_paciente id del paciente al que se le agenda una cita
     * @param fecha fehca de la cita agendada
     * @param motivo Motivo de la cita
     */
    public void agendarCita(String id_paciente, String fecha, String motivo) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();
            cc.setAutoCommit(false);

            /**
             * llama al procedure para guardar la cita
             */
            CallableStatement llamada = cc.prepareCall("{call saveCita(?,?,?)}");

            llamada.setString(1, id_paciente);
            llamada.setString(2, fecha);
            llamada.setString(3, motivo);
            llamada.execute();
            JOptionPane.showMessageDialog(null, "Cita guardada");

            cc.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Selecciona una Fecha");
            //   Logger.getLogger(MODL_Antecedentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Busca los datos de las citas en la base de datos y los agrega a una tabla
     * que recibe como parametro
     *
     * @param buscarPor Estado de la cita como se desea buscar
     * @param fecha Fecha de las citas
     * @param defModel Donde se motraran los datos encontrados
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

    /**
     * Define que consulta se va a uasr o como se va a buscar
     *
     * @param buscarPor Estado en la que se va a buscar atendido o no atendido
     * @param fecha Fecha en la que se desea ver las citas
     * @return Consulta que se va a utilizar
     */
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
