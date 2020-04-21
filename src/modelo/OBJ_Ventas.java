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
public class OBJ_Ventas {

    private String conseptoPago;
    private double cantidad;

    public OBJ_Ventas(String conseptoPago, double cantidad) {
        this.conseptoPago = conseptoPago;
        this.cantidad = cantidad;
    }

    public String getConseptoPago() {
        return conseptoPago;
    }

    public void setConseptoPago(String conseptoPago) {
        this.conseptoPago = conseptoPago;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
