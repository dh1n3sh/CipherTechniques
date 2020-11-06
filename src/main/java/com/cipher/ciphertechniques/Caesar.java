package com.cipher.ciphertechniques;

import java.util.*;

public class Caesar {

    private static String offset(String text, int key){
        StringBuilder cipher = new StringBuilder();
        for(int i=0; i<text.length(); ++i){
            char ch = text.charAt(i);
            if(Character.isUpperCase(ch)){
                int ind = ch-'A';
                ind = ((ind + key)%26+26)%26;
                cipher.append((char)(ind+'A'));
            }
            else if(Character.isLowerCase(ch)){
                int ind = ch-'a';
                ind = ((ind + key)%26+26)%26;
                cipher.append((char)(ind+'a'));
            }
            else
                cipher.append(ch);       
        }
        return cipher.toString();
    }

    private static String encrypt(String cipher, int key){
        return offset(cipher, key);
    }

    private static String decrypt(String cipher, int key){

        return offset(cipher, -key);
    }

    private static int menu(){
        Scanner scan =  new Scanner(System.in);
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.println("3. Exit");
        System.out.print("Enter your choice : ");
        int ch = scan.nextInt();
        System.out.println("-----------------------------------");
        return ch;
    }

    public static void main(String[] args) {

        Scanner scan =  new Scanner(System.in);

        System.out.print("Enter string to encrypt : ");
        String text = scan.nextLine();
        System.out.print("Enter key to encrypt : ");
        int key = scan.nextInt();
        System.out.println("-----------------------------------");
        int ch;
        String enc = null;
        do{
            ch = menu();

            if(ch==1){
                // Encrypt
                enc = encrypt(text,key);
                System.out.println("Encrypted text : "+enc);
                System.out.println("-----------------------------------");
            }
            if(ch==2){
                // Decrypt
                if(enc!=null){
                    String dec = decrypt(enc,key);
                    System.out.println("Decrypted text : "+dec);
                    System.out.println("-----------------------------------");
                }
            }
        }while(ch!=3);
    }
}