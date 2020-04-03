/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
        try {
            Statement state = new Conexion().crearConexion().createStatement();
            state.executeUpdate("INSERT INTO tejidos_blandos("
                    + "id_paciente,"
                    + "frenillo,"
                    + "mejilla,"
                    + "labios,"
                    + "paladar,"
                    + "encia,"
                    + "lengua) VALUES("
                    + +tejido.getId_paciente()+",'"
                    + tejido.getFrenillo() + "','"
                    + tejido.getMejilla() + "','"
                    + tejido.getLabios() + "','"
                    + tejido.getPaladar() + "','"
                    + tejido.getEncia() + "','"
                    + tejido.getLengua() + "')");
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getUltimoId() {

        String id = "";
        try {
            ResultSet result = new Conexion().crearConexion().createStatement().executeQuery("SELECT id_tejidos FROM tejidos_blandos");
            while (result != null & result.next()) {
                id = result.getString("id_tejidos");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MODL_TejidosBlandos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
}
