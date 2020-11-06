/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cipher.ciphertechniques;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.*;

public class DSS {

    public static KeyPairGenerator keyPairGenerator;
    public static KeyPair keyPair;
    public static PrivateKey privateKey;
    public static PublicKey publicKey;

    public static void init() {
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("DSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static byte[] sign(String msg) {
        try {
            Signature signature = Signature.getInstance("SHA256withDSA");
            signature.initSign(privateKey);
            signature.update(msg.getBytes());
            return signature.sign();
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public static boolean verify(String msg, byte[] msgSignature) {
        try {
            Signature signature = Signature.getInstance("SHA256withDSA");
            signature.initVerify(publicKey);
            signature.update(msg.getBytes());
            return signature.verify(msgSignature);
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            init();
            final Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the message to be signed : ");
            String msg = scanner.nextLine();
            byte[] msgSignature = sign(msg);
            boolean result = verify(msg, msgSignature);
            System.out.print("The signature of the message is ");
            System.out.println(new String(msgSignature, "UTF-8"));
            System.out.println("The signature is verified : " + result);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
