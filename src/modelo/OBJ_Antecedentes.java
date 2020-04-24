package modelo;

public class OBJ_Antecedentes {

    private int id_antecedente;
    private String fecha;
    private String higiene_bucal;
    private String alimentacion;
    private String id_paciente;
    private String motivo_visita;

    private int id_consulta;
    private String tipo_tratamiento;
    private String observaciones;
    private String tipoConsulta;

    public OBJ_Antecedentes() {

    }

    public OBJ_Antecedentes(String higiene_bucal, String alimentacion, String id_paciente, String motivo) {
        this.higiene_bucal = higiene_bucal;
        this.alimentacion = alimentacion;
        this.id_paciente = id_paciente;
        this.motivo_visita = motivo;
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

    public String getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(String id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int tipo_consulta) {
        this.id_consulta = tipo_consulta;
    }

    public String getTipo_tratamiento() {
        return tipo_tratamiento;
    }

    public void setTipo_tratamiento(String tipo_tratamiento) {
        this.tipo_tratamiento = tipo_tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getMotivo_visita() {
        return motivo_visita;
    }

    public void setMotivo_visita(String motivo_visita) {
        this.motivo_visita = motivo_visita;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
    
    

    public void MostrarElementos() {
        System.out.println("Datos antecedentes");
        System.out.println("antecedente: " + id_antecedente);
        System.out.println(fecha);
        System.out.println(higiene_bucal);
        System.out.println(alimentacion);
        System.out.println("paciente: " + id_paciente);
    }
}
