/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
los * muestras las tablas que se usan en la base de datos
 */
package controlador;

import mdoelo.ExtraccionDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import mdoelo.MODL_Consulta;
import mdoelo.*;
import vista.V_DatosPersonales;

/**
 *
 * @author Paulino
 */
public class CTRL_DatosPersonales {

    V_DatosPersonales v_datosPersonales;
    MODL_Consulta m_consulta;
    MODL_TejidosBlandos mdl_tejidos;
    MODL_Domicilio mdl_domicilio;
    OBJ_Paciente paciente;
    ExtraccionDatos extraerDatosVista;
    OBJ_Tratamiento tratamiento;
    OBJ_Antecedentes antecedentes;
    OBJ_Referencia domicilio;
    OBJ_Referencia numTelefono;
    OBJ_Referencia correo = null;
    OBJ_Referencia tutor;
    OBJ_TejidosBlandos tegidosBlandos = null;
    OBJ_Estado embarazada = null;
    OBJ_Estado anticonceptivo;
    OBJ_Relacion tipoCionsulta;
    
    
    ArrayList<OBJ_Relacion> listaHabitos = null;
    ArrayList<OBJ_Padecimiento> listaPadecimienientos = null;
    ArrayList<OBJ_Relacion> listaMedicamentos = null;
    ArrayList<OBJ_Relacion> listaAlergia = null;

    public CTRL_DatosPersonales() {
        listaMedicamentos = new ArrayList<OBJ_Relacion>();
        listaAlergia = new ArrayList<OBJ_Relacion>();

        v_datosPersonales = new V_DatosPersonales();
        extraerDatosVista = new ExtraccionDatos();
        agregarActions();
        v_datosPersonales.setDefaultCloseOperation(0);
        LlenarItemsConsulta();
        setModels();
        
    }
    
    public void setModels(){
        mdl_tejidos=new MODL_TejidosBlandos();
        mdl_domicilio=new MODL_Domicilio();
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
                RecopilarDatos();//--------------------------------------------pendiente
            }
        });
    }

    public void LlenarItemsConsulta() {
        m_consulta.cargarItems(v_datosPersonales.jcb_t_consulta);
    }

    public void RecopilarDatos() {
        System.out.println("sucess full");
//        paciente.MostrarDatos();

        EstraerDomicilio();
        
        EstraerTejidosBlandos();
        
        ExtraerPaciente();
        ExtraerTratamiento();
        ExtraerAntecedentes();
        EstraerCorreo();
        EstraerTelefono();
        EstraerTutor();
        EstraerPadecimientos();
        ExtraerEmbarazo();
        ExtraeAnticonc();
        ExtraerTipoConsulta();
        ExtraerHabitos();
        AgregarMedicamentos();
        AgregarAlergias();
        
        GuardarDatos();

        System.out.println("sucess full");
    }

    public void ExtraerPaciente() {
        paciente = extraerDatosVista.ExtraerDatosPaciente(v_datosPersonales);

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
        domicilio.prints();
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

    public void EstraerTejidosBlandos() {
        tegidosBlandos = extraerDatosVista.EstraerTegidosBlandos(v_datosPersonales);//tejidos_blandos*
    }

    public void ExtraerEmbarazo() {
        embarazada = extraerDatosVista.EstraerDatosEmbarazo(v_datosPersonales, antecedentes);//embarazada*
    }

    public void ExtraeAnticonc() {                                              //anticonc
        anticonceptivo = extraerDatosVista.ExtraerAntic(v_datosPersonales.jtf_anti, antecedentes);
    }

    /**
     * Agrega los medicamentos de la vista al Array de OBJ_Relacion de
     * medicamentos
     */
    public void AgregarMedicamentos() {                                          //anteced_medicam*
        listaMedicamentos.add(extraerDatosVista.ExtraerMedicamento(v_datosPersonales.jtf_medicamento, antecedentes));
    }

    public void AgregarAlergias() {                                             //anteced_alergias*
        listaAlergia.add(extraerDatosVista.ExtraerAlergia(v_datosPersonales.jtf_alergias, antecedentes));
    }

    public void ExtraerTipoConsulta() {                                             //tipo_consulta*
        tipoCionsulta = extraerDatosVista.EstraerConsulta(v_datosPersonales.jcb_t_consulta, antecedentes);
    }
    public void GuardarDatos(){
       // mdl_domicilio.ExtraerUltimoID(domicilio);
        mdl_domicilio.GuardarDomicilioDB(domicilio);
       // mdl_tejidos.ExtraerUltimoID(tegidosBlandos);
        mdl_tejidos.GuardarTejidosDB(tegidosBlandos);
        
    }
}
