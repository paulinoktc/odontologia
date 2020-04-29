/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import modelo.ExtraccionDatos;
import modelo.MODL_Antecedentes;
import modelo.MODL_Consulta;
import modelo.MODL_EstadoPaciente;
import modelo.MODL_Paciente;
import modelo.MODL_Padecimiento;
import modelo.MODL_ReferenciaTB;
import modelo.MODL_RelacionTB;
import modelo.MODL_TejidosBlandos;
import modelo.OBJ_Antecedentes;
import modelo.OBJ_EstadoPaciente;
import modelo.OBJ_Paciente;
import modelo.OBJ_Padecimiento;
import modelo.OBJ_Referencia;
import modelo.OBJ_Relacion;
import modelo.OBJ_TejidosBlandos;
import modelo.Validador;
import odontograma.ManipulaOdontograma;
import vista.V_DatosPersonales;

/**
 *
 * @author zomby
 */
public class CTRL_NuevoHistorial {

    ExtraccionDatos extraerDatosVista;
    MODL_Consulta mdl_consulta;
    MODL_TejidosBlandos mdl_tejidos;
    MODL_Paciente mdl_paciente;
    MODL_Antecedentes mdl_antecedente;
    MODL_EstadoPaciente mdl_estado;
    MODL_Padecimiento mdl_padecimiento;

    OBJ_Antecedentes antecedPaciente;
    OBJ_EstadoPaciente embarazada = null;
    OBJ_EstadoPaciente hospitalizado;

    OBJ_TejidosBlandos tegidosBlandos = null;

    ArrayList<OBJ_Referencia> listaAlergia = null;
    ArrayList<OBJ_Referencia> listaMedicamentos = null;
    OBJ_Referencia anticonceptivo;

    ArrayList<OBJ_Relacion> listaHabitos = null;
    ArrayList<OBJ_Padecimiento> listaPadecimienientos = null;

    V_DatosPersonales vista;
    OBJ_Paciente paciente;
    String id_paciente;
    ManipulaOdontograma odontograma;

    public CTRL_NuevoHistorial(String id_paciente) {
        this.id_paciente = id_paciente;
        setearObjetos();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mostrarDatos();
        setModels();
        agregarActions();
        vista.setVisible(true);
    }

