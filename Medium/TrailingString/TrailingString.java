/**
 * Created by Shining Shadows on 14/06/2014.
 * You are given two strings 'A' and 'B'. Print out a 1 if string 'B' occurs at the end of string 'A'. Else a zero.
 * https://www.codeeval.com/open_challenges/32/
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TrailingString {

    private static Scanner sc;

    public static void  main(String[] args){

        String tmp1;
        String tmp2;
        String line;

        try{
            sc = new Scanner(new File(args[0]));

        }catch(FileNotFoundException ex){
            ex.getMessage();
        }

        while(sc.hasNextLine()){

            line =sc.nextLine();
            tmp1 = line.split(",")[0];
            tmp2 = line.split(",")[1];

        printTrailing(tmp1,tmp2);
        }
    }

    private static void printTrailing(String first, String second){

        //System.out.println(first);
       // System.out.println(second);

        if(first.endsWith(second))
            System.out.println("1");
        else
            System.out.println("0");
       // System.out.println();


    }
}
