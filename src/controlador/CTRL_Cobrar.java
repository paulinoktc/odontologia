/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;
import modelo.MODL_Ventas;
import modelo.OBJ_Reglones;
import vista.V_Cobrar;

/**
 *
 * @author ZOMBY
 */
public class CTRL_Cobrar {

    V_Cobrar v_cobrar;

    public CTRL_Cobrar(String[] concepto, String nombre) {
        v_cobrar = new V_Cobrar();
        agregarActions();
        v_cobrar.defModel.addRow(concepto);
        v_cobrar.jl_nombre.setText("Nombre: " + nombre);
        v_cobrar.setVisible(true);
    }

    public CTRL_Cobrar() {
        v_cobrar = new V_Cobrar();
        agregarActions();
        v_cobrar.setVisible(true);
    }

    /**
     * Configura el comportamiento de los botones
     */
    public void agregarActions() {
        v_cobrar.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CTRL_principal();
                v_cobrar.dispose();
            }
        });

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

        v_cobrar.jb_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String[] add = {"1","2"};
                v_cobrar.defModel.addRow(add);
            }
        });

    }

    public void botonComartidoCobrar() {

        v_cobrar.jb_cobrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    v_cobrar.jtab_venta.moveColumn(0, 0);
                    ArrayList<OBJ_Reglones> saveList = ExtraElementosTB();
                    double total = calcularTotal(saveList);
                    v_cobrar.jl_total_pagar.setText("$" + total);

                    if (JOptionPane.showConfirmDialog(null, "Cobrar: $" + total) == 0) {
                        JOptionPane.showMessageDialog(null, "Cobro exitoso!");
                        new MODL_Ventas().SaveVentas(saveList);
                        new CTRL_principal();
                        v_cobrar.dispose();
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "El cuadro deve estar completamente lleno\n o borra reglones que no uses");
                }
            }
        });
    }

    public ArrayList<OBJ_Reglones> ExtraElementosTB() throws NumberFormatException {
        ArrayList<OBJ_Reglones> reglones = new ArrayList<>();
        int columnas = v_cobrar.defModel.getColumnCount();
        int filas = v_cobrar.defModel.getRowCount();
        for (int i = 0; i < filas; i++) {
            String uno = (String) v_cobrar.defModel.getValueAt(i, 0);
            double dos = Double.parseDouble(String.valueOf(v_cobrar.defModel.getValueAt(i, 1)).trim());
            reglones.add(new OBJ_Reglones(uno, dos));
        }
        return reglones;
    }

    public double calcularTotal(ArrayList<OBJ_Reglones> reglones) {
        double total = 0;
        for (OBJ_Reglones ventas : reglones) {
            total += ventas.getCantidad();
        }
        return total;
    }

}
