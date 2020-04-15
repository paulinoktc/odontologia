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

public class MODL_Padecimiento {

    public int getIdPadecimiento(OBJ_Padecimiento nombre_consulta) {

        int id = 0;
        try {
            ResultSet result = new Conexion().crearConexion().createStatement().executeQuery(
                    "SELECT id_padecimiento FROM padecimiento WHERE nombre_padecimiento='" + nombre_consulta.getNombre_padecimiento() + "'");
            if (result != null & result.next()) {
                id = result.getInt("id_padecimiento");
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_TejidosBlandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public void saveListaPadecimientos(ArrayList<OBJ_Padecimiento> listaPadecimienientos) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();
            cc.setAutoCommit(false);

            CallableStatement llamada = cc.prepareCall("{call savePadecimientos(?,?)}");

            for (OBJ_Padecimiento lista : listaPadecimienientos) {
                llamada.setString(1,lista.getId_paciente());
                llamada.setInt(2,lista.getId_padecimiento());
                llamada.execute();
            }

            cc.commit();
        } catch (SQLException ex) {
            
            Logger.getLogger(MODL_Antecedentes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
