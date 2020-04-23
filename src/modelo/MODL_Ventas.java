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
public class MODL_Ventas {

    public void SaveVentas(ArrayList<OBJ_Reglones> ventas) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();
            cc.setAutoCommit(false);
            CallableStatement llamada = cc.prepareCall("{call saveVenta(?,?)}");

            for (OBJ_Reglones lista : ventas) {
                llamada.setString(1, lista.getConcepto());
                llamada.setDouble(2, lista.getCantidad());
                llamada.execute();
            }

            cc.commit();
        } catch (SQLException ex) {

            Logger.getLogger(MODL_Antecedentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    public String abonaCuenta(String id_paciente, double cantidad) {
        String mensaje = "";
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();

            PreparedStatement ps = cc.prepareStatement(
                    "select abonarCuenta('" + id_paciente + "'," + cantidad + ");");

            ResultSet rs = ps.executeQuery();
            rs.next();

            mensaje = rs.getString(1);

        } catch (SQLException ex) {
            Logger.getLogger(MODL_Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }

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
