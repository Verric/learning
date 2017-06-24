/*
 * https://www.codeeval.com/open_challenges/99/
 * You have coordinates of 2 points and need to find the distance between them. 
 */

package distance_btwn_two_points;

/**
 * @author Verric
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Distance_btwn_two_points {
    
    private static Scanner sc;

    public static void main(String[] args) {
        
        try{
            sc = new Scanner(new File(args[0]));
            
        }catch(FileNotFoundException ex){
            ex.getMessage();
        }
        
        while(sc.hasNextLine()){
            getDistance(sc.nextLine());
        }
    }
    
    private static void getDistance(String input){
        
        double x1;
        double y1;
        
        double x2;
        double y2;
        
        input = input.replace("(","");//most defs a better way than doing this :(
        input = input.replace(")","");        
        input = input.replace(",","");
        input = input.trim();
        
        String[] points = input.split(" ");
        
        x1=Double.parseDouble(points[0]);
        y1=Double.parseDouble(points[1]);
        x2=Double.parseDouble(points[2]);
        y2=Double.parseDouble(points[3]);
        
        System.out.println((int)Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2)));
        
    }
}
