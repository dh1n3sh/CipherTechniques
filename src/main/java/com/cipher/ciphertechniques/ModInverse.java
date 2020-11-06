/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cipher.ciphertechniques;

/**
 *
 * @author dhinesh
 */
public class ModInverse {
   
// Iterative Java program to find modular
// inverse using extended Euclid algorithm


	// Returns modulo inverse of a with
	// respect to m using extended Euclid
	// Algorithm Assumption: a and m are
	// coprimes, i.e., gcd(a, m) = 1
	static int modInverse(int a, int m)
	{
		int m0 = m;
		int y = 0, x = 1;

		if (m == 1)
			return 0;

		while (a > 1) {
			// q is quotient
			int q = a / m;

			int t = m;

			// m is remainder now, process
			// same as Euclid's algo
			m = a % m;
			a = t;
			t = y;

			// Update x and y
			y = x - q * y;
			x = t;
		}

		// Make x positive
		if (x < 0)
			x += m0;

		return x;
	}

	// Driver code
	public static void main(String args[])
	{
		int a = 3, m = 26;
		
		// Function call
                for(int i=1; i<26; ++i)
		System.out.println("Modular multiplicative "
						+ "inverse is "
						+ modInverse(i, m));
	}
}

/*This code is contributed by Nikita Tiwari.*/

