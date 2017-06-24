/*
 *  Write a program which separates words with digits. You shouldn't change the order elements. 
 * https://www.codeeval.com/open_challenges/115/
 */

//package mixedcontent;

/**
 * @author Verric
 */

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class MixedContent {


    private static Scanner sc;
    
    public static void main(String[] args) {
        
        try{
            sc = new Scanner(new File(args[0]));
            
        }catch(FileNotFoundException ex){
            System.out.println("Could not find input file");
        }
        
        while(sc.hasNextLine()){
            sortContent(sc.nextLine());
        }
        
    }
    public static void sortContent(String input){
        
        int test = 0;
        List<Integer> intList = new ArrayList<>();
        List<String> strList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
 
        String[] values = input.split(",");
        
        for(int i = 0;i < values.length;i++){
            
            try{
                Integer.parseInt(values[i]);
            }catch(NumberFormatException ex){
                strList.add(values[i]);
                continue;
            }
            intList.add(Integer.parseInt(values[i]));
        }
        
        
        for(String temp: strList){
            sb.append(" "+temp);
        }
        if((!intList.isEmpty()) && (!strList.isEmpty())){ //only append seprator if both list contain values
        sb.append("|");
        }
        
        for (int index : intList){
            sb.append(index+" ");
        }
        
        String temp = sb.toString().trim().replace(" ", ",");
        System.out.println(temp);
    }
}
