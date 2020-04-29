/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.MODL_Paciente;
import modelo.MODL_Ventas;
import modelo.OBJ_Paciente;
import modelo.OBJ_Reglones;
import modelo.Validador;
import vista.V_BuscarPaciente;
import vista.V_Cobrar;
import vista.V_RegistrarCita;

/**
 *
 * @author ZOMBY
 */
public class CTRL_BuscarPaciente {

    V_BuscarPaciente v_buscarPaciente;
    private ArrayList<OBJ_Paciente> listaPacientes;

    public CTRL_BuscarPaciente() {
        v_buscarPaciente = new V_BuscarPaciente();
        agregarActions();
        v_buscarPaciente.jl_abonar.setVisible(false);
        v_buscarPaciente.jl_otorgaCredito.setVisible(false);
        v_buscarPaciente.jb_abonar.setVisible(false);
        v_buscarPaciente.jb_credito.setVisible(false);

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

        v_buscarPaciente.jb_nuevoHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (v_buscarPaciente.jcb_select_paciente.getItemCount() > 0) {
                    String id = listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getId_paciente();
                    new CTRL_NuevoHistorial(id);
                    v_buscarPaciente.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Busca un paciente");
                }

            }
        });

        v_buscarPaciente.jb_abonar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaCobrar();
            }
        });
        v_buscarPaciente.jb_add_cita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (v_buscarPaciente.jcb_select_paciente.getItemCount() != 0) {
                    String nombre = listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getNombre()
                            + " " + listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getAp_paterno()
                            + " " + listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getAp_materno();

                    new CTRL_AgendarCita(nombre).setId_paciente(listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getId_paciente());
                    v_buscarPaciente.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Primero debes buscar un paciente");
                }
            }
        });
        v_buscarPaciente.jb_hist_complet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (v_buscarPaciente.jcb_select_paciente.getItemCount() != 0) {
                    String id = listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getId_paciente();
                    new CTRL_HistorialCompleto(id);
                    v_buscarPaciente.dispose();

                }

            }
        });

        v_buscarPaciente.jb_buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                revalidarBusqueda();
            }
        });

        v_buscarPaciente.jtf_dato_a_buscar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                String enter = "\n";
                if (enter.equalsIgnoreCase(ke.getKeyChar() + "")) {
                    revalidarBusqueda();

                }

            }

            @Override
            public void keyPressed(KeyEvent ke) {

            }

            @Override
            public void keyReleased(KeyEvent ke) {

            }

        });

        v_buscarPaciente.jb_credito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                otorgaCredito();
            }
        });

        v_buscarPaciente.jcb_select_paciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (v_buscarPaciente.jcb_select_paciente.getItemCount() > 0) {
                    cargarDatosDelPaciente();
                }
            }
        });
    }

    public void revalidarBusqueda() {
        buscarPaciente();
        cargarDatosDelPaciente();
    }

    public void cargarDatosDelPaciente() {
        if (listaPacientes.size() != 0) {
            double cantidad = new MODL_Ventas().validaCredito(
                    listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getId_paciente());

            OBJ_Paciente temporal = new MODL_Paciente().h_paciente(listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getId_paciente());
            v_buscarPaciente.jl_telefono.setText("Telefono: " + temporal.getTelefono());
            v_buscarPaciente.jl_tutor.setText("Tutor: " + temporal.getTutor());
            v_buscarPaciente.jl_telTutor.setText("Telefono: " + temporal.getTelTutor());

            if (cantidad > 0) {
                v_buscarPaciente.jl_cuenta_credito.setText("$ " + cantidad);
                v_buscarPaciente.jb_abonar.setVisible(true);
                v_buscarPaciente.jl_abonar.setVisible(true);
                v_buscarPaciente.jb_credito.setVisible(false);
                v_buscarPaciente.jl_otorgaCredito.setVisible(false);

            } else if (cantidad < 0) {
                v_buscarPaciente.jb_credito.setVisible(true);
                v_buscarPaciente.jb_abonar.setVisible(false);
                v_buscarPaciente.jl_abonar.setVisible(false);
                v_buscarPaciente.jl_otorgaCredito.setVisible(true);

                v_buscarPaciente.jl_cuenta_credito.setText("$ 0.00");
            } else if (cantidad == 0) {
                v_buscarPaciente.jb_abonar.setVisible(false);
                v_buscarPaciente.jl_abonar.setVisible(false);
                v_buscarPaciente.jb_credito.setVisible(true);
                v_buscarPaciente.jl_otorgaCredito.setVisible(true);
                v_buscarPaciente.jl_cuenta_credito.setText("$ 0.00");
            }
        }
    }

    public void otorgaCredito() {
        try {
            double cantidadAnt = new MODL_Ventas().validaCredito(
                    listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getId_paciente());
            String id_paciente = listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getId_paciente();
            double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingresa cantidad"));

            if (cantidad > 0) {
                if (JOptionPane.showConfirmDialog(null, "Otorgar Credito?") == 0) {
                    if (cantidadAnt < 0) {
                        new MODL_Ventas().ActializaCredito(id_paciente, cantidad);
                        revalidarBusqueda();
                    } else {
                        new MODL_Ventas().otorgarCredito(id_paciente, cantidad);
                        revalidarBusqueda();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cantidad no valida");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingresa cantidad valida");
        }
    }

    public void mostrarPacientePredefinido() {
        for (OBJ_Paciente listPacient : listaPacientes) {
            v_buscarPaciente.jcb_select_paciente.addItem("Folio: "
                    + listPacient.getId_paciente() + " "
                    + listPacient.getNombre() + " "
                    + listPacient.getAp_paterno() + " "
                    + listPacient.getAp_materno() + " "
            );

        }
    }

    public void buscarPaciente() {
        v_buscarPaciente.jcb_select_paciente.removeAllItems();
        listaPacientes = new MODL_Paciente().buscarPacientes(v_buscarPaciente.jcb_buscar_por.getSelectedIndex(), v_buscarPaciente.jtf_dato_a_buscar.getText());
        if (listaPacientes.size() != 0) {
            for (OBJ_Paciente listPacient : listaPacientes) {
                v_buscarPaciente.jcb_select_paciente.addItem(
                        listPacient.getId_paciente() + " "
                        + listPacient.getNombre() + " "
                        + listPacient.getAp_paterno() + " "
                        + listPacient.getAp_materno() + " "
                        + listPacient.getTelefono()
                );

            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
        }
    }

    public void addPacientePredefinido(OBJ_Paciente pacienteDefault) {
        listaPacientes = new ArrayList<>();
        listaPacientes.add(pacienteDefault);
        mostrarPacientePredefinido();
        v_buscarPaciente.jtf_dato_a_buscar.setText(pacienteDefault.getNombre());

    }

    public void VentanaCobrar() {
        String[] conecpto = {"Abono a cuenta"};
        String nombreCompleto = listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getNombre()
                + " " + listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getAp_paterno()
                + " " + listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getAp_materno();
        CTRL_Cobrar cntr_cobrar = new CTRL_Cobrar(conecpto, nombreCompleto);
        v_buscarPaciente.dispose();

        cntr_cobrar.v_cobrar.jb_cobrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    cntr_cobrar.v_cobrar.jtab_venta.moveColumn(0, 0);
                    ArrayList<OBJ_Reglones> saveList = cntr_cobrar.ExtraElementosTB(cntr_cobrar.v_cobrar.jl_nombre.getText());
                    double total = cntr_cobrar.calcularTotal(saveList);
                    cntr_cobrar.v_cobrar.jl_total_pagar.setText("$" + total);

                    if (JOptionPane.showConfirmDialog(null, "Cobrar: $" + total) == 0) {
                        MODL_Ventas vtas = new MODL_Ventas();
                        vtas.SaveVentas(saveList);
                        String mensaje = vtas.abonaCuenta(listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getId_paciente(), total);
                        JOptionPane.showMessageDialog(null, mensaje);

                        new CTRL_BuscarPaciente();
                        cntr_cobrar.v_cobrar.dispose();
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "El cuadro deve estar completamente lleno\n o borra reglones que no uses");
                }
            }
        });

    }
}
