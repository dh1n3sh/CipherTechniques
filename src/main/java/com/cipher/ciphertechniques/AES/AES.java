/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cipher.ciphertechniques.AES;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
public class AES {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = "", key = "";
        while (true) {
            System.out.println("\n1. Enter Text\n2. Enter the Key\n3. Encrypt \n4. Decrypt\nany for exit ");
            int op = in .nextInt();
            if (op == 1)
                text = in .next();
            else if (op == 2)
                key = in .next();
            else if (op == 3) {
                System.out.println("Encrypted Text : " +
                    encrypt(text, key));
            } else if (op == 4) {
                System.out.println("Decrypted Text : " +
                    decrypt(text, key));
            } else
                break;
        } in .close();
    }
    public static byte[] keygen(String key) throws
    UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] keybytes = key.getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        byte[] hashedkey = sha.digest(keybytes);
        return Arrays.copyOf(hashedkey, 16);
    }
    public static String encrypt(String text, String key) {
        String res = "Invalid Key";
        try {
            byte[] key128 = keygen(key);
            Cipher cipher =
                Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec secretKey = new SecretKeySpec(key128,
                "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            res =
                Base64.getEncoder().encodeToString(cipher.doFinal(text.getBytes(
                    "UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public static String decrypt(String text, String key) {
        String res = "Invalid Key";
        try {
            byte[] key128 = keygen(key);
            Cipher cipher =
                Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec secretKey = new SecretKeySpec(key128,
                "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            res = new
            String(cipher.doFinal(Base64.getDecoder().decode(text)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}