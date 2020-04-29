/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author zomby
 */
public class OBJ_Paciente {

    private String id_paciente;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private String sexo;
    private String fechaNaciemiento;
    private String estadoCivil;
    private String ocupacion;
    private String escolaridad;

    private String domicilio;
    private String telefono;
    private String correo;
    private String tutor;
    private String telTutor;

    public OBJ_Paciente() {
    }

    public OBJ_Paciente(String id_paciente, String nombre, String ap_paterno, String ap_materno, String sexo, String fechaNaciemiento, String estadoCivil, String ocupacion, String escolaridad, String telefono) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.sexo = sexo;
        this.fechaNaciemiento = fechaNaciemiento;
        this.estadoCivil = estadoCivil;
        this.ocupacion = ocupacion;
        this.escolaridad = escolaridad;
        this.telefono = telefono;
    }

    public String getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(String id_paciente) {
        this.id_paciente = id_paciente;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String creatIDPaciente(String iniciales) {
        String nuevoId = "";
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter ldt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        nuevoId += datetime.format(ldt);
        nuevoId = nuevoId.replaceAll("\\-", "");
        nuevoId = nuevoId.replaceAll("\\:", "");
        nuevoId = nuevoId.replaceAll("\\ ", "");
        System.out.println(nuevoId);
        return nuevoId;
    }

    public String getTelTutor() {
        return telTutor;
    }

    public void setTelTutor(String telTutor) {
        this.telTutor = telTutor;
    }

    public void MostrarDatos() {
        System.out.println("Datos paciente");
        System.out.println("id " + id_paciente);
        System.out.println(nombre);
        System.out.println(ap_paterno);
        System.out.println(ap_materno);
        System.out.println(sexo);
        System.out.println(fechaNaciemiento);
        System.out.println(estadoCivil);
        System.out.println(ocupacion);
        System.out.println(escolaridad);
        System.out.println(telefono);
        System.out.println(domicilio);
        System.out.println(tutor);
        System.out.println(correo);

    }
}
