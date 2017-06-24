/**
 * Created by rich on 6/27/14.
 * A zero based number is set in the following form: "flag" "sequence of zeroes"
 * "flag" "sequence of zeroes" etc. Separated by a single space.
 * https://www.codeeval.com/open_challenges/149/
 */


import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class JugglingZeroes {

    //private static Scanner sc;

    public static void main(String[] args){

        File fn = new File(args[0]);
        BufferedReader br = null;
        String line;

        try{
            br = new BufferedReader(new FileReader(fn));

        }catch(FileNotFoundException ex){
            System.out.println("Could not find file, now exiting");
            System.exit(1);
        }

        try{

            while((line = br.readLine()) != null){
                getBinaryString(line);
                //getBinaryString2(line);
            }

        }catch(IOException ex){
            System.out.println("Error reading file, now exiting");
        }

    }//end main


    public  static void getBinaryString(String line){

        StringBuilder sb = new StringBuilder();

         Scanner sc = new Scanner(line).useDelimiter(" "); //Scanner, so awesome, no need for arrays :)

        try {
            while (sc.hasNext()) { //while we have a delemited value 00 or 0

                if (sc.next().equals("0")) {
                    sb.append(sc.next());
                } else {
                    sb.append(sc.next().replace("0", "1"));
                }

            }
            System.out.println(Long.parseLong(sb.toString(),2)); //get long from String using radix 2 for binary, using long just 2 be safe or unsigned int
         }catch(NoSuchElementException ex){} // no value after initial 00 or 0 or empty line
    }

}
