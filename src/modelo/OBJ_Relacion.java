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
public class OBJ_Relacion {
    

    private String nombreAntecedente;
    private int id_antecedente;
    private int id_nombreAntecedente;

    public OBJ_Relacion(String nombreAntecedente, int id_nombreAntecedente) {
        this.nombreAntecedente = nombreAntecedente;
        this.id_nombreAntecedente = id_nombreAntecedente;
    }

    public OBJ_Relacion(String nombreAntecedente, int id_antecedente, int id_nombreAntecedente) {
        this.nombreAntecedente = nombreAntecedente;
        this.id_antecedente = id_antecedente;
        this.id_nombreAntecedente = id_nombreAntecedente;
    }

    public int getId_antecedente() {
        return id_antecedente;
    }

    public void setId_antecedente(int id_antecedente) {
        this.id_antecedente = id_antecedente;
    }

    public int getId_nombreAntecedente() {
        return id_nombreAntecedente;
    }

    public void setId_nombreAntecedente(int id_nombreAntecedente) {
        this.id_nombreAntecedente = id_nombreAntecedente;
    }

    public String getNombreAntecedente() {
        return nombreAntecedente;
    }

    public void setNombreAntecedente(String nombreAntecedente) {
        this.nombreAntecedente = nombreAntecedente;
    }

    public void mostrarDAtos() {
        System.out.println("Datos Relacion");
        System.out.println(nombreAntecedente);
        System.out.println(id_antecedente);
        System.out.println(id_nombreAntecedente);

    }
}

