/*
 * A palindromic number reads the same both ways. 
 * The largest palindrome made from the product of two 2-digit numbers 
 * is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * Answer:906609
 */


/**
 * @author Verric
 */

public class Project_4 {


    public static void main(String[] args) {
        long t1 =gettime();
        int largestpalindrome = 0;
        int l=0;
        int i =100;
        
        while(i <=999){
            for(int j=100;j<=999;j++){
                l=i*j;
                if(isPalindrome(l)){    
                    if((l >largestpalindrome)){
                    largestpalindrome=l;}
                    else {
                        break;
                    }
                }
            }i++;
        }System.out.println(largestpalindrome);
        long t2=gettime();
        System.out.println(("time:"+(t2-t1)+"ms"));
    }
   public static boolean isPalindrome(int number) {
        int palindrome = number;
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        if (number == reverse) {
            return true;
        }
        return false;
    }
   public static long gettime(){
      return System.currentTimeMillis();
   }
   
}