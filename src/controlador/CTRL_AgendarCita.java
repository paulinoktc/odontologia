/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.MODL_Agenda;
import vista.V_RegistrarCita;

/**
 *
 * @author ZOMBY
 */
public class CTRL_AgendarCita {

    private String id_paciente;
    V_RegistrarCita v_citas;

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

                if (JOptionPane.showConfirmDialog(null, "Agendar cita?") == 0) {
                    new MODL_Agenda().agendarCita(id_paciente, getFecha(), v_citas.jtf_motivo.getText());
                    JOptionPane.showMessageDialog(null, "Cita guardada");
                    v_citas.dispose();
                    new CTRL_BuscarPaciente();
                }else{
                    v_citas.jtf_motivo.setText("");
                }
            }
        });
    }

    public String getFecha() {
        return ((JTextField) v_citas.jd_fecha.getDateEditor().getUiComponent()).getText();
    }

    public String getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(String id_paciente) {
        this.id_paciente = id_paciente;
    }
}
