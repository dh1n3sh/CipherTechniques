package com.cipher.ciphertechniques;

import java.io.*;

class CRT { 
	
	// Returns modulo inverse of a 
	// with respect to m using extended 
	// Euclid Algorithm. Refer below post for details: 
	// https://www.geeksforgeeks.org/multiplicative-inverse-under-modulo-m/ 
        
        static int gcdExtended(int a, int b, int[] g){
            // Base Case
            if (a == 0) 
            {
                g[0] = 0;
                g[1] = 1;
                        
                return b;
            }

            int gcd = gcdExtended(b % a, a, g);

            // Update x and y using results of recursive
            // call
            int x = g[1] - (b / a) * g[0];
            int y = g[0];
            
            g[0] = x;
            g[1] = y;
            return gcd;
        }
	static int inv(int a, int m) 
	{ 
            int[] g = new int[2];
            int gcd = gcdExtended(a, m, g);
            if (gcd != 1)
                return -1;
            else
            {
                // m is added to handle negative x
                int res = (g[0] % m + m) % m;
                return res;
            }
	} 
	
	// Assumption: Numbers in num[] are pairwise 
	// coprime (gcd for every pair is 1) 
	static int findMinX(int num[], int rem[], int k) 
	{ 
		// Compute product of all numbers 
		int prod = 1; 
		for (int i = 0; i < k; i++) 
			prod *= num[i]; 
	
		// Initialize result 
		int result = 0; 
	
		// Apply above formula 
		for (int i = 0; i < k; i++) 
		{ 
			int pp = prod / num[i]; 
			result += rem[i] * inv(pp, num[i]) * pp; 
		} 
	
		return result % prod; 
	} 
	
	// Driver method 
	public static void main(String args[]) 
	{ 
		int num[] = {3, 4, 5}; 
		int rem[] = {2, 3, 1}; 
		int k = num.length; 
		System.out.println("x is " +findMinX(num, rem, k)); 
	} 
} 

// This code is contributed by nikita Tiwari. 
