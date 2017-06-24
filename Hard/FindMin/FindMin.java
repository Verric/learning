import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FindMin {

    public static void main(String[] args) {

        String line;
        Path file = Paths.get(args[0]);

        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            while ((line = br.readLine()) != null) {
                findElement(line);

            }
        } catch (IOException ex) {
            System.err.println("Got an error: " + ex.getMessage() + ", exiting");
            System.exit(1);
        }
    }

    private static void findElement(String input) {

        List<Integer> m = new ArrayList<>();
        List<Integer> sub;

        int n, k, a, b, c, r, p;
        String[] temp = input.split(",");

        n = Integer.parseInt(temp[0]);
        k = Integer.parseInt(temp[1]);
        a = Integer.parseInt(temp[2]);
        b = Integer.parseInt(temp[3]);
        c = Integer.parseInt(temp[4]);
        r = Integer.parseInt(temp[5]);

        m.add(a); //add initial value to array

        for (int i = 1; i < k; i++) { //generate all known values of m
            m.add((b * m.get(i - 1) + c) % r); //add them to the array
        }

        for (int j=k; j < n; j++) { //for all values where (k <= j < n)
            sub = m.subList(j-k, j); //create a rotating list (every iteration)
            p = 0;
            while (sub.indexOf(p) != -1) { //loop through until we hit the first valid number in the sublist
                p++;
            }
            m.add(p); //add it to the end of the m values
        }
        System.out.println(m.get(n - 1)); //grab m(n-1) as per the challenge's request
    }
}
