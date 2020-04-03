/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
los * muestras las tablas que se usan en la base de datos
 */
package controlador;

import modelo.OBJ_Antecedentes;
import modelo.OBJ_Paciente;
import modelo.MODL_Antecedentes;
import modelo.OBJ_Referencia;
import modelo.MODL_TejidosBlandos;
import modelo.OBJ_Tratamiento;
import modelo.OBJ_Domicilio;
import modelo.OBJ_TejidosBlandos;
import modelo.MODL_Paciente;
import modelo.OBJ_Relacion;
import modelo.MODL_Domicilio;
import modelo.OBJ_Padecimiento;
import modelo.MODL_Tratamiento;
import modelo.OBJ_Estado;
import modelo.ExtraccionDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.MODL_Consulta;
import modelo.MODL_Estados;
import modelo.MODL_Referencia;
import modelo.MODL_Relacion;
import vista.V_DatosPersonales;

/**
 *
 * @author Paulino
 */
public class CTRL_DatosPersonales {

    V_DatosPersonales v_datosPersonales;
    //--------------------------------------------------------------------------Modelos
    MODL_Consulta mdl_consulta;
    MODL_TejidosBlandos mdl_tejidos;
    MODL_Domicilio mdl_domicilio;
    MODL_Paciente mdl_paciente;
    MODL_Tratamiento mdl_tratamiento;
    MODL_Antecedentes mdl_antecedente;
    MODL_Referencia mdl_referencia;
    MODL_Estados mdl_estado;
    //--------------------------------------------------------------------------Objetos
    OBJ_Paciente paciente;
    ExtraccionDatos extraerDatosVista;
    OBJ_Tratamiento tratamiento;
    OBJ_Antecedentes antecedentes;
    OBJ_Domicilio domicilio;

    OBJ_Referencia numTelefono;
    OBJ_Referencia correo = null;
    OBJ_Referencia tutor;
    OBJ_Referencia hospitalizado;
    OBJ_Referencia anticonceptivo;
    
    OBJ_TejidosBlandos tegidosBlandos = null;
    OBJ_Estado embarazada = null;
    OBJ_Relacion tipoCionsulta;
    //--------------------------------------------------------------------------Listas
    ArrayList<OBJ_Relacion> listaHabitos = null;
    ArrayList<OBJ_Padecimiento> listaPadecimienientos = null;
    ArrayList<OBJ_Referencia> listaMedicamentos = null;
    ArrayList<OBJ_Referencia> listaAlergia = null;

    public CTRL_DatosPersonales() {
        listaMedicamentos = new ArrayList<OBJ_Referencia>();
        listaAlergia = new ArrayList<OBJ_Referencia>();

        v_datosPersonales = new V_DatosPersonales();
        extraerDatosVista = new ExtraccionDatos();
        agregarActions();
        v_datosPersonales.setDefaultCloseOperation(0);
        LlenarItemsConsulta();
        setModels();

    }

    public void setModels() {
        mdl_tejidos = new MODL_TejidosBlandos();
        mdl_domicilio = new MODL_Domicilio();
        mdl_paciente = new MODL_Paciente();
        mdl_tratamiento = new MODL_Tratamiento();
        mdl_antecedente = new MODL_Antecedentes();
        mdl_referencia = new MODL_Referencia();
        mdl_estado=new MODL_Estados();
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
        mdl_consulta = new MODL_Consulta();
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
        mdl_consulta.cargarItems(v_datosPersonales.jcb_t_consulta);
    }

