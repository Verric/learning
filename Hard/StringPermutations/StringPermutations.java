import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringPermutations {

    private static List<String> ls = new ArrayList<>();

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        String line;
        Path file = Paths.get(args[0]);

        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            while ((line = br.readLine()) != null) {
                sb.append(getNumbers(line)).append('\n');


            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.print(sb.toString());
    }

    private static String getNumbers(String line) {

        ls.clear();
        StringBuilder sb = new StringBuilder();

        permutate("",line);
        Collections.sort(ls);

        for(String s : ls){
            sb.append(s).append(" ");
        }
        return sb.toString().trim().replace(" ",",");
    }

    private static void permutate(String prefix, String str) {
        int n = str.length();
        if (n == 0) ls.add(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutate(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }

    }
}
