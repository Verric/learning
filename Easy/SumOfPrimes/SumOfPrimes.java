/*
 * https://www.codeeval.com/open_challenges/4/
 */

//package sumofprimes;

/**
 * @author Verric
 */
public class SumOfPrimes {

    public static void main(String[] args) {
        
        int counter = 0; //stores how many times we hit  a prime number
        int accum = 0;
        
        for(int i=1; counter!=1000;i++){
            if(isPrime(i)){
                accum+=i;
                counter++;
            }
        }
        System.out.println(accum);
   
    }
    
    public static boolean isPrime(int n) {
	if (n < 2) return false;
	    if (n % 2 == 0)
	        return (n == 2);
	for (int i=3; i*i<=n; i+=2)
	    if (n % i == 0)
	        return false;
	return true;
	}
}
