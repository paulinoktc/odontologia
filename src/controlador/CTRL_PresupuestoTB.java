/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.OBJ_Reglones;
import vista.V_PresupuestoTB;

/**
 *
 * @author ZOMBY
 */
public class CTRL_PresupuestoTB {

    private V_PresupuestoTB v_presupuesto;

    ArrayList<String[]> reglonesConcepto;

    public CTRL_PresupuestoTB() {
        init();
        EnEscucha();
        v_presupuesto.setVisible(true);
    }

    public void EnEscucha() {
        v_presupuesto.jb_calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<OBJ_Reglones> seleccionados = extraerDatosTabla();
                v_presupuesto.jl_total.setText("$ "+calcularTotales(seleccionados));

            }
        });
        v_presupuesto.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_presupuesto.dispose();
                new CTRL_principal();
            }
        });
    }

    public void init() {
        v_presupuesto = new V_PresupuestoTB();
        reglonesConcepto = new ArrayList<>();
        initReglones();
        v_presupuesto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initReglones() {
        reglonesConcepto.add(new String[]{"AMALGAMAS C/U", "", "", ""});
        reglonesConcepto.add(new String[]{"RECINAS C/U", "", "", ""});
        reglonesConcepto.add(new String[]{"INCRUTACIONES C/U", "", "", ""});
        reglonesConcepto.add(new String[]{"CORONAS C/U", "", "", ""});
        reglonesConcepto.add(new String[]{"ENDODONCIA C/U", "", "", ""});
        reglonesConcepto.add(new String[]{"EXTRACCIONES C/U", "", "", ""});
        reglonesConcepto.add(new String[]{"PROSTODONCIA C/U", "", "", ""});
        reglonesConcepto.add(new String[]{"LIMPIEZA C/U", "", "", ""});
        reglonesConcepto.add(new String[]{"CURETAS C/U", "", "", ""});

        for (String[] listaConceptos : reglonesConcepto) {
            v_presupuesto.defModel.addRow(listaConceptos);
        }
    }

    public double calcularTotales(ArrayList<OBJ_Reglones> select) {
        double totalNeto = 0;
        for (OBJ_Reglones listReglones : select) {
            totalNeto += listReglones.getTotal();
        }
        return totalNeto;
    }

    private ArrayList<OBJ_Reglones> extraerDatosTabla() {
        ArrayList<OBJ_Reglones> reglones = new ArrayList<>();
        v_presupuesto.jtab_contenido.moveColumn(0, 0);
        int filas = v_presupuesto.defModel.getRowCount();
        for (int i = 0; i < filas; i++) {
            String concepto = v_presupuesto.defModel.getValueAt(i, 0).toString();
            String precio = v_presupuesto.defModel.getValueAt(i, 1).toString();
            String cantidad = v_presupuesto.defModel.getValueAt(i, 2).toString();

            double price = 0;

            if (!precio.isEmpty()) {
                try {
                    price = Double.parseDouble(precio);

                    if (!cantidad.isEmpty()) {
                        int size = Integer.parseInt(cantidad);
                        OBJ_Reglones reglon = new OBJ_Reglones(v_presupuesto.jl_nombreCliente.getText(), concepto, size, price);
                        reglones.add(reglon);
                        v_presupuesto.defModel.setValueAt("$ " + reglon.getTotal(), i, 3);

                    } else {
                        JOptionPane.showMessageDialog(null, "Ingresa Cantidad!");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Verifica\n COLUMNA CANTIDAD NUMERO ENTEROS \n NO LETRAS \nEn:  " + concepto);
                }
            }

        }
        System.out.println("\n\n");
        return reglones;
    }

    public static void main(String[] args) {
        new CTRL_PresupuestoTB();
    }

}
