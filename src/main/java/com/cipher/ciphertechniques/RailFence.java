package com.cipher.ciphertechniques;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.cipher.ciphertechniques;

/**
 *
 * @author dhinesh
 */
import java.util.*;
import java.io.*;

public class RailFence {
    static ArrayList<ArrayList<String>> fence = new ArrayList<ArrayList<String>>();

    public static String Encrypt(String text, int key) {
        String res = "";
        fence = new ArrayList<ArrayList<String>>(key);

        for (int i = 0; i < key; i++) {
            fence.add(new ArrayList<String>(text.length()));
        }
        System.out.println(text);
        int down = 1;
        int i = 0, x = 0;

        for (char c : text.toCharArray()) {

            for (int z = 0; z < key; z++)
                fence.get(z).add(" ");

            fence.get(i).set(fence.get(i).size() - 1, Character.toString(c));

            if (i == key - 1)
                down = 0;
            if (i == 0)
                down = 1;
            if (down == 1)
                i += 1;
            else
                i -= 1;
        }

        fence.forEach(arrayList -> {
            System.out.println(arrayList);
        });
        System.out.println("");
        for (i = 0; i < key; i++) {
            for (String c : fence.get(i)) {
                res += c;
            }
        }
        return res.replace(" ", "");
    }

    public static String Decrypt(String enc, int key) {
        String res = "";
        int down = 1;
        int x = 0;
        for (int i = 0; i < enc.length(); i++) {
            res += ((ArrayList) fence.get(x)).get(i);

            if (x == key - 1)
                down = 0;
            if (x == 0)
                down = 1;

            if (down == 1)
                x += 1;
            else
                x -= 1;
        }
        return res;
    }

    public static void main(String args[]) {
        
        System.out.print("Text : ");
        System.out.flush();
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        text = text.replace(" ", "");
        text = text.toUpperCase();
        System.out.print("Key : ");
        Integer key = sc.nextInt();

        int op;
        do {
            System.out.println("");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.println("3. Exit");
            System.out.print("Enter Choice : ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("");
                    String enc = Encrypt(text, key);
                    System.out.println("Encrypted Text : " + enc);
                    break;
                case 2:
                    String dec = Decrypt(text, key);
                    System.out.println("");
                    System.out.println("Decrypted Text : " + dec);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid Choice !!");
            }    
        }while (op != 3);
    }
}