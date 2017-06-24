import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WithoutRepetitions {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        String line;
        Path file = Paths.get(args[0]);

        try(BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)){

            while ((line = br.readLine())!= null){
                removeRepetitions(line);
            }
        }catch (IOException ex){
            System.err.println("Got an error: " + ex.getMessage() + ", exiting");
            System.exit(1);
        }
        System.out.println(sb.toString().trim());
    }

    private static void removeRepetitions(String input){

        String temp;

        temp = input.replaceAll("\\s+", " "); //replace "    " with " "
        temp = input.replaceAll("(.)\\1+", "$1"); //matches any char in the string with itself only once and replaces with what ever is in that group

        sb.append(temp).append("\n");
    }
}
