/*
 * Find the largest word in a sentence, if two words are the same length output the 1st word
 * https://www.codeeval/open_challenges/111/
 */

package longest.word;

/**
 * @author Verric
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LongestWord {

    private static Scanner sc;
    
    public static void main(String[] args) {
        
        try{
            sc = new Scanner(new File(args[0]));
        }catch(FileNotFoundException ex){
            ex.getMessage();
        }
        
        while(sc.hasNextLine()){
            findLongestWord(sc.nextLine());
        }
    }
    
    private static void findLongestWord(String input){
        
        String largestWord =""; //hold largest word found
        String[] values = input.split(" "); //get individual words
        
        for(String temp: values){ //starting to look enhance loop :)
            if(temp.length() >largestWord.length()){ //compare input word to largestWord
                largestWord = temp; //new highscore if ^^ is true :)
            }
        }
        System.out.println(largestWord);
    }
}
