/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import glbank.Employee;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joseph
 */
public class ConnectionProviderTest {
    
    public ConnectionProviderTest() {
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
     * Test of isEmployeePasswordValid method, of class ConnectionProvider.
     */
    @Test
    public void testIsEmployeePasswordValid1() {
        System.out.println("isEmployeePasswordValid");
        String username = "molnar";
        String password = "molnar";
        ConnectionProvider instance = new ConnectionProvider();
        boolean expResult = true;
        boolean result = instance.isEmployeePasswordValid(username, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsEmployeePasswordValid2() {
        System.out.println("isEmployeePasswordValid");
        String username = "molnarr";
        String password = "molnar";
        ConnectionProvider instance = new ConnectionProvider();
        boolean expResult = false;
        boolean result = instance.isEmployeePasswordValid(username, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmployeeId method, of class ConnectionProvider.
     */
    @Test
    public void testGetEmployeeId1() {
        System.out.println("getEmployeeId");
        String username = "kollar";
        ConnectionProvider instance = new ConnectionProvider();
        int expResult = 1;
        int result = instance.getEmployeeId(username);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetEmployeeId2() {
        System.out.println("getEmployeeId");
        String username = "molnar";
        ConnectionProvider instance = new ConnectionProvider();
        int expResult = 2;
        int result = instance.getEmployeeId(username);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetEmployeeId3() {
        System.out.println("getEmployeeId");
        String username = "Molnar";
        ConnectionProvider instance = new ConnectionProvider();
        int expResult = -1;
        int result = instance.getEmployeeId(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of logEmployeeAccess method, of class ConnectionProvider.
     */
    /*
    @Test
    public void testLogEmployeeAccess() {
        System.out.println("logEmployeeAccess");
        int id = 2;
        ConnectionProvider instance = new ConnectionProvider();
        instance.logEmployeeAccess(id);

    }
    */
    /**
     * Test of getDateTime method, of class ConnectionProvider.
     */
    /*
    @Test
    public void testGetDateTime() {
        System.out.println("getDateTime");
        ConnectionProvider instance = new ConnectionProvider();
        String expResult = "";
        String result = instance.getDateTime();
        assertEquals(expResult, result);

    }
    */
    /**
     * Test of getEmployee method, of class ConnectionProvider.
     */
    @Test
    public void testGetEmployee1() {
        System.out.println("getEmployee");
        int id = 1;
        ConnectionProvider instance = new ConnectionProvider();
        Employee result = instance.getEmployee(id);
        assertEquals("Jan", result.getFirstname());
        assertEquals("Kollar", result.getLastname());
        assertEquals(1, result.getIdemp());
        assertEquals("kollar@pobox.sk", result.getEmail());
        assertEquals('C', result.getPosition());    
    }
    @Test
    public void testGetEmployee2() {
        System.out.println("getEmployee");
        int id = 2;
        ConnectionProvider instance = new ConnectionProvider();
        Employee result = instance.getEmployee(id);
        assertEquals("Daniel", result.getFirstname());
        assertEquals("Molnar", result.getLastname());
        assertEquals(2, result.getIdemp());
        assertEquals("molnar@pobox.sk", result.getEmail());
        assertEquals('C', result.getPosition());    
    }
    
}
