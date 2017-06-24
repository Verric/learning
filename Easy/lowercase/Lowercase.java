/*
 * https://www.codeeval.com/open_challenges/20/
 */

//package lowercase;

/**
 * @author Verric
 */

import java.util.*;
import java.io.*;
public class Lowercase {

     private static Scanner sc; //class instance :/
    
    public static void main(String[] args) {
         
        try{
           
            sc = new Scanner(new File(args[0]));    
            
        }catch(FileNotFoundException ex){
            System.out.println("Could not find the file specified");
            ex.getMessage();
        }  
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine().toLowerCase());
        }
        sc.close();

    }
    
}
