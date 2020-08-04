/**
 * Clase Controlar la busqueda de los pacientes por nombre apellido
 * numero de telefono o folio de paciente hace uso de la vista
 * V_BuscarPaciente y de los modelos MODL_Paciente,MODL_Ventas
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.MODL_Paciente;
import modelo.MODL_Ventas;
import modelo.OBJ_Paciente;
import modelo.OBJ_Reglones;
import vista.V_BuscarPaciente;

/**
 *
 * @author PaulinoSalas
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
        /**
         * Al salir llama al Controlador principal para regresar al menu
         * principal
         */
        v_buscarPaciente.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_buscarPaciente.dispose();

                new CTRL_principal();
            }
        });

        /**
         * Llama el controlador de nuevo histotial para llevar a cabo el nuevo
         * registro de historial
         */
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

        /**
         * Llama al metodo VentanaAbonar() reusa un controlador
         */
        v_buscarPaciente.jb_abonar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaCobrar();
            }
        });
        /**
         * Lamam al controlador para agendar unan cita
         */
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

        /**
         * Llama el cotrolador para ver el historial completo
         */
        v_buscarPaciente.jb_hist_complet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (v_buscarPaciente.jcb_select_paciente.getItemCount() != 0) {
                    String id = listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getId_paciente();
                    new CTRL_HistorialCompleto(id);
                    v_buscarPaciente.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Primero Busca un Paciente");
                }

            }
        });

        /**
         * Llama al metodo revalidarBusqueda() busca una lista de pacientes
         */
        v_buscarPaciente.jb_buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                revalidarBusqueda();
            }
        });

        /**
         * Se encuentra a la escucha de un enter para buscar al paciente y
         * enlistarlo
         */
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

        /**
         * Llama el metodo otorgaCredito() para otorgar un credito al paciente
         */
        v_buscarPaciente.jb_credito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                otorgaCredito();
            }
        });

        /**
         * Se mantiene en escucha cuando se selecciona un item con el nombre
         * este busca los datos que contenga el indice dicha lista de pacientes
         */
        v_buscarPaciente.jcb_select_paciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (v_buscarPaciente.jcb_select_paciente.getItemCount() > 0) {
                    cargarDatosDelPaciente();
                }
            }
        });
    }

    /**
     * Se encarga de buscar al paciente y mostrar los datos del paciente
     * seleccionado en la vista
     */
    public void revalidarBusqueda() {
        buscarPaciente();
        cargarDatosDelPaciente();
    }

    /**
     * Muestra Los datos de paciente seleccionado en la vista de buscarPaciente
     */
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

    /**
     * Valida si el ususario ha tenido ha tenido o no credito o si debe en todo
     * caso y pide la cantidad que se le otorgara
     */
    public void otorgaCredito() {
        try {
            //Extrae la cantidad que se debe desde la base de datos el resultado lo define el metodo del modelo
            double cantidadAnt = new MODL_Ventas().validaCredito(
                    listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getId_paciente());
            //Extrae el id(Folio del paciente ) para actualizar u otorgar el credito
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

    /**
     * Cuando se envia un paciente este metodo es el encargado de mostrarlo en
     * la pantalla por ejemplo cuando es un nuevo paciente y se tiene que
     * realizar alguna accion con el paciente como realizar cita otorgar credito
     * etc.
     */
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

    /**
     * Busca al paciente y lo enlista para mostrarlo la lista de items
     * (psaciente) encontrados
     */
    public void buscarPaciente() {
        v_buscarPaciente.jcb_select_paciente.removeAllItems();
        String datoTemporal = v_buscarPaciente.jtf_dato_a_buscar.getText();
        datoTemporal = quitarEspaciosBasios(datoTemporal);
        listaPacientes = new MODL_Paciente().buscarPacientes(v_buscarPaciente.jcb_buscar_por.getSelectedIndex(), datoTemporal);
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

    /**
     * Recibe un paciente predefinido para ser este el paciente en el que se va
     * a trabajar
     *
     * @param pacienteDefault Paciente por defecto a mostrar
     */
    public void addPacientePredefinido(OBJ_Paciente pacienteDefault) {
        listaPacientes = new ArrayList<>();
        listaPacientes.add(pacienteDefault);
        mostrarPacientePredefinido();
        v_buscarPaciente.jtf_dato_a_buscar.setText(pacienteDefault.getNombre());

    }

    /**
     * Activa la ventana para cobrar un abono y reusa el controlador de cobrar
     * ademas agrega a las ventas del dia una venta
     */
    public void VentanaCobrar() {
        String[] conecpto = {"Abono a cuenta"};
        String nombreCompleto = listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getNombre()
                + " " + listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getAp_paterno()
                + " " + listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getAp_materno();
        CTRL_Cobrar cntr_cobrar = new CTRL_Cobrar(conecpto, nombreCompleto);
        v_buscarPaciente.dispose();

        cntr_cobrar.v_cobrar.jb_add.setVisible(false);
        cntr_cobrar.v_cobrar.jb_rm.setVisible(false);
        cntr_cobrar.v_cobrar.jb_cobrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    cntr_cobrar.v_cobrar.jtab_venta.moveColumn(0, 0);
                    //Enlista los datos a cobrar
                    ArrayList<OBJ_Reglones> saveList = cntr_cobrar.ExtraElementosTB(cntr_cobrar.v_cobrar.jl_nombre.getText());
                    double total = cntr_cobrar.calcularTotal(saveList);
                    cntr_cobrar.v_cobrar.jl_total_pagar.setText("$" + total);

                    //pide la confirmacion para realizar el cobro
                    if (JOptionPane.showConfirmDialog(null, "Cobrar: $" + total) == 0) {
                        MODL_Ventas vtas = new MODL_Ventas();

                        String mensaje = vtas.abonaCuenta(listaPacientes.get(v_buscarPaciente.jcb_select_paciente.getSelectedIndex()).getId_paciente(), total);
                        if (!mensaje.equalsIgnoreCase("Cobro Excesivo")) {
                            //guarda la lista de lo que se cobro
                            vtas.SaveVentas(saveList);
                        }
                        JOptionPane.showMessageDialog(null, mensaje);
                        //una vez realizado el abono este regresa a la ventana de buscarpaciente
                        new CTRL_BuscarPaciente();
                        cntr_cobrar.v_cobrar.dispose();
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "El cuadro deve estar completamente lleno\n o borra reglones que no uses");
                }
            }
        });

    }

    /**
     * Metodo para quitar espacios a las palabras escritas
     *
     * @param palabra palabra a quitar espacios
     * @return palabra sin espacios
     */
    public String quitarEspaciosBasios(String palabra) {
        palabra = palabra.replaceAll("\\ ", "");
        return palabra;
    }

}
