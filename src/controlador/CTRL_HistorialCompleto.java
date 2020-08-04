/**
 * Busca al paciente y todas sus dependencias para mostrarlos en la vista de historial asi como su odontograma
 */
package controlador;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import modelo.MODL_Antecedentes;
import modelo.MODL_Paciente;
import modelo.MODL_Padecimiento;
import modelo.MODL_ReferenciaTB;
import modelo.MODL_RelacionTB;
import modelo.MODL_TejidosBlandos;
import modelo.OBJ_Antecedentes;
import modelo.OBJ_Paciente;
import modelo.OBJ_TejidosBlandos;
import vista.V_HistorialComplet;

/**
 *
 * @author PaulinoSalas
 */
public class CTRL_HistorialCompleto {

    V_HistorialComplet v_historial;

    private String id_paciente;
    private String antoconceptivo;
    private OBJ_Paciente paciente;
    private OBJ_Antecedentes antecedente;
    private ArrayList<String> listaHabitos;
    private ArrayList<String> listaPadecimiento;
    private ArrayList<String> listaMedicamentos;
    private ArrayList<String> listaAlergias;

    private OBJ_TejidosBlandos tejidos_blandos;

    /**
     * Realiza la busque de datos del paciente que se le indica
     *
     * @param id_paciente id del paciente a bucar
     */
    public CTRL_HistorialCompleto(String id_paciente) {
        this.id_paciente = id_paciente;
        v_historial = new V_HistorialComplet();
        //Busca las fechas de los antecedetes se hace uso desepues para buscar los antecedentes por fecha
        new MODL_Antecedentes().getItemFechasAntecedentes(id_paciente, v_historial.jcb_fechas);
        agregarActions();
        v_historial.setVisible(true);
    }

    /**
     * Muestra en la pantalla los datos encontrados del paciente (JTextField)
     */
    public void mostrarDatosEnPantalla() {

        cargarodontHist(v_historial.jl_odontograma, id_paciente);

        v_historial.jta_AllData.setText("");
        v_historial.jta_AllData.append("____________________________________________________\n");
        v_historial.jta_AllData.append("                      DATOS PACIENTE\n");
        v_historial.jta_AllData.append("____________________________________________________\n");
        v_historial.jta_AllData.append("Nombre: " + paciente.getNombre() + " ");
        v_historial.jta_AllData.append(paciente.getAp_paterno() + " ");
        v_historial.jta_AllData.append(paciente.getAp_materno() + "\n");
        v_historial.jta_AllData.append("Sexo: " + paciente.getSexo() + "\n");
        v_historial.jta_AllData.append("Edad: " + paciente.getFechaNaciemiento() + "\n");
        v_historial.jta_AllData.append("Estado Civil: " + paciente.getEstadoCivil() + "\n");
        v_historial.jta_AllData.append("Ocupacion: " + paciente.getOcupacion() + "\n");
        v_historial.jta_AllData.append("Escolaridad: " + paciente.getEscolaridad() + "\n");
        v_historial.jta_AllData.append("Telefono: " + paciente.getTelefono() + "\n");
        v_historial.jta_AllData.append("Correo: " + paciente.getCorreo() + "\n");
        v_historial.jta_AllData.append("Tutor: " + paciente.getTutor() + "\n");
        v_historial.jta_AllData.append("Domicilio: " + paciente.getDomicilio() + "\n");
        v_historial.jta_AllData.append("____________________________________________________\n");

        v_historial.jta_AllData.append("                        ANTECEDENTES\n");
        v_historial.jta_AllData.append("____________________________________________________\n");

        v_historial.jta_AllData.append("Higiene Bucal: " + antecedente.getHigiene_bucal() + "\n");
        v_historial.jta_AllData.append("Alimentacion: " + antecedente.getAlimentacion() + "\n");
        v_historial.jta_AllData.append("Motivo Visita: " + antecedente.getMotivo_visita() + "\n");

        v_historial.jta_AllData.append("Tratamiento: " + antecedente.getTipo_tratamiento() + "\n");
        v_historial.jta_AllData.append("Observaciones: " + antecedente.getObservaciones() + "\n");
        v_historial.jta_AllData.append("Tipo Consulta: " + antecedente.getTipoConsulta() + "\n");

        for (String padecimientos : listaPadecimiento) {
            v_historial.jta_AllData.append(padecimientos + "\n");
        }
        v_historial.jta_AllData.append("____________________________________________________\n");
        v_historial.jta_AllData.append("                      TEJIDOS BLANDOS\n");
        v_historial.jta_AllData.append("____________________________________________________\n");

        v_historial.jta_AllData.append("Frenillo: " + tejidos_blandos.getFrenillo() + "\n");
        v_historial.jta_AllData.append("Mejilla: " + tejidos_blandos.getMejilla() + "\n");
        v_historial.jta_AllData.append("Labios: " + tejidos_blandos.getLabios() + "\n");
        v_historial.jta_AllData.append("Paladar: " + tejidos_blandos.getPaladar() + "\n");
        v_historial.jta_AllData.append("Encia: " + tejidos_blandos.getEncia() + "\n");
        v_historial.jta_AllData.append("Lengua: " + tejidos_blandos.getLengua() + "\n");
        v_historial.jta_AllData.append("____________________________________________________\n");

        v_historial.jta_AllData.append("                     HABITOS\n");
        v_historial.jta_AllData.append("____________________________________________________\n");

        for (String listHabit : listaHabitos) {
            v_historial.jta_AllData.append(listHabit + "\n");
        }
        v_historial.jta_AllData.append("____________________________________________________\n");

        v_historial.jta_AllData.append("                  MEDICAMENTOS \n");
        v_historial.jta_AllData.append("____________________________________________________\n");

        for (String listMedicaments : listaMedicamentos) {
            v_historial.jta_AllData.append(listMedicaments + "\n");
        }
        v_historial.jta_AllData.append("____________________________________________________\n");
        v_historial.jta_AllData.append("                       ALERGIAS\n");
        v_historial.jta_AllData.append("____________________________________________________\n");

        for (String alergias : listaAlergias) {
            v_historial.jta_AllData.append(alergias + "\n");
        }
        v_historial.jta_AllData.append("____________________________________________________\n");
        v_historial.jta_AllData.append("                    ANTICONCEPTIVO\n");
        v_historial.jta_AllData.append("____________________________________________________\n");
        if (antoconceptivo.length() > 0) {
            v_historial.jta_AllData.append(antoconceptivo + "\n");
        }
        v_historial.jta_AllData.setDisabledTextColor(Color.BLACK);
        v_historial.jta_AllData.enable(false);
    }

