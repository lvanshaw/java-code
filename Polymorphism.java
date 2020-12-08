import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int startElement;
    public static  int endElement;
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
       
        startElement = scan.nextInt();
        endElement = scan.nextInt();
        
        ChildOne CO = new ChildOne();
        ChildTwo CT = new ChildTwo();
       
        System.out.println(CO.filter(startElement, endElement));
        System.out.println(CT.filter(startElement, endElement));
        
        
    }
    public static String filter(){
            
            return null;
        }
}

class ChildOne extends Solution{
    static int num=0;
    static String  primeNumbers = "";
    public String filter(int startElement, int endElement){
        
         for (int i = startElement ; i <= endElement; i++)         
       {                 
          int counter=0;       
          for(num =i; num>=1; num--)
      {
             if(i%num==0)
         {
         counter = counter + 1;
         }
      }
      if (counter ==2)
      {
         //Appended the Prime number to the String
         primeNumbers = primeNumbers + i + " ";
      }    
       }
           return primeNumbers;
        }
    
    
}
class ChildTwo extends Solution{
    static String  HappyNumbers = "";
    public String filter(int startElement, int endElement){
          for(int i = startElement; i <= endElement; i++){  
            int result = i;  
              
            //Happy number always ends with 1 and   
            //unhappy number ends in a cycle of repeating numbers which contains 4  
            while(result != 1 && result != 4){  
                result = isHappyNumber(result);  
            }  
              
            if(result == 1) { 
                //System.out.print(i + " ");  
                HappyNumbers+=i+" ";
            }
                 
        }          
        return HappyNumbers;
    }
    public static int isHappyNumber(int num){  
        int rem = 0, sum = 0;  
          
        //Calculates the sum of squares of digits  
        while(num > 0){  
            rem = num%10;  
            sum = sum + (rem*rem);  
            num = num/10;  
        }  
        return sum;  
    }  
    
}