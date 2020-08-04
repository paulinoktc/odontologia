/**
 * Realiza las acciones con los pacientes tales como guardar y consultar informacion del paciente en la base de datos
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
 * @author SandraElizabet
 */
public class MODL_Paciente {

    /**
     * Consutas SQL a usar
     */
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
    private String scr_tutor = "select nombre_tutor,num_tel from tutor where id_paciente='";

    /**
     * Guarda todos los datos del paciente realiza el autocomit a falase para
     * que si ocurre un error este no se guarde y altere la base de datos
     *
     * @param paciente OBJ_Paciente paciente que se va a guardar
     */
    public void guardarDatosPaciente(OBJ_Paciente paciente) {
        Conexion cn = new Conexion();
        Connection cc = cn.crearConexion();

        try {
            cc.setAutoCommit(false);
            /**
             * llama el procedure encargado de guardar los datos del paciente
             */
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

            /**
             * llama a los respectivos procedures encargados de cada accion
             */
            llamada = cc.prepareCall("{call saveTelefono(?,?)}");//---------------telefono
            llamada.setString(1, paciente.getId_paciente());
            llamada.setString(2, paciente.getTelefono());
            llamada.execute();

            llamada = cc.prepareCall("{call saveCorreo(?,?)}");//-----------------correo
            llamada.setString(1, paciente.getId_paciente());
            llamada.setString(2, paciente.getCorreo());
            llamada.execute();

            llamada = cc.prepareCall("{call saveTutor(?,?,?)}");//------------------tutor
            llamada.setString(1, paciente.getId_paciente());
            llamada.setString(2, paciente.getTutor());
            llamada.setString(3, paciente.getTelTutor());
            llamada.execute();

            llamada = cc.prepareCall("{call saveDomicilio(?,?)}");//--------------direccion
            llamada.setString(1, paciente.getId_paciente());
            llamada.setString(2, paciente.getDomicilio());
            llamada.execute();

            /**
             * REALIZA UN COMIT SI NO HAT PROBLEMA
             */
            cc.commit();
            llamada.close();
        } catch (SQLException ex) {
            try {
                //si hay una excepcion realiza un rollback
                cc.rollback();
            } catch (SQLException ex1) {

                Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Busca pacientes por listas no recopila todos los datos completos solo los
     * escenciales para mostrar al usuario
     *
     * @param buscarPor Como se desea buscar al paciente nombre,apellidos folio
     * o numero de telefono
     * @param texto telfono,nombre apellido o folio que se va a buscar
     * @return Lista de pacietes encontrados
     */
    public ArrayList<OBJ_Paciente> buscarPacientes(int buscarPor, String texto) {
        ArrayList<OBJ_Paciente> listaPacientes = new ArrayList<>();
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

    /**
     * Define que Consula se va a utilizar
     *
     * @param buscaX Como se va a buscar
     * @param palabra palabra que se va a buscar
     * @return Consulta seleccionada
     */
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

    /**
     * Guarda los antededentes del paciente
     *
     * @param id_paciente id de paciente prpietario del antecedente
     * @param fecha fecha de cuando se realizo el antecedente
     */
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

    /**
     * Busca todos los datos del paciente (historial)
     *
     * @param folio_paciente Folio (id) del paciente
     * @return OBJ_Paciente con todos los atributos encontrados en la base de
     * datos
     */
    public OBJ_Paciente h_paciente(String folio_paciente) {
        OBJ_Paciente paciente = new OBJ_Paciente();
        try {
            Conexion cn = new Conexion();
            Connection cc = cn.crearConexion();

            PreparedStatement ps = cc.prepareStatement(scr_allPaciente + folio_paciente + "';");
            ResultSet rs = ps.executeQuery();
            paciente.setId_paciente(folio_paciente);
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

            ps = cc.prepareStatement(scr_domicilio + folio_paciente + "';");
            rs = ps.executeQuery();

            rs.next();
            paciente.setDomicilio(rs.getString(1));

            ps = cc.prepareStatement(scr_tutor + folio_paciente + "';");
            rs = ps.executeQuery();

            rs.next();
            paciente.setTutor(rs.getString(1));
            paciente.setTelTutor(rs.getString(2));

            ps = cc.prepareStatement(
                    "select getEdad('" + paciente.getFechaNaciemiento() + "');");

            rs = ps.executeQuery();
            rs.next();
            paciente.setFechaNaciemiento(rs.getString(1));
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MODL_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paciente;
    }

}
