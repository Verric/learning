/*
 * https://www.codeeval.com/open_challenges/22/
 * The Fibonacci series is defined as: F(0) = 0; F(1) = 1; F(n) = F(n-1) + F(n-2) when n>1. Given a positive integer 'n', print out the F(n).
 */

//package fibonacci.series;

/**
 * @author  Verric
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FibonacciSeries {

    private static Scanner sc;
    
    public static void main(String[] args) {
        
        try{
            
            sc = new Scanner(new File(args[0]));
            
        }catch(FileNotFoundException ex){
            ex.getMessage();
        }
        
        while(sc.hasNextLine())
            System.out.println(findFibNumber(sc.nextLine()));
    }
    
    private static int findFibNumber(String input){
        
        int number = Integer.parseInt(input);
        int a =0;
        int b =1;
        int c =1;
        int counter =2; //ignore forts iterationas they are initalized to F(1)
        
        if( number == 0)
            return 0;
        
        if(number ==1)
            return 1;
        
        while (counter != number){
           a=b;
           b=c;
           c=a+b;
           counter++; 
        }
        return c;
    }
}
