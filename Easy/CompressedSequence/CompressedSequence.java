/**
 * Created by Verric on 7/10/14.
 */

import java.io.*;

public class CompressedSequence {

    public static void main(String[] args){

        File fn = new File(args[0]);
        BufferedReader br = null;
        String line;

        try{
            br = new BufferedReader(new FileReader(fn));

        }catch(FileNotFoundException ex){
            System.out.println("Error finding file");
            System.exit(1);
        }

        try{

            while((line=br.readLine())!= null){
                printCompressedSequence(line);
            }

        }catch(IOException ex){
            System.out.println("Error reading file");
        }

    }

    public static void printCompressedSequence(String input) {


        StringBuilder sb = new StringBuilder();
        String[] tmp = input.split(" ");
        int[] numbers = new int[tmp.length];
        int count = 1;
        int currentNumber=0;

        for(int i=0; i<tmp.length; i++){
            numbers[i] = Integer.parseInt(tmp[i]);
        }

        for(int i =0; i<numbers.length;i++){ //loop through the array

            currentNumber = numbers[i]; //get the current number

                if( i == (numbers.length-1)){ //if we hit the final element in the array we use this if statement as the other checks for i+1 instead of just i.
                    if (currentNumber == numbers[i]) {

                        sb.append(count + " " + currentNumber + " ");
                        count = 1;//reset count to
                    }
                }


               else if (currentNumber == numbers[i+1]) //if the current number equals the next increase the count and continue.
                    count++;

                else {
                    sb.append(count + " " + currentNumber + " "); //if we hit a different number print the count and value of the previous value
                    count = 1; //reset count to 1
                }
        }

        System.out.println(sb.toString().trim());// god spede sire
    }
}
