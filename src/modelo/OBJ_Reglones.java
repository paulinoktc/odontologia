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
    private String nombreCliente;
    
    
/*
    public OBJ_Reglones(String concepto, double cantidad) {
        this.concepto = concepto;
        this.cantidad = cantidad;
    }
*/

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
    
    
}
