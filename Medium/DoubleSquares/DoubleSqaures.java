import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DoubleSquares {

    private static List<Integer> ls = new ArrayList<>();

    public static void main(String[] args) {

        String line;
        File fn = new File(args[0]);

        try (BufferedReader br = new BufferedReader(new FileReader(fn))) {

            while ((line = br.readLine()) != null) {
                ls.add(Integer.parseInt(line));
            }
        } catch (IOException ex) {
            System.err.println("Got an error, " + ex.getMessage() + ", now exiting");
            System.exit(1);
        }

        //Stupid question wording, the first number read from the file denotes the number of test cases ???
        int N = ls.get(0); //get the number that will tell us how many test cases there are
        for(int i=1; i<=N; i++){
            findFactors(ls.get(i));
        }
    }

    private static void findFactors(int number){

        int count = 0;

        for(int i=0; i<Math.sqrt(number/2); i++){
            if(isperfectSquare(number - (i*i)))
                count++;
        }

        System.out.println(count);


    }

    private static boolean isperfectSquare(int value){


        int root = (int)Math.sqrt(value); // 'value' gets auto casted to a double
        return value == (root*root);
    }
}
