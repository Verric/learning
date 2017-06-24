/*
 * Given two integers N and M, calculate N Mod M (without using any inbuilt modulus operator).
 * https://www.codeeval.com/open_challenges/62/
 */

//package modulo;

/**
 * @author Verric
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Modulo {

    private static Scanner sc;
    
    public static void main(String[] args) {
        
        String line ="";
        int numerator = 0;
        int denominator = 0;
        
        try{
            sc = new Scanner(new File(args[0]));
        }catch(FileNotFoundException ex){
            System.out.println("Could not find file specified");
        }

        while(sc.hasNextLine()){
            
            line = sc.nextLine();
            numerator = Integer.parseInt(line.split(",")[0]);//easier to read
            denominator = Integer.parseInt(line.split(",")[1]); //easier to read
            
            modulo(numerator,denominator);
        }
    }
    public static void modulo (int number, int divisor){
        
        int result = 0;
        int modulo = 0;
        
        result = number/divisor; //get quotient
        
        modulo = number - (result * divisor); //remainder = number - (quotient x denominator)
                
        System.out.println(modulo);
    }
}
