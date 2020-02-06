/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.V_Agenda;
import vista.V_Cobrar;

/**
 *
 * @author ZOMBY
 */
public class CNTRL_Venta {
    V_Cobrar v_ventasDia;

    public CNTRL_Venta() {
        v_ventasDia=new V_Cobrar();
        agregarActions();
        AjustarVentana();
        v_ventasDia.setVisible(true);
    }
    public void AjustarVentana(){
        v_ventasDia.jl_titulo.setText("VENTAS DEL DIA");
        v_ventasDia.jl_nombre.setVisible(false);
        v_ventasDia.jtf_datos_ref.setVisible(false);
    }
    public void agregarActions(){
        v_ventasDia.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_ventasDia.dispose();
                new CTRL_principal();
            }
        });
    }
}
