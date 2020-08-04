/**
 * Extrae de los datos de las vistas que se le envian como parametro y retorna objetos llenos de atributos
 */
package modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import vista.V_DatosPersonales;
import vista.V_Presupuesto;

/**
 *
 * @author BereniceAnai
 */

public class ExtraccionDatos {

    //V_Presupuesto v_presupuesto;
   // private MatrizCostos[] listaPresupuesto = null;

    /**
     * Extrae los datos de la vista presupuestos
     *
     * @param v_presupuesto ventana presupuesto a extraer elementos inicializa
     * MatrizCostos[] Arreglo de clase
     */
    public MatrizCostos[] ExtraerDatosPresupuesto(V_Presupuesto v_presupuesto) {
        MatrizCostos[] listaPresupuesto = null;
        try {
            listaPresupuesto = new MatrizCostos[11];
            if (!v_presupuesto.jtf_p_amalgama.getText().isEmpty()) {
                listaPresupuesto[0] = new MatrizCostos(
                        Double.parseDouble(v_presupuesto.jtf_p_amalgama.getText().toString()), 
                        Integer.parseInt(v_presupuesto.jtf_c_amalgama.getText().toString()));
                v_presupuesto.jtf_t_amalgama.setText(listaPresupuesto[0].getTotal() + "");
            }
            if (!v_presupuesto.jtf_p_recina.getText().isEmpty()) {
                listaPresupuesto[1] = new MatrizCostos(Double.parseDouble(
                        v_presupuesto.jtf_p_recina.getText().toString()), 
                        Integer.parseInt(v_presupuesto.jtf_c_recina.getText().toString()));
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
        return listaPresupuesto;
    }

    /**
     * Retorna matriz de costos
     *
     * @return matris con los costos para el presupuesto
     
    public MatrizCostos[] getListaPresupuesto() {
        return listaPresupuesto;
    }

    /**
     * Establece la lista de presupuestos a partir de una matriz de costos
     *
     * @param listaPresupuesto Matriz de costros
     *
    public void setListaPresupuesto(MatrizCostos[] listaPresupuesto) {
        this.listaPresupuesto = listaPresupuesto;
    }*/

    /**
     * Extrae los datos del paciente desde la vista recibida y retorna un objeto
     * paciente con todos los datos llenos
     *
     * @param vista Donde se extraeran los datos
     * @return OBj paciente que se llenara con los datos
     */
    public OBJ_Paciente ExtraerDatosPaciente(V_DatosPersonales vista) {
        OBJ_Paciente el_paciente = new OBJ_Paciente();
        el_paciente.setId_paciente(el_paciente.creatIDPaciente("ininciales pendientes de mandar"));
        
        String datoTemporal=vista.jt_nombre.getText();
        datoTemporal=quitarEspaciosBasios(datoTemporal);
        el_paciente.setNombre(datoTemporal);

        datoTemporal=vista.jt_ap_paterno.getText();
        datoTemporal=quitarEspaciosBasios(datoTemporal);
        el_paciente.setAp_paterno(datoTemporal);

        datoTemporal=vista.jt_ap_materno.getText();
        datoTemporal=quitarEspaciosBasios(datoTemporal);
        el_paciente.setAp_materno(datoTemporal);
        el_paciente.setSexo((String.valueOf(vista.jcb_sexo.getSelectedItem())));
        String fechaNaciemiento = ((JTextField) vista.jd_fechcaNacimiento.getDateEditor().getUiComponent()).getText();
        el_paciente.setFechaNaciemiento(fechaNaciemiento);
        el_paciente.setEstadoCivil(String.valueOf(vista.jcb_estadoCivil.getSelectedItem()));
        el_paciente.setOcupacion(vista.jtf_ocupacion.getText());
        el_paciente.setEscolaridad(String.valueOf(vista.jcb_escolaridad.getSelectedItem()));

        el_paciente.setTelefono(vista.jt_telefono.getText());
        el_paciente.setDomicilio(vista.jt_domicilio.getText());
        el_paciente.setTutor(vista.jt_representante.getText());
        el_paciente.setTelTutor(vista.jl_telefonotutor.getText());
        el_paciente.setCorreo(vista.jt_correo.getText());

        return el_paciente;
    }
    
    /**
     * Metodo para quitar espacios a las palabras escritas
     * @param palabra palabra a quitar espacios
     * @return palabra sin espacios
     */
    public String quitarEspaciosBasios(String palabra){
         palabra=palabra.replaceAll("\\ ", "");
         return palabra;
    }

    /**
     * Extrae los datos referentes a los habitos
     *
     * @param vista Vista de donde se extraeran los datos
     * @param antecedente Objeto Antecedente donde biene los antecedentes del
     * paciente
     * @return
     */
    public ArrayList<OBJ_Relacion> ExtraerDatosHabitos(V_DatosPersonales vista, OBJ_Antecedentes antecedente) {
        ArrayList<OBJ_Relacion> listaHabitos = new ArrayList<OBJ_Relacion>();
        System.out.println("dentro habit: " + antecedente.getId_antecedente());

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

    /**
     * Extrae los datos de la tabla antecedentes
     *
     * @param vista Vista donde se encuentran los datos a extraer
     * @param tratamiento Objeto Tratamiento al que se le extraera el id
     * @param id_paciente id del paciente al que pertenece el antecedente
     * @return
     */
    public OBJ_Antecedentes ExtraerAntecedentes(V_DatosPersonales vista, String id_paciente) {
        OBJ_Antecedentes antecedentes = new OBJ_Antecedentes(
                String.valueOf(vista.jcb_higieneBucal.getSelectedItem()),
                String.valueOf(vista.jcb_alimentacion.getSelectedItem()),
                id_paciente,
                vista.jt_motiv_visita.getText()
        );
        antecedentes.setTipo_tratamiento(vista.jta_tratamiento.getText());
        antecedentes.setObservaciones(vista.jta_observaciones.getText());
        return antecedentes;
    }

    /**
     * Extrae la lista de padecimientos de la vista
     *
     * @param vista Vista donde se extraeran los datos
     * @param paciente paciente proprietario del antecededente
     * @return lista de objetos padecimiento con los datos recabados
     */
    public ArrayList<OBJ_Padecimiento> EstraerPadecimientos(V_DatosPersonales vista, OBJ_Paciente paciente) {
        ArrayList<OBJ_Padecimiento> padecimientos = new ArrayList<OBJ_Padecimiento>();                        //cargar id_ del paciente

        if (vista.jrb_apRespiratorio.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_paciente(), vista.jrb_apRespiratorio.getText()));
        }
        if (vista.jrb_aparatoCardio.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_paciente(), vista.jrb_aparatoCardio.getText()));
        }

