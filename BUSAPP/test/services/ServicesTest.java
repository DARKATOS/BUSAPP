/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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
public class ServicesTest {
    
    public ServicesTest() {
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
     * Test of busLogIn method, of class Services.
     */
    @Test
    public void testBusLogIn() {
        System.out.println("busLogIn");
        int id = 1;
        String plate = "FFC38";
        Services instance = new Services();
        String expResult = "";
        String result = instance.busLogIn(id, plate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void testInvalidBusLogIn() {
        System.out.println("busLogIn");
        int id = 1;
        String plate = "";
        Services instance = new Services();
        String expResult = "";
        String result = instance.busLogIn(id, plate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of busLogInRegister method, of class Services.
     */
    @Test
    public void testBusLogInRegister() {
        System.out.println("busLogInRegister");
        String plate = "FFC38 ";
        String password = "123";
        Services instance = new Services();
        String expResult = "";
        String result = instance.busLogInRegister(plate, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
 
    @Test
    public void testInvalid1BusLogInRegister() {
        System.out.println("busLogInRegister");
        String plate = "FFC38";
        String password = "";
        Services instance = new Services();
        String expResult = "";
        String result = instance.busLogInRegister(plate, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void testInvalid2BusLogInRegister() {
        System.out.println("busLogInRegister");
        String plate = "";
        String password = "123";
        Services instance = new Services();
        String expResult = "";
        String result = instance.busLogInRegister(plate, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of busLocationRegister method, of class Services.
     */
    @Test
    public void testBusLocationRegister() {
        System.out.println("busLocationRegister");
        int id = 1;
        Services instance = new Services();
        String expResult = "";
        String result = instance.busLocationRegister(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void testInvalid1BusLocationRegister() {
        System.out.println("busLocationRegister");
        int id = 0;
        Services instance = new Services();
        String expResult = "";
        String result = instance.busLocationRegister(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of busLocationUpdate method, of class Services.
     */
    @Test
    public void testBusLocationUpdate() {
        System.out.println("busLocationUpdate");
        int id = 0;
        double latitude = 0.0;
        double longitude = 0.0;
        Services instance = new Services();
        String expResult = "";
        String result = instance.busLocationUpdate(id, latitude, longitude);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
  
    /**
     * Test of busLocationDelete method, of class Services.
     */
    @Test
    public void testBusLocationDelete() {
        System.out.println("busLocationDelete");
        int id = 0;
        Services instance = new Services();
        String expResult = "";
        String result = instance.busLocationDelete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of busUpdateGet method, of class Services.
     */
    @Test
    public void testBusUpdateGet() {
        System.out.println("busUpdateGet");
        Services instance = new Services();
        String expResult = "";
        String result = instance.busUpdateGet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
