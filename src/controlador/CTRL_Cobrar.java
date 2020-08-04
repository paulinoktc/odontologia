/**
 * Se encarga de Cobrar recibe el concepto de venta y el nombre de quien realizo la compras
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.MODL_Ventas;
import modelo.OBJ_Reglones;
import vista.V_Cobrar;

/**
 *
 * @author PaulinoSalas
 */
public class CTRL_Cobrar {

    V_Cobrar v_cobrar;

    /**
     * Contructor que recibe el concepto de pago y el nombre
     *
     * @param concepto
     * @param nombre
     */
    public CTRL_Cobrar(String[] concepto, String nombre) {
        v_cobrar = new V_Cobrar();
        agregarActions();
        v_cobrar.defModel.addRow(concepto);
        v_cobrar.jl_nombre.setText(nombre);
        v_cobrar.setVisible(true);
    }

    /**
     * Solo inicializa la ventana y pone a los botones en escucha para ser
     * reutilizado
     */
    public CTRL_Cobrar() {
        v_cobrar = new V_Cobrar();
        agregarActions();
        v_cobrar.setVisible(true);
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
                String[] add = {"", ""};
                v_cobrar.defModel.addRow(add);
            }
        });

    }

    /**
     * Pone a la escucha al boton y le agrega las acciones a realizar para
     * realizar el cobro
     */
    public void botonComartidoCobrar() {
        v_cobrar.jb_cobrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    v_cobrar.jtab_venta.moveColumn(0, 0);
                    ArrayList<OBJ_Reglones> saveList = ExtraElementosTB(v_cobrar.jl_nombre.getText());
                    double total = calcularTotal(saveList);
                    if (total > 0) {
                        v_cobrar.jl_total_pagar.setText("$" + total);
                        
                        if (JOptionPane.showConfirmDialog(null, "Cobrar: $" + total) == 0) {
                            JOptionPane.showMessageDialog(null, "Cobro exitoso!");
                            new MODL_Ventas().SaveVentas(saveList);
                            new CTRL_principal();
                            v_cobrar.dispose();
                        }
                    } else {
                         JOptionPane.showMessageDialog(null, "No se permiten precios menores a $ 0");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "El cuadro debe estar completamente lleno\n o borra reglones que no uses\nEscribe el precio con numeros");
                }
            }
        });
    }

    /**
     * Extrae los elementos de la tabla a cobrar
     *
     * @param nombre Rcibe el nombre de el cliente que realiza el cobro
     * @return Lista de conceptos cantidad y nombre de las venta
     * @throws NumberFormatException
     */
    public ArrayList<OBJ_Reglones> ExtraElementosTB(String nombre) throws NumberFormatException {
        ArrayList<OBJ_Reglones> reglones = new ArrayList<>();
        //cuenta las columas que se encuentran en la tabla
        int columnas = v_cobrar.defModel.getColumnCount();
        //cuenta las filas que se encuentran en la tabla
        int filas = v_cobrar.defModel.getRowCount();
        for (int i = 0; i < filas; i++) {
            String uno = (String) v_cobrar.defModel.getValueAt(i, 0);
            //convierte en double la cantidad que se encuentra escrita en la tabla
            double dos = Double.parseDouble(String.valueOf(v_cobrar.defModel.getValueAt(i, 1)).trim());
            reglones.add(new OBJ_Reglones(uno, dos, nombre));
        }
        return reglones;
    }

    /**
     * Calcula el total de de las ventas del arraylist que se estrajo
     * anterirmente
     *
     * @param reglones Reglones que se van a sumar
     * @return Total de las sumas a cobrar
     */
    public double calcularTotal(ArrayList<OBJ_Reglones> reglones) {
        double total = 0;

        for (OBJ_Reglones ventas : reglones) {
            if (ventas.getCantidad() <= 0) {
                return 0;
            } else {
                total += ventas.getCantidad();
            }
        }
        return total;
    }

    public static void main(String[] args) {
        new CTRL_Cobrar();
    }
}
