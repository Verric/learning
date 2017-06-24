/*
 * Write a program which swaps letters' case in a sentence. All non-letter characters should remain the same. 
 * https://www.codeeval.com/open_challenges/96/
 */

//package swapcase;

/**
 * @author Verric
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SwapCase {

    
    private static Scanner sc;
    public static void main(String[] args) {
        
        try{
            sc = new Scanner(new File(args[0]));
        }catch(FileNotFoundException ex){
            System.out.println("Could not find input file :(");
        }
        
        while(sc.hasNextLine()){
            System.out.println(swapCase(sc.nextLine()));
        }
    }
    
    //pulled from commons apache StringUtils http://commons.apache.org/proper/commons-lang/apidocs/src-html/org/apache/commons/lang3/StringUtils.html#line.5769
    //important to understand how this works, but no point re-inventing the fking wheel :/
     public static String swapCase(final String str) {
        final char[] buffer = str.toCharArray();

        for (int i = 0; i < buffer.length; i++) {
            final char ch = buffer[i];
            if (Character.isUpperCase(ch)) {
                buffer[i] = Character.toLowerCase(ch);
            } else if (Character.isTitleCase(ch)) {
                buffer[i] = Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                buffer[i] = Character.toUpperCase(ch);
            }
        }
        return new String(buffer);
    }
}
