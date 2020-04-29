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

    private String scr_l_medicamento = "SELECT nombre_medicamento "
            + "FROM medicamento "
            + "WHERE id_antecedente=";
    private String scr_l_alerjias = "SELECT nombre_alergia "
            + "FROM alergia "
            + "WHERE id_antecedente=";

    private String scr_l_anticoncept = "SELECT nombre_antico "
            + "FROM anticonceptivo   "
            + "WHERE id_antecedente=";

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

    public void saveListMedicamento(ArrayList<OBJ_Referencia> listaAlergia) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();
            cc.setAutoCommit(false);
            CallableStatement llamada = cc.prepareCall("{call saveMedicamento(?,?)}");

            for (OBJ_Referencia lista : listaAlergia) {
                llamada.setInt(1, lista.getId_antecedente());
                llamada.setString(2, lista.getNombre());
                llamada.execute();
            }

            cc.commit();
        } catch (SQLException ex) {

            Logger.getLogger(MODL_ReferenciaTB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
