/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cipher.ciphertechniques;


import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
import java.io.*;
import java.util.*;


public class sha1_with_library { 
	public static String encrypt(String input) 
	{ 
		try { 
			MessageDigest md = MessageDigest.getInstance("SHA-1"); 

            // digest() method is called to calculate message digest 
            // of the input string returned as array of byte 
			byte[] messageDigest = md.digest(input.getBytes()); 

			// Convert byte array into signum representation 
			BigInteger no = new BigInteger(1, messageDigest); 

			// Convert message digest into hex value 
			String hashtext = no.toString(16); 

			// Add preceding 0s to make it 32 bit 
			while (hashtext.length() < 32) { 
				hashtext = "0" + hashtext; 
			} 

			// return the HashText 
			return hashtext; 
		} 

		// For specifying wrong message digest algorithms 
		catch (NoSuchAlgorithmException e) { 
            System.out.println("[ERR]:" + e.getMessage());
            return "";
		} 
    } 
    
	public static void main(String args[]){ 
            Scanner s = new Scanner(System.in);
            System.out.print("Enter text to encrypt:");
            String text = s.next();
            System.out.println("MESSAGE DIGEST:" + encrypt(text)); 
	} 
}
