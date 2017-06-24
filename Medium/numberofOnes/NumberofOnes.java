/*
 * Write a program to determine the number of 1 bits in the internal representation of a given integer. Write a program to determine the number of 1 bits in the internal representation of a given integer. 
 * https://www.codeeval.com/open_challenges/16/
 * Going for a  more OO style for these responses
 */

//package numberofones;

/**
 * @author Verric
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class NumberofOnes {

//should work with default constructor
    private static Scanner sc;
    
    public static void main(String[] args) {
        
        NumberofOnes n1 = new NumberofOnes();
        
        try{
            sc = new Scanner(new File(args[0]));
            
        }catch(FileNotFoundException ex){
            System.out.println("Could not find file specified");
        }
        
        while(sc.hasNextInt()){
            System.out.println(n1.getBits(sc.nextInt()));
        }
       
    }
    
    public String getBits(int number){
        
        int count = 0;
        String temp;
        
        temp = Integer.toBinaryString(number);
        
        for(int i = 0;i < temp.length();i++){
            if(temp.charAt(i) == '1'){
                count++;
            }       
        }
        return Integer.toString(count);
    }
    
}
