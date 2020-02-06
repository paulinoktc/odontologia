/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.V_RegistrarCita;

/**
 *
 * @author ZOMBY
 */
public class CTRL_AgendarCita {
    V_RegistrarCita v_citas;

    public CTRL_AgendarCita() {
        v_citas=new V_RegistrarCita();
        AgregarActions();
        v_citas.setVisible(true);
        
    }
    public void AgregarActions(){
        v_citas.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CTRL_BuscarPaciente();
                v_citas.dispose();
            }
        });
    }
}
