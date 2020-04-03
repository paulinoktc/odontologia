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
public class OBJ_Estado {
    private int id_antecedente;
    private String estado;

    public OBJ_Estado(int id_antecedente, String meses) {
        this.id_antecedente = id_antecedente;
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
    
    
}
