/*
 * https://www.codeeval.com/open_challenges/26/
 * Print the size of a file in bytes. 
 */

//package filesize;

/**
 * @author Verric
 */

import java.io.File;


public class FileSize {

    public static void main(String[] args) {
        
        File fn = new File(args[0]);
        System.out.println(fn.length());
    }
    
}
