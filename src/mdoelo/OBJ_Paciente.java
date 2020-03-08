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
public class OBJ_Paciente {

    private int id_cliente;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private char sexo;
    private String fechaNaciemiento;
    private String estadoCivil;
    private String ocupacion;
    private String escolaridad;
    private int id_domicilio;
    private int id_tejidos;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getFechaNaciemiento() {
        return fechaNaciemiento;
    }

    public void setFechaNaciemiento(String fechaNaciemiento) {
        this.fechaNaciemiento = fechaNaciemiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public int getId_domicilio() {
        return id_domicilio;
    }

    public void setId_domicilio(int id_domicilio) {
        this.id_domicilio = id_domicilio;
    }

    public int getId_tejidos() {
        return id_tejidos;
    }

    public void setId_tejidos(int id_tejidos) {
        this.id_tejidos = id_tejidos;
    }

    public void MostrarDatos() {
        //System.out.println(id_cliente);
        System.out.println(nombre);
        System.out.println(ap_paterno);
        System.out.println(ap_materno);
        System.out.println(sexo);
        System.out.println(fechaNaciemiento);
        System.out.println(estadoCivil);
        System.out.println(ocupacion);
        System.out.println(escolaridad);
        //System.out.println(id_domicilio);
        //System.out.println(id_tejidos);
    }
}
