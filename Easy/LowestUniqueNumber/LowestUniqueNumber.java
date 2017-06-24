/*
 *  A player wins if his number is the lowest unique
 * https://www.codeeval.com/open_challenges/103/
 */

//package lowestuniquenumber;

/**
 * @author Verric
 */

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class LowestUniqueNumber {

    private static Scanner sc;
    
    public static void main(String[] args) {
        
        try{
            sc = new Scanner(new File(args[0]));
        }catch(FileNotFoundException ex){
            ex.getMessage();
        }
        
        while(sc.hasNextLine()){
            findLowestUniqueNum(sc.nextLine());
        }
    }
    
    private static void findLowestUniqueNum(String input){
        List<Integer> unique = new ArrayList<>();
        String[] tmp = input.split(" ");
        int[] values = new int[tmp.length];
        int count;
        
        for(int i = 0; i <tmp.length;i++){
            values[i] = Integer.parseInt(tmp[i]);
        }
        
        for(int i  = 0;i <values.length;i++){
            count = 0;
            for(int  j = 0; j <values.length;j++){
                if (values[i] == values[j])
                    count++;
                if (count > 1){
                    break;
                }
            }
            if (count == 1)
                unique.add(values[i]);
        }
        if(unique.isEmpty())
            System.out.println(0);
        
        else{
            Collections.sort(unique);
            for(int z = 0;z <unique.size();z+=unique.size()){
            System.out.println(input.replace(" ","").indexOf(unique.get(0).toString())+1);
            }
        }
    }
}
