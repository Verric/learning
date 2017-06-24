/*
* Demo 1: convert 330.39991833 to funky time format
*
* Degrees is simply the degrees already stated hence
* D = 330 we can obtain by casting the double to a float
*
* to get the minutes get the fractional part of the double
* (0.39991833) and times it by 60 = 23.9950998
* Then we simply get the left hand side of the decimal
* once again we can cast to an int to obtain this
* hence M = 23
*
* We repeat the above for the seconds
* we obtain the fractional part of the double(0.9950998)
* and we multiply it 60
* 60*0.9950998 = 59.705988
* Then we want the left hand side of the decimal
* so we can cast to an int to obtain this
* hence S = 59
*
* so 330.39991833 = 330.23'59"
*
* Or so the legend goes...
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NiceAngels {

    public static void main(String[] args){

        File fn = new File(args[0]);
        String line;


        try(BufferedReader br = new BufferedReader(new FileReader(fn))){

            while((line = br.readLine()) != null){

                convertAngle(Double.parseDouble(line));
            }


        }catch(IOException ex){
            System.out.println("Error: " + ex.getMessage() + " exiting");
            System.exit(1);
        }
    }

    private static void convertAngle(double input){
        int degrees = (int)input;
        int minutes;
        int seconds;

       //these blocks simply 'extract' the fractional part of the double, multiply by 60 and then extract the 'integer' part of the double by casting it to an int
        String temp = String.valueOf(input);
        double d1 = Double.parseDouble("0.".concat(temp.split("\\.")[1]));
        double d2 = d1*60;
        minutes = (int)d2;

        String temp1 = String.valueOf(d2);
        double d3 = Double.parseDouble("0.".concat(temp1.split("\\.")[1]));
        double d4 = d3*60;
        seconds = (int)d4;

        String s1 = String.format("%02d", minutes); //format to fill zeros from the left hand side if needed
        String s2 = String.format("%02d", seconds); // same as above

        System.out.println(degrees + "." + s1 + "'" + s2+ "\"");

    }
}
