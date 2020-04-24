/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.V_Principal;
import vista.V_login;

/**
 *
 * @author ZOMBY
 */
public class CTRL_principal {
    V_Principal v_principal;
    public CTRL_principal() {
        v_principal=new V_Principal();
        agregarActions();
        v_principal.setVisible(true);
    }
    
    private void agregarActions(){
        v_principal.jmi_cerrarCecion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_principal.dispose();
                new CTRL_login();
            }
        });
        
        v_principal.jb_nuevoPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_principal.dispose();
                new CTRL_DatosPersonales();
            }
        });
        
        v_principal.jb_buscarPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_principal.dispose();
                new CTRL_BuscarPaciente();
            }
        });
        
        v_principal.jb_agenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_principal.dispose();
                new CTRL_ListaAgenda();
            }
        });
        
        v_principal.jb_cerrar_caja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_principal.dispose();
                new CTRL_Venta();
            }
        });
        
        v_principal.jb_presupuesto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_principal.dispose();
                new CTRL_Presupuesto();
            }
        });
    }
    
   
}
