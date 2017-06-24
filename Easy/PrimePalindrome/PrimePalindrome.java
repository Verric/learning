/*
 * https://www.codeeval.com/open_challenges/3/
 */

package primepalindrome;

/**
 * @author Verric
 */
public class PrimePalindrome {

    public static void main(String[] args) {
        
        int highscore = 0;
        
        for(int i =1;i <1001;i++){
            if((isPrime(i)) && (isPalindrome(i) && (i>highscore)))
                highscore=i;
        }
        System.out.println(highscore);
        
    }
    
    public static boolean isPrime(int n) { //pulled from project_euler question 7
	if (n < 2) return false;
	    if (n % 2 == 0)
	        return (n == 2);
	for (int i=3; i*i<=n; i+=2)
	    if (n % i == 0)
	        return false;
	return true;
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
}
