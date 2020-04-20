package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MODL_ReferenciaTB {

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
                System.out.println(lista.getId_antecedente() + " " + lista.getNombre());
            }

            cc.commit();
        } catch (SQLException ex) {

            Logger.getLogger(MODL_Antecedentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
