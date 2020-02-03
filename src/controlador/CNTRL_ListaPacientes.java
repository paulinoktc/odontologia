/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.V_ListaPacientes;

/**
 *
 * @author ZOMBY
 */
public class CNTRL_ListaPacientes {
    V_ListaPacientes v_listaPacientes;

    public CNTRL_ListaPacientes() {
        v_listaPacientes=new  V_ListaPacientes();
        agregarActions();
        v_listaPacientes.setVisible(true);
    }
    
    public void agregarActions(){
        v_listaPacientes.jmi_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_listaPacientes.dispose();
                new CTRL_principal();
            }
        });
        
        
    }
}
