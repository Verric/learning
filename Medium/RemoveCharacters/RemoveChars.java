/**
 * Created by Verric on 13/06/2014.
 */

import java.io.*;

public class RemoveChars {

    public static void main(String[] args){

        BufferedReader br = null;
        String line;
        String phrase;
        String scrubber;


        try{
            br = new BufferedReader(new FileReader(args[0]));

        }catch(FileNotFoundException ex){
            System.out.println("Could not find file specified");
        }

        try{
            while ((line = br.readLine()) != null){
                phrase = line.split(",")[0];
                scrubber = line.split(",")[1];
                printStrippedLines(phrase,scrubber);
        }

        }catch(IOException ex){
            ex.getMessage();
        }

    }

    public static void printStrippedLines(String sentence, String remove){

        char[] rm = remove.trim().toCharArray();

        for(char temp : rm){
            sentence = sentence.replace(Character.toString(temp),"");
        }
        System.out.println(sentence);
    }
}
