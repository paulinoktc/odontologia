/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import mdoelo.MODL_Consulta;
import vista.V_DatosPersonales;
import vista.V_Presupuesto;

/**
 *
 * @author ZOMBY
 */
public class CTRL_DatosPersonales {

    V_DatosPersonales v_datosPersonales;
    MODL_Consulta m_consulta;
    public CTRL_DatosPersonales() {
        v_datosPersonales = new V_DatosPersonales();

        agregarActions();
        v_datosPersonales.setDefaultCloseOperation(0);
        LlenarItemsConsulta();

    }

    /**
     * Configura el comportamiento de los botones
     */
    public void agregarActions() {
        /**
         * Ajusta comboBox y textField para un mejor entendimiento de la ventana
         * no todos son requeridos y conforme se necesiten iran apareciendo
         * ejemplo sexo si es hombre no apareceran los meses de embarazo etc.
         */
        v_datosPersonales.jcb_mesesEmbarazo.setVisible(false);
        v_datosPersonales.jtf_alergias.setVisible(false);
        v_datosPersonales.jtf_anti.setVisible(false);
        v_datosPersonales.setVisible(true);
        m_consulta=new MODL_Consulta();
        v_datosPersonales.jtf_hospitalizado.setVisible(false);
        v_datosPersonales.jtf_medicamento.setVisible(false);
        v_datosPersonales.jrb_embarazada.setVisible(false);

        v_datosPersonales.jcb_sexo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v_datosPersonales.jcb_sexo.getSelectedIndex() == 1) {
                    v_datosPersonales.jrb_embarazada.setVisible(true);
                } else {
                    v_datosPersonales.jrb_embarazada.setVisible(false);
                }
            }
        });

        v_datosPersonales.jb_salir.addActionListener(new ActionListener() {
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
    }

    public void LlenarItemsConsulta(){
        m_consulta.cargarItems(v_datosPersonales.jcb_t_consulta);
    }
}
