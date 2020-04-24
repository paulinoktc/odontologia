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
import javax.swing.plaf.basic.BasicDesktopIconUI;
import javax.swing.table.DefaultTableModel;
import modelo.MODL_Agenda;
import modelo.MODL_Paciente;
import vista.V_Agenda;
import vista.V_RegistrarCita;

/**
 *
 * @author ZOMBY
 */
public class CTRL_ListaAgenda {

    V_Agenda v_listaAgenda;
    String fecha;
    // V_RegistrarCita v_regitra_cita;

    public CTRL_ListaAgenda() {
        v_listaAgenda = new V_Agenda();
        MostrarAgenda(0, "x", v_listaAgenda.defModel);
        agregarActions();
        v_listaAgenda.jd_calendar.setVisible(false);
        v_listaAgenda.jb_buscar.setVisible(false);
        v_listaAgenda.setVisible(true);
    }

    public void agregarActions() {
        v_listaAgenda.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_listaAgenda.dispose();
                new CTRL_principal();
            }
        });
        v_listaAgenda.jb_agendar_cita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CTRL_BuscarPaciente();
                v_listaAgenda.dispose();
            }
        });

        v_listaAgenda.jb_buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VaciarTabla(v_listaAgenda.defModel);
                fecha = ((JTextField) v_listaAgenda.jd_calendar.getDateEditor().getUiComponent()).getText();
                MostrarAgenda(v_listaAgenda.jcb_pacientes_mostrar.getSelectedIndex(), fecha, v_listaAgenda.defModel);
            }
        });
        v_listaAgenda.jcb_pacientes_mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (v_listaAgenda.jcb_pacientes_mostrar.getSelectedIndex() == 0) {
                    v_listaAgenda.jd_calendar.setVisible(false);
                    v_listaAgenda.jb_buscar.setVisible(false);
                    VaciarTabla(v_listaAgenda.defModel);
                    MostrarAgenda(0, "x", v_listaAgenda.defModel);
                } else {
                    v_listaAgenda.jd_calendar.setVisible(true);
                    v_listaAgenda.jb_buscar.setVisible(true);
                }
            }
        });
        v_listaAgenda.jb_atender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                atenderPaciente();
                VaciarTabla(v_listaAgenda.defModel);
                fecha = ((JTextField) v_listaAgenda.jd_calendar.getDateEditor().getUiComponent()).getText();
                MostrarAgenda(v_listaAgenda.jcb_pacientes_mostrar.getSelectedIndex(), fecha, v_listaAgenda.defModel);
            }
        });
    }

    public void MostrarAgenda(int tipo, String fecha, DefaultTableModel defModel) {
        new MODL_Agenda().EnlistarAgenda(tipo, fecha, v_listaAgenda.defModel);
    }

    public void VaciarTabla(DefaultTableModel defModel) {
        while (defModel.getRowCount() > 0) {
            defModel.removeRow(defModel.getRowCount() - 1);
        }
    }

    public void atenderPaciente() {
        try {
            int fila = v_listaAgenda.jt_cita_pacientes.getSelectedRow();
            String id = String.valueOf(v_listaAgenda.defModel.getValueAt(fila, 0));
            String fecha = String.valueOf(v_listaAgenda.defModel.getValueAt(fila, 4));
            System.out.println(id + " " + fecha);
            new MODL_Paciente().AtenderPaciente(id, fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecciona un paciente");
        }
    }

}
