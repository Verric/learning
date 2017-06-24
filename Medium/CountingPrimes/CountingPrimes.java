/*
 * Given two integers N and M, count the number of prime numbers between N and M (both inclusive) 
 * https://www.codeeval.com/open_challenges/63/
 */

import java.io.*;

public class CountingPrimes {

    public static void main(String[] args) {
        
        File fn = new File(args[0]);
        BufferedReader br  = null;
        String line;
        
        try{
            br = new BufferedReader(new FileReader(fn));
        }catch(FileNotFoundException ex){
            System.out.println("No file here");
        }
        
        try{
            while((line = br.readLine())!= null){
                System.out.println(findPrimes(Integer.parseInt(line.split(",")[0]),Integer.parseInt(line.split(",")[1])));//wombo combo
            }
        }catch(IOException ex){
            System.out.println("Something went wronf reading file");
        }
    }
    
    public static int findPrimes(int lower,int upper){
        
        int count  =0 ;
        
        for (int i = lower;i<=upper;i++){
            if(isPrime(i))
                count++;
        }
        return count;
    }
    
    public static boolean isPrime(int n){ //every second challenge, i use this method :/
	if (n < 2) return false;
	    if (n % 2 == 0)
	        return (n == 2);
	for (int i=3; i*i<=n; i+=2)
	    if (n % i == 0)
	        return false;
	return true;
    }
}
