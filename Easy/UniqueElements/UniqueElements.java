/*
 * https://www.codeeval.com/open_challenges/29/
 * You are given a sorted list of numbers with duplicates. Print out the sorted list with duplicates removed. 
 */

package uniqueelements;

/**
 * @author Verric
 */

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class UniqueElements {
    
     private static Scanner sc;

    public static void main(String[] args) {
        
        int[] values;
        String line;

        
        try{
            sc = new Scanner(new File(args[0])).useDelimiter(",");

            
        }catch(FileNotFoundException ex){
            ex.getMessage();
        }
        
        while(sc.hasNextLine()){
            filterduplicates(sc.nextLine());            
        }
    }
    private static void filterduplicates(String input){
        
         List<Integer> ls = new ArrayList();
         Set<String> set = new HashSet(); 
         StringBuilder sb = new StringBuilder();
         
         String values[] =input.split(",");
        
         for(String temp: values){// adds array to set to remove duplicates
             set.add(temp);
         }
         
        for(String unordered: set){ //pump it into Intger list so we can sort
            ls.add(Integer.parseInt(unordered));
        }
        
        Collections.sort(ls); //sort the damn thing
        
        for (int meh:ls){
            sb.append(meh+" "); //add a space after each value
        }
        String temp = sb.toString().trim();// trim so there is no trailing or leading spaces
        System.out.println(temp.replace(" ",","));// convert all spaces to commas
        //this stops/buthcers an issue where i would have a comma haging after the last digit.
        // i.e 1,2,3,4,
    }
}
