/*
 * Given a decimal (base 10) number, print out its binary representation. 
 * https://www.codeeval.com/open_challenges/27/
 */

//package decimal2binary;

/**
 * @author Verric
 */

import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

public class Decimal2Binary {

    private static Scanner sc;
    
    public static void main(String[] args) {
        
        try{
            sc = new Scanner(new File(args[0]));
            
        }catch(FileNotFoundException ex){
            ex.getMessage();
        }
        try{
            while (sc.hasNextLine()){
                
                System.out.println(Integer.toBinaryString(sc.nextInt(10)));
            }
        }catch(NoSuchElementException ex)
            {} //always have to place this when using sc.nextInt, always throws this on EOF
            
            sc.close();
    }    
}