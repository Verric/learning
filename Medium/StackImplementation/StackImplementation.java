/**
 * Created by rich on 6/22/14.
 */

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class StackImplementation {

    public static void main(String[] args) {

        File fn = new File(args[0]);
        BufferedReader br = null;
        String line;


        try {
            br = new BufferedReader(new FileReader(fn));

        } catch (FileNotFoundException ex) {
            System.out.println("Could not find input file");
        }
        try {
            while ((line = br.readLine()) != null){
                printStackOperations(line);
            }
        }catch(IOException ex){
            System.out.println("Could not read file");
        }
    }

    public static void printStackOperations(String line){

        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] numbers;
        String[] values;

//--------------------------------------------------------------------

        values = line.split(" ");
        numbers = new int[values.length];

//------------------------------------------------------------------

        for(int i  = 0; i <values.length;i++){
            numbers[i] = Integer.parseInt(values[i]);
        }

//---------------------------------------------------------------------

    for(int x : numbers){
        stack.push(x);
    }
//-------------------------------------------------------------------

        //System.out.println(stack);
        try {
            for (int i = stack.size(); i > 0; i -= 2) {
                sb.append(stack.pop() + " ");
                stack.pop();
            }
        }catch(NoSuchElementException ex){}
        System.out.println(sb.toString().trim());
  }
}
