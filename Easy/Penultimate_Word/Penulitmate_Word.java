/*
 * Write a program which finds the next-to-last word in a string. 
 * https://www.codeeval.com/open_challenges/92/
 */

package penulitmate_word;

/**
 * @author Verric
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Penulitmate_Word {

    private static Scanner sc;

    public static void main(String[] args) {
        
        try{
            sc = new Scanner(new File(args[0]));
            
        }catch(FileNotFoundException ex){
            ex.getMessage();
        }
        
        while(sc.hasNextLine()){
            getPenultimateWord(sc.nextLine());
        }
   
    }
    
    private static void getPenultimateWord(String input){
        
        String[] values = input.split(" ");
        System.out.println(values[(values.length-2)]);
    }
}
