import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class MaxRangeSum {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        String line;
        Path file = Paths.get(args[0]);

        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            while ((line = br.readLine()) != null) {
                sb.append(findMaxRange(line)).append('\n');
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println(sb.toString());
    }

    private static int findMaxRange(String input){


        int highscore = Integer.MIN_VALUE;
        int range = Integer.parseInt(input.split(";")[0]);
        String[] temp =  (input.split(";")[1].split(" "));
        int[] numbers = new int[temp.length];


        for(int i=0;i<temp.length;i++){
            numbers[i] = Integer.parseInt(temp[i]);
        }

        for(int i=0; i<numbers.length-(range-1);i++) {
            int result = add(Arrays.copyOfRange(numbers, i, (i + range)));
            highscore = (result > highscore) ? result : highscore;

        }
        return  0 > highscore ? 0 : highscore;
    }

    private static int add(int[] nums){
        int answer = 0;

        for(Integer i : nums){
            answer+=i;
        }
        return answer;
    }
}
