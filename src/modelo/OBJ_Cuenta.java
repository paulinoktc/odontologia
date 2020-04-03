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
public class OBJ_Cuenta {

    private int id_cuenta;
    private int id_paciente;
    private double cantidad;

    public OBJ_Cuenta() {
    }

    public OBJ_Cuenta(int id_cuenta, int id_paciente, double cantidad) {
        this.id_cuenta = id_cuenta;
        this.id_paciente = id_paciente;
        this.cantidad = cantidad;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void mostraDatos() {
        System.out.println("OBJ_Abono");
        System.out.println(cantidad);
        System.out.println("cuenta" + id_cuenta);
        System.out.println("paciente: " + id_paciente);
    }

}
