/*
 * https://www.codeeval.com/open_challenges/19/
 */

//package bitpositions;

/**
 * @author Verric
 */

import java.io.*;
public class BitPositions {

    public static void main(String[] args) {
                String line;
        BufferedReader br  = null;
        
        try{
            br = new BufferedReader(new FileReader(args[0])); //Same Sh!t different project
            while((line = br.readLine()) != null)
            locatebits(line);
            
        }catch(FileNotFoundException ex){
            System.out.println("Error: Could not find the file specidied, please check your parameters");
            ex.getMessage();
            
        }catch(IOException ex){
            System.out.println("Error reading stream from file, check encoding???");
            ex.getMessage();
        }finally{
            
            try{
                if (br!=null)
                    br.close();
                
            }catch(IOException ex){
                System.out.println("Could not close stream");
                ex.getMessage();
            }
        }
        
    }
    private static void locatebits (String input){
        
        String[] values;
        String num;
        
        values=input.split(",");
        num =Integer.toString(Integer.parseInt(values[0]), 2);
        
        int p1=Integer.parseInt(values[1]);
        int p2=Integer.parseInt(values[2]);
        int length =num.length();  
        
        
       if(num.charAt(length - p1) == num.charAt(length-p2)) //charAt start at left, hence length -posiontx
           System.out.println("true");
       else
           System.out.println("false");
        
    }
}
