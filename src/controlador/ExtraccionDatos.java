/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import mdoelo.MatrizCostos;
import mdoelo.OBJ_Antecedentes;
import mdoelo.OBJ_Estado;
import mdoelo.OBJ_Paciente;
import mdoelo.OBJ_Padecimiento;
import mdoelo.OBJ_Referencia;
import mdoelo.OBJ_Relacion;
import mdoelo.OBJ_TejidosBlandos;
import mdoelo.OBJ_Tratamiento;
import vista.V_DatosPersonales;
import vista.V_Presupuesto;

/**
 *
 * @author ZOMBY
 */
public class ExtraccionDatos {

    //V_Presupuesto v_presupuesto;
    private MatrizCostos[] listaPresupuesto = null;
    private ArrayList<OBJ_Relacion> listaHabitos;

    private OBJ_Tratamiento tratamiento;
    private OBJ_Antecedentes antecedentes;
    private ArrayList<OBJ_Padecimiento> padecimientos;
    private OBJ_TejidosBlandos tegidosBlandos;
    private OBJ_Estado embarazada = null;
    private OBJ_Estado anticonceptivo;

    /**
     * Extrae los datos de la vista presupuestos
     *
     * @param v_presupuesto ventana presupuesto a extraer elementos inicializa
     * MatrizCostos[]
     */
    public void ExtraerDatosPresupuesto(V_Presupuesto v_presupuesto) {
        try {
            listaPresupuesto = new MatrizCostos[11];
            if (!v_presupuesto.jtf_p_amalgama.getText().isEmpty()) {
                listaPresupuesto[0] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_amalgama.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_amalgama.getText().toString()));
                v_presupuesto.jtf_t_amalgama.setText(listaPresupuesto[0].getTotal() + "");
            }
            if (!v_presupuesto.jtf_p_recina.getText().isEmpty()) {
                listaPresupuesto[1] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_recina.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_recina.getText().toString()));
                v_presupuesto.jtf_t_recina.setText(listaPresupuesto[1].getTotal() + "");
            }

            if (!v_presupuesto.jtf_p_incrustacion.getText().isEmpty()) {
                listaPresupuesto[2] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_incrustacion.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_incrustacion.getText().toString()));
                v_presupuesto.jtf_t_incrustacion.setText(listaPresupuesto[2].getTotal() + "");
            }

            if (!v_presupuesto.jtf_p_corona.getText().isEmpty()) {
                listaPresupuesto[3] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_corona.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_corona.getText().toString()));
                v_presupuesto.jtf_t_corona.setText(listaPresupuesto[3].getTotal() + "");
            }

            if (!v_presupuesto.jtf_p_endodoncia.getText().isEmpty()) {
                listaPresupuesto[4] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_endodoncia.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_endodoncia.getText().toString()));
                v_presupuesto.jtf_t_endodoncia.setText(listaPresupuesto[4].getTotal() + "");
            }

            if (!v_presupuesto.jtf_p_extraccion.getText().isEmpty()) {
                listaPresupuesto[5] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_extraccion.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_exraccion.getText().toString()));
                v_presupuesto.jtf_t_exraccion.setText(listaPresupuesto[5].getTotal() + "");
            }

            if (!v_presupuesto.jtf_p_prostotoncia.getText().isEmpty()) {
                listaPresupuesto[6] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_prostotoncia.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_prostodoncia.getText().toString()));
                v_presupuesto.jtf_t_prostodoncia.setText(listaPresupuesto[6].getTotal() + "");
            }

            if (!v_presupuesto.jtf_p_limpieza.getText().isEmpty()) {
                listaPresupuesto[7] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_limpieza.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_limpieza.getText().toString()));
                v_presupuesto.jtf_t_limpieza.setText(listaPresupuesto[7].getTotal() + "");
            }
            if (!v_presupuesto.jtf_p_curetas.getText().isEmpty()) {
                listaPresupuesto[8] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_curetas.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_cureta.getText().toString()));
                v_presupuesto.jtf_t_cureta.setText(listaPresupuesto[8].getTotal() + "");
            }

            if (!v_presupuesto.jtf_p_otro1.getText().isEmpty()) {
                listaPresupuesto[9] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_otro1.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_otro1.getText().toString()));
                v_presupuesto.jtf_t_otro2.setText(listaPresupuesto[9].getTotal() + "");
            }

            if (!v_presupuesto.jtf_p_otro2.getText().isEmpty()) {
                listaPresupuesto[10] = new MatrizCostos(Double.parseDouble(v_presupuesto.jtf_p_otro2.getText().toString()), Integer.parseInt(v_presupuesto.jtf_c_otro2.getText().toString()));
                v_presupuesto.jtf_t_otro2.setText(listaPresupuesto[10].getTotal() + "");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dato erroneo : Prueba\n1: Verifica que presio y cantidad no estan vacios\n2: Poner Numero Entero En Cantidad\n3: No Poner Letras");
        }
    }

    public MatrizCostos[] getListaPresupuesto() {
        return listaPresupuesto;
    }

    public void setListaPresupuesto(MatrizCostos[] listaPresupuesto) {
        this.listaPresupuesto = listaPresupuesto;
    }

    public OBJ_Paciente ExtraerDatosPaciente(V_DatosPersonales vista) {
        OBJ_Paciente el_paciente = new OBJ_Paciente();
        el_paciente.setNombre(vista.jt_nombre.getText());
        el_paciente.setAp_paterno(vista.jt_ap_paterno.getText());
        el_paciente.setAp_materno(vista.jt_ap_materno.getText());
        el_paciente.setSexo((String.valueOf(vista.jcb_sexo.getSelectedItem())).charAt(0));
        String eage = String.valueOf(vista.jcb_age.getSelectedItem());
        String mes = String.valueOf(vista.jcb_mes.getSelectedItem());
        String dia = String.valueOf(vista.jcb_dia.getSelectedItem());
        String fechaNaciemiento = eage + "-" + mes + "-" + dia;
        el_paciente.setFechaNaciemiento(fechaNaciemiento);
        el_paciente.setEstadoCivil(String.valueOf(vista.jcb_estadoCivil.getSelectedItem()));
        el_paciente.setOcupacion(vista.jtf_ocupacion.getText());
        el_paciente.setEscolaridad(String.valueOf(vista.jcb_escolaridad.getSelectedItem()));
        /**
         * pendientes insertar id_domicilio and id_tegidos
         */
        return el_paciente;
    }

    /**
     * Extrae los datos referentes a los habitos
     *
     * @param vista Vista de donde se extraeran los datos
     * @param antecedente Objeto Antecedente donde biene los antecedentes del
     * paciente
     */
    public ArrayList<OBJ_Relacion> ExtraerDatosHabitos(V_DatosPersonales vista, OBJ_Antecedentes antecedente) {
        listaHabitos = new ArrayList<OBJ_Relacion>();
        if (vista.jrb_brincomania.isSelected()) {
            listaHabitos.add(new OBJ_Relacion(vista.jrb_brincomania.getText(), antecedente.getId_antecedente()));
        }

        if (vista.jrb_contracciones.isSelected()) {
            listaHabitos.add(new OBJ_Relacion(vista.jrb_contracciones.getText(), antecedente.getId_antecedente()));
        }
        if (vista.jrb_habitMoridida.isSelected()) {
            listaHabitos.add(new OBJ_Relacion(vista.jrb_habitMoridida.getText(), antecedente.getId_antecedente()));
        }
        if (vista.jrb_respiracionBucal.isSelected()) {
            listaHabitos.add(new OBJ_Relacion(vista.jrb_respiracionBucal.getText(), antecedente.getId_antecedente()));
        }
        if (vista.jrb_lengua.isSelected()) {
            listaHabitos.add(new OBJ_Relacion(vista.jrb_lengua.getText(), antecedente.getId_antecedente()));
        }
        if (vista.jrb_encia.isSelected()) {
            listaHabitos.add(new OBJ_Relacion(vista.jrb_encia.getText(), antecedente.getId_antecedente()));
        }
        if (vista.jrb_carrillo.isSelected()) {
            listaHabitos.add(new OBJ_Relacion(vista.jrb_carrillo.getText(), antecedente.getId_antecedente()));
        }
        return listaHabitos;
    }

    public OBJ_Tratamiento ExtraerTratamiento(V_DatosPersonales vista) {
        tratamiento = new OBJ_Tratamiento(vista.jta_tratamiento.getText(), vista.jta_observaciones.getText());
        return tratamiento;
    }

    /**
     * Extrae los datos de la tabla antecedentes
     *
     * @param vista Vista donde se encuentran los datos a extraer
     * @param tratamiento Objeto Tratamiento al que se le extraera el id
     * @param id_paciente id del paciente al que pertenece el antecedente
     * @return
     */
    public OBJ_Antecedentes ExtraerAntecedentes(V_DatosPersonales vista, OBJ_Tratamiento tratamiento, int id_paciente) {
        antecedentes = new OBJ_Antecedentes(
                String.valueOf(vista.jcb_higieneBucal.getSelectedItem()),
                String.valueOf(vista.jcb_alimentacion.getSelectedItem()),
                tratamiento.getId_tratamiento(),
                id_paciente);
        return antecedentes;
    }

    public ArrayList<OBJ_Padecimiento> EstraerPadecimientos(V_DatosPersonales vista, OBJ_Paciente paciente) {
        padecimientos = new ArrayList<OBJ_Padecimiento>();                        //cargar id_ del paciente

        if (vista.jrb_apRespiratorio.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_cliente(), vista.jrb_apRespiratorio.getText()));
        }
        if (vista.jrb_aparatoCardio.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_cliente(), vista.jrb_aparatoCardio.getText()));
        }

        if (vista.jrb_apDigestivo.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_cliente(), vista.jrb_apDigestivo.getText()));
        }
        if (vista.jrb_sistemNervioso.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_cliente(), vista.jrb_sistemNervioso.getText()));
        }

        if (vista.jrb_probGoaulacion.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_cliente(), vista.jrb_probGoaulacion.getText()));
        }

        if (vista.jrb_desmayos.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_cliente(), vista.jrb_desmayos.getText()));
        }

        if (vista.jrb_vertigos.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_cliente(), vista.jrb_vertigos.getText()));
        }

        if (vista.jrb_diabetes.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_cliente(), vista.jrb_diabetes.getText()));
        }

        if (vista.jrb_tiroides.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_cliente(), vista.jrb_tiroides.getText()));
        }

        if (vista.jrb_fiebreReumatica.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_cliente(), vista.jrb_fiebreReumatica.getText()));
        }
        if (vista.jrb_hipertencion.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_cliente(), vista.jrb_hipertencion.getText()));
        }
        return padecimientos;
    }

    public OBJ_TejidosBlandos EstraerTegidosBlandos(V_DatosPersonales vista) {
        tegidosBlandos = new OBJ_TejidosBlandos();
        tegidosBlandos.setFrenillo(String.valueOf(vista.jcb_frenillo.getSelectedItem()));
        tegidosBlandos.setMejilla(vista.jtf_mejilla.getText());
        tegidosBlandos.setLabios(vista.jtf_labios.getText());
        tegidosBlandos.setPaladar(vista.jtf_paladar.getText());
        tegidosBlandos.setEncia(vista.jtf_encia.getText());
        tegidosBlandos.setLengua(vista.jtf_lengua.getText());
        return tegidosBlandos;
    }

    public OBJ_Estado EstraerDatosEmbarazo(V_DatosPersonales vista, OBJ_Antecedentes antecedentes) {
        embarazada = new OBJ_Estado(antecedentes.getId_antecedente(), String.valueOf(vista.jcb_mesesEmbarazo.getSelectedItem()));
        return embarazada;
    }
    
    public OBJ_Estado ExtraerAntic(JTextField texto,OBJ_Antecedentes antecedente){
        return new OBJ_Estado(antecedente.getId_antecedente(), texto.getText());
    }
}
