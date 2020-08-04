/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ZOMBY
 */
public class OBJ_AbonosTest {
    
    public OBJ_AbonosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId_abono method, of class OBJ_Abonos.
     */
    @Test
    public void testGetId_abono() {
        System.out.println("getId_abono");
        OBJ_Abonos instance = new OBJ_Abonos();
        int expResult = 0;
        int result = instance.getId_abono();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId_abono method, of class OBJ_Abonos.
     */
    @Test
    public void testSetId_abono() {
        System.out.println("setId_abono");
        int id_abono = 0;
        OBJ_Abonos instance = new OBJ_Abonos();
        instance.setId_abono(id_abono);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCantidad method, of class OBJ_Abonos.
     */
    @Test
    public void testGetCantidad() {
        System.out.println("getCantidad");
        OBJ_Abonos instance = new OBJ_Abonos();
        double expResult = 0.0;
        double result = instance.getCantidad();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCantidad method, of class OBJ_Abonos.
     */
    @Test
    public void testSetCantidad() {
        System.out.println("setCantidad");
        double cantidad = 0.0;
        OBJ_Abonos instance = new OBJ_Abonos();
        instance.setCantidad(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class OBJ_Abonos.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        OBJ_Abonos instance = new OBJ_Abonos();
        String expResult = "";
        String result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class OBJ_Abonos.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        String fecha = "";
        OBJ_Abonos instance = new OBJ_Abonos();
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId_paciente method, of class OBJ_Abonos.
     */
    @Test
    public void testGetId_paciente() {
        System.out.println("getId_paciente");
        OBJ_Abonos instance = new OBJ_Abonos();
        int expResult = 0;
        int result = instance.getId_paciente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId_paciente method, of class OBJ_Abonos.
     */
    @Test
    public void testSetId_paciente() {
        System.out.println("setId_paciente");
        int id_paciente = 0;
        OBJ_Abonos instance = new OBJ_Abonos();
        instance.setId_paciente(id_paciente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId_cuenta method, of class OBJ_Abonos.
     */
    @Test
    public void testGetId_cuenta() {
        System.out.println("getId_cuenta");
        OBJ_Abonos instance = new OBJ_Abonos();
        int expResult = 0;
        int result = instance.getId_cuenta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId_cuenta method, of class OBJ_Abonos.
     */
    @Test
    public void testSetId_cuenta() {
        System.out.println("setId_cuenta");
        int id_cuenta = 0;
        OBJ_Abonos instance = new OBJ_Abonos();
        instance.setId_cuenta(id_cuenta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarDatos method, of class OBJ_Abonos.
     */
    @Test
    public void testMostrarDatos() {
        System.out.println("mostrarDatos");
        OBJ_Abonos instance = new OBJ_Abonos();
        instance.mostrarDatos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
