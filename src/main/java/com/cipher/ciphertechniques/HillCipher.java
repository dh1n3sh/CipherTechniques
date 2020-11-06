package com.cipher.ciphertechniques;

import java.util.*;
import java.io.*;
public class HillCipher {
	
	static int[][] multiplyMatrix(int a[][], int b[][]) 
    { 
        int i, j, k; 
  		int row1 = a.length;
  		int row2 = b.length;
  		int col2 = b[0].length;
        int result[][] = new int[row1][col2]; 
  
        for (i = 0; i < row1; i++) { 
            for (j = 0; j < col2; j++) { 
                for (k = 0; k < row2; k++) {
                    result[i][j] += a[i][k] * b[k][j]; 
                    result[i][j] %= 26;
                }
            } 
        } 
        return result;
    } 

	public static void main(String[] args) {
		String ciphertext="";
		String plaintext="";
		int n,t;
		int[][] key = new int[3][3];
		Scanner scanner = new Scanner(System.in);

		while(true) {
			System.out.println("1. Read plaintext");
			System.out.println("2. Read key");
			System.out.println("3. Encrypt");
			System.out.println("4. Decrypt");
			System.out.println("5. Exit");
			int ch = scanner.nextInt();
			if(ch==1) {
				System.out.println("Enter plaintext:");
				scanner.nextLine();
				plaintext = scanner.nextLine();
			}
			else if (ch==2) {
				System.out.println("Enter size of key: ");
				n = scanner.nextInt();
				System.out.println("Enter key:");
				key = new int[n][n];
				for(int i=0;i<n;i++)
					for(int j=0;j<n;j++)
						key[i][j] = scanner.nextInt();
                                int det = 0;
				for(int i = 0; i < 3; i++)
			        det = det + (key[0][i] * (key[1][(i+1)%3] * key[2][(i+2)%3] - key[1][(i+2)%3] * key[2][(i+1)%3]));
                                det %=26;
                                if(det%2==0){
                                    System.out.println("The given key matrix is not invertible");
                                    continue;
                                }
			}
			else if (ch==3) {
				t = 3 - (plaintext.length() % 3);
				while(t!=3 && t>0)
				{
					plaintext += "Z";
					t--;
				}	
				
				//dividing plaintext into chunks of 3
				for(int i=0;i<plaintext.length();i+=3) {
					String sub = plaintext.substring(i,i+3);
					int pmat[][] = new int [3][1];
					for(t=0;t<sub.length();t++) {
						pmat[t][0] = (int)(sub.charAt(t))-65;
					}

					int[][] cipher = multiplyMatrix(key,pmat);
					for(t=0;t<3;t++)
					{
						ciphertext += (char)(cipher[t][0]+65);
					}
				}
				System.out.println("The ciphertext is: "+ciphertext);		
			}
			else if (ch==4) {
				//calculate inverse of key
				int det = 0;
				int inverse[][] = new int[3][3];
				for(int i = 0; i < 3; i++)
			        det = det + (key[0][i] * (key[1][(i+1)%3] * key[2][(i+2)%3] - key[1][(i+2)%3] * key[2][(i+1)%3]));
			    det %=26;
                            if(det%2==0){
                                System.out.println("The given key matrix is not invertible");
                                continue;
                            }
			    for(int i = 0; i < 3; ++i) {
					for(int j = 0; j < 3; ++j)
					{
						inverse[i][j] = (((key[(j+1)%3][(i+1)%3] * key[(j+2)%3][(i+2)%3]) - (key[(j+1)%3][(i+2)%3] * key[(j+2)%3][(i+1)%3])))/ det;
						inverse[i][j] %= 26;
						if(inverse[i][j]<26)
							inverse[i][j] += 26;
					}
				}			
				plaintext = "";
				//dividing ciphertext into chunks of 3
				for(int i=0;i<ciphertext.length();i+=3) {
					String sub = ciphertext.substring(i,i+3);
					int cmat[][] = new int [3][1];
					for(t=0;t<sub.length();t++) {
						cmat[t][0] = (int)(sub.charAt(t))-65;
					}
					int[][] plain = multiplyMatrix(inverse,cmat);
					for(t=0;t<3;t++)
					{
						plaintext += (char)(plain[t][0]+65);
					}
				}
				System.out.println("The plaintext is: "+plaintext);		
			}
			else if (ch==5) {
				break;
			}
		}
	}

}