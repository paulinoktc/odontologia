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
public class OBJ_TejidosBlandos {

    private int id_tejido;
    private String frenillo;
    private String mejilla;
    private String labios;
    private String paladar;
    private String encia;
    private String lengua;

    public int getId_tejido() {
        return id_tejido;
    }

    public void setId_tejido(int id_tejido) {
        this.id_tejido = id_tejido;
    }

    public String getFrenillo() {
        return frenillo;
    }

    public void setFrenillo(String frenillo) {
        this.frenillo = frenillo;
    }

    public String getMejilla() {
        return mejilla;
    }

    public void setMejilla(String mejilla) {
        this.mejilla = mejilla;
    }

    public String getLabios() {
        return labios;
    }

    public void setLabios(String labios) {
        this.labios = labios;
    }

    public String getPaladar() {
        return paladar;
    }

    public void setPaladar(String paladar) {
        this.paladar = paladar;
    }

    public String getEncia() {
        return encia;
    }

    public void setEncia(String encia) {
        this.encia = encia;
    }

    public String getLengua() {
        return lengua;
    }

    public void setLengua(String lengua) {
        this.lengua = lengua;
    }

    public void MostrarDatos() {
        //System.out.println(id_tejido);
        System.out.println(frenillo);
        System.out.println(mejilla);
        System.out.println(labios);
        System.out.println(paladar);
        System.out.println(encia);
        System.out.println(lengua);
    }
}
