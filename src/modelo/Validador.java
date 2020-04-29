/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
        if (vista.jt_nombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa Nombre");
            faltanDatos = true;
        } else if (vista.jt_ap_paterno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa Apellido Paterno");
            faltanDatos = true;
        } else if (vista.jt_ap_materno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ingresa apellido materno");
            faltanDatos = true;
        } else if (((JTextField) vista.jd_fechcaNacimiento.getDateEditor().getUiComponent()).getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fecha de nacimieno?");
        } else if (vista.jtf_ocupacion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa Ocupacion");
            faltanDatos = true;
        } else if (vista.jt_telefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Numero De Telefono");
            faltanDatos = true;
        } else if (vista.jt_telefono.getText().length() < 10) {
            JOptionPane.showMessageDialog(null, "Numemero Muy corto");
            faltanDatos = true;
        } else if (vista.jt_telefono.getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "El numero Muy grande");
            faltanDatos = true;
        } else if (vista.jt_domicilio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Domicilio?");
            faltanDatos = true;
        } else if (vista.jt_representante.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa Representante");
            faltanDatos = true;
        } else if (vista.jt_motiv_visita.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Motivo de visita?");
            faltanDatos = true;
        } else if (vista.jt_correo.getText().isEmpty()) {
            vista.jt_correo.setText("no definido!");
        } else if (vista.jta_tratamiento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Escribe Tratamiento!");
            faltanDatos = true;
        }

        return faltanDatos;
    }

    public boolean validaEspaciosAddiconales() {
        boolean faltanDatos = false;

        if (vista.jt_representante.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa Representante");
            faltanDatos = true;
        } else if (vista.jt_motiv_visita.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Motivo de visita?");
            faltanDatos = true;
        } else if (vista.jt_correo.getText().isEmpty()) {
            vista.jt_correo.setText("no definido!");
        } else if (vista.jta_tratamiento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Escribe Tratamiento!");
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
            JOptionPane.showMessageDialog(null, "Selecciona tipo de frenillo");
            return true;
        } else if (vista.jrb_embarazada.isSelected() & vista.jcb_mesesEmbarazo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona Meses embarazo");
            return true;
        } else if (vista.jrb_hospializado.isSelected() & vista.jtf_hospitalizado.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecciona motivo de hopitalizacion");
            return true;
        }
        return false;
    }

    public boolean revisaJComboboxSecundarios() {
        if (vista.jcb_t_consulta.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona un Tipo consulta");
            return true;
        } else if (vista.jcb_higieneBucal.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona hijiene bucal");
            return true;
        } else if (vista.jcb_alimentacion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona tipo de Alimentacion");
            return true;
        } else if (vista.jcb_frenillo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona tipo de frenillo");
            return true;
        } else if (vista.jrb_embarazada.isSelected() & vista.jcb_mesesEmbarazo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecciona Meses embarazo");
            return true;
        } else if (vista.jrb_hospializado.isSelected() & vista.jtf_hospitalizado.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecciona motivo de hopitalizacion");
            return true;
        }
        return false;
    }

}
