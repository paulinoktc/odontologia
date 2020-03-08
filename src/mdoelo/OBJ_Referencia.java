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
public class OBJ_Referencia {

    private int id_domicilio;
    private String nombreDomicilio;
    private String adicional;

    public OBJ_Referencia(String nombreDomicilio) {
        this.nombreDomicilio = nombreDomicilio;
    }

    public int getId_domicilio() {
        return id_domicilio;
    }

    public void setId_domicilio(int id_domicilio) {
        this.id_domicilio = id_domicilio;
    }

    public String getNombreDomicilio() {
        return nombreDomicilio;
    }

    public void setNombreDomicilio(String nombreDomicilio) {
        this.nombreDomicilio = nombreDomicilio;
    }

    public String getAdicional() {
        return adicional;
    }

    public void setAdicional(String adicional) {
        this.adicional = adicional;
    }
    
}
