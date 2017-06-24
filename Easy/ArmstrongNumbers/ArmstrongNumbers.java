/*
 * An Armstrong number is an n-digit number that is equal to the sum of the n'th powers of its digits. 
 * Determine if the input numbers are Armstrong numbers. 
 *https://www.codeeval.com/open_challenges/82/
 */

//package armstrongnumbers;

/**
 * @author Verric
 */

import java.util.*;
import java.io.*;

public class ArmstrongNumbers {

    private static Scanner sc;
    
    public static void main(String[] args) {
        
        try{
            sc = new Scanner(new File(args[0]));
            
        }catch(FileNotFoundException ex){
            System.out.println("Could not find input file :(");
        }
        
        while(sc.hasNextLine()){
            findArmstrongNumber(sc.nextLine());
        }
    }
    
    private static void findArmstrongNumber(String input){
        int calculated=0;
        
        String[] values = input.trim().split("");
        double[] digits = new double[values.length];
        
        for(int i = 1;i<values.length;i++){ //so for some fkin apparent reason if i=0 program always thrown an "empty string" exception
           digits[i] =Double.parseDouble(values[i]); 
        }
        
        for(int i =0;i <digits.length;i++){ //calculate armstrong number
            calculated += Math.pow(digits[i],input.length());
        }
        
        if(calculated == Integer.parseInt(input)) //if calculated equals number inputted
            System.out.println("True");
        else
            System.out.println("False");
        

    }
}
