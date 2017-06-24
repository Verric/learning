/*
 * reverse its digits and add it to the original. If the sum is not a palindrome
 * https://www.codeeval.com/open_challenges/45/
 * Used long instead of int as input could go upto 100 iterations, for n <10,000
 */

import java.io.*;

public class ReverseAdd {


    public static void main(String[] args) {
        
        BufferedReader br = null;
        String line;
        
        try{
            br = new BufferedReader (new FileReader(args[0]));
            
        }catch(FileNotFoundException ex){
            System.out.println("No file was found");
        }
        
        try{
        while((line = br.readLine()) != null){  
            
            findPalindrome(Integer.parseInt(line));  
        }  
        
        }catch(IOException ex){
                ex.getMessage();
                }
   
        }
    
    private static void findPalindrome(int number){
        
        long temp = number;
        long rev;
        int count = 0;
        
        while(!isPalindrome(temp)){
            
            rev = reverseNumber(temp);
            temp+=rev;
            count++;
        }
        
        System.out.println(count+" "+temp);  
        
    }
    private static boolean isPalindrome(long number) { //pulled from archaic project euler
 
        long reverse = reverseNumber(number);

        if (number == reverse) {
            return true;
        }
        return false;
    }
    
    private static long reverseNumber(long number){
        
       long tmp = number;
        long reverse = 0;

        while (tmp != 0) {
            long remainder = tmp % 10;
            reverse = reverse * 10 + remainder;
            tmp = tmp / 10;
        }
        return reverse;
    }
}
    
