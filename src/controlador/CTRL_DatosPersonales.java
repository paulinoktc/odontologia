/**
 * Extrae los datos ingresados en la visrta de nuevo paciente valida campos vacios guarla los cambios guarda el odontograma del paciente
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
import modelo.MODL_ReferenciaTB;
import modelo.MODL_RelacionTB;
import modelo.OBJ_EstadoPaciente;
import modelo.OBJ_Padecimiento;
import modelo.OBJ_Referencia;
import modelo.OBJ_Relacion;
import modelo.Validador;
import odontograma.ManipulaOdontograma;
import vista.V_DatosPersonales;

/**
 *
 * @author PaulinoSalas
 */
public class CTRL_DatosPersonales {

    ExtraccionDatos extraerDatosVista;
    V_DatosPersonales v_datosPersonales;
    //--------------------------------------------------------------------------Modelos
    private MODL_Consulta mdl_consulta;
    private MODL_TejidosBlandos mdl_tejidos;
    private MODL_Paciente mdl_paciente;
    private MODL_Antecedentes mdl_antecedente;
    private MODL_EstadoPaciente mdl_estado;
    private MODL_Padecimiento mdl_padecimiento;
    //--------------------------------------------------------------------------Objetos
    private OBJ_Paciente paciente;
    private OBJ_Antecedentes antecedPaciente;
    private OBJ_EstadoPaciente embarazada = null;
    private OBJ_EstadoPaciente hospitalizado;

    private OBJ_TejidosBlandos tegidosBlandos = null;

    //--------------------------------------------------------------------------Listas
    private ArrayList<OBJ_Referencia> listaAlergia = null;
    private ArrayList<OBJ_Referencia> listaMedicamentos = null;
    private OBJ_Referencia anticonceptivo;

    private ArrayList<OBJ_Relacion> listaHabitos = null;
    private ArrayList<OBJ_Padecimiento> listaPadecimienientos = null;
    //--------------------------------------------------------------------------clase que manipula los odontogramas para editarlos
    ManipulaOdontograma odontograma;

    /**
     * Inicializa los las listas y onjetos principales
     */
    public CTRL_DatosPersonales() {
        listaMedicamentos = new ArrayList<>();
        listaAlergia = new ArrayList<>();
        extraerDatosVista = new ExtraccionDatos();
        v_datosPersonales = new V_DatosPersonales();

        
        v_datosPersonales.setDefaultCloseOperation(0);
        odontograma = new ManipulaOdontograma(v_datosPersonales);
        agregarActions();
        LlenarItemsConsulta();
        setModels();

    }

    /**
     * Inicializa los modelos correspondientes
     */
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
        v_datosPersonales.jb_more_medic.setVisible(false);
        v_datosPersonales.jb_addAlegia.setVisible(false);
        v_datosPersonales.setVisible(true);

        /**
         * Si el usuario es femenino mostrara los meses de embarazo si es
         * masculino entonces no
         */
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

