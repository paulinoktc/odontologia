/**
 *
 * Objeto para relizar los presupuestos
 */
package modelo;

/**
 *
 * @author
 */
public class MatrizCostos {
    
    private double total = 0;
    private double presio = 0;
    private int cantidad = 0;

    /**
     * Calcula precio total de dos parametros
     *
     * @param presio presio
     * @param cantidad cantidad
     */
    public MatrizCostos(double presio, int cantidad) {
        this.presio = presio;
        this.cantidad = cantidad;
        total = presio * cantidad;
    }

    /**
     *
     * @return
     */
    public double getTotal() {
        return total;
    }

    /**
     *
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     *
     * @return
     */
    public double getPresio() {
        return presio;
    }

    /**
     *
     * @param presio
     */
    public void setPresio(double presio) {
        this.presio = presio;
    }

    /**
     *
     * @return
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     *
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
