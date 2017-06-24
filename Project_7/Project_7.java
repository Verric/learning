/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 * https://projecteuler.net/problem=7
 * Answer:104743
 */


/**
 * @author Verric
 */
public class Project_7 {

    public static void main(String[] args) {
        
        int index=0;
        int counter = 1;
        
        do{
            index++;
            
            if (isPrime(index)){
                counter++;           
            }

        }while(counter <=10001);
        
        System.out.println(index);
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
