/**
 * Created by rich on 6/30/14.
 */

import java.io.*;

public class SplitTheNumber {


    public static void main(String[] args){

        File fn = new File(args[0]);
        BufferedReader br = null;
        String line;
        int position = 0;
        boolean isPlus = true;


        try{

            br = new BufferedReader(new FileReader(fn));

        }catch(FileNotFoundException ex){
            System.out.println("Me no find your file");
            System.exit(1);
        }

        try{

            while((line = br.readLine())!= null){

                position = getOperatorPosition(line.split(" ")[1]); //get position of operator

                isPlus = getOperatorSign(line.split(" ")[1], position); //get sign of operator as a boolean since we cant convert char to an operator :/

                findSplitNumber(line.split(" ")[0],position,isPlus); //finish the job <(0.o<)


            }

        }catch(IOException ex){
            System.out.println("Error reading file");
            System.exit(1);
        }

    } //end main


    public static void findSplitNumber(String line,int index,boolean toAdd){

        int n0 = Integer.parseInt(line.substring(0,index)); // get the number for the left split based on the index of the operator
        int n1 = Integer.parseInt(line.substring(index, (line.length()))); // get the number for the right split based on the index of the operator
        int result = 0;

        if(toAdd){
            result = n0 + n1;}

        else{
            result = n0 -n1;}

        System.out.println(result);
    }


    public  static int getOperatorPosition(String line){

        char[] tmpArray = line.toCharArray();
        int index = 0;

        for(int i  = 0;i <tmpArray.length;i++) {

            if (!(Character.isLetter(tmpArray[i]))) { //if you're not part of the solution... you're the precipitant
                index = i;
                break;
            }
        }

        return index; //get index at which we didn't a letter, must be the operator
    }


    public static boolean getOperatorSign(String line, int index) { //maybe ambiguous method name for a boolean  return :/

        if (line.charAt(index) == '+')
            return true;
        else
            return false;
    }

}
