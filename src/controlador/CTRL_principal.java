/**
 * Lleva el control de la ventana principal muestra las diferentes opciones que se pueden realizar
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.V_Principal;

/**
 *
 * @author PaulinoSalas
 */
public class CTRL_principal {

    V_Principal v_principal;

    /**
     * Inicializa la ventana de logueo
     */
    public CTRL_principal() {
        v_principal = new V_Principal();
        agregarActions();
        v_principal.setVisible(true);
    }

    /**
     * Establece las acciones que van a realizar los botones
     */
    private void agregarActions() {
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
                new CTRL_Ventas();
            }
        });

        v_principal.jb_presupuesto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v_principal.dispose();
                new CTRL_PresupuestoTB();
            }
        });
    }

}
