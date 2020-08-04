/**
 *Controla el logueo a la aplicacion
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.MODL_Login;
import vista.V_login;

/**
 *
 * @author PaulinoSalass
 */
public class CTRL_login {

    V_login v_login;
    MODL_Login mod_login;

    /**
     * Inicializa la ventana del login y llena los items de ususarios
     */
    public CTRL_login() {
        v_login = new V_login();
        mod_login = new MODL_Login();

        agregarActions();
        v_login.setVisible(true);
        cargarItems();
    }

    /**
     * Busca los usuarios en la base de datos y los carga en los items
     */
    public void cargarItems() {
        mod_login.cargarItems(v_login.jcb_usuarios);
    }

    /**
     * Agrega las accioens a los botones
     */
    private void agregarActions() {

        v_login.jb_iniciar.addActionListener(new ActionListener() {
            @Override
            /**
             * Verifica que el usuario y contraseña sean correctos pendiente de
             * cifrar contraseñas
             */
            public void actionPerformed(ActionEvent ae) {
                logearse();
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

        v_login.jp_pass.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char teclaPresionada = evt.getKeyChar();
                if (teclaPresionada == KeyEvent.VK_ENTER) {
                    logearse();
                }
            }
        });

    }

    public void logearse() {
        if (v_login.jcb_usuarios.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "SELECCIONA UN USUARIO");
        } else if (mod_login.validarPass(String.valueOf(v_login.jcb_usuarios.getSelectedItem()), v_login.jp_pass.getText())) {
            new CTRL_principal();
            v_login.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "CONTRASEÑA ERRONEA");
            v_login.jp_pass.setText("");
        }
    }
}
