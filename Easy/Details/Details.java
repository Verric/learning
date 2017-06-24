
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Details {

    private static int i = 0;

    public static void main(String[] args) {

        String line;
        Path file = Paths.get(args[0]);

        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            while ((line = br.readLine()) != null) {
               findDetails(line.trim());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void findDetails(String input){

        int count;
        int lowscore = 1000;

        String[] details = input.split(",");

        for(String s : details){
            count = ((s.indexOf('Y')-s.lastIndexOf('X'))-1);
            lowscore = count < lowscore ? count : lowscore;
        }
        System.out.println(lowscore);

    }
}
