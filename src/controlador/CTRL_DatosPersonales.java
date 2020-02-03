/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.V_DatosPersonales;
import vista.V_Presupuesto;

/**
 *
 * @author ZOMBY
 */
public class CTRL_DatosPersonales {

    V_DatosPersonales v_datosPersonales;
    V_Presupuesto v_presupuesto;

    public CTRL_DatosPersonales() {
        v_datosPersonales = new V_DatosPersonales();
        v_presupuesto=new V_Presupuesto();
        //v_historial = new V_Historial();
        agregarActions();

    }

    public void agregarActions() {

        v_datosPersonales.jcb_mesesEmbarazo.setVisible(false);
        v_datosPersonales.jtf_alergias.setVisible(false);
        v_datosPersonales.jtf_anti.setVisible(false);
        v_datosPersonales.setVisible(true);
        v_datosPersonales.setVisible(true);
        v_datosPersonales.jtf_hospitalizado.setVisible(false);
        v_datosPersonales.jtf_medicamento.setVisible(false);
        v_datosPersonales.jrb_embarazada.setVisible(false);
        
        v_datosPersonales.jcb_sexo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(v_datosPersonales.jcb_sexo.getSelectedIndex()==1){
                    v_datosPersonales.jrb_embarazada.setVisible(true);
                }else{
                    v_datosPersonales.jrb_embarazada.setVisible(false);
                }
            }
        });

        v_datosPersonales.jmi_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_datosPersonales.dispose();
                new CTRL_principal();
            }
        });

        v_datosPersonales.jrb_embarazada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v_datosPersonales.jrb_embarazada.isSelected()) {
                    v_datosPersonales.jcb_mesesEmbarazo.setVisible(true);
                } else {
                    v_datosPersonales.jcb_mesesEmbarazo.setVisible(false);
                }
            }
        });

        v_datosPersonales.jrb_alergias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v_datosPersonales.jrb_alergias.isSelected()) {
                    v_datosPersonales.jtf_alergias.setVisible(true);
                } else {
                    v_datosPersonales.jtf_alergias.setVisible(false);
                }
            }
        });

        v_datosPersonales.jrb_anti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v_datosPersonales.jrb_anti.isSelected()) {
                    v_datosPersonales.jtf_anti.setVisible(true);
                } else {
                    v_datosPersonales.jtf_anti.setVisible(false);
                }
            }
        });

        v_datosPersonales.jrb_hospializado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v_datosPersonales.jrb_hospializado.isSelected()) {
                    v_datosPersonales.jtf_hospitalizado.setVisible(true);
                } else {
                    v_datosPersonales.jtf_hospitalizado.setVisible(false);
                }
            }
        });

        v_datosPersonales.jrb_medicamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v_datosPersonales.jrb_medicamento.isSelected()) {
                    v_datosPersonales.jtf_medicamento.setVisible(true);
                } else {
                    v_datosPersonales.jtf_medicamento.setVisible(false);
                }
            }
        });
        /*
        
        v_datosPersonales.jmi_presupuesto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CTRL_Presupuesto();
            }
        });
        */
       v_presupuesto.jmi_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_presupuesto.setVisible(false);
            }
        });
    }
}
