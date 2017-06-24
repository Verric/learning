/*
* Chanllenge:
* If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
* Find the sum of all the multiples of 3 or 5 below 1000.
* https://projecteuler.net/problem=1
*
 */


/**
 *
 * @author Verric
 */
public class Project_1 {


    public static void main(String[] args) {
        long number = 0; //use a "long" as we are going through a decent sized loop
        
        for(int i=0; i <1000;i++){ //pretty standard loop
           if( i % 3 == 0 || i % 5 == 0){ // only care for multiples of 3 OR 5
               number+=i; // accumulate the result
           } 
        }System.out.println(number); // print outside of the loop as we only care about the result
    }
    
}
