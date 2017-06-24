/*
 * https://www.codeeval.com/open_challenges/100/
 * Write a program which checks input numbers and determines whether a number is even or not.
 */

//package evennumbers;

/**
 * @author Verric
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class EvenNumbers {
    
    static Scanner sc;

    public static void main(String[] args) {
        
        try{
        sc = new Scanner(new File(args[0]));
        
        }catch( FileNotFoundException ex){
            System.out.println("Could not find file specidied!");
            ex.getMessage();
        }
        
        while(sc.hasNextInt()){
            if(sc.nextInt() % 2 ==0)
                System.out.println("1");
            else
                System.out.println("0");
        }sc.close();
    }
}
