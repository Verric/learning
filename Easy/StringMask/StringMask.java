import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StringMask {

    public static void main(String[] args) {

        String line;
        Path file = Paths.get(args[0]);
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            while ((line = br.readLine()) != null) {
                sb.append(maskString(line)).append('\n');
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(sb.toString().trim());
    }

    private static String maskString(String input) {

        StringBuilder sb = new StringBuilder();

        char[] word = input.split(" ")[0].toCharArray();
        char[] mask = input.split(" ")[1].toCharArray();

        for (int i = 0; i < word.length; i++) {
            word[i] = mask[i] == '1' ? Character.toUpperCase(word[i]) : word[i];
            sb.append(word[i]);
        }
        return sb.toString().trim();
    }
}