    public void agregarActions() {
        vista.jtf_alergias.setVisible(false);
        vista.jtf_anti.setVisible(false);
        vista.jtf_hospitalizado.setVisible(false);
        vista.jtf_medicamento.setVisible(false);
        if (paciente.getSexo().equalsIgnoreCase("M")) {
            vista.jrb_embarazada.setVisible(false);
        }
        vista.jb_more_medic.setVisible(false);
        vista.jb_addAlegia.setVisible(false);

        vista.jrb_embarazada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista.jrb_embarazada.isSelected()) {
                    vista.jcb_mesesEmbarazo.setVisible(true);
                } else {
                    vista.jcb_mesesEmbarazo.setVisible(false);
                }
            }
        });

        vista.jb_addAlegia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AgregarAlergias();
                vista.jtf_alergias.setText("");
            }
        });
        vista.jrb_alergias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista.jrb_alergias.isSelected()) {
                    vista.jb_addAlegia.setVisible(true);
                    vista.jtf_alergias.setVisible(true);

                } else {
                    vista.jtf_alergias.setVisible(false);
                    vista.jb_addAlegia.setVisible(false);
                    vista.jtf_alergias.setText("");
                }
            }
        });

        vista.jrb_anti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista.jrb_anti.isSelected()) {
                    vista.jtf_anti.setVisible(true);
                } else {
                    vista.jtf_anti.setVisible(false);
                    vista.jtf_anti.setText("");
                }
            }
        });

        vista.jrb_hospializado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista.jrb_hospializado.isSelected()) {
                    vista.jtf_hospitalizado.setVisible(true);
                } else {
                    vista.jtf_hospitalizado.setText("");
                    vista.jtf_hospitalizado.setVisible(false);
                }
            }
        });

        vista.jb_more_medic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AgregarMedicamentos();
                vista.jtf_medicamento.setText("");
            }
        });

        vista.jrb_medicamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vista.jrb_medicamento.isSelected()) {
                    vista.jtf_medicamento.setVisible(true);
                    vista.jb_more_medic.setVisible(true);
                } else {
                    vista.jtf_medicamento.setVisible(false);
                    vista.jb_more_medic.setVisible(false);
                    vista.jtf_medicamento.setText("");
                }
            }
        });

        vista.jb_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                RecopilarDatos();
                new CTRL_BuscarPaciente().addPacientePredefinido(paciente);
                vista.dispose();
            }
        });

        vista.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new CTRL_BuscarPaciente();
                vista.dispose();
            }
        });
    }

    public void RecopilarDatos() {
        ExtraerAntecedentes();
        mdl_antecedente.GuardarAntecedente(antecedPaciente);
        antecedPaciente.setId_antecedente(mdl_antecedente.getIdAntecedente(antecedPaciente));
        EstraerTejidosBlandos();
        antecedPaciente.setId_consulta(mdl_antecedente.getIdConsulta(String.valueOf(vista.jcb_t_consulta.getSelectedItem())));
        mdl_antecedente.saveTipoConsulta(antecedPaciente);
        EstraerPadecimientos();
        ExtraerEmbarazo();
        ExtraeAnticonc();
        ExtraerHospitalizado();
        ExtraerHabitos();

        guardaDatosSecundarios();
    }

    public void guardaDatosSecundarios() {
        if (listaPadecimienientos.size() != 0) {
            for (OBJ_Padecimiento listaPad : listaPadecimienientos) {
                listaPad.setId_padecimiento(mdl_padecimiento.getIdPadecimiento(listaPad));
            }
            mdl_padecimiento.saveListaPadecimientos(listaPadecimienientos);
        }
        if (embarazada != null) {
            new MODL_EstadoPaciente().GuardarEmbarazo(embarazada);
        }
        if (hospitalizado != null) {
            new MODL_EstadoPaciente().GuardarHospitalizado(hospitalizado);
        }
        if (listaAlergia.size() != 0) {
            for (OBJ_Referencia listAler : listaAlergia) {
                listAler.setId_antecedente(antecedPaciente.getId_antecedente());
            }
            new MODL_ReferenciaTB().saveLisAlergias(listaAlergia);
        }
        if (anticonceptivo != null) {
            anticonceptivo.setId_antecedente(antecedPaciente.getId_antecedente());
            new MODL_ReferenciaTB().saveAntic(anticonceptivo);
        }
        if (listaHabitos.size() != 0) {

            for (OBJ_Relacion listaHabit : listaHabitos) {
                listaHabit.setId_Relacion(new MODL_RelacionTB().getIdPaHabito(listaHabit));
            }
            new MODL_RelacionTB().saveListHabitos(listaHabitos);
        }
        if (listaMedicamentos.size() != 0) {
            for (OBJ_Referencia listaMedic : listaMedicamentos) {
                listaMedic.setId_antecedente(antecedPaciente.getId_antecedente());
            }
            new MODL_ReferenciaTB().saveListMedicamento(listaMedicamentos);
        }

    }

    private void setearObjetos() {
        vista = new V_DatosPersonales();
        odontograma = new ManipulaOdontograma(vista);
        listaAlergia = new ArrayList<>();
        listaMedicamentos = new ArrayList<>();
        extraerDatosVista = new ExtraccionDatos();
        paciente = new MODL_Paciente().h_paciente(id_paciente);

    }

    public void setModels() {
        mdl_tejidos = new MODL_TejidosBlandos();
        mdl_paciente = new MODL_Paciente();
        mdl_antecedente = new MODL_Antecedentes();
        mdl_estado = new MODL_EstadoPaciente();
        mdl_padecimiento = new MODL_Padecimiento();
    }

    private void mostrarDatos() {
        new MODL_Consulta().cargarItems(vista.jcb_t_consulta);
        vista.jt_nombre.setText(paciente.getNombre());
        vista.jt_nombre.setEditable(false);
        vista.jt_ap_paterno.setText(paciente.getAp_paterno());
        vista.jt_ap_paterno.setEditable(false);
        vista.jt_ap_materno.setText(paciente.getAp_materno());
        vista.jt_ap_materno.setEditable(false);
        vista.jcb_sexo.removeAllItems();
        vista.jcb_sexo.addItem(paciente.getSexo());

        vista.jcb_estadoCivil.removeAllItems();
        vista.jcb_estadoCivil.addItem(paciente.getEstadoCivil());
        vista.jtf_ocupacion.setText(paciente.getOcupacion());
        vista.jtf_ocupacion.setEditable(false);
        vista.jcb_escolaridad.removeAllItems();
        vista.jcb_escolaridad.addItem(paciente.getEscolaridad());
        vista.jt_telefono.setText(paciente.getTelefono());
        vista.jt_domicilio.setEditable(false);
        vista.jt_domicilio.setText(paciente.getDomicilio());
        vista.jt_representante.setText(paciente.getTutor());
        vista.jt_correo.setText(paciente.getCorreo());
    }

    public void ExtraerAntecedentes() {                                         //tabla antecedPaciente*
        antecedPaciente = extraerDatosVista.ExtraerAntecedentes(vista, id_paciente);//modificar el idpaciente
    }                                                                        //tutor*

    public void EstraerTejidosBlandos() {
        tegidosBlandos = extraerDatosVista.EstraerTegidosBlandos(vista, paciente.getId_paciente());//tejidos_blandos*
    }

    public void ExtraerEmbarazo() {
        embarazada = extraerDatosVista.ExtraeEsteElemento(String.valueOf(vista.jcb_mesesEmbarazo.getSelectedItem()));//embarazada*
        embarazada.setId_antecedente(antecedPaciente.getId_antecedente());         //------------estableciendo el Id antecedente                
    }

    public void ExtraeAnticonc() {                                              //anticonc
        anticonceptivo = extraerDatosVista.ExtraeReferencia(vista.jtf_anti);
    }

    /**
     * Agrega los medicamentos de la vista al Array de OBJ_Relacion de
     * medicamentos
     */
    public void AgregarMedicamentos() {                                          //anteced_medicam*
        listaMedicamentos.add(extraerDatosVista.ExtraeReferencia(vista.jtf_medicamento));
    }

    public void AgregarAlergias() {                                             //anteced_alergias*
        listaAlergia.add(extraerDatosVista.ExtraeReferencia(vista.jtf_alergias));
    }

    public void EstraerPadecimientos() {
        listaPadecimienientos = extraerDatosVista.EstraerPadecimientos(vista, paciente);

    }                                                                           //padeci_paciente*

    public void ExtraerHabitos() {//--------------------------------------------enviar id antecedente
        listaHabitos = extraerDatosVista.ExtraerDatosHabitos(vista, antecedPaciente);//anteced_habit*
    }

    public void ExtraerHospitalizado() {
        if (!vista.jtf_hospitalizado.getText().isEmpty()) {
            hospitalizado = extraerDatosVista.ExtraeEsteElemento(vista.jtf_hospitalizado.getText());
            hospitalizado.setId_antecedente(antecedPaciente.getId_antecedente());
        }
    }

    public static void main(String[] args) {
        new CTRL_NuevoHistorial("20200423123607");
    }
}
