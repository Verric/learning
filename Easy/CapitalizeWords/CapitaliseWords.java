/*
 * https://www.codeeval.com/open_challenges/93/
 * Write a program which capitalizes the first letter of each word in a sentence. 
 */

package capitalisewords;

/**
 * @author Verric
 */
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class CapitaliseWords {

    private static Scanner sc;
    
    public static void main(String[] args) {
        
        try{
           sc = new Scanner(new File(args[0]));
        }catch(FileNotFoundException ex){
            ex.getMessage();
        }
        
        while(sc.hasNextLine()){
            capitaliseWords(sc.nextLine());
        }
    
    }
    
    private static void capitaliseWords(String input){
        
        StringBuilder sb = new StringBuilder();
        String[] values =input.split(" ");
        
        for(String temp1 :values){
            sb.append(Character.toUpperCase(temp1.charAt(0))).append(temp1.substring(1));
            sb.append(" ");
        }// thank Java lords for method chains :)
        
        System.out.println(sb.toString().trim());
    }
}
    
