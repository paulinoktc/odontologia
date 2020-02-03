/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.V_BuscarPaciente;
import vista.V_Cobrar;

/**
 *
 * @author ZOMBY
 */
public class CTRL_BuscarPaciente {

    V_BuscarPaciente v_buscarPaciente;
    V_Cobrar v_cobrar;
    
    public CTRL_BuscarPaciente() {
        v_buscarPaciente=new V_BuscarPaciente();
        v_cobrar=new V_Cobrar();
        agregarActions();
        v_buscarPaciente.setVisible(true);
    }
   public void agregarActions(){
       v_buscarPaciente.jmi_salir.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               v_buscarPaciente.dispose();
               new CTRL_principal();
           }
       });
       
       v_buscarPaciente.jmi_abonar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               v_cobrar.setVisible(true);
           }
       });
       
       v_cobrar.jb_cancelar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               v_cobrar.dispose();
           }
       });
   }
}
