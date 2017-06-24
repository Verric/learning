/**
 * Created by Shining Shadows on 15/06/2014.
 *
 * You are given a list of numbers which is supplemented with positions that have to be swapped.
 *https://www.codeeval.com/open_challenges/112/
 */

import java.util.*;
import java.io.*;


public class SwapElements {


    public static void main(String[] args){

        BufferedReader br = null;
        String line;

        try{
            br = new BufferedReader(new FileReader(args[0]));

        }catch(FileNotFoundException ex){
            ex.getMessage();
        }

        try{
            while((line = br.readLine()) != null){

               String tmp1 = line.split(" : ")[0];
                String tmp2 = line.split(" : ")[1];
                printSwappedList(tmp1,tmp2);
            }
        }catch(IOException ex){
                ex.getMessage();
            }

    }
    private static void printSwappedList(String list, String tokens){


//-----------------Scoped Initializations------------------------
        StringBuilder sb = new StringBuilder();
        String[] tmps;
        int[] values =new int[2];
//------------------Get list to be opoerated on--------------------
        String[] tempArray = list.split(" ");
        List<String> ls = new ArrayList<String>();
        ls.addAll(Arrays.asList(tempArray));
        tempArray = null;
//---------------BAD PRAC (probs) get values 2 b swappped----------
        if(tokens.contains(",")){
            String[] tempParams = tokens.split(", ");
            List<String> vl = new ArrayList<String>();
            vl.addAll(Arrays.asList(tempParams));

            for(String x :vl){
                tmps = x.split("-");
                values[0] = Integer.parseInt(tmps[0]);
                values[1] = Integer.parseInt(tmps[1]);
                Collections.swap(ls,values[0],values[1]);


            }
            for(String b : ls){
                sb.append(b + " ");
            }

        }else {
            tmps = tokens.split("-");
            values[0] = Integer.parseInt(tmps[0]);
            values[1] = Integer.parseInt(tmps[1]);
            Collections.swap(ls,values[0],values[1]);

            for(String a :ls){
                sb.append(a+" ");
            }
        }
//-------------------Print modified List-----------
        System.out.println(sb.toString().trim());
    }
}
