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
public class OBJ_Reglones {

    private String concepto;
    private int cantidad_1;
    private double presio;
    private String nombreCliente;
    private double total;
    private String fecha;

    public OBJ_Reglones(String nombreCliente, String concepto, int cantidad, double precio) {
        this.concepto = concepto;
        this.cantidad_1 = cantidad;
        this.presio = precio;
        this.nombreCliente = nombreCliente;
        total = this.presio * cantidad_1;
    }

    public OBJ_Reglones(String nombreCliente, String concepto, int cantidad_1, double presio, double total, String fecha) {
        this.concepto = concepto;
        this.cantidad_1 = cantidad_1;
        this.presio = presio;
        this.nombreCliente = nombreCliente;
        this.total = total;
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }


    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getPresio() {
        return presio;
    }

    public void setPresio(double presio) {
        this.presio = presio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCantidad_1() {
        return cantidad_1;
    }

    public void setCantidad_1(int cantidad_1) {
        this.cantidad_1 = cantidad_1;
    }

}
