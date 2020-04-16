/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.AncestorListener;
import modelo.OBJ_Reglones;
import vista.V_Cobrar;

/**
 *
 * @author ZOMBY
 */
public class CTRL_Cobrar {

    V_Cobrar v_cobrar;

//---------------------------------pendiente de mandar un objeto
    public CTRL_Cobrar(String[] concepto) {
        v_cobrar = new V_Cobrar();
        agregarActions();
        String[] otro = {"", ""};
        v_cobrar.defModel.addRow(concepto);
        v_cobrar.defModel.addRow(otro);
        v_cobrar.defModel.addRow(otro);
        v_cobrar.defModel.addRow(otro);
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
                new CTRL_BuscarPaciente();
                v_cobrar.dispose();
            }
        });

        v_cobrar.jb_abonar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                v_cobrar.jtab_venta.moveColumn(0, 0);
                ExtraElementosTB();
            }
        });
        

    }

    public void ExtraElementosTB() {
        ArrayList<OBJ_Reglones> reglones = new ArrayList<>();
        int columnas = v_cobrar.defModel.getColumnCount();
        int filas = v_cobrar.defModel.getRowCount();
        for (int i = 0; i < filas; i++) {
                String uno=(String) v_cobrar.defModel.getValueAt(i, 0);
                String dos=(String) v_cobrar.defModel.getValueAt(i, 1);
                System.out.println(uno+" "+dos);
  //          reglones.add(new OBJ_Reglones(
//                    String.valueOf(v_cobrar.defModel.getValueAt(i, 0)),
//                    Double.parseDouble(String.valueOf(v_cobrar.defModel.getValueAt(i, 1)))));
        }
        
        

    }

}
