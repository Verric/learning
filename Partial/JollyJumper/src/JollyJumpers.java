import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JollyJumpers {

    public static void main(String[] args) {

        String line;
        Path file = Paths.get(args[0]);

        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            while ((line = br.readLine()) != null) {

                System.out.println(printJolly(line));


            }
        } catch (IOException ex) {
            System.err.println("Got error: " + ex.getMessage() + ", exiting");
            System.exit(1);
        }
    }

    private static String printJolly(String line) {

        List<String> ls = new ArrayList<>();
        ls.addAll(Arrays.asList(line.split("\\s+"))); //split the array on every space

/*         if(checkDigits(ls))
             return "Jolly";*/
        //ls.remove(0); //removes first element of the array

        int[] answer = new int[ls.size()-1];


        for (int i = 0; i < ls.size() - 1; i++) {
            answer[i] = Math.abs(Integer.parseInt(ls.get(i)) - Integer.parseInt(ls.get(i+1))); //get the answers by subtracting the numbers;
        }

        Arrays.sort(answer); //sort from low to high

        for (int i = 1; i <= answer.length - 1; i++) {
            if (answer[i - 1] != answer[i] -1) { //check to see if the previous answer equals this answer minus 1 (see if they're consecutive)
                return "Not jolly";
            }
            break;
        }
        return "Jolly";
    }

/*    private static boolean checkDigits(List<String> ls) {

        List<Integer> num = new ArrayList<>();

        for(String s : ls){
            num.add(Integer.parseInt(s));
        }

        for(Integer i : num){
            if(i < 0 || i > 9) return false;
        }
        return true;
    }*/

}
