/**
 * Created by Verric on 13/06/2014.
 *
 * logic was to reverse the input sequence so we could count up, then bump the array by 1, (i.e add 'X' to index 0) so could just reel of the input index
 * being requested
 *
 * https://www.codeeval.com/open_challenges/10/
 * Write a program to determine the Mth to last element of a list.
 */


import java.io.*;
import java.util.*;

public class mtoLast {

    public static void main(String[] args){

        BufferedReader br =null;
        String line;
        int test =0;

        try{
             br = new BufferedReader(new FileReader(args[0]));
        }catch(FileNotFoundException ex){
            ex.getMessage();
        }

        try{
            while((line = br.readLine()) != null){

                String[] tmp = line.split(" ");
                test = Integer.parseInt(tmp[tmp.length-1]);
                tmp = null; //for gc, if ever

                line = line.replace(" ", "");
                char[] data = line.toCharArray(); //prims less memory to deal with than array of Strings

                printElement(data,test);
            }

        }catch(IOException ex){
            ex.getMessage();
        }

    }

    private static void printElement(char[] values,int index){

        List<Character> ls = new ArrayList<Character>();

        for(int i = 0;i <values.length -1;i++){
            ls.add(values[i]); //dont include final number
        }

        if (index <= ls.size() && (index >0)) { //check if index is valid
            Collections.reverse(ls);
            ls.add(0, 'X');//added to bump from 0 based index to 1 based index, well in my mind

            if(index>=10)
                System.out.println(ls.get(index+1));//not sure why, but ls.get(9) always returns the same as ls.get(10) so, if >= 10 bump index by 1

            else
            System.out.println(ls.get(index)); //else simply get the index being requested

        }else ; //exit method
    }
}
