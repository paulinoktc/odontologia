/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import vista.V_HistorialComplet;

/**
 *
 * @author Paulino
 */
public class CTRL_HistorialCompleto {
    V_HistorialComplet v_histComplet;

    public CTRL_HistorialCompleto() {
        v_histComplet=new V_HistorialComplet();
        agregarActions();
        v_histComplet.setVisible(true);
        
    }
    
    public void agregarActions(){
        v_histComplet.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new CTRL_BuscarPaciente();                                  //recibit objeto Buscar_paciente
                 v_histComplet.dispose();
            }
        });
    }
}
