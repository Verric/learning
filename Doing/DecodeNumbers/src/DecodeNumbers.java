import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Set;


public class DecodeNumbers {

    static final int MAX = 26;
    static  int SOLUTIONS = 0;

    static Set<String> combinations = new HashSet<>();

    public static void main(String[] args) {

        File fn = new File(args[0]);
        String line;

        try(BufferedReader br = new BufferedReader(new FileReader(fn))){

            while((line = br.readLine()) != null){
                generateCombinations(line);


            }
        }catch (IOException ex){
            System.err.println("Got error: " +  ex.getMessage() + ", exiting");
            System.exit(1);
        }

        convertCombinations(combinations);
    }

    static void generateCombinations(String input){

        int len = input.length();
        String temp;


        combinations.add(input.replace("", " ").trim());
        for(int i=0; i<len; i++){
            temp = input;

            temp = input.substring(0,i).trim()+ " " + input.substring(i).trim();


            for(int j=i; j<=len; j++){
            combinations.add(temp.substring(0, j).trim() + " " + temp.substring(j).trim());
            }

        }

      //  printArray(combinations);
    }

    static void convertCombinations(Set<String> st ){

        int[] numbers = new int[10];
        String[] temp;
        int solutions = 0;

        Iterator<String> iter = st.iterator();
        solutions = 0;
        while ((iter.hasNext())){
            temp = iter.next().trim().split(" ");

            for(int i=0; i <temp.length; i++){
                numbers[i] = Integer.parseInt(temp[i]);
            }

            for(int j=0; j<numbers.length;j++){
                if (numbers[j] > MAX) break;
            }
            solutions++;
            System.out.println(solutions);
        }

       // System.out.println(solutions);

    }

    static void printArray(Set<String> ls){

        for(String s : ls) System.out.println(s);
        System.out.println();
    }

}

