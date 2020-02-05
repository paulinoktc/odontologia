/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.V_Cobrar;

/**
 *
 * @author ZOMBY
 */
public class CTRL_Cobrar {
    V_Cobrar v_cobrar;

//---------------------------------pendiente de mandar un objeto
    public CTRL_Cobrar() {
        v_cobrar=new V_Cobrar();
        agregarActions();
        v_cobrar.setVisible(true);
    }
    public void agregarActions(){
        v_cobrar.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CTRL_principal();
                v_cobrar.dispose();
            }
        });
    }
}
