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
import modelo.MODL_TejidosBlandos;
import modelo.OBJ_TejidosBlandos;
import modelo.MODL_Paciente;
import modelo.ExtraccionDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.MODL_Consulta;
import modelo.MODL_EstadoPaciente;
import modelo.MODL_Padecimiento;
import modelo.OBJ_EstadoPaciente;
import modelo.OBJ_Padecimiento;
import modelo.OBJ_Referencia;
import modelo.OBJ_Relacion;
import modelo.Validador;
import vista.V_DatosPersonales;

public class CTRL_DatosPersonales {

    ExtraccionDatos extraerDatosVista;
    V_DatosPersonales v_datosPersonales;
    //--------------------------------------------------------------------------Modelos
    MODL_Consulta mdl_consulta;
    MODL_TejidosBlandos mdl_tejidos;
    MODL_Paciente mdl_paciente;
    MODL_Antecedentes mdl_antecedente;
    MODL_EstadoPaciente mdl_estado;
    MODL_Padecimiento mdl_padecimiento;
    //--------------------------------------------------------------------------Objetos
    OBJ_Paciente paciente;
    OBJ_Antecedentes antecedentes;
    OBJ_EstadoPaciente embarazada = null;
    OBJ_EstadoPaciente hospitalizado;

    OBJ_TejidosBlandos tegidosBlandos = null;

    //--------------------------------------------------------------------------Listas
    ArrayList<OBJ_Referencia> listaMedicamentos = null;
    ArrayList<OBJ_Referencia> listaAlergia = null;
    OBJ_Referencia anticonceptivo;

    ArrayList<OBJ_Relacion> listaHabitos = null;
    ArrayList<OBJ_Padecimiento> listaPadecimienientos = null;

    public CTRL_DatosPersonales() {
        listaMedicamentos = new ArrayList<>();
        listaAlergia = new ArrayList<>();
        extraerDatosVista = new ExtraccionDatos();
        v_datosPersonales = new V_DatosPersonales();

        agregarActions();
        v_datosPersonales.setDefaultCloseOperation(0);
        LlenarItemsConsulta();
        setModels();

    }

    public void setModels() {
        mdl_tejidos = new MODL_TejidosBlandos();
        mdl_paciente = new MODL_Paciente();
        mdl_antecedente = new MODL_Antecedentes();
        mdl_estado = new MODL_EstadoPaciente();
        mdl_padecimiento = new MODL_Padecimiento();
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
        mdl_consulta = new MODL_Consulta();

        v_datosPersonales.jcb_mesesEmbarazo.setVisible(false);
        v_datosPersonales.jtf_alergias.setVisible(false);
        v_datosPersonales.jtf_anti.setVisible(false);
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
                if (!new Validador(v_datosPersonales).validarEspaciosPaciente()) {
                    JOptionPane.showMessageDialog(null, "Todos los espacios son obligatorios");
                } else if (new Validador(v_datosPersonales).revisaJCombobox()) {
                    System.out.println("no more");
                } else {
                    RecopilarDatos();
                }
            }
        });
    }

    public void LlenarItemsConsulta() {
        mdl_consulta.cargarItems(v_datosPersonales.jcb_t_consulta);
    }

    public void RecopilarDatos() {
//-------------------------------------------datos obligatorios
        ExtraerPaciente();
        mdl_paciente.guardarDatosPaciente(paciente);
        ExtraerAntecedentes();
        mdl_antecedente.GuardarAntecedente(antecedentes);
        antecedentes.setId_antecedente(mdl_antecedente.getIdAntecedente(antecedentes));
        EstraerTejidosBlandos();
        antecedentes.setId_consulta(mdl_antecedente.getIdConsulta(String.valueOf(v_datosPersonales.jcb_t_consulta.getSelectedItem())));
        System.out.println(antecedentes.getId_antecedente());
        mdl_antecedente.saveTipoConsulta(antecedentes);
        mdl_tejidos.GuardarTejidosDB(tegidosBlandos);

        EstraerPadecimientos();
        ExtraerEmbarazo();//this

        ExtraeAnticonc();
        ExtraerHabitos();
        AgregarMedicamentos();
        AgregarAlergias();
        ExtraerHospitalizado();

        AgregarIdListas();
        guardaDatosSecundarios();

    }

    public void guardaDatosSecundarios() {
        if (listaPadecimienientos.size() != 0) {
            mdl_padecimiento.saveListaPadecimientos(listaPadecimienientos);
        }
        if (embarazada != null) {
            new MODL_EstadoPaciente().GuardarEmbarazo(embarazada);
        }
        if(hospitalizado!=null){
            new MODL_EstadoPaciente().GuardarHospitalizado(hospitalizado);
        }
    }

    public void ExtraerPaciente() {
        paciente = extraerDatosVista.ExtraerDatosPaciente(v_datosPersonales);

    }

    public void ExtraerAntecedentes() {                                         //tabla antecedentes*
        //----------------------------------------------------------------------cargar fecha desde sql
        antecedentes = extraerDatosVista.ExtraerAntecedentes(v_datosPersonales, paciente.getId_paciente());//modificar el idpaciente
    }                                                                        //tutor*

    public void EstraerTejidosBlandos() {
        tegidosBlandos = extraerDatosVista.EstraerTegidosBlandos(v_datosPersonales, paciente.getId_paciente());//tejidos_blandos*
    }

    public void ExtraerEmbarazo() {
        embarazada = extraerDatosVista.ExtraeEsteElemento(antecedentes.getId_antecedente(),String.valueOf(v_datosPersonales.jcb_mesesEmbarazo.getSelectedItem()));//embarazada*
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

    public void ExtraerHospitalizado() {
        hospitalizado = extraerDatosVista.ExtraeEsteElemento(antecedentes.getId_antecedente(),v_datosPersonales.jtf_hospitalizado.getText());
    }

    public void AgregarIdListas() {
        for (OBJ_Referencia listMedic : listaMedicamentos) {
            listMedic.setId_antecedente(antecedentes.getId_antecedente());
        }
        for (OBJ_Referencia listAler : listaAlergia) {
            listAler.setId_antecedente(antecedentes.getId_antecedente());
        }
        for (OBJ_Padecimiento listaPad : listaPadecimienientos) {
            listaPad.setId_padecimiento(mdl_padecimiento.getIdPadecimiento(listaPad));
            System.out.println(listaPad.getId_paciente() + " nombre: " + listaPad.getNombre_padecimiento() + " id " + listaPad.getId_padecimiento());
        }
    }

}