        /**
         * Regresa al menu principal llamando al controlador principal
         */
        v_datosPersonales.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_datosPersonales.dispose();
                new CTRL_principal();
            }
        });

        /**
         * Si esta embarazada muestra el muestra los items para selecconar
         * cuantos meses
         */
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
        /**
         * Agrega alergia a la lista de alergias
         */
        v_datosPersonales.jb_addAlegia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AgregarAlergias();
                v_datosPersonales.jtf_alergias.setText("");
            }
        });

        /**
         * Se Muestra el textField si se a seleccionado que tiene alergias
         */
        v_datosPersonales.jrb_alergias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v_datosPersonales.jrb_alergias.isSelected()) {
                    v_datosPersonales.jb_addAlegia.setVisible(true);
                    v_datosPersonales.jtf_alergias.setVisible(true);

                } else {
                    v_datosPersonales.jtf_alergias.setVisible(false);
                    v_datosPersonales.jb_addAlegia.setVisible(false);
                    v_datosPersonales.jtf_alergias.setText("");
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
                    v_datosPersonales.jtf_anti.setText("");
                }
            }
        });

        /**
         * Muestra el cuadro de texto si el paciente ha sid hospitlaizado
         * paraponer el motivo de la hopitalizacion
         */
        v_datosPersonales.jrb_hospializado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v_datosPersonales.jrb_hospializado.isSelected()) {
                    v_datosPersonales.jtf_hospitalizado.setVisible(true);
                } else {
                    v_datosPersonales.jtf_hospitalizado.setText("");
                    v_datosPersonales.jtf_hospitalizado.setVisible(false);
                }
            }
        });

        /**
         * Agrega Medicamentos a la lista de medicamentos
         */
        v_datosPersonales.jb_more_medic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AgregarMedicamentos();
                v_datosPersonales.jtf_medicamento.setText("");
            }
        });

        /**
         * Valida si esta seleccionado mostrara el textField para ingresar el
         * nombre del medicamentp
         */
        v_datosPersonales.jrb_medicamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v_datosPersonales.jrb_medicamento.isSelected()) {
                    v_datosPersonales.jtf_medicamento.setVisible(true);
                    v_datosPersonales.jb_more_medic.setVisible(true);
                } else {
                    v_datosPersonales.jtf_medicamento.setVisible(false);
                    v_datosPersonales.jb_more_medic.setVisible(false);
                    v_datosPersonales.jtf_medicamento.setText("");
                }
            }
        });
        /**
         * Antes de agregar al paciente se asegura que se todos los campos esten
         * llenos
         */
        v_datosPersonales.jb_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (new Validador(v_datosPersonales).validarEspaciosPaciente()) {
                    JOptionPane.showMessageDialog(null, "Todos los espacios son obligatorios");
                } else if (!new Validador(v_datosPersonales).revisaJCombobox()) {
                    RecopilarDatos();
                    // guarda el odontograma del paciente con el id del paciente
                    odontograma.guarda(paciente.getId_paciente());
                    new CTRL_BuscarPaciente().addPacientePredefinido(paciente);
                    v_datosPersonales.dispose();
                }
            }
        });
    }

    /**
     * LLena los items con las consultas que se pueden realizar extrae los datos
     * de la base de datos
     */
    public void LlenarItemsConsulta() {
        mdl_consulta.cargarItems(v_datosPersonales.jcb_t_consulta);
    }

    /**
     * Extrae los datos de la vista guarda los principales como paciente y
     * antecedentes
     */
    public void RecopilarDatos() {
//-------------------------------------------datos obligatorios
        ExtraerPaciente();
        mdl_paciente.guardarDatosPaciente(paciente);
        ExtraerAntecedentes();
        mdl_antecedente.GuardarAntecedente(antecedPaciente);
        antecedPaciente.setId_antecedente(mdl_antecedente.getIdAntecedente(antecedPaciente));
        EstraerTejidosBlandos();
        antecedPaciente.setId_consulta(mdl_antecedente.getIdConsulta(String.valueOf(v_datosPersonales.jcb_t_consulta.getSelectedItem())));
        mdl_antecedente.saveTipoConsulta(antecedPaciente);
        mdl_tejidos.GuardarTejidosDB(tegidosBlandos);
        EstraerPadecimientos();
        ExtraerEmbarazo();
        ExtraeAnticonc();
        ExtraerHospitalizado();
        ExtraerHabitos();
        guardaDatosSecundarios();

    }

    /**
     * Guarda los datos secundarios como las listas, habitos y padecimientos se
     * asegura de que las listas no esten bacias para guardar los datos en DB
     */
    public void guardaDatosSecundarios() {
        if (listaPadecimienientos.size() != 0) {
            for (OBJ_Padecimiento listaPad : listaPadecimienientos) {
                listaPad.setId_padecimiento(mdl_padecimiento.getIdPadecimiento(listaPad));
            }
            mdl_padecimiento.saveListaPadecimientos(listaPadecimienientos);
        }
        if (v_datosPersonales.jcb_sexo.getSelectedIndex() == 1) {
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

    /**
     * LLama la clase de extarccion de datos para estraer cada unas de las
     * siguienres peticiones todos los datos son extraidos de la vista datos
     * personales
     */
    public void ExtraerPaciente() {
        paciente = extraerDatosVista.ExtraerDatosPaciente(v_datosPersonales);

    }

    public void ExtraerAntecedentes() {                                         //tabla antecedPaciente*
        //----------------------------------------------------------------------cargar fecha desde sql
        antecedPaciente = extraerDatosVista.ExtraerAntecedentes(v_datosPersonales, paciente.getId_paciente());//modificar el idpaciente
    }                                                                        //tutor*

    public void EstraerTejidosBlandos() {
        tegidosBlandos = extraerDatosVista.EstraerTegidosBlandos(v_datosPersonales, paciente.getId_paciente());//tejidos_blandos*
    }

    public void ExtraerEmbarazo() {
        if (v_datosPersonales.jcb_sexo.getSelectedIndex() == 1) {
            embarazada = extraerDatosVista.ExtraeEsteElemento(String.valueOf(v_datosPersonales.jcb_mesesEmbarazo.getSelectedItem()));//embarazada*
            embarazada.setId_antecedente(antecedPaciente.getId_antecedente());         //------------estableciendo el Id antecedente                
        }
    }

    public void ExtraeAnticonc() {                                              //anticonc
        anticonceptivo = extraerDatosVista.ExtraeReferencia(v_datosPersonales.jtf_anti);
    }

    /**
     * Agrega los medicamentos de la vista al Array de OBJ_Relacion de
     * medicamentos
     */
    public void AgregarMedicamentos() {                                          //anteced_medicam*
        listaMedicamentos.add(extraerDatosVista.ExtraeReferencia(v_datosPersonales.jtf_medicamento));
    }

    public void AgregarAlergias() {                                             //anteced_alergias*
        listaAlergia.add(extraerDatosVista.ExtraeReferencia(v_datosPersonales.jtf_alergias));
    }

    public void EstraerPadecimientos() {
        //----------------------------------------------------------------------contemplar que puede estar vacia
        listaPadecimienientos = extraerDatosVista.EstraerPadecimientos(v_datosPersonales, paciente);

    }                                                                           //padeci_paciente*

    public void ExtraerHabitos() {//--------------------------------------------enviar id antecedente
        listaHabitos = extraerDatosVista.ExtraerDatosHabitos(v_datosPersonales, antecedPaciente);//anteced_habit*
    }

    public void ExtraerHospitalizado() {
        if (!v_datosPersonales.jtf_hospitalizado.getText().isEmpty()) {
            hospitalizado = extraerDatosVista.ExtraeEsteElemento(v_datosPersonales.jtf_hospitalizado.getText());
            hospitalizado.setId_antecedente(antecedPaciente.getId_antecedente());
        }

    }
}
