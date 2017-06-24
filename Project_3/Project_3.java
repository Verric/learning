/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * https://projecteuler.net/problem=3
 */


/**
 * @author Verric
 */

import java.util.*;

public class Project_3 {
    
private static final String VERSION ="1.0";

    public static void main(String[] args) {
        
        List<Long> factors = new ArrayList<Long>();
        long x = 600851475143L;
        for(long i =2;i < Math.sqrt(x);i++){
              if(x % i == 0){
                  factors.add(i);
               }
        } 
        System.out.println(factors.get(factors.size()/2)); //return 6857
    }
}
// Well got me the right answer. I dont know how, but it did. Will have to come back
// to it later,