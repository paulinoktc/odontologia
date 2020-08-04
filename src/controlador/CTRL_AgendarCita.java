package controlador;

/**
 * Esta clase es la ecargada de agendar las citas de los pacientes es la
 * encargada de manipular la vista de cobrar
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.MODL_Agenda;
import vista.V_RegistrarCita;

public class CTRL_AgendarCita {

    private String id_paciente;
    V_RegistrarCita v_citas;

    /**
     * Metodo constructor en el que se indica el nombre de la persona que tendra
     * la cita
     *
     * @param nombre nombre de la persona que tendra la cita esta encargada de
     * inicializar la ventana agregar el nombre a la ventana y poner en escucha
     * a los componentes correspondientes
     */
    public CTRL_AgendarCita(String nombre) {
        v_citas = new V_RegistrarCita();
        AgregarActions();
        v_citas.setVisible(true);
        v_citas.jl_nombreCompleto.setText(nombre);
    }

    /**
     * Configura el comportamiento de los botones
     */
    public void AgregarActions() {
        v_citas.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CTRL_BuscarPaciente();
                v_citas.dispose();
            }
        });
        v_citas.jb_listo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //pide la confirmacion de agregar la cita
                if (!v_citas.jtf_motivo.getText().isEmpty()) {
                    if (JOptionPane.showConfirmDialog(null, "Agendar cita?") == 0) {
                        new MODL_Agenda().agendarCita(id_paciente, getFecha(), v_citas.jtf_motivo.getText());
                        v_citas.dispose();
                        new CTRL_BuscarPaciente();
                    } else {
                        v_citas.jtf_motivo.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Escribe el motivo");
                }
            }
        });
    }

    /**
     * Extrae la fecha que se seleccoina en la vista
     *
     * @return String fecha seleccionada
     */
    public String getFecha() {
        return ((JTextField) v_citas.jd_fecha.getDateEditor().getUiComponent()).getText();
    }

    /**
     *
     * @return
     */
    public String getId_paciente() {
        return id_paciente;
    }

    /**
     *
     * @param id_paciente
     */
    public void setId_paciente(String id_paciente) {
        this.id_paciente = id_paciente;
    }
}
