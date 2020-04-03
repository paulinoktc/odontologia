/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Action;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.MODL_Login;
import vista.V_login;

/**
 *
 * @author ZOMBY
 */
public class CTRL_login {

    V_login v_login;
    MODL_Login mod_login;

    public CTRL_login() {
        v_login = new V_login();
        mod_login = new MODL_Login();
        
        agregarActions();
        v_login.setVisible(true);
        cargarItems();
    }
    
    public void cargarItems(){
        mod_login.cargarItems(v_login.jcb_usuarios);
    }

    private void agregarActions() {

        v_login.jb_iniciar.addActionListener(new ActionListener() {
            @Override
            /**
             * Verifica que el usuario y contraseña sean correctos pendiente de cifrar contraseña
             */
            public void actionPerformed(ActionEvent ae) {
                if(mod_login.validarPass(String.valueOf(v_login.jcb_usuarios.getSelectedItem()), v_login.jp_pass.getText())){
                    new CTRL_principal();
                    v_login.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "CONTRASEÑA ERRONEA");
                }
            }
        });
        
        v_login.jcb_usuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_login.jp_pass.setText("");
            }
        });
        v_login.jb_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
    }

}
