/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tc.dao;

import com.tc.dto.Employee;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AVIJIT
 */
public class EmployeeDaoTest {
    
    public EmployeeDaoTest() {
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
     * Test of saveEmployeeInfo method, of class EmployeeDao.
     */
    @Test
    public void testSaveEmployeeInfo() {
        System.out.println("saveEmployeeInfo");
        Employee emp = null;
        boolean expResult = false;
        boolean result = EmployeeDao.saveEmployeeInfo(emp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showAllEmployeeInfo method, of class EmployeeDao.
     */
    @Test
    public void testShowAllEmployeeInfo_0args() {
        System.out.println("showAllEmployeeInfo");
        ArrayList expResult = null;
        ArrayList result = EmployeeDao.showAllEmployeeInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeeInfo method, of class EmployeeDao.
     */
    @Test
    public void testGetEmployeeInfo() {
        System.out.println("getEmployeeInfo");
        String employeeId = "";
        Employee expResult = null;
        Employee result = EmployeeDao.getEmployeeInfo(employeeId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateEmployeeInfo method, of class EmployeeDao.
     */
    @Test
    public void testUpdateEmployeeInfo() {
        System.out.println("updateEmployeeInfo");
        Employee emp = null;
        boolean expResult = false;
        boolean result = EmployeeDao.updateEmployeeInfo(emp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showAllEmployeeInfo method, of class EmployeeDao.
     */
    @Test
    public void testShowAllEmployeeInfo_String() {
        System.out.println("showAllEmployeeInfo");
        String empName = "";
        ArrayList<Employee> expResult = null;
        ArrayList<Employee> result = EmployeeDao.showAllEmployeeInfo(empName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
