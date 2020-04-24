/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zomby
 */
public class MODL_Paciente {

    private String buscaXnombre = "select  paciente.id_paciente, paciente.nombre,paciente.ap_apellido,paciente.am_apellido,paciente.sexo,paciente.fecha_nacimiento,paciente.estadoCivil,paciente.ocupacion,paciente.escolaridad,telefono.num_tel "
            + "from paciente INNER JOIN telefono "
            + "WHERE telefono.id_paciente=paciente.id_paciente "
            + "AND paciente.nombre ='";

    private String buscaXtel = "select  paciente.id_paciente, paciente.nombre,paciente.ap_apellido,paciente.am_apellido,paciente.sexo,paciente.fecha_nacimiento,paciente.estadoCivil,paciente.ocupacion,paciente.escolaridad,telefono.num_tel "
            + "from paciente INNER JOIN telefono "
            + "WHERE telefono.id_paciente=paciente.id_paciente "
            + "AND telefono.num_tel ='";

    private String buscaXpaterno = "select  paciente.id_paciente, paciente.nombre,paciente.ap_apellido,paciente.am_apellido,paciente.sexo,paciente.fecha_nacimiento,paciente.estadoCivil,paciente.ocupacion,paciente.escolaridad,telefono.num_tel "
            + "from paciente INNER JOIN telefono "
            + "WHERE telefono.id_paciente=paciente.id_paciente "
            + "AND paciente.ap_apellido ='";

    private String buscaXmaterno = "select  paciente.id_paciente, paciente.nombre,paciente.ap_apellido,paciente.am_apellido,paciente.sexo,paciente.fecha_nacimiento,paciente.estadoCivil,paciente.ocupacion,paciente.escolaridad,telefono.num_tel "
            + "from paciente INNER JOIN telefono "
            + "WHERE telefono.id_paciente=paciente.id_paciente "
            + "AND paciente.am_apellido ='";

    private String buscaXid = "select  paciente.id_paciente, paciente.nombre,paciente.ap_apellido,paciente.am_apellido,paciente.sexo,paciente.fecha_nacimiento,paciente.estadoCivil,paciente.ocupacion,paciente.escolaridad,telefono.num_tel "
            + "from paciente INNER JOIN telefono "
            + "WHERE telefono.id_paciente=paciente.id_paciente "
            + "AND paciente.id_paciente ='";

    private String scr_allPaciente = "select * from paciente where id_paciente='";
    private String scr_domicilio = "select nombre_domicilio from domicilio where id_paciente='";
    private String scr_telefono = "select num_tel from telefono where id_paciente='";
    private String scr_correo = "select correo from correo where id_paciente='";
    private String scr_tutor = "select nombre_tutor from tutor where id_paciente='";

    public void guardarDatosPaciente(OBJ_Paciente paciente) {
        Conexion cn = new Conexion();
        Connection cc = cn.crearConexion();

        try {
            cc.setAutoCommit(false);
            CallableStatement llamada = cc.prepareCall("{call guardaPaciente(?,?,?,?,?,?,?,?,?)}");//---paciente
            llamada.setString(1, paciente.getId_paciente());
            llamada.setString(2, paciente.getNombre());
            llamada.setString(3, paciente.getAp_paterno());
            llamada.setString(4, paciente.getAp_materno());
            llamada.setString(5, paciente.getSexo());
            llamada.setString(6, paciente.getFechaNaciemiento());
            llamada.setString(7, paciente.getEstadoCivil());
            llamada.setString(8, paciente.getOcupacion());
            llamada.setString(9, paciente.getEscolaridad());
            llamada.execute();

            llamada = cc.prepareCall("{call saveTelefono(?,?)}");//---------------telefono
            llamada.setString(1, paciente.getId_paciente());
            llamada.setString(2, paciente.getTelefono());
            llamada.execute();

            llamada = cc.prepareCall("{call saveCorreo(?,?)}");//-----------------correo
            llamada.setString(1, paciente.getId_paciente());
            llamada.setString(2, paciente.getCorreo());
            llamada.execute();

            llamada = cc.prepareCall("{call saveTutor(?,?)}");//------------------tutor
            llamada.setString(1, paciente.getId_paciente());
            llamada.setString(2, paciente.getTutor());
            llamada.execute();

            llamada = cc.prepareCall("{call saveDomicilio(?,?)}");//--------------direccion
            llamada.setString(1, paciente.getId_paciente());
            llamada.setString(2, paciente.getDomicilio());
            llamada.execute();

            cc.commit();
            llamada.close();
        } catch (SQLException ex) {
            try {
                cc.rollback();
            } catch (SQLException ex1) {

                Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<OBJ_Paciente> buscarPacientes(int buscarPor, String texto) {
        ArrayList<OBJ_Paciente> listaPacientes = new ArrayList<>();
        OBJ_Paciente el_paciente = new OBJ_Paciente();
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();

            PreparedStatement ps = cc.prepareStatement(usarScript(buscarPor, texto));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                listaPacientes.add(new OBJ_Paciente(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10))
                );

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPacientes;
    }

    public String usarScript(int buscaX, String palabra) {
        String script = "";
        switch (buscaX) {
            case 0:
                script = buscaXnombre + palabra + "';";
                break;
            case 1:
                script = buscaXpaterno + palabra + "';";
                break;
            case 2:
                script = buscaXmaterno + palabra + "';";
                break;
            case 3:
                script = buscaXtel + palabra + "';";
                break;
            case 4:
                script = buscaXid + palabra + "';";
                break;
        }
        return script;
    }

    public void AtenderPaciente(String id_paciente, String fecha) {
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();
            cc.setAutoCommit(false);

            CallableStatement llamada = cc.prepareCall("{call atenderPaciente(?,?)}");

            llamada.setString(1, id_paciente);
            llamada.setString(2, fecha);
            llamada.execute();

            cc.commit();
        } catch (SQLException ex) {

            Logger.getLogger(MODL_Antecedentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public OBJ_Paciente h_paciente(String folio_paciente) {
        OBJ_Paciente paciente = new OBJ_Paciente();
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();

            PreparedStatement ps = cc.prepareStatement(scr_allPaciente + folio_paciente + "';");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                paciente.setNombre(rs.getString(2));
                paciente.setAp_paterno(rs.getString(3));
                paciente.setAp_materno(rs.getString(4));
                paciente.setSexo(rs.getString(5));
                paciente.setFechaNaciemiento(rs.getString(6));
                paciente.setEstadoCivil(rs.getString(7));
                paciente.setOcupacion(rs.getString(8));
                paciente.setEscolaridad(rs.getString(9));
            }
            ps = cc.prepareStatement(scr_telefono + folio_paciente + "';");
            rs = ps.executeQuery();

            rs.next();
            paciente.setTelefono(rs.getString(1));
            
            ps = cc.prepareStatement(scr_correo + folio_paciente + "';");
            rs = ps.executeQuery();

            rs.next();
            paciente.setCorreo(rs.getString(1));
            
            
            ps = cc.prepareStatement(scr_tutor + folio_paciente + "';");
            rs = ps.executeQuery();

            rs.next();
            paciente.setTutor(rs.getString(1));

            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paciente;
    }

}
