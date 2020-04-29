
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
import javax.swing.JComboBox;


public class MODL_Antecedentes {

    Conexion cn = new Conexion();
    Connection cc = cn.crearConexion();

    private String scr_anteced = "select * FROM antecedentes where id_paciente='";
    private String scr_tratamiento = "select * from tratamiento  where id_antecedente=";
    private String scr_tipConsult = "SELECT consulta.nombre_consulta  "
            + "FROM consulta INNER JOIN tipo_consulta "
            + "WHERE consulta.id_consulta=tipo_consulta.id_consulta "
            + "AND tipo_consulta.id_antecedente=";


    public void GuardarAntecedente(OBJ_Antecedentes antecedente) {
        try {
            cc.setAutoCommit(false);
            CallableStatement llamada = cc.prepareCall("{call saveAntecedentes(?,?,?,?)}");
            llamada.setString(1, antecedente.getHigiene_bucal());
            llamada.setString(2, antecedente.getAlimentacion());
            llamada.setString(3, antecedente.getId_paciente());
            llamada.setString(4, antecedente.getMotivo_visita());
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

    public int getIdConsulta(String nombre_consulta) {

        int id = 0;
        try {
            ResultSet result = new Conexion().crearConexion().createStatement().executeQuery(
                    "SELECT id_consulta FROM consulta where nombre_consulta='" + nombre_consulta + "'");
            while (result != null & result.next()) {
                id = result.getInt("id_consulta");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MODL_TejidosBlandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public void getItemFechasAntecedentes(String folio_paciente, JComboBox items) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();

            PreparedStatement ps;

            ps = cc.prepareStatement(""
                    + "SELECT fecha FROM antecedentes WHERE id_paciente='" + folio_paciente + "';");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                items.addItem(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MODL_Antecedentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public OBJ_Antecedentes getHistorialAntecedentes(String folio_paciente, String fecha) {
        OBJ_Antecedentes antecedente = new OBJ_Antecedentes();
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();

            PreparedStatement ps = cc.prepareStatement(scr_anteced + folio_paciente + "' AND fecha='" + fecha + "';");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                antecedente.setId_antecedente(rs.getInt(1));
                antecedente.setFecha(rs.getString(2));
                antecedente.setHigiene_bucal(rs.getString(3));
                antecedente.setAlimentacion(rs.getString(4));
                antecedente.setId_paciente(rs.getString(5));
                antecedente.setMotivo_visita(rs.getString(6));
            }

            ps = cc.prepareStatement(scr_tratamiento + antecedente.getId_antecedente() + ";");
            rs = ps.executeQuery();

            rs.next();
            antecedente.setTipo_tratamiento(rs.getString(2));
            antecedente.setObservaciones(rs.getString(3));

            ps = cc.prepareStatement(scr_tipConsult + antecedente.getId_antecedente() + ";");
            rs = ps.executeQuery();

            rs.next();
            antecedente.setTipoConsulta(rs.getString(1));

            rs.close();

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return antecedente;
    }

}
