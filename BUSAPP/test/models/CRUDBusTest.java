/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class CRUDBusTest {
    
    public CRUDBusTest() {
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
     * Test of busRegister method, of class CRUDBus.
     */
    @Test
    public void testBusRegister() {
        System.out.println("busRegister");
        String plate = "FFC389";
        String password = "ABC";
        String driverName = "PEPITO";
        String busType = "EJECUTIVO";
        int ticketPrice = 2000;
        CRUDBus instance = new CRUDBus();
        boolean expResult = true;
        boolean result = instance.busRegister(plate, password, driverName, busType, ticketPrice);
        assertEquals(expResult, result);
    }
    @Test
    public void testInvalid1BusRegister() {
        System.out.println("busRegister");
        String plate = "FFC389";
        String password = "";
        String driverName = "PEPITO";
        String busType = "EJECUTIVO";
        int ticketPrice = 2000;
        CRUDBus instance = new CRUDBus();
        boolean expResult = false;
        boolean result = instance.busRegister(plate, password, driverName, busType, ticketPrice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInvalid2BusRegister() {
        System.out.println("busRegister");
        String plate = "";
        String password = "ABC";
        String driverName = "PEPITO";
        String busType = "EJECUTIVO";
        int ticketPrice = 2000;
        CRUDBus instance = new CRUDBus();
        boolean expResult = false;
        boolean result = instance.busRegister(plate, password, driverName, busType, ticketPrice);
        assertEquals(expResult, result);
    }
    
}
