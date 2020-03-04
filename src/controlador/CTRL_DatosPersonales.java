/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mdoelo.MODL_Consulta;
import mdoelo.OBJ_Antecedentes;
import mdoelo.OBJ_Paciente;
import mdoelo.OBJ_Relacion;
import mdoelo.OBJ_Tratamiento;
import vista.V_DatosPersonales;
import vista.V_Presupuesto;

/**
 *
 * @author ZOMBY
 */
public class CTRL_DatosPersonales {

    V_DatosPersonales v_datosPersonales;
    MODL_Consulta m_consulta;
    OBJ_Paciente paciente;
    ExtraccionDatos extraerDatosVista;
    OBJ_Tratamiento tratamiento;
    OBJ_Antecedentes antecedentes;
    ArrayList<OBJ_Relacion> listaHabitos;

    public CTRL_DatosPersonales() {
        v_datosPersonales = new V_DatosPersonales();
        extraerDatosVista = new ExtraccionDatos();
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
        m_consulta = new MODL_Consulta();
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
        v_datosPersonales.jb_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                extraerDatosPaciente();//--------------------------------------------pendiente
            }
        });
    }

    public void LlenarItemsConsulta() {
        m_consulta.cargarItems(v_datosPersonales.jcb_t_consulta);
    }

    public void extraerDatosPaciente() {
        paciente = extraerDatosVista.ExtraerDatosPaciente(v_datosPersonales);
        System.out.println("sucess full");
        
        extraerTratamiento();
        extraerAntecedentes();
        ExtraerHabitos();
        //-----------------------------------------------------------------------extraer datos habitos
    }

    public void extraerTratamiento() {
        tratamiento = extraerDatosVista.ExtraerTratamiento(v_datosPersonales);
    }
    
    public void extraerAntecedentes(){
        antecedentes=extraerDatosVista.ExtraerAntecedentes(v_datosPersonales, tratamiento, 0);//modificar el idpaciente
    }
    public void ExtraerHabitos(){
        listaHabitos=extraerDatosVista.ExtraerDatosHabitos(v_datosPersonales, antecedentes);
    }
}
