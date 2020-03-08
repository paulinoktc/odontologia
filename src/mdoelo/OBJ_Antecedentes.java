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
public class OBJ_Antecedentes {

    private int id_antecedente;
    private String fecha;
    private String higiene_bucal;
    private String alimentacion;
    private int id_tratamiento;
    private int id_paciente;

    public OBJ_Antecedentes() {
    }

    public OBJ_Antecedentes(String higiene_bucal, String alimentacion, int id_tratamiento, int id_paciente) {
        this.higiene_bucal = higiene_bucal;
        this.alimentacion = alimentacion;
        this.id_tratamiento = id_tratamiento;
        this.id_paciente = id_paciente;
    }

    public int getId_antecedente() {
        return id_antecedente;
    }

    public void setId_antecedente(int id_antecedente) {
        this.id_antecedente = id_antecedente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHigiene_bucal() {
        return higiene_bucal;
    }

    public void setHigiene_bucal(String higiene_bucal) {
        this.higiene_bucal = higiene_bucal;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public int getId_tratamiento() {
        return id_tratamiento;
    }

    public void setId_tratamiento(int id_tratamiento) {
        this.id_tratamiento = id_tratamiento;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public void MostrarElementos() {
        //System.out.println(id_antecedente);
        System.out.println(fecha);
        System.out.println(higiene_bucal);
        System.out.println(alimentacion);
        //System.out.println(id_tratamiento);
        //System.out.println(id_paciente);
    }
}
