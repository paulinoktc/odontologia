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
public class OBJ_Tratamiento {

    private int id_tratamiento;
    private String tipoTratamiento;
    private String observaciones;

    public OBJ_Tratamiento(String tipoTratamiento, String observaciones) {
        this.tipoTratamiento = tipoTratamiento;
        this.observaciones = observaciones;
    }

    public OBJ_Tratamiento(int id_tratamiento, String tipoTratamiento, String observaciones) {
        this.id_tratamiento = id_tratamiento;
        this.tipoTratamiento = tipoTratamiento;
        this.observaciones = observaciones;
    }

    public int getId_tratamiento() {
        return id_tratamiento;
    }

    public void setId_tratamiento(int id_tratamiento) {
        this.id_tratamiento = id_tratamiento;
    }

    public String getTipoTratamiento() {
        return tipoTratamiento;
    }

    public void setTipoTratamiento(String tipoTratamiento) {
        this.tipoTratamiento = tipoTratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void MostrarDatos() {
        //System.out.println(id_tratamiento);
        System.out.println(tipoTratamiento);
        System.out.println(observaciones);
    }

}
