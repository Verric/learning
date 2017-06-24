/**
 *The major element in a sequence with the length of L 
 * is the element which appears in a sequence more than L/2 times.
 * The challenge is to find that element in a sequence. 
 * https://www.codeeval.com/open_challenges/132/
 */

//package majorelement;

/**
 * @author Verric
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class MajorElement {

    private static Scanner sc;
    
    public static void main(String[] args) {
        
        
        try{
            sc = new Scanner(new File(args[0]));
            
        }catch(FileNotFoundException ex){
            System.out.println("Could not find input file");
        }
        
        while(sc.hasNextLine()){
            showMajorElement(sc.nextLine());
        }
    }
    
    public static void showMajorElement(String lines){//butchered re-fix later
        
        String[] temps = lines.split(",");
        short[] values = new short[temps.length];
        
        for(int m = 0; m <temps.length;m++){
            values[m] = Short.parseShort(temps[m]);
        }
        
        int fieldLength = values.length;
        int majorLength = (fieldLength/2);
        int count;        
        int majorelement = 0;

        for(int i = 0;i < fieldLength;i++){
            count = 0;            
            for(int j = 0; j<fieldLength;j++){
                
               if(values[i] ==(values[j]))
                   count++; 
            } //end inner loop
            
            if (count > majorLength){
                majorelement = values[i];
                break;} //no need to loop anylonger
        } //end outer loop
        
        if(majorelement > 0)
            System.out.println(majorelement);
        else
            System.out.println("None");
    }
    
}
