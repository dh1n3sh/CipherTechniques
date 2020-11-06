/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cipher.ciphertechniques;

import java.util.*;
public class RowColumn {
 public static String Encrypt(String text, String key){
 String res = "";
 String alpha = "ZYXWVUTSRQPONMLKJIHGFEDCBA";

 int n;
 if(text.length()%key.length()>0)
 n = (text.length()/key.length())+1;
 else
 n = text.length()/key.length();

 char[][] rc = new char[n][key.length()];

 int i=0,j=0;
 for(char c: text.toCharArray()){
 rc[i][j] = c;
 j+=1;

 if(j==key.length()){
 j=0;
 i+=1;
 }
 }

 int x=key.length()-j;
 while(i!=n && j!=key.length()){
 rc[i][j] = alpha.charAt(x-1);
 x-=1;
 j+=1; }
 for(i=0;i<n;i++){
 for(j=0;j<key.length();j++){
 System.out.print(rc[i][j]+" ");
 }
 System.out.println("");
 }
 System.out.println("");
 
 for(i=1;i<=key.length();i++)
 for(j=0;j<n;j++){
 res+=rc[j][key.indexOf(Integer.toString(i))];
 }
 return res;
 }

 public static String Decrypt(String enc, String key){
 String res = "";
 int x=0;
 int n=enc.length()/key.length();
 char[][] rc = new char[n][key.length()];

 for(int i=1;i<=key.length();i++){
 for(int j=0;j<n;j++){
 rc[j][key.indexOf(Integer.toString(i))]= enc.charAt(x);
 x+=1;
 }
 }

 for(int i=0;i<n;i++)
 for(int j=0;j<key.length();j++)
 res+=(rc[i][j]);

 return res;
 }

 public static void main(String[] args){
 Scanner sc= new Scanner(System.in);
 System.out.print(("Text : "));
 String text = sc.nextLine();
 text = text.replace(" ", "");
 text = text.toUpperCase();
 System.out.print("Key : ");
 String key = sc.nextLine();

 String enc = "";

 System.out.println("");
 System.out.println("1. Encrypt");
 System.out.println("2. Decrypt");
 System.out.println("0. Exit");
 System.out.print("Enter Choice : ");
 int op = sc.nextInt();
 while(op!=0){

 switch(op){
 case 1:
 System.out.println("");
 enc = Encrypt(text, key);
 System.out.println("Encrypted Text : "+enc.replace(" ", ""));
 break;
 case 2:
 System.out.println("");
 String dec = Decrypt(enc, key);
 System.out.println("Decrypted Text : "+dec.replace(" ", "").substring(0, text.length()));
 break;
 default:
 System.out.println("Invalid Choice !!");
 }

 System.out.println("");
 System.out.println("1. Encrypt");
 System.out.println("2. Decrypt");
 System.out.println("0. Exit");
 System.out.print("Enter Choice : ");
 op = sc.nextInt();
 }
 }
}