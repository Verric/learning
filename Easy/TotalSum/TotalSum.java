/*
 * https://www.codeeval.com/open_challenges/24/
 * Print out the sum of integers read from a file. 
 */

//package totalsum;

/**
 * @author Verric
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TotalSum {
    
    static Scanner sc;


    public static void main(String[] args) {
        
        int total=0;
        
        try{
            sc =new Scanner(new File(args[0]));
        }catch(FileNotFoundException ex){
            System.out.println("Could not find file specified");
            ex.getMessage();
        }
        
        while(sc.hasNextInt()){
            total+=sc.nextInt();
        }
        sc.close();
        System.out.println(total);
    }
    
}
