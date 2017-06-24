/*
 * https://www.codeeval.com/open_challenges/104/
 * Having a string representation of a set of numbers you need to print this numbers. 
 */

package wordtodigit;

/*
 * @author Verric
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordtoDigit {
    
    static Scanner sc;
    
    public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder();
        String line;
        String [] values;
        try{
            sc = new Scanner(new File(args[0]));            
        }catch(FileNotFoundException ex){
            System.out.println("Could not find file specified");
            ex.getMessage();
        }
    
        while(sc.hasNextLine()){
            
            sb.setLength(0); //reset buffer every loop
            values=sc.nextLine().split(";"); //get delimited values from each line
            for(String numbers :values) //dont know how this works :/
                
            switch(numbers){ //can switch Strings in JRE 7 :)
               
                case "zero":
                    sb.append("0");
                    continue;
                case "one":
                    sb.append("1");
                    continue;
                case "two":
                    sb.append("2");
                    continue;
                case "three":
                    sb.append("3");
                    continue;
                case "four":
                    sb.append("4");
                    continue;
                case "five":
                    sb.append("5");
                    continue;
                case "six":
                     sb.append("6");
                     continue;
                case "seven":
                     sb.append("7");
                     continue;
                case "eight":
                     sb.append("8");
                     continue;
                case "nine":
                    sb.append("9");
            }
         System.out.println(sb);           
        }

    }
    
}
