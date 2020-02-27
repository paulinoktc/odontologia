/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdoelo;

/**
 *
 * @author zomby
 */
public class OBJ_Abonos {

    private int id_abono;
    private double cantidad;
    private String fecha;
    private int id_paciente;
    private int id_cuenta;

    public OBJ_Abonos() {
    }

    public OBJ_Abonos(int id_abono, double cantidad, String fecha, int id_paciente, int id_cuenta) {
        this.id_abono = id_abono;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.id_paciente = id_paciente;
        this.id_cuenta = id_cuenta;
    }

    public int getId_abono() {
        return id_abono;
    }

    public void setId_abono(int id_abono) {
        this.id_abono = id_abono;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }
    
    
}
