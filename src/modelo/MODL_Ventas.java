/**
 * Guarda y extrae ventas de la base de datos
 *
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

public class MODL_Ventas {

    /**
     * Guarla la lista de las ventas
     *
     * @param ventas lista de las ventas a guardar
     */
    public void SaveVentas(ArrayList<OBJ_Reglones> ventas) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();
            cc.setAutoCommit(false);
            CallableStatement llamada = cc.prepareCall("{call saveVenta(?,?,?)}");

            for (OBJ_Reglones lista : ventas) {
                llamada.setString(1, lista.getNombreCliente());
                llamada.setString(2, lista.getConcepto());
                llamada.setDouble(3, lista.getCantidad());
                llamada.execute();
            }

            cc.commit();
        } catch (SQLException ex) {

            Logger.getLogger(MODL_Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Valida si tiene credito o ono
     *
     * @param id_paciente id del paciente a otorgar credito
     * @return tiene o no tiene credito
     */
    public double validaCredito(String id_paciente) {
        double cantidaCuenta = 0;
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();

            PreparedStatement ps = cc.prepareStatement("select validaCredito('" + id_paciente + "');");

            ResultSet rs = ps.executeQuery();
            rs.next();

            cantidaCuenta = Double.parseDouble(rs.getString(1));

        } catch (SQLException ex) {
            Logger.getLogger(MODL_Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidaCuenta;
    }

    /**
     * Otorga un credito al paciente
     *
     * @param id_paciente Id de paciente a otorgar credito
     * @param cantidad catidad del credito a otorgar
     */
    public void otorgarCredito(String id_paciente, double cantidad) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();
            cc.setAutoCommit(false);
            CallableStatement llamada = cc.prepareCall("{call otorgaCredito(?,?)}");

            llamada.setString(1, id_paciente);
            llamada.setDouble(2, cantidad);
            llamada.execute();

            cc.commit();
        } catch (SQLException ex) {

            Logger.getLogger(MODL_Antecedentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Si ya tiene credito lo actualiza
     *
     * @param id_paciente id del paciente a actualizar credito
     * @param cantidad catidad de credito a otorgar
     */
    public void ActializaCredito(String id_paciente, double cantidad) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();
            cc.setAutoCommit(false);
            CallableStatement llamada = cc.prepareCall("{call  actualizarCredito(?,?)}");

            llamada.setString(1, id_paciente);
            llamada.setDouble(2, cantidad);
            llamada.execute();

            cc.commit();
        } catch (SQLException ex) {

            Logger.getLogger(MODL_Antecedentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Abona a la cuenta el procedure se encargar de hacer la operaciones
     * necesarias
     *
     * @param id_paciente id del paciente que abona
     * @param cantidad cantidad que abona
     * @return mensaje que informa si el cobro se realiso correctamente
     */
    public String abonaCuenta(String id_paciente, double cantidad) {
        String mensaje = "";
        try {
            Conexion cn = new Conexion();

            Connection cc = cn.crearConexion();
            cc.setAutoCommit(false);
            PreparedStatement ps = cc.prepareStatement(
                    "select abonarCuenta('" + id_paciente + "'," + cantidad + ");");

            ResultSet rs = ps.executeQuery();
            rs.next();

            mensaje = rs.getString(1);
            cc.commit();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }

    /**
     * Extrae y muestra todas las ventas del dia
     *
     * @param fecha fecha de las ventas a mostrar
     * @return Lista de las ventas encontradas
     */
    public ArrayList<OBJ_Ventas> todasLasVentas(String fecha) {
        ArrayList<OBJ_Ventas> listaVentas = new ArrayList<>();
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();

            PreparedStatement ps = cc.prepareStatement(
                    "select concepto_pago, cantidad from totalVentas where fecha='" + fecha + "';");

            ResultSet rs = ps.executeQuery();
            while (rs.next() && rs != null) {
                listaVentas.add(new OBJ_Ventas(rs.getString(1), rs.getDouble(2)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(MODL_Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVentas;
    }

    /**
     * Realiza las sumas de l dia para cerrar caja
     *
     * @param fecha fecha en la que se buscan las ventas
     * @return suma total de las ventas
     */
    public double totalVentasDia(String fecha) {
        double total = 0;
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();

            PreparedStatement ps = cc.prepareStatement(
                    "select sum(cantidad) from totalVentas where fecha='" + fecha + "';");

            ResultSet rs = ps.executeQuery();
            rs.next();
            total = rs.getDouble(1);

        } catch (SQLException ex) {
            Logger.getLogger(MODL_Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
}
