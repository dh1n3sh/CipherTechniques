import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;
public class PlayFair {

    public static String encrypt(HashMap<Character, int[]> lookup, char [][] matrix, String text, ArrayList<Integer> filler, int off){
        StringBuilder cipher = new StringBuilder();
        
        int f_index = 0;
        for(int i=0; i<text.length(); i+=1){
            char ch1 = text.charAt(i);
            char ch2 = '1';
            if (i+1<text.length()) ch2 = text.charAt(i+1);
            else
            {
                ch2 = 'x';
                filler.add(i+f_index+1);
                f_index+=1;
            }
            if(ch1=='j') ch1='i';
            if(ch2=='j') ch2='i';
            if(off==1 && ch1==ch2 & ch1!='x')
            {
                ch2='x';
                filler.add(i+f_index+1);
                f_index+=1;
            }
            else i+=1;
            int [] ind1 = lookup.get(ch1);
            int [] ind2 = lookup.get(ch2); 
            
            if(ind1[0]!=ind2[0] && ind1[1]!=ind2[1]){
                // Rectangle
                ch1 = matrix[ind1[0]][ind2[1]];
                ch2 = matrix[ind2[0]][ind1[1]];
            }
            else if( ind1[0] == ind2[0]){
                // Same Row
                ch1 = matrix[ind1[0]][((ind1[1]+off)%5+5)%5];
                ch2 = matrix[ind2[0]][((ind2[1]+off)%5+5)%5];
            }
            else{
                // Same Column
                ch1 = matrix[((ind1[0]+off)%5+5)%5][ind1[1]];
                ch2 = matrix[((ind2[0]+off)%5+5)%5][ind2[1]];               
            }
            cipher.append(ch1);
            cipher.append(ch2);
        }
        return cipher.toString();
    }

    public static void constructMatrix(String key, HashMap<Character, int[]> lookup, char [][]matrix){
        int index = 0;
        char alpha = 'a';
        for(int i=0; i<5;++i){
            for(int j =0; j<5; ++j){
                // filling with characters from key
                if (index<key.length()){
                    char k = key.charAt(index);
                    if (k=='j') k='i';
                    if (lookup.containsKey(k)){
                        index+=1;
                        j-=1;
                        continue;
                    }
                    matrix[i][j] = k;
                    lookup.put(k,new int[]{i,j});
                    index+=1;
                }
                // filling left over alphabets
                else
                {
                    if(alpha=='j') alpha++;
                    if(lookup.containsKey(alpha)){
                        alpha++;
                        if(alpha=='j') alpha++;
                        j-=1;
                        continue;
                    }
                    matrix[i][j] = alpha;
                    lookup.put(alpha++,new int[]{i,j});
                }
            }
        }
    }


    private static int menu(){
        Scanner scan =  new Scanner(System.in);
        System.out.println("1. Show matrix");
        System.out.println("2. Encrypt");
        System.out.println("3. Decrypt");
        System.out.println("4. Exit");
        System.out.print("Enter your choice : ");
        int ch = scan.nextInt();
        System.out.println("-----------------------------------");
        return ch;
    }

    public static void main(String[] args) {

        Scanner scan =  new Scanner(System.in);

        
        String text, key;
        if(args.length==0){
            System.out.print("Enter string to encrypt : ");
            text = scan.nextLine();
            System.out.print("Enter key to encrypt : ");
            key = scan.nextLine();
        }
        else{
            text = args[0];
            key = args[1];
        }

        char [][]matrix = new char[5][5];
        HashMap<Character, int[]> lookup = new HashMap<Character, int[]>();
        ArrayList<Integer> filler = new ArrayList<Integer>();
        String enc = null, dec = null;
        int ch;
        constructMatrix(key,lookup,matrix);
        do{
            ch = menu();
            if(ch==1){
                
                System.out.println("-----------------------------------");
                System.out.println("Matrix");
                for(int i=0; i<5;++i){
                    for(int j =0; j<5; ++j)
                        System.out.print((char)matrix[i][j]+" ");
                    System.out.print('\n');
                }            
                System.out.println("-----------------------------------");
            }
            if(ch==2){
                // encrypt    
                enc = encrypt(lookup,matrix,text,filler,1);
                System.out.println("Encrypted text : "+enc);
                System.out.println("-----------------------------------");
            }
            if(ch==3){
                // decrypt
                dec = encrypt(lookup,matrix,enc,filler,-1);
                System.out.print("Decrypted text : ");
                for(int i =0; i< dec.length(); ++i){
                    if(filler.contains(i)) continue;
                    System.out.print(dec.charAt(i));
                }
                System.out.println("\n-----------------------------------");
            }
     
        } while(ch!=4);
        
    }
}