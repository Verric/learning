/*
 * Perform requested operations to a an array to be querried
 * https://www.codeeval.com/browse/87/
 */

//package queryboards;

/**
 * @author Verric
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class QueryBoards {

    private static Scanner sc;
    private static int[][] board = new int[256][256];
    private static final int FIELDSIZE = 256;
    
    public static void main(String[] args) {
        
        String line=""; //store sc.NextLine for obtainiing values
        String operation=""; 
        int field = 0;
        int value = 0;
        
        try{
            sc = new Scanner(new File(args[0]));
        }catch(FileNotFoundException ex){
            System.out.println("Could not find input file");
        }
        
        while(sc.hasNextLine()){
            
            line = sc.nextLine();
            operation = line.split(" ")[0];
            
            if(operation.equals("SetCol")){
                field = Integer.parseInt(line.split(" ")[1]);
                value = Integer.parseInt(line.split(" ")[2]);
                setCol(field,value);
            }
            
            else if(operation.equals("SetRow")){
                field = Integer.parseInt(line.split(" ")[1]);
                value = Integer.parseInt(line.split(" ")[2]);
                setRow(field,value);
            }
            
            else if(operation.equals("QueryRow")){
                field = Integer.parseInt(line.split(" ")[1]);
                queryRow(field);
            }
            
            else if(operation.equals("QueryCol")){
                field = Integer.parseInt(line.split(" ")[1]);
                queryCol(field);
            }
        } //end while loop

    } //end main class
    
    public static void setCol(int colNumber, int colValue){ //working
        
        for(int i = 0; i < FIELDSIZE; i++){
            board[i][colNumber] = colValue;
        }
    }

    
    public static void setRow(int rowNumber, int rowValue){
        
        for(int i = 0; i < FIELDSIZE; i++){
            board[rowNumber][i] = rowValue;
        }       
    }
    
    public static void queryCol(int colNumber){//print the sum of all values on colNumber
        
        int total = 0;
        
        for(int i = 0; i < FIELDSIZE; i++){
           total += board[i][colNumber];
        }
        System.out.println(total);
    }
    
    public static void queryRow(int rowNumber){
        int total = 0;
        
        for(int i = 0; i < FIELDSIZE; i++){
           total += board[rowNumber][i];
        }
        System.out.println(total);        
    }
}
