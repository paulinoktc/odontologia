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
public class OBJ_Estado {

    private int id_antecedente;
    private String estado;

    public OBJ_Estado(String meses) {
        this.estado = meses;
    }

    public int getId_antecedente() {
        return id_antecedente;
    }

    public void setId_antecedente(int id_antecedente) {
        this.id_antecedente = id_antecedente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String meses) {
        this.estado = meses;
    }

    public void MostrarElementos() {
        System.out.println("Datos estado");
        System.out.println("antecedente: " + id_antecedente);
        System.out.println(""+estado);
        
    }
}
