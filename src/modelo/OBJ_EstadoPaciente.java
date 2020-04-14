package modelo;


public class OBJ_EstadoPaciente {

    private int id_antecedente;
    private String estado;

    public OBJ_EstadoPaciente(String meses) {
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

