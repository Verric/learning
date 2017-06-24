/*
 * https://www.codeeval.com/open_challenges/97/
 * Your goal is to go through each number in the key (numbers are separated by space) left-to-right. 
 */

//package findwriter;

/**
 * @author Verric
 */

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class FindWriter {

    
    private static Scanner sc;
    
    public static void main(String[] args) {
        
        try{
            sc = new Scanner(new File(args[0]));
        }catch(FileNotFoundException ex){
            System.out.println("Could not find input file");
        }
        
        while(sc.hasNextLine()){
            findWriter(sc.nextLine());
        }
        
    }
    
    public static void findWriter(String input){      
        
        String[] values =input.split("\\|"); //shout-out to Bulkan Evcimen for debug on this line
        
        String secret = values[0].trim();
        String[] keys = values[1].trim().split(" ");
        
        for(int i =0;i<=keys.length-1;i++){
            
            System.out.print(secret.charAt(Integer.parseInt(keys[i])-1));

        }
            System.out.println();        
    }
}
