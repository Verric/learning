/*
 *You will be given a hexadecimal (base 16) number. Convert it into decimal (base 10). 
 * https://www.codeeval.com/open_challenges/67/
 */

package hextodecimal;

/**
 * @author Shining Shadows
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HextoDecimal {

    private static Scanner sc;
    
    public static void main(String[] args) {
        
        try{
            sc = new Scanner(new File(args[0]));
            
        }catch(FileNotFoundException ex){
            ex.getMessage();
        }
        
        try{
            while (sc.hasNextLine()){
                System.out.println(sc.nextInt(16));}  //set scanner radix to 16 (hex) for int, pretty cool :)
        }catch(java.util.NoSuchElementException ex){}//do nothing
            sc.close();
    }   
}
