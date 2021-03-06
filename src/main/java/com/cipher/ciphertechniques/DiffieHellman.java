/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cipher.ciphertechniques;

import java.math.BigInteger;
import java.util.*;
public class DiffieHellman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int P = BigInteger.probablePrime(30, new Random()).intValue();
        int G = primitiveRoot(P);
        System.out.println("P = "+P+" G = "+G);
        BigInteger g = new BigInteger(""+G);
        BigInteger p = new BigInteger(""+P);
        
        System.out.println("Enter A's secret key ");
        BigInteger xa = new BigInteger(in.next());
        BigInteger ya = g.modPow(xa, p);
        System.out.println("A's public key = " + ya);
        
        System.out.println("Enter B's secret key ");
        BigInteger xb = new BigInteger(in.next());
        BigInteger yb = g.modPow(xb, p);
        System.out.println("B's public key = " + yb);

        BigInteger A_sh = yb.modPow(xa, p);
        BigInteger B_sh = ya.modPow(xb, p);

        System.out.println("A's shared secret = "+A_sh);
        System.out.println("B's shared secret = "+B_sh);


        in.close();
        
    }

    public static int primitiveRoot(int p)
    {
        if (!(new BigInteger(""+p).isProbablePrime(1))) return -1;

        int phi = p-1;
        ArrayList<Integer> fact = primeFactors(phi);
        for (int res=2; res<=p; ++res) {
            Boolean ok = true;
            for (int i=0; i<fact.size() && ok; ++i)
                ok &= powmod (res, phi / fact.get(i), p) != 1;
            if (ok)  return res;
        }
        return -1;
    }
    
    public static ArrayList<Integer> primeFactors(int n)
    {
        ArrayList<Integer> facts = new ArrayList<>();
        for (int i=2; i*i<=n; ++i)
            if (n % i == 0) {
                facts.add(i);
                while (n % i == 0)
                    n /= i;
            }
       
        return facts;

    }
    public static int powmod(int a,int b,int mod)
    {
        if (b==0)
            return 1;
        if (b==1)
            return a%mod;
        int temp = powmod(a,b/2,mod);
        temp = (temp*temp);
        if (b%2!=0)
            temp*= a;
        return temp%mod;       
    }
//    static boolean millerTest(int d, int n) { 
//        int a = 2 + (int)(Math.random() % (n - 4)); 
//        int x = powmod(a, d, n); 
//      
//        if (x == 1 || x == n - 1) 
//            return true; 
//        while (d != n - 1) { 
//            x = (x * x) % n; 
//            d *= 2; 
//          
//            if (x == 1) 
//                return false; 
//            if (x == n - 1) 
//                return true; 
//        } 
//        return false; 
//    } 
//    static boolean isPrime(int n) { 
//        if (n <= 1 || n == 4) 
//            return false; 
//        if (n == 3) 
//            return true; 
//        int d = n - 1; 
//        int k=n-2;
//        while (d % 2 == 0) 
//        {
//            d /= 2;
//            // k++; 
//        }
//        for (int i = 0; i < k; i++) 
//            if (!millerTest(d, n)) 
//                return false; 
//      
//        return true; 
//    } 
      
}

