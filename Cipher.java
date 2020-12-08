import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class CipherDecipher{
    /**
     * This method is used to cipher the message (normal) by following steps.
     * Swap the cases of String - UpperCase letters to LowerCase letters and viceversa.
     * Reverse the String
     * Replace the spaces of string with a star character("*")
     * Replace the characters in the even positions of the string
     * Append any integer at the last in that String
     * 
     * @param normal
     * @return the ciphered message
     */
    public String ciphering(String normal){
        StringBuilder str = new StringBuilder(normal);
        StringBuilder ascii = new StringBuilder();
        
        String s = str.reverse().toString();
        
        char[] chars = s.toCharArray();
        
        for(int i=0;i<chars.length;i++){
            char c = chars[i];
            if(Character.isUpperCase(c)){
                chars[i] = Character.toLowerCase(c);
            }else if(Character.isLowerCase(c)){
                chars[i] = Character.toUpperCase(c);
            }else if(c == ' '){
                chars[i] = '*';
            }
        }
        for(int i=0;i<chars.length;i++){
            if(i%2!=0){
                int c = (int)chars[i];
                ascii.append(c);
            }else{
                ascii.append(chars[i]);
            }
        }
        //System.out.println(chars);
       // System.out.println(ascii);
       ascii.append('3');
    String encode = ascii.toString();
       return encode;
    }
    /** 3
     * This method is used to get the normal text by the reverse process of ciphering.
     * 
     * @param ciphered
     * @return the deciphered message
     */
    public String deciphering(String ciphered){
                StringBuilder code = new StringBuilder();
                StringBuilder dcode = new StringBuilder();
                
        int num = 0;

        for (int i=0; i<ciphered.length(); i++) 
        {     
        if(ciphered.charAt(i) == '*' || ciphered.charAt(i) == '?' || ciphered.charAt(i) == '.' ){
                    code.append(ciphered.charAt(i)); 
                }
            else if (Character.isAlphabetic(ciphered.charAt(i))){ 
                code.append(ciphered.charAt(i)); 
                if(ciphered.charAt(i) == '*' || ciphered.charAt(i) == '?' || ciphered.charAt(i) == '.' ){
                    code.append(ciphered.charAt(i)); 
                }
            }
            else if(Character.isDigit(ciphered.charAt(i))) 
                num = num * 10 + (ciphered.charAt(i) - '0'); 
             if (num >= 32 && num <= 122) { 
  
                // Convert num to char 
                char ch = (char)num; 
                code.append(ch);
                //System.out.print(ch);
                num = 0; 
            }
            
        } 
        char[] chars = code.reverse().toString().toCharArray();  
        // Conversion using predefined methods 
       for (int i = 0; i < chars.length; i++)
    {
        char c = chars[i];
        if (Character.isUpperCase(c))
        {
            chars[i] = Character.toLowerCase(c);
        }
        else if (Character.isLowerCase(c))
        {
            chars[i] = Character.toUpperCase(c);
        }else if(c == '*'){
            chars[i] = ' ';
        }
    }
    
    
   String d = dcode.append(chars).toString();
       return d;
    }
}
public class Solution {
    
    public static void main(String[] args){
        Scanner readInput = new Scanner(System.in);
        String normal=readInput.nextLine();
        String ciphered=readInput.nextLine();
        
        CipherDecipher cipherOrDecipher = new CipherDecipher();
        System.out.println(cipherOrDecipher.ciphering(normal));
        System.out.println(cipherOrDecipher.deciphering(ciphered));
        
        

    }
    
}