/**
 * Created by rich on 6/25/14.
 *
 * Changed approach, previously i checked each individual number and the number of imes it appears. Changed this to simply generate the number the number,
 * it then compares this to the original number, this is way less efficient but i feel offers greater accuracy of the result..
 */

import java.io.*;

public class SelfDescribingNumber {


    public static void main(String[] args){

        File fn = new File(args[0]);
        BufferedReader br = null;
        String line;

//---------------------------------------------------------------
        try{
            br = new BufferedReader(new FileReader(fn));
        }catch(FileNotFoundException ex){
            System.out.println("Cant find file you requested");
            System.exit(1);
        }
//---------------------------------------------------------------------
        try{
            while((line = br.readLine()) != null){

                int[] numbers = getIntArray(line);
                findSDN(numbers,Integer.parseInt(line));

            }
        }catch(IOException ex){
            System.out.println("Error reading file");
            System.exit(1);
        }
//-------------------------------------------------------------------
    }//end main


    public static void findSDN(int[] numbers,int input){

        StringBuilder sb = new StringBuilder();
        String tmp;
        int count  = 0;
        int theOne = 0;
//-------------------------------------------------------
        for(int i = 0;i <numbers.length;i++) {

            count = 0;
            for (int j = 0; j < numbers.length; j++) {

                if (numbers[j] == i)
                    count++;
            }

            sb.append(count);

        }

        tmp = sb.toString().trim();

        if(Integer.parseInt(tmp) == input)
            System.out.println(1);

        else
            System.out.println(0);

    }


    public static int[] getIntArray(String line){

        char[] x = line.toCharArray();
        int[] numArray = new int[x.length];

        for (int i = 0; i <x.length;i++){
            numArray[i] = Character.getNumericValue(x[i]);
        }
        return numArray;
    }
}
