/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author zomby
 */
public class OBJ_Padecimiento {
    
    private String id_paciente;
    private int id_padecimiento;
    private String nombre_padecimiento;

    public OBJ_Padecimiento(String id_paciente, String nombre_padecimiento) {
        this.id_paciente = id_paciente;
        this.nombre_padecimiento = nombre_padecimiento;
    }

    public String getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(String id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_padecimiento() {
        return id_padecimiento;
    }

    public void setId_padecimiento(int id_padecimiento) {
        this.id_padecimiento = id_padecimiento;
    }

    public String getNombre_padecimiento() {
        return nombre_padecimiento;
    }

    public void setNombre_padecimiento(String nombre_padecimiento) {
        this.nombre_padecimiento = nombre_padecimiento;
    }

    public void mostrarDatos() {
        System.out.println("Datos padeimientos");
        System.out.println(id_paciente);
        System.out.println(id_padecimiento);
        System.out.println(nombre_padecimiento);
    }
}
