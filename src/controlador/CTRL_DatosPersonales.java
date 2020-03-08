/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
los * muestras las tablas que se usan en la base de datos
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mdoelo.MODL_Consulta;
import mdoelo.*;
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
    ArrayList<OBJ_Relacion> listaHabitos = null;
    OBJ_Referencia domicilio;
    OBJ_Referencia numTelefono;
    OBJ_Referencia correo = null;
    OBJ_Referencia tutor;
    ArrayList<OBJ_Padecimiento> listaPadecimienientos = null;
    OBJ_TejidosBlandos tegidosBlandos = null;
    OBJ_Estado embarazada = null;

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
        m_consulta = new MODL_Consulta();
        v_datosPersonales.jtf_hospitalizado.setVisible(false);
        v_datosPersonales.jtf_medicamento.setVisible(false);
        v_datosPersonales.jrb_embarazada.setVisible(false);
        v_datosPersonales.setVisible(true);

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
        paciente.MostrarDatos();

        ExtraerTratamiento();
        tratamiento.MostrarDatos();
        ExtraerAntecedentes();
        antecedentes.MostrarElementos();
        ExtraerHabitos();
        EstraerDomicilio();
        EstraerTelefono();
        EstraerCorreo();
        EstraerTutor();
        EstraerTegidosBlandos();
        EstraerPadecimientos();

        System.out.println("sucess full");
    }

    public void ExtraerTratamiento() {
        tratamiento = extraerDatosVista.ExtraerTratamiento(v_datosPersonales);  //tabla tratamiento*
    }

    public void ExtraerAntecedentes() {                                         //tabla antecedentes*
        //----------------------------------------------------------------------cargar fecha desde sql
        antecedentes = extraerDatosVista.ExtraerAntecedentes(v_datosPersonales, tratamiento, 0);//modificar el idpaciente
    }

    public void ExtraerHabitos() {//--------------------------------------------enviar id antecedente
        listaHabitos = extraerDatosVista.ExtraerDatosHabitos(v_datosPersonales, antecedentes);//anteced_habit*
    }

    public void EstraerDomicilio() {
        domicilio = new OBJ_Referencia(v_datosPersonales.jt_domicilio.getText());//domicilio*
    }

    public void EstraerTelefono() {//-------------------------------------------crearArrayList de objetos
        numTelefono = new OBJ_Referencia(v_datosPersonales.jt_telefono.getText());//telefono*
    }

    public void EstraerCorreo() {
        correo = new OBJ_Referencia(v_datosPersonales.jt_correo.getText()); // --pendiente borrar anterior
    }                                                                           //correo*

    public void EstraerTutor() {
        tutor = new OBJ_Referencia(v_datosPersonales.jt_representante.getText());//borrar anterior
    }                                                                           //tutor*

    public void EstraerPadecimientos() {
        //----------------------------------------------------------------------contemplar que puede estar vacia
        listaPadecimienientos = extraerDatosVista.EstraerPadecimientos(v_datosPersonales, paciente);
    }                                                                           //padeci_paciente*

    public void EstraerTegidosBlandos() {
        tegidosBlandos = extraerDatosVista.EstraerTegidosBlandos(v_datosPersonales);//tejidos_blandos*
    }

    public void ExtraerEmbarazo() {
        embarazada = extraerDatosVista.EstraerDatosEmbarazo(v_datosPersonales, antecedentes);//embarazada*
    }

}
