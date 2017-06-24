/**
 * Created by rich on 7/4/14.
 */

import java.io.*;
import java.util.*;
import java.util.HashSet;

public class Pangrams {

    private static final char[] alphabet = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private static final int len = alphabet.length;

    public static void main(String[] args){

        File fn = new File(args[0]);
        BufferedReader br = null;
        String line;

        try{

            br = new BufferedReader(new FileReader(fn));

        }catch(FileNotFoundException ex){
            System.out.println("Could not find your file");
            System.exit(1);
        }

        try{

            while ((line = br.readLine())!= null){

                printOutstandingLetters(line);
            }

        }catch(IOException ex){
            System.out.println("Error reading file");
            System.exit(1);
        }
    }


    public static void printOutstandingLetters(String line){

        StringBuilder sb= new StringBuilder();
        Set<Character> testSet = new HashSet<>();
        String result;

        line = line.toLowerCase();
        char[] letters = line.toCharArray();

       for(int i = 0;i<letters.length;i++){ //remove duplicate letters in the input line

           testSet.add(letters[i]);
       }

        for(Character x : alphabet){ //for all the chars in alphabet

            if(!(testSet.contains(x))) //if the letter being test is not in the alphabet, add it to sb
                sb.append(x);
        }

        result = sb.toString();

        if(result.isEmpty())
            System.out.println("NULL");

        else
            System.out.println(result);

    }
}
