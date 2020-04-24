/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import modelo.MODL_Ventas;
import modelo.OBJ_Ventas;
import vista.V_Agenda;
import vista.V_Cobrar;

/**
 *
 * @author ZOMBY
 */
public class CTRL_Venta {

    V_Cobrar v_ventasDia;

    public CTRL_Venta() {
        v_ventasDia = new V_Cobrar();
        agregarActions();
        AjustarVentana();
        v_ventasDia.jb_add.setVisible(false);
        v_ventasDia.jb_rm.setVisible(false);    
        v_ventasDia.setVisible(true);
        mostrarVentas(getFecha());
    }

    /**
     * Ajusta la ventana combrar para terminar las ventas de dia
     */
    public void AjustarVentana() {
        v_ventasDia.jl_titulo.setText("VENTAS DEL DIA");
        v_ventasDia.jl_nombre.setVisible(false);
    }

    public void agregarActions() {
        v_ventasDia.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_ventasDia.dispose();
                new CTRL_principal();
            }
        });
        v_ventasDia.jb_cobrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                v_ventasDia.jl_total_pagar.setText("$ "+new MODL_Ventas().totalVentasDia(getFecha()));
            }
        });
    }

    public void mostrarVentas(String fecha) {
        ArrayList<OBJ_Ventas> listaVentas = new MODL_Ventas().todasLasVentas(fecha);
        for (OBJ_Ventas listaVnts : listaVentas) {
            String[] add = {listaVnts.getConseptoPago(), "$ " + listaVnts.getCantidad()};
            v_ventasDia.defModel.addRow(add);
        }
    }

    public String getFecha() {
        String fecha = "";//iniciales;
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter ldt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        fecha += datetime.format(ldt);
        return fecha;
    }
}
