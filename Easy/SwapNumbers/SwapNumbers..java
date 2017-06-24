import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SwapNumbers {

    public static void main(String[] args) {

        String line;
        Path file = Paths.get(args[0]);
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            while ((line = br.readLine()) != null) {
                sb.append(swapNumbers(line)).append('\n');
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(sb.toString());
    }

    private static String swapNumbers(String input) {

        StringBuilder sentenceBuilder = new StringBuilder();

        String[] words = input.split(" ");

        for (String word : words) {
            //keep it in char array, we could do the same thing with StringBuilder however as memory consumption is being tested
            // hopefully this will reduce it even by a marginal amount (other wise we had have to create 3 string to swap the chars around... i think)
            char[] letters = word.toCharArray();

            //el classico swapping of elements in arrays
            char temp = letters[0];
            letters[0] = letters[letters.length - 1];
            letters[letters.length - 1] = temp;

            sentenceBuilder.append(letters).append(' '); //append the char array and not 'new String(letters);'
        }
        return sentenceBuilder.toString().trim(); //returned the trimmed string since we can't have trailing whitespaces
    }
}
