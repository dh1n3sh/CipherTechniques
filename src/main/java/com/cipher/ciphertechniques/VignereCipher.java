import java.util.Scanner;
public class VignereCipher {

    static String generateKey(String str, String key) 
    { 
        int x = str.length(); 

        for (int i = 0; ; i++) 
        { 
            if (x == i) 
                i = 0; 
            if (key.length() == str.length()) 
                break; 
            key+=(key.charAt(i)); 
        } 
        return key; 
    } 
  
    static String Encrypt(String str, String key) 
    { 
        String cipher_text=""; 

        for (int i = 0; i < str.length(); i++) 
        {   char c=str.charAt(i);
            if(!Character.isLetter(c)){
                cipher_text+=c;
            }
            else{
            int x = (str.charAt(i) + key.charAt(i)) %26; 
            x+=65;
            cipher_text+=(char)(x);
            }
        } 
        return cipher_text; 
    } 
   
    static String Decrypt(String cipher_text, String key) 
    { 
        String orig_text=""; 

        for (int i = 0 ; i < cipher_text.length() &&  
                                i < key.length(); i++) 
        {   char c=cipher_text.charAt(i);
            if(!Character.isLetter(c)){
                cipher_text+=c;
            }else{
            int x = (cipher_text.charAt(i) -  
                        key.charAt(i) + 26) %26; 

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
        String keyword; 
        System.out.println("Enter a keyword:");
        keyword = in.nextLine();
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
                String key = generateKey(str, keyword); 
                String cipher_text = Encrypt(str, key); 
                System.out.println("Ciphertext : "+ cipher_text);
                System.out.println("-----------------------------------");
            }
            if(ch==2){
                // Decrypt
            
                String key = generateKey(str, keyword); 
                String cipher_text = Encrypt(str, key); 
                System.out.println("Original/Decrypted Text : "+ Decrypt(cipher_text, key));
                System.out.println("-----------------------------------");
                
            }
        }while(ch!=3); 
    } 
} 
    