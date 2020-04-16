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
    

    private String nombre;
    private int id_antecedente;
    private int id_Relacion;

    public OBJ_Relacion(String nombreAntecedente, int id_antecedente) {
        this.nombre = nombreAntecedente;
        this.id_antecedente = id_antecedente;
    }
/*
    public OBJ_Relacion(String nombreAntecedente, int id_antecedente, int id_nombreAntecedente) {
        this.nombre = nombreAntecedente;
        this.id_antecedente = id_antecedente;
        this.id_Relacion = id_nombreAntecedente;
    }*/

    public int getId_antecedente() {
        return id_antecedente;
    }

    public void setId_antecedente(int id_antecedente) {
        this.id_antecedente = id_antecedente;
    }

    public int getId_Relacion() {
        return id_Relacion;
    }

    public void setId_Relacion(int id_Relacion) {
        this.id_Relacion = id_Relacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarDAtos() {
        System.out.println("Datos Relacion");
        System.out.println(nombre);
        System.out.println(id_antecedente);
        System.out.println(id_Relacion);

    }
}

