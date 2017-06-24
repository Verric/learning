/*
 * https://www.codeeval.com/open_challenges/18/
 */

//package multiplesofanumber;

import java.io.*;

/**
 * @author Verric
 */

public class MultiplesOfaNumber {


    public static void main(String[] args) {
        String line;
        BufferedReader br  = null;
        
        try{
            br = new BufferedReader(new FileReader(args[0]));
            while((line = br.readLine()) != null)
            calculateline(line);
            
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
    
    private static void calculateline(String input){
        
        String[] values;
        int x;
        int n;
        int reset;
        
        values=input.split(",");
        
        x=Integer.parseInt(values[0]);
        n=Integer.parseInt(values[1]);
        reset = n;
        
        for(int i =1;x>n;i++){
            n=reset;//reset n to inital value, not sure, but there has to be a better way :/
            n*=i;
            
        }
        //debug System.out.println("x: "+x);
       //debug  System.out.println("n: "+n);
        System.out.println(n);
    }
    
}
