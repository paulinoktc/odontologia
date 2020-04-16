/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.MODL_Paciente;
import modelo.OBJ_Paciente;
import vista.V_BuscarPaciente;
import vista.V_Cobrar;
import vista.V_RegistrarCita;

/**
 *
 * @author ZOMBY
 */
public class CTRL_BuscarPaciente {

    V_BuscarPaciente v_buscarPaciente;
    V_RegistrarCita v_regitra_cita;

    public CTRL_BuscarPaciente() {
        v_buscarPaciente = new V_BuscarPaciente();
        agregarActions();
        v_buscarPaciente.setVisible(true);
    }

    /**
     * Configura el comportamiento de los botones
     */
    public void agregarActions() {
        v_buscarPaciente.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_buscarPaciente.dispose();
                new CTRL_principal();
            }
        });

        v_buscarPaciente.jb_abonar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CTRL_Cobrar();
                v_buscarPaciente.dispose();
            }
        });
        v_buscarPaciente.jb_add_cita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CTRL_AgendarCita();
                v_buscarPaciente.dispose();
            }
        });
        v_buscarPaciente.jb_hist_complet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                v_buscarPaciente.dispose();
                new CTRL_HistorialCompleto();
            }
        });

        v_buscarPaciente.jb_buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                buscarPaciente();
            }
        });
    }

    public void buscarPaciente() {
        v_buscarPaciente.jcb_select_paciente.removeAllItems();
        ArrayList<OBJ_Paciente> listaPacientes = new MODL_Paciente().buscarIdPaciente(v_buscarPaciente.jcb_buscar_por.getSelectedIndex(), v_buscarPaciente.jtf_dato_a_buscar.getText());
        for (OBJ_Paciente listPacient : listaPacientes) {
            v_buscarPaciente.jcb_select_paciente.addItem(
                    listPacient.getId_paciente() + " "
                    + listPacient.getNombre() + " "
                    + listPacient.getAp_paterno() + " "
                    + listPacient.getAp_materno() + " " 
                    + listPacient.getTelefono()
            );

        }
    }
}
