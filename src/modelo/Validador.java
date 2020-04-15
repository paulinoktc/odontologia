/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;
import vista.V_DatosPersonales;

/**
 *
 * @author zomby
 */
public class Validador {

    V_DatosPersonales vista;

    public Validador(V_DatosPersonales vista) {
        this.vista = vista;
    }

    public boolean validarEspaciosPaciente() {
        boolean faltanDatos = false;
        if (!vista.jt_nombre.getText().isEmpty()) {
            faltanDatos = true;
        }
        if (!vista.jt_ap_paterno.getText().isEmpty()) {

            faltanDatos = true;
        }
        if (!vista.jt_ap_materno.getText().isEmpty()) {

            faltanDatos = true;
        }
        if (!vista.jtf_ocupacion.getText().isEmpty()) {

            faltanDatos = true;
        }

        if (!vista.jt_telefono.getText().isEmpty()) {

            faltanDatos = true;
        }
        if (!vista.jt_domicilio.getText().isEmpty()) {

            faltanDatos = true;
        }

        if (!vista.jt_representante.getText().isEmpty()) {

            faltanDatos = true;
        }
        if (!vista.jt_motiv_visita.getText().isEmpty()) {

            faltanDatos = true;
        }

        if (!vista.jt_correo.getText().isEmpty()) {

            faltanDatos = true;
        }

        if (!vista.jta_tratamiento.getText().isEmpty()) {

            faltanDatos = true;
        }

        return faltanDatos;
    }

    public boolean revisaJCombobox() {
        if (vista.jcb_sexo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona sexo");
            return true;
        } else if (vista.jcb_estadoCivil.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona Estado civil");
            return true;
        } else if (vista.jcb_escolaridad.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona Escolaridad");
            return true;
        } else if (vista.jcb_t_consulta.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona un Tipo consulta");
            return true;
        } else if (vista.jcb_higieneBucal.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona hijiene bucal");
            return true;
        } else if (vista.jcb_alimentacion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona tipo de Alimentacion");
            return true;
        } else if (vista.jcb_frenillo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona tipo de freni");
            return true;
        }
        return false;
    }

}
