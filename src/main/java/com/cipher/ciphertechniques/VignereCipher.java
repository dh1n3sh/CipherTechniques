package com.cipher.ciphertechniques;

import java.util.Scanner;
public class VignereCipher {

    static String offset(String cipher_text, String key, int off) 
    { 
        String orig_text=""; 

        for (int i = 0 ; i < cipher_text.length(); i++) 
        {   char c=cipher_text.charAt(i);
            if(!Character.isLetter(c)){
                cipher_text+=c;
            }else{
            int x = (cipher_text.charAt(i) + off*  
                        key.charAt(i%key.length()) + 26) %26; 

            x+=65;
            orig_text+=(char)(x);
            }
        } 
        return orig_text; 
    } 
  
    public static void main(String[] args)  
    { 
        Scanner in = new Scanner(System.in);
        String str ;
        int ch;        
        String keyword, key; 
        System.out.println("Enter a keyword:");
        key = in.nextLine();
        System.out.println("Enter the Plain text");
        str=in.nextLine();
        do{
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.println("3. Exit");
            System.out.print("Enter your choice : ");
        ch=in.nextInt();
        in.nextLine();
            if(ch==1){
                // Encrypt

                String cipher_text = offset(str, key, 1); 

                System.out.println("Ciphertext : "+ cipher_text);
                System.out.println("-----------------------------------");
            }
            if(ch==2){
                // Decrypt

                String cipher_text = offset(str, key, 1); 
                System.out.println("Original/Decrypted Text : "+ offset(cipher_text, key,-1));
                System.out.println("-----------------------------------");
                
            }
        }while(ch!=3); 
    } 
} 
    