/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;

public class NonRepeatedCharacter {


    public static void main(String[] args) {
        
        File fn = new File(args[0]);
        
        BufferedReader br = null;
        String line;
        
        try{
            br = new BufferedReader(new FileReader(fn));
        }catch(FileNotFoundException ex){
            System.out.println("This a file, it no exsist");
        }
        try{
            while((line = br.readLine())!= null){
                printUniqueChar(line);
            }
        }catch(IOException ex){
            System.out.println("Program CBF reading file");
            
            
        }
    }
    
    public static void printUniqueChar(String line){
        int count = 0;
        char theone = '\0';
        Set<Character> uniques = new LinkedHashSet<>();
        char[] letters = line.toCharArray();
//-----------------------------------------------------        
        for(Character x: letters){
            uniques.add(x);
        }
//-------------------------------------------------------
        for(Character p : uniques){
            count = 0;
            for(int i = 0;i <letters.length;i++){
                if(letters[i] == p)
                    count++;
            }
            if(count == 1){
                theone = p;
                break;
            }    
        }
        
        System.out.println(theone);
    }
    
}
