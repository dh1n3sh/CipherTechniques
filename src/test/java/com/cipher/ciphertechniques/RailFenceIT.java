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
public class RailFenceIT {
    
    static RailFence rf;
    public RailFenceIT() {
    }

    
    @AfterAll
    public static void tearDownClass() {
        RailFenceIT.rf = new RailFence();
    }

    /**
     * Test of Encrypt method, of class RailFence.
     */
    @org.junit.jupiter.api.Test
    public void testEncrypt() {
        System.out.println("Encrypt");
        String text = "IAMTHEBADGUY";
        int key = 3;
        String expResult = "IHDATEAGYMBU";
        String result = RailFence.Encrypt(text, key);
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of Decrypt method, of class RailFence.
     */
    @org.junit.jupiter.api.Test
    public void testDecrypt() {
        System.out.println("Decrypt");
        String enc = "IHDATEAGYMBU";
        int key = 3;
        String expResult = "IAMTHEBADGUY";
        var result = RailFence.Decrypt(enc, key);
        assertEquals(expResult, result);
    }

    /**
     * Test of main method, of class RailFence.
     */
//    @org.junit.jupiter.api.Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        RailFence.main(args);
//        testEncrypt();
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
    
}
