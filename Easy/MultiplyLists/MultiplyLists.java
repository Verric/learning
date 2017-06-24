/*
 * You have 2 lists of positive integers. Write a program which multiplies corresponding elements in these lists. 
 * https://www.codeeval.com/open_challenges/113/
 */

//package multiplylists;

/**
 * @author Verric
 */

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class MultiplyLists {

    private static Scanner sc;
    
    public static void main(String[] args) {

        try{
            sc = new Scanner(new File(args[0]));
        }catch(FileNotFoundException ex){
            System.out.println("Could not find your file :/");
        }
        
        while(sc.hasNextLine()){
            calculateLists(sc.nextLine());
        }
    }
    
    public static void calculateLists(String input){
          
        StringBuilder sb  = new StringBuilder();
        
        String[] values;
        String[] temp1;
        String[] temp2;
        
        values = input.split("\\|");
        
        temp1 = values[0].trim().split(" ");
        temp2 = values[1].trim().split(" ");  
        
        int[] list1 = new int[temp1.length];
        int[] list2 = new int[temp2.length];
        
        //popualte list1
        for(int i = 0;i< temp1.length;i++){
            list1[i] = Integer.parseInt(temp1[i]);
        }
        
       //populate list2
        for(int i = 0;i< temp2.length;i++){
            list2[i] = Integer.parseInt(temp2[i]);
        }
        //Multiply cooresponding elements
        for(int i  = 0;i < list1.length;i++){
            sb.append(list1[i] * list2[i] +" ");
        }
        
        System.out.println(sb.toString().trim());

    }
    
}
