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
    private double cantidad;
    private int cantidad_1;
    private double presio;
    private String nombreCliente;
    private double total;

    public OBJ_Reglones(String nombreCliente,String concepto, int cantidad, double precio) {
        this.concepto = concepto;
        this.cantidad_1 = cantidad;
        this.presio=precio;
        this.nombreCliente = nombreCliente;
        total=this.presio*cantidad_1;
    }

    public OBJ_Reglones(String concepto, double cantidad, String nombreCliente) {
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.nombreCliente = nombreCliente;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
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
    
    

}
