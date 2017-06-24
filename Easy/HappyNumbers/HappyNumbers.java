// ALright i'll tell, pulled isHappy method from rosetta stone http://rosettacode.org/wiki/Happy_numbers#Java

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HappyNumbers {

    private static List<Integer> results = new ArrayList<>();

    public static boolean ishappy(long number){

        long m;
        int digit;
        HashSet<Long> cycle = new HashSet<>();
        while(number != 1 && cycle.add(number)){
            m = 0;
            while(number > 0){
                digit = (int)(number % 10);
                m += digit*digit;
                number /= 10;
            }
            number = m;
        }
        return number == 1;
    }

    private static void printResults(){

        for(Integer i : results){
            System.out.println(i);
        }
    }


    public static void main(String[] args){

        String line;
        File fn = new File(args[0]);

        try(BufferedReader br = new BufferedReader(new FileReader(fn))){

            while((line = br.readLine()) != null){

                if(ishappy(Long.parseLong(line))){
                    results.add(1);
                }
                else{
                    results.add(0);
                }

            }

        }catch(IOException ex){
            System.out.println("Got Error " + ex.getMessage() + " exiting");
            System.exit(1);
        }

        printResults();

    }
}
