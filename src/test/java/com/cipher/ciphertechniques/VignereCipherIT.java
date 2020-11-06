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
public class VignereCipherIT {


    /**
     * Test of Encrypt method, of class VignereCipher.
     */
    @Test
    public void testEncrypt() {
        System.out.println("Encrypt");
        String cipher_text = "GEEKSFORGEEKS";
        String key = "AYUSH";
        int off = 1;
        String expResult = "GCYCZFMLYLEIM";
        String result = VignereCipher.offset(cipher_text, key, off);
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of Decrypt method, of class VignereCipher.
     */
    @Test
    public void testDecrypt() {
        System.out.println("Decrypt");
        String cipher_text = "GCYCZFMLYLEIM";
        String key = "AYUSH";
        int off = -1;
        String expResult = "GEEKSFORGEEKS";
        String result = VignereCipher.offset(cipher_text, key, off);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }


    
}
