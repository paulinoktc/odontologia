/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.OBJ_Reglones;
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
public class CTRL_CobrarTest {
    
    public CTRL_CobrarTest() {
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
     * Test of agregarActions method, of class CTRL_Cobrar.
     */
    @Test
    public void testAgregarActions() {
        System.out.println("agregarActions");
        CTRL_Cobrar instance = new CTRL_Cobrar();
        instance.agregarActions();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of botonComartidoCobrar method, of class CTRL_Cobrar.
     */
    @Test
    public void testBotonComartidoCobrar() {
        System.out.println("botonComartidoCobrar");
        CTRL_Cobrar instance = new CTRL_Cobrar();
        instance.botonComartidoCobrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ExtraElementosTB method, of class CTRL_Cobrar.
     */
    @Test
    public void testExtraElementosTB() {
        System.out.println("ExtraElementosTB");
        String nombre = "Nombre";
        CTRL_Cobrar instance = new CTRL_Cobrar();
        ArrayList<OBJ_Reglones> expResult = null;
        ArrayList<OBJ_Reglones> result = instance.ExtraElementosTB(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularTotal method, of class CTRL_Cobrar.
     */
    @Test
    public void testCalcularTotal() {
        System.out.println("calcularTotal");
        ArrayList<OBJ_Reglones> reglones = new ArrayList<>();
        reglones.add(new OBJ_Reglones("cobro", 100, "jose pers"));
        CTRL_Cobrar instance = new CTRL_Cobrar();
        double expResult = 0.0;
        double result = instance.calcularTotal(reglones);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
