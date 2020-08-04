/**
 * Se encarga de Cobrar recibe el concepto de venta y el nombre de quien realizo la compras
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.MODL_Ventas;
import modelo.OBJ_Paciente;
import modelo.OBJ_Reglones;
import vista.V_Cobrar;

/**
 *
 * @author PaulinoSalas
 */
public class CTRL_Cobrar {

    private ArrayList<OBJ_Reglones> conceptos;
    public V_Cobrar v_cobrar;
    private OBJ_Paciente el_paciente;

    public CTRL_Cobrar(ArrayList<OBJ_Reglones> conceptos) {
        v_cobrar = new V_Cobrar();
        agregarActions();
        mostrarElementos(conceptos);
        v_cobrar.jl_nombre.setText("Al mostrador");
        v_cobrar.setVisible(true);
    }

    public CTRL_Cobrar(ArrayList<OBJ_Reglones> conceptos, OBJ_Paciente el_paciente) {
        v_cobrar = new V_Cobrar();
        this.el_paciente = el_paciente;
        agregarActions();
        mostrarElementos(conceptos);
        v_cobrar.jl_nombre.setText(this.el_paciente.getNombre()+" "+this.el_paciente.getAp_paterno()+" "+this.el_paciente.getAp_materno());
        v_cobrar.setVisible(true);
    }

    public void mostrarElementos(ArrayList<OBJ_Reglones> conceptos) {
        for (OBJ_Reglones servicios : conceptos) {
            String[] reglon = {
                servicios.getConcepto(),
                servicios.getPresio() + "",
                servicios.getCantidad_1() + "",
                servicios.getTotal() + ""
            };
            v_cobrar.defModel.addRow(reglon);
        }
    }

    /**
     * Configura el comportamiento de los botones
     */
    public void agregarActions() {
        /**
         * Regresa a la ventaba principal
         */
        v_cobrar.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CTRL_principal();
                v_cobrar.dispose();
            }
        });

        /**
         * Elimina reglones de la vista ventas
         */
        v_cobrar.jb_rm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    v_cobrar.defModel.removeRow(v_cobrar.defModel.getRowCount() - 1);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No hay mas reglones");
                }
            }
        });

        /**
         * agrega reglones si es necesario cobrar un concepto mas
         */
        v_cobrar.jb_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String[] add = {"", "", "", "",};
                v_cobrar.defModel.addRow(add);
            }
        });
        v_cobrar.jb_cobrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<OBJ_Reglones> datosExtraidos = extraerDatosTabla();
                extraerDatosTabla();
                double totalNeto = calcularTotales(datosExtraidos);
                v_cobrar.jl_total_pagar.setText("$ " + totalNeto);
                if (totalNeto <= 0) {
                    JOptionPane.showMessageDialog(null, "Cantidad no valida de $ 0.0");
                } else {
                    if (JOptionPane.showConfirmDialog(null, "Cobrar: $" + totalNeto) == 0) {
                        if (v_cobrar.jb_add.isVisible()) {
                            new MODL_Ventas().SaveVentas(datosExtraidos);
                            new CTRL_principal();
                        } else {
                            MODL_Ventas vtas = new MODL_Ventas();

                            String mensaje = vtas.abonaCuenta(el_paciente.getId_paciente(), totalNeto);
                            if (!mensaje.equalsIgnoreCase("Cobro Excesivo")) {
                                //guarda la lista de lo que se cobro
                                vtas.SaveVentas(datosExtraidos);
                            }
                            JOptionPane.showMessageDialog(null, mensaje);
                            new CTRL_BuscarPaciente();
                        }
                        v_cobrar.dispose();

                    }
                }
            }
        });

    }

    //public void boton
    private ArrayList<OBJ_Reglones> extraerDatosTabla() {
        ArrayList<OBJ_Reglones> reglones = new ArrayList<>();
        v_cobrar.jtab_venta.moveColumn(0, 0);
        int filas = v_cobrar.defModel.getRowCount();
        for (int i = 0; i < filas; i++) {
            String concepto = v_cobrar.defModel.getValueAt(i, 0).toString();
            String precio = v_cobrar.defModel.getValueAt(i, 1).toString();
            String cantidad = v_cobrar.defModel.getValueAt(i, 2).toString();

            double price = 0;

            if (!precio.isEmpty()) {
                try {
                    price = Double.parseDouble(precio);

                    if (!cantidad.isEmpty() && price >= 0) {
                        int size = Integer.parseInt(cantidad);
                        if (size > 0) {
                            OBJ_Reglones reglon = new OBJ_Reglones(v_cobrar.jl_nombre.getText(), concepto, size, price);
                            reglones.add(reglon);
                            v_cobrar.defModel.setValueAt("$ " + reglon.getTotal(), i, 3);
                        } else {
                            JOptionPane.showMessageDialog(null, "La cantidad deve ser mayor a cero!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingresa Cantidad mayor a cero! \nEn: " + concepto);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Verifica\n COLUMNA CANTIDAD NUMERO ENTEROS \n NO LETRAS \nEn:  " + concepto);
                }
            }
        }
        return reglones;
    }

    public double calcularTotales(ArrayList<OBJ_Reglones> select) {
        double totalNeto = 0;
        for (OBJ_Reglones listReglones : select) {
            totalNeto += listReglones.getTotal();
        }
        return totalNeto;
    }
}
