/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Action;
import modelo.MODL_Antecedentes;
import modelo.MODL_Paciente;
import modelo.MODL_Padecimiento;
import modelo.MODL_ReferenciaTB;
import modelo.MODL_RelacionTB;
import modelo.MODL_TejidosBlandos;
import modelo.OBJ_Antecedentes;
import modelo.OBJ_Paciente;
import modelo.OBJ_TejidosBlandos;
import vista.V_HistorialComplet;

/**
 *
 * @author Paulino
 */
public class CTRL_HistorialCompleto {

    V_HistorialComplet v_historial;

    private String id_paciente;
    private String antoconceptivo;

    private OBJ_Paciente paciente;
    private OBJ_Antecedentes antecedente;
    private ArrayList<String> listaHabitos;
    private ArrayList<String> listaPadecimiento;
    private ArrayList<String> listaMedicamentos;
    private ArrayList<String> listaAlergias;

    private OBJ_TejidosBlandos tejidos_blandos;

    public CTRL_HistorialCompleto(String id_paciente) {
        this.id_paciente = id_paciente;
        v_historial = new V_HistorialComplet();
        new MODL_Antecedentes().getItemFechasAntecedentes(id_paciente, v_historial.jcb_fechas);

        agregarActions();
        v_historial.setVisible(true);
    }

    public void mostrarDatosEnPantalla() {
        v_historial.jta_AllData.append("__________________DATOS PACIENTE________________\n\n");
        v_historial.jta_AllData.append("Nombre: " + paciente.getNombre() + " ");
        v_historial.jta_AllData.append(paciente.getAp_paterno() + " ");
        v_historial.jta_AllData.append(paciente.getAp_materno() + "\n");
        v_historial.jta_AllData.append("Sexo: " + paciente.getSexo() + "\n");
        v_historial.jta_AllData.append("Fecha: " + paciente.getFechaNaciemiento() + "\n");
        v_historial.jta_AllData.append("Estado Civil: " + paciente.getEstadoCivil() + "\n");
        v_historial.jta_AllData.append("Ocupacion: " + paciente.getOcupacion() + "\n");
        v_historial.jta_AllData.append("Escolaridad: " + paciente.getEscolaridad() + "\n");
        v_historial.jta_AllData.append("Telefono: " + paciente.getTelefono() + "\n");
        v_historial.jta_AllData.append("Correo: " + paciente.getCorreo() + "\n");
        v_historial.jta_AllData.append("Tutor: " + paciente.getTutor() + "\n");

        v_historial.jta_AllData.append("__________________ANTECEDENTES________________\n\n");

        v_historial.jta_AllData.append("Higiene Bucal: " + antecedente.getHigiene_bucal() + "\n");
        v_historial.jta_AllData.append("Alimentacion: " + antecedente.getAlimentacion() + "\n");
        v_historial.jta_AllData.append("Motivo Visita: " + antecedente.getMotivo_visita() + "\n");

        v_historial.jta_AllData.append("Tratamiento: " + antecedente.getTipo_tratamiento() + "\n");
        v_historial.jta_AllData.append("Observaciones: " + antecedente.getObservaciones() + "\n");
        v_historial.jta_AllData.append("Tipo Consulta: " + antecedente.getTipoConsulta() + "\n\n");

        for (String padecimientos : listaPadecimiento) {
            v_historial.jta_AllData.append(padecimientos + "\n");
        }

        v_historial.jta_AllData.append("__________________TEJIDOS BLANDOS________________\n\n");

        v_historial.jta_AllData.append("Frenillo: " + tejidos_blandos.getFrenillo() + "\n");
        v_historial.jta_AllData.append("Mejilla: " + tejidos_blandos.getMejilla() + "\n");
        v_historial.jta_AllData.append("Labios: " + tejidos_blandos.getLabios() + "\n");
        v_historial.jta_AllData.append("Paladar: " + tejidos_blandos.getPaladar() + "\n");
        v_historial.jta_AllData.append("Encia: " + tejidos_blandos.getEncia() + "\n");
        v_historial.jta_AllData.append("Lengua: " + tejidos_blandos.getLengua() + "\n");
        v_historial.jta_AllData.append("___________________________________________________\n");

        v_historial.jta_AllData.append("                     HABITOS\n");
        v_historial.jta_AllData.append("___________________________________________________\n");

        for (String listHabit : listaHabitos) {
            v_historial.jta_AllData.append(listHabit + "\n");
        }
        v_historial.jta_AllData.append("____________________________________________________\n");

        v_historial.jta_AllData.append("                  MEDICAMENTOS \n\n");
        v_historial.jta_AllData.append("____________________________________________________\n");


        for (String listMedicaments : listaMedicamentos) {
            v_historial.jta_AllData.append(listMedicaments + "\n");
        }
        v_historial.jta_AllData.append("____________________________________________________\n");
        v_historial.jta_AllData.append("                       ALERGIAS\n");
        v_historial.jta_AllData.append("____________________________________________________\n");


        for (String alergias : listaAlergias) {
            v_historial.jta_AllData.append(alergias + "\n");
        }
        v_historial.jta_AllData.append("____________________________________________________\n");
        v_historial.jta_AllData.append("                    ANTICONCEPTIVO\n");
        v_historial.jta_AllData.append("____________________________________________________\n");
        if (antoconceptivo.length() > 0) {
            v_historial.jta_AllData.append(antoconceptivo + "\n");
        }
        v_historial.jta_AllData.setDisabledTextColor(Color.BLACK);
        v_historial.jta_AllData.enable(false);
    }

    public void ExtraerDatosObejo() {
        paciente = new MODL_Paciente().h_paciente(this.id_paciente);
        antecedente = new MODL_Antecedentes().getHistorialAntecedentes(
                id_paciente, String.valueOf(v_historial.jcb_fechas.getSelectedItem()));
        listaHabitos = new MODL_RelacionTB().getListaHabitos(antecedente.getId_antecedente());
        tejidos_blandos = new MODL_TejidosBlandos().getListTejidos(id_paciente);

        listaPadecimiento = new MODL_Padecimiento().getListaPadecimientos(id_paciente);
        listaMedicamentos = new MODL_ReferenciaTB().getListaMedicamentos(antecedente.getId_antecedente());
        listaAlergias = new MODL_ReferenciaTB().getListaAlergias(antecedente.getId_antecedente());
        antoconceptivo = new MODL_ReferenciaTB().getAnticonceptivo(antecedente.getId_antecedente());
    }

    public void agregarActions() {
        v_historial.jb_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new CTRL_BuscarPaciente();
                v_historial.dispose();
            }
        });

        v_historial.jcb_fechas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ExtraerDatosObejo();
                mostrarDatosEnPantalla();
            }
        });
    }
}
