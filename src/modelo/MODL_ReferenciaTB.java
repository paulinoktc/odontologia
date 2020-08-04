/**
 * Se comporta como las tablas de referencias mostrada en la base de datos
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

public class MODL_ReferenciaTB {

    /**
     * consultas a usar
     */
    private String scr_l_medicamento = "SELECT nombre_medicamento "
            + "FROM medicamento "
            + "WHERE id_antecedente=";
    private String scr_l_alerjias = "SELECT nombre_alergia "
            + "FROM alergia "
            + "WHERE id_antecedente=";

    private String scr_l_anticoncept = "SELECT nombre_antico "
            + "FROM anticonceptivo   "
            + "WHERE id_antecedente=";

    /**
     * guar una Lista de alergias
     *
     * @param listaAlergia Lista de alergias
     */
    public void saveLisAlergias(ArrayList<OBJ_Referencia> listaAlergia) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();
            cc.setAutoCommit(false);
            CallableStatement llamada = cc.prepareCall("{call saveAlergia(?,?)}");

            for (OBJ_Referencia lista : listaAlergia) {
                llamada.setInt(1, lista.getId_antecedente());
                llamada.setString(2, lista.getNombre());
                llamada.execute();
            }

            cc.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Antecedentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Guarda el antoonceptivo usado por el paicente
     *
     * @param antic Objeto de Referencia
     */
    public void saveAntic(OBJ_Referencia antic) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();
            cc.setAutoCommit(false);
            CallableStatement llamada = cc.prepareCall("{call saveAntic(?,?)}");

            llamada.setInt(1, antic.getId_antecedente());
            llamada.setString(2, antic.getNombre());
            llamada.execute();

            cc.commit();
        } catch (SQLException ex) {

            Logger.getLogger(MODL_Antecedentes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Guarda la lista de medicamentos
     *
     * @param listaMedicamentos lista de medicamentos a guardar
     */
    public void saveListMedicamento(ArrayList<OBJ_Referencia> listaMedicamentos) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();
            cc.setAutoCommit(false);
            CallableStatement llamada = cc.prepareCall("{call saveMedicamento(?,?)}");

            for (OBJ_Referencia lista : listaMedicamentos) {
                llamada.setInt(1, lista.getId_antecedente());
                llamada.setString(2, lista.getNombre());
                llamada.execute();
            }

            cc.commit();
        } catch (SQLException ex) {

            Logger.getLogger(MODL_ReferenciaTB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Extrae las lista de medicamentos que se encuentran en la base de datos
     *
     * @param id_antecedente id_ del antecedente a buscar
     * @return lista de los medicamentos
     */
    public ArrayList<String> getListaMedicamentos(int id_antecedente) {
        ArrayList<String> listMedicamento = new ArrayList<>();
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();
            PreparedStatement ps = cc.prepareStatement(scr_l_medicamento + id_antecedente + ";");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listMedicamento.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listMedicamento;
    }

    /**
     * Extrae la lista de alergias que se encuentran en la base de datos
     *
     * @param id_antecedente id del antecedente a buscar
     * @return Lista de Alergias a buscar
     */
    public ArrayList<String> getListaAlergias(int id_antecedente) {
        ArrayList<String> listAlergias = new ArrayList<>();
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();
            PreparedStatement ps = cc.prepareStatement(scr_l_alerjias + id_antecedente + ";");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listAlergias.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listAlergias;
    }

    /**
     * Extrae Anticonceptivo
     *
     * @param id_antecedente id del antecedente a buscar
     * @return Anticonceptivo a buscar
     */
    public String getAnticonceptivo(int id_antecedente) {
        String antic = "";
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();
            PreparedStatement ps = cc.prepareStatement(scr_l_anticoncept + id_antecedente + ";");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                antic = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return antic;
    }

}
