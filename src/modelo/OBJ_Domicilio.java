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
public class OBJ_Domicilio {

    private int id_domicilio;
    private int id_paciente;
    private String direccion;

    public OBJ_Domicilio(String direccion) {
        this.direccion = direccion;
    }

    public int getId_domicilio() {
        return id_domicilio;
    }

    public void setId_domicilio(int id_domicilio) {
        this.id_domicilio = id_domicilio;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void MostrarElementos() {
        System.out.println("Datos domicilio");
        System.out.println("antecedente: " + id_domicilio);
        System.out.println("paciente: " + id_paciente);
        System.out.println(direccion);
    }

}
