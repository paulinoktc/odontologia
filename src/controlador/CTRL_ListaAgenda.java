/**
 *Lleva el control de las citas muestra todas las citas, pedientes, atendidas por fecha selecciona la cita que se desea atender
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.MODL_Agenda;
import modelo.MODL_Paciente;
import vista.V_Agenda;

/**
 *
 * @author PaulinoSalas
 */
public class CTRL_ListaAgenda {

    V_Agenda v_listaAgenda;
    String fecha;

    /**
     * Metodo constructor inicializa los objetos cargar todas las citas que se
     * encuentre atendidas o no atendidas
     */
    public CTRL_ListaAgenda() {
        v_listaAgenda = new V_Agenda();
        MostrarAgenda(0, "x", v_listaAgenda.defModel);
        agregarActions();
        v_listaAgenda.jd_calendar.setVisible(false);
        v_listaAgenda.jb_buscar.setVisible(false);
        v_listaAgenda.setVisible(true);
    }

    /**
     * Agrega el comportamiento de los botones
     */
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
                if (fecha.length() > 3) {
                    MostrarAgenda(v_listaAgenda.jcb_pacientes_mostrar.getSelectedIndex(), fecha, v_listaAgenda.defModel);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona una fecha");
                }
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

    /**
     * Busca en la base de datos las citas dependiendo de los parametros
     *
     * @param tipo Tipo de cita atndido 1 no atgendido 0
     * @param fecha Fecha de la cita
     * @param defModel defModel en la que se van a mostrar los datos encontrados
     */
    public void MostrarAgenda(int tipo, String fecha, DefaultTableModel defModel) {
        new MODL_Agenda().EnlistarAgenda(tipo, fecha, v_listaAgenda.defModel);
    }

    /**
     * Vacia los datos de la tabla para voverlos a llenar
     *
     * @param defModel DelModel que se pretende limpiar
     */
    public void VaciarTabla(DefaultTableModel defModel) {
        while (defModel.getRowCount() > 0) {
            defModel.removeRow(defModel.getRowCount() - 1);
        }
    }

    /**
     * Cambia el estado de la cita a atendido
     */
    public void atenderPaciente() {
        try {
            int fila = v_listaAgenda.jt_cita_pacientes.getSelectedRow();
            String id = String.valueOf(v_listaAgenda.defModel.getValueAt(fila, 0));
            String fecha = String.valueOf(v_listaAgenda.defModel.getValueAt(fila, 4));
            new MODL_Paciente().AtenderPaciente(id, fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecciona un paciente");
        }
    }

}