    public void RecopilarDatos() {
//-------------------------------------------datos obligatorios
        EstraerDomicilio();
        EstraerTejidosBlandos();

        ExtraerPaciente();
        ExtraerTratamiento();
        ExtraerAntecedentes();
        
        GuardarDatosPimarios();//-----------------------------------------------guardando datos primarios

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
        ExtraerHospitalizado();
        
        GuardarDatosSecundarios();

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

    public void EstraerDomicilio() {
        domicilio = new OBJ_Domicilio(v_datosPersonales.jt_domicilio.getText());//domicilio*
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

    public void EstraerTejidosBlandos() {
        tegidosBlandos = extraerDatosVista.EstraerTegidosBlandos(v_datosPersonales);//tejidos_blandos*
    }

    public void ExtraerEmbarazo() {
        embarazada = extraerDatosVista.EstraerDatosEmbarazo(v_datosPersonales);//embarazada*
        embarazada.setId_antecedente(antecedentes.getId_antecedente());         //------------estableciendo el Id antecedente                
    }

    public void ExtraeAnticonc() {                                              //anticonc
        anticonceptivo = extraerDatosVista.ExtraerAntic(v_datosPersonales.jtf_anti);
        anticonceptivo.setId_antecedente(antecedentes.getId_antecedente());
    }

    /**
     * Agrega los medicamentos de la vista al Array de OBJ_Relacion de
     * medicamentos
     */
    public void AgregarMedicamentos() {                                          //anteced_medicam*
        listaMedicamentos.add(extraerDatosVista.ExtraerMedicamento(v_datosPersonales.jtf_medicamento));
    }

    public void AgregarAlergias() {                                             //anteced_alergias*
        listaAlergia.add(extraerDatosVista.ExtraerAlergia(v_datosPersonales.jtf_alergias));
    }

    public void EstraerPadecimientos() {
        //----------------------------------------------------------------------contemplar que puede estar vacia
        listaPadecimienientos = extraerDatosVista.EstraerPadecimientos(v_datosPersonales, paciente);
    }                                                                           //padeci_paciente*

    public void ExtraerHabitos() {//--------------------------------------------enviar id antecedente
        listaHabitos = extraerDatosVista.ExtraerDatosHabitos(v_datosPersonales, antecedentes);//anteced_habit*
    }

    public void ExtraerTipoConsulta() {                                             //tipo_consulta*
        tipoCionsulta = extraerDatosVista.EstraerConsulta(v_datosPersonales.jcb_t_consulta, antecedentes);
    }
    
    public void ExtraerHospitalizado(){
        hospitalizado=extraerDatosVista.ExtraeEsteElemento(v_datosPersonales.jtf_hospitalizado);
        hospitalizado.setId_antecedente(antecedentes.getId_antecedente());
    }

    public void GuardarDatosPimarios() {
        // mdl_domicilio.ExtraerUltimoID(domicilio);
        mdl_paciente.GuardarDatospacienteDB(paciente);
        paciente.setId_paciente(Integer.parseInt(mdl_paciente.getUltimoId()));

        domicilio.setId_paciente(paciente.getId_paciente());
        mdl_domicilio.GuardarDomicilioDB(domicilio);
        domicilio.setId_domicilio(Integer.parseInt(mdl_domicilio.getUltimoId()));

        // mdl_tejidos.ExtraerUltimoID(tegidosBlandos);
        tegidosBlandos.setId_paciente(paciente.getId_paciente());
        mdl_tejidos.GuardarTejidosDB(tegidosBlandos);
        tegidosBlandos.setId_tejido(Integer.parseInt(mdl_tejidos.getUltimoId()));

        mdl_tratamiento.GuardarTratamieto(tratamiento);
        tratamiento.setId_tratamiento(Integer.parseInt(mdl_tratamiento.getUltimoId()));

        antecedentes.setId_tratamiento(tratamiento.getId_tratamiento());
        antecedentes.setId_paciente(paciente.getId_paciente());
        mdl_antecedente.GuardarAntecedente(antecedentes);

        antecedentes.setId_antecedente(Integer.parseInt(mdl_antecedente.getUltimoId()));

    }

    public void GuardarDatosSecundarios() {
        //AgregarIdListas();
       // antecedentes.MostrarElementos();

        //mdl_referencia.GuardarListaMedicamentos(listaMedicamentos);

      //  mdl_referencia.GuardarListaAlergia(listaAlergia);
        
        //mdl_estado.GuardarEmbarazoDB(embarazada);
       // mdl_referencia.GuardarHospitalizado(hospitalizado);
       
       //mdl_referencia.GuardarAnticoncp(anticonceptivo);
    }

    public void AgregarIdListas() {
        for (OBJ_Referencia listMedic : listaMedicamentos) {
            listMedic.setId_antecedente(antecedentes.getId_antecedente());
        }
        for (OBJ_Referencia listAler : listaAlergia) {
            listAler.setId_antecedente(antecedentes.getId_antecedente());
        }
    }
}
