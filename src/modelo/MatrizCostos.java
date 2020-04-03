/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ZOMBY
 */
public class MatrizCostos {

    private double total = 0;
    private double presio = 0;
    private int cantidad = 0;

    /**
     * Calcula precio total de dos parametros 
     * @param presio presio
     * @param cantidad cantidad
     */
    public MatrizCostos(double presio, int cantidad) {
        this.presio = presio;
        this.cantidad = cantidad;
        total = presio * cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPresio() {
        return presio;
    }

    public void setPresio(double presio) {
        this.presio = presio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