    /**
     * Extrae cada uno de los objetos de los pacientes
     */
    public void ExtraerDatosObejo() {
        paciente = new MODL_Paciente().h_paciente(this.id_paciente);
        antecedente = new MODL_Antecedentes().getHistorialAntecedentes(
                id_paciente, String.valueOf(v_historial.jcb_fechas.getSelectedItem()));
        listaHabitos = new MODL_RelacionTB().getListaHabitos(antecedente.getId_antecedente());
        tejidos_blandos = new MODL_TejidosBlandos().getListTejidos(id_paciente);

        listaPadecimiento = new MODL_Padecimiento().getListaPadecimientos(id_paciente);
        listaMedicamentos = new MODL_ReferenciaTB().getListaMedicamentos(antecedente.getId_antecedente());
        listaAlergias = new MODL_ReferenciaTB().getListaAlergias(antecedente.getId_antecedente());
        antoconceptivo = new MODL_ReferenciaTB().getAnticonceptivo(antecedente.getId_antecedente());
    }

    /**
     * Agrega el comportamiento de los botones estan a la escucha
     */
    public void agregarActions() {
        v_historial.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new CTRL_BuscarPaciente();
                v_historial.dispose();
            }
        });

        v_historial.jcb_fechas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ExtraerDatosObejo();
                mostrarDatosEnPantalla();
            }
        });
    }

    /**
     * Busca el odontograma guardado del paciente
     *
     * @param label Label donde se mostrara el odontograma
     * @param nombre Nombre del odontograma (id del paciente)
     */
    public void cargarodontHist(JLabel label, String nombre) {
        label.repaint();
        ImageIcon imagen = new ImageIcon("C:\\ODONTOGRAMA\\PACIENTES\\" + nombre + ".png");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
    }
}
