/*
 * https://www.codeeval.com/open_challenges/30/
 * You are given two sorted list of numbers (ascending order).Print out the intersection of these two sets. 
 */

//package setintersection;

/**
 * @author Verric
 */

//imports ,Scanner and Collections
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class SetIntersection {


    private static Scanner sc;
    
    public static void main(String[] args) {
        
        try{
            sc = new Scanner(new File(args[0]));
            
        }catch(FileNotFoundException ex){
            System.out.println("Could not find File, dumbass");//no offence, dumbass
        }
        
        while(sc.hasNextLine()){
            findIntersection(sc.nextLine());

        }
    }
    
    public static void findIntersection(String input){
        //Used List for the .contains() function
        List<String> ls1 = new ArrayList();
        List<String> ls2 = new ArrayList();
        StringBuilder sb = new StringBuilder();
        
        String[] sets = input.split(";");
        String[] set1 = sets[0].split(",");
        String[] set2 = sets[1].split(",");
        
        //populate ls1
        for(String temp1 : set1){
            ls1.add(temp1);
        }
        
        //populate ls2
        for(String temp2 : set2){
            ls2.add(temp2);
        }
        
        
        for(String test: ls1){
            if(ls2.contains(test))
                sb.append(test+" ");
        }
        
        System.out.println(sb.toString().trim().replace(" ", ","));
    }
}
