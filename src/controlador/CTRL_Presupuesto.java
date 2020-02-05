/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JOptionPane;
import mdoelo.ExtraccionDatos;
import mdoelo.MatrizCostos;
import vista.V_Presupuesto;

/**
 *
 * @author ZOMBY
 */
public class CTRL_Presupuesto {

    V_Presupuesto v_presupuesto;
    ExtraccionDatos xtraccionDatos;

    public CTRL_Presupuesto() {
        v_presupuesto = new V_Presupuesto();
        xtraccionDatos = new ExtraccionDatos();
        AgregarActions();
        v_presupuesto.setVisible(true);
    }

    public void AgregarActions() {
        v_presupuesto.jb_calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xtraccionDatos.ExtraerDatosPresupuesto(v_presupuesto);
                CalcularPrecioTotal();
            }
        });
        
        v_presupuesto.jmi_generarHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_presupuesto.dispose();
                new CTRL_DatosPersonales();
            }
        });
        
        v_presupuesto.jmi_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_presupuesto.dispose();
                new CTRL_principal();
            }
        });
    }

    public void CalcularPrecioTotal() {
        double totalNeto = 0;

        MatrizCostos[] listaPresupuesto = xtraccionDatos.getListaPresupuesto();

        for (int i = 0; i < listaPresupuesto.length; i++) {
            if (listaPresupuesto[i] != null) {
                totalNeto += listaPresupuesto[i].getTotal();
                v_presupuesto.jl_total.setText("$" + totalNeto);
            }
            
        }
    }
}
