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
public class OBJ_Referencia {

    private int id_antecedente;
    private String nombre;

    public OBJ_Referencia( String nombre) {
        this.nombre = nombre;
    }

    public int getId_antecedente() {
        return id_antecedente;
    }

    public void setId_antecedente(int id_antecedente) {
        this.id_antecedente = id_antecedente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarDatos() {
        System.out.println("Datos referencia");
        System.out.println("antecedente " + id_antecedente);
        System.out.println(nombre);
    }
}
