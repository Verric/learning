/**
 * Created by rich on 6/28/14.
 * The break statement after the else @ line 58
 * breaks for loop so index is reset to 0(as  it goes back to the while loop which re-initialises the for loop,
 * this means the highest denomination is always testes every iteration
 *
 * The continue after the If staemtent @ line 56 pushes the loop to the next lowest denomination as the current denomination would
 * push the "amount" below zero
 */

import java.io.*;

public class MinimumCoins {

    private static final int[] coins = new int[] {5,3,1};

    public static void main(String[] args){

        File fn = new File(args[0]);
        BufferedReader br =null;
        String line;

        try{
            br = new BufferedReader(new FileReader(fn));


        }catch(FileNotFoundException ex){
            System.out.println("Could not find file");
            System.exit(1);
        }


        try{

            while((line = br.readLine())!= null){

                findMinimumCoins(Integer.parseInt(line));

            }


        }catch(IOException ex){
            System.out.println("Error reading File");
            System.exit(1);
        }
    }//end main


    public static void findMinimumCoins(int amount){ //similair logic to "Cash Register" problem

        int count = 0;

        while( amount > 0){

            for(int i = 0;i <coins.length;i++) {

                if ((amount - coins[i]) < 0) {
                    continue;
                } else {
                    amount = amount - coins[i];
                    count++;
                    break;
                }
            }

        }



        System.out.println(count);


    }
}
