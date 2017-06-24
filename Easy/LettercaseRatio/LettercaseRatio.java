/*
 * Your goal is to find the percentage ratio of lowercase and uppercase letters in line below. 
 * https://www.codeeval.com/open_challenges/147/
 */

/**
 * @author Verric
 */

import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.File;
import java.io.FileNotFoundException;

public class LettercaseRatio {

    private static Scanner sc;
    
    public static void main(String[] args) {
        
        try{
            sc= new Scanner(new File(args[0]));
        }catch(FileNotFoundException ex){
            System.out.println("Could not find input file");
        }
        
        while(sc.hasNextLine()){
            showLetterCasePercent(sc.nextLine());
        }

    }
    public static void showLetterCasePercent(String input){
        DecimalFormat f = new DecimalFormat( "#0.00" );
        char[] word =input.toCharArray();
        int arraylen = word.length;
        int lowercase = 0;
        int uppercase = 0;
        String upperperc;
        String lowerperc;
        
        for (int i = 0;i<arraylen;i++){
            if(Character.isLowerCase(word[i]))
                lowercase++;
            else
                uppercase++;
        }
        
        lowerperc =f.format(((double)lowercase/(double)arraylen)*100);
        upperperc =  f.format(((double)uppercase/(double)arraylen)*100);
        System.out.println("lowercase: "+ lowerperc + " uppercase: "+ upperperc);
    }
}
