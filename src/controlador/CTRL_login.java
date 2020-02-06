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
import mdoelo.MOD_login;
import vista.V_login;

/**
 *
 * @author ZOMBY
 */
public class CTRL_login {

    V_login v_login;
    MOD_login mod_login;

    public CTRL_login() {
        v_login = new V_login();
        mod_login = new MOD_login();
        agregarActions();
        v_login.setVisible(true);
    }

    private void agregarActions() {
        v_login.jb_iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mod_login.conectarPostgres(String.valueOf(v_login.jcb_usuarios.getSelectedItem()), v_login.jp_pass.getText()) != null) {
                    new CTRL_principal();
                    v_login.dispose();
                } else {
                    v_login.jp_pass.setText("");
                    JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INVALIDA");
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
