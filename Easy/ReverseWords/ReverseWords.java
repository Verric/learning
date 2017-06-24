/*
 * https://www.codeeval.com/open_challenges/8/
 * Write a program to reverse the words of an input sentence. 
 */

//package reversewords;

/**
 * @author Verric
 */

import java.io.*;

public class ReverseWords {


    public static void main(String[] args) {
        BufferedReader br =null;
        String line;
        
        try{
            br = new BufferedReader(new FileReader(args[0])); //could of gone Scanner again :/ meh
            while ((line = br.readLine()) != null){
                Processline(line);
            }
        }catch(FileNotFoundException ex){
            ex.getMessage();
            
        }catch(IOException ex){
            ex.getMessage();
            
        }finally{
            
            try{
                
                if(br != null)
                    br.close();
                
            }catch(IOException ex){
                ex.getMessage();
            }
        }
                
    }
    
    private static void Processline (String input){
        
        StringBuilder sb = new StringBuilder();
        
        String[] values = input.split(" ");
        sb.setLength(0);
        
        for(int i = values.length-1; i>=0;i--){
            sb.append(values[i]+" ");
        }
        System.out.println(sb);
    }
    
}
