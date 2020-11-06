/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cipher.ciphertechniques;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author dhinesh
 */
public class DESIT {
    
    public DESIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of ASCIItoHEX method, of class DES.
     */
    @Test
    public void testASCIItoHEX() {
        System.out.println("ASCIItoHEX");
        String ascii = "";
        String expResult = "";
        String result = DES.ASCIItoHEX(ascii);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hexToASCII method, of class DES.
     */
    @Test
    public void testHexToASCII() {
        System.out.println("hexToASCII");
        String hex = "";
        String expResult = "";
        String result = DES.hexToASCII(hex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class DES.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DES.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
