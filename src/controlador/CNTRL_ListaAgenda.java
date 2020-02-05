/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.V_Agenda;
import vista.V_RegistrarCita;

/**
 *
 * @author ZOMBY
 */
public class CNTRL_ListaAgenda {
    V_Agenda v_listaAgenda;
    V_RegistrarCita v_regitra_cita;
    
    public CNTRL_ListaAgenda() {
        v_listaAgenda=new  V_Agenda();
        agregarActions();
        v_listaAgenda.setVisible(true);
    }
    
    public void agregarActions(){
        v_listaAgenda.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_listaAgenda.dispose();
                new CTRL_principal();
            }
        });
        v_listaAgenda.jb_agendar_cita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new CTRL_BuscarPaciente();
               v_listaAgenda.dispose();
            }
        });
        
    }
}
