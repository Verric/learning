/**
 * Created by Verric on 7/12/14.
 */

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;

public class AgeDistribution {

    private static Scanner sc;

    public static void main(String[] args){

        File fn = new File(args[0]);

        try{

            sc = new Scanner(fn);

        }catch(FileNotFoundException ex){
            System.out.println("File Not Found");
            System.exit(1);
        }

        while(sc.hasNextLine()){

            try{
                printStatus(sc.nextInt());

            }catch(NoSuchElementException ex){} //catch blank lines as we are expecting integers from file

        }

    }


    public static void printStatus(int age){

        StringBuilder sb = new StringBuilder();

        if (age >=0 && age <=2) {
            sb.append("Home");
        }

        if (age >=3 && age <=4) {
            sb.append("Preschool");
        }

        if (age >=5 && age <11) {
            sb.append("Elementry school");
        }

        if (age >=12 && age <=14) {
            sb.append("Middle school");
        }

        if (age >=15 && age <=18) {
            sb.append("High school");
        }

        if (age >=19 && age <=22) {
            sb.append("College");
        }

        if (age >=23 && age <=65) {
            sb.append("Work");
        }

        if (age >=66 && age <=100) {
            sb.append("Retirement");
        }

        if(age >100 || age <0) {
            sb.append("This program is for humans");
        }


        System.out.println(sb.toString().trim());

    }
}
