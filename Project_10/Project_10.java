/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * https://projecteuler.net/problem=10
 * Answer: 142913828922
 * seemed relativley easy compared to project_9, personally speaking :(
 * Notes: if you use an int for (i) java won't complain it can store 2 million into an int
 * and will out put an incorrect answer with out errors :/
 */

package project_10;

/**
 * @author Shining Shadows
 */
public class Project_10 {

    public static void main(String[] args) {
        
        long sum=0;
        
        for(long i =0;i<2000000;i++){ //loop all integer under 2 million
            if(isPrime(i))//check if ts prime
                sum+=i; //add to the pile if it is
        }
        System.out.println(sum);
    }
        public static boolean isPrime(long n) { //pulled from project 7
	if (n < 2) return false;
	    if (n % 2 == 0)
	        return (n == 2);
	for (int i=3; i*i<=n; i+=2)
	    if (n % i == 0)
	        return false;
	return true;
	}
}