        if (vista.jrb_apDigestivo.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_paciente(), vista.jrb_apDigestivo.getText()));
        }
        if (vista.jrb_sistemNervioso.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_paciente(), vista.jrb_sistemNervioso.getText()));
        }

        if (vista.jrb_probGoaulacion.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_paciente(), vista.jrb_probGoaulacion.getText()));
        }

        if (vista.jrb_desmayos.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_paciente(), vista.jrb_desmayos.getText()));
        }

        if (vista.jrb_vertigos.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_paciente(), vista.jrb_vertigos.getText()));
        }

        if (vista.jrb_diabetes.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_paciente(), vista.jrb_diabetes.getText()));
        }

        if (vista.jrb_tiroides.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_paciente(), vista.jrb_tiroides.getText()));
        }

        if (vista.jrb_fiebreReumatica.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_paciente(), vista.jrb_fiebreReumatica.getText()));
        }
        if (vista.jrb_hipertencion.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_paciente(), vista.jrb_hipertencion.getText()));
        }
        if (vista.jrb_fuma.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_paciente(), vista.jrb_fuma.getText()));
        }
        if (vista.jrb_alcohol.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_paciente(), vista.jrb_alcohol.getText()));
        }
        if (vista.jrb_drogas.isSelected()) {
            padecimientos.add(new OBJ_Padecimiento(paciente.getId_paciente(), vista.jrb_drogas.getText()));
        }

        return padecimientos;
    }

    /**
     * Extrae los datos de los tejidos blandos que se encuentren en la vista
     *
     * @param vista Donde se extraeran los datos
     * @param id_paciente id_ del paciente propietario de los tejidos blandos
     * @return OBJ_Tejidos blandos lleno de atributos
     */
    public OBJ_TejidosBlandos EstraerTegidosBlandos(V_DatosPersonales vista, String id_paciente) {
        OBJ_TejidosBlandos tejidosBlandos = new OBJ_TejidosBlandos();
        tejidosBlandos.setId_paciente(id_paciente);
        tejidosBlandos.setFrenillo(String.valueOf(vista.jcb_frenillo.getSelectedItem()));
        tejidosBlandos.setMejilla(vista.jtf_mejilla.getText());
        tejidosBlandos.setLabios(vista.jtf_labios.getText());
        tejidosBlandos.setPaladar(vista.jtf_paladar.getText());
        tejidosBlandos.setEncia(vista.jtf_encia.getText());
        tejidosBlandos.setLengua(vista.jtf_lengua.getText());
        return tejidosBlandos;
    }

    /**
     * Estrae objetos de referencia
     *
     * @param texto Texto a Extraer
     * @return Objero para crear lista
     */
    public OBJ_Referencia ExtraeReferencia(JTextField texto) {
        if (texto.getText().isEmpty()) {
            return null;
        }
        return new OBJ_Referencia(texto.getText());
    }

    /**
     * Extrae el estado de un paciente
     *
     * @param texto Texto a extraer
     * @return OBJ_EstadoPaciente con atributos llenos
     */
    public OBJ_EstadoPaciente ExtraeEsteElemento(String texto) {
        System.out.println(texto+"------------------------------------------------------");
        if (texto.isEmpty()) {
            return null;
        }
        return new OBJ_EstadoPaciente(texto);
    }

}
