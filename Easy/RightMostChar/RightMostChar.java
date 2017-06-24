/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 */

package rightmostchar;

/**
 * @author Verric
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class RightMostChar {

    private static Scanner sc;
    
    public static void main(String[] args) {
        
        try{
            sc = new Scanner(new File(args[0]));
            
        }catch(FileNotFoundException ex){
            ex.getMessage();
        }
        
        while(sc.hasNextLine()){
            getRightMostChar(sc.nextLine());
        }
    }
    
    private static void getRightMostChar(String input){
        
        String[] values = input.split(",");
        String sentence =values[0]; //place into nice names for easier reading
        String letter = values[1]; // ^^^^^
        
        System.out.println(sentence.indexOf(letter));
        //System.out.println(values[0].indexOf(values[1]))
    }
}
