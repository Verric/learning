/*
 * https://www.codeeval.com/open_challenges/21/
 * Given a positive integer, find the sum of its constituent digits.
 */

//package sumofdigits;

/**
 * @author Verric
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SumofDigits {
    
    static Scanner sc;
    
    public static void main(String[] args) {
        
        String line;
        int result;
        try{
            sc = new Scanner(new File(args[0]));
            
        }catch(FileNotFoundException ex){
            System.out.println("Could not find file specified");
            ex.getMessage();
        }
        
        while(sc.hasNextLine()){
            line=sc.nextLine();
            result =0; //got to reset after each line
                for(int i=0; i <line.length();i++){
                   result+=Character.getNumericValue(line.charAt(i)); //1 line value :)
            }
            System.out.println(result);
        }sc.close();
    }
    
}
