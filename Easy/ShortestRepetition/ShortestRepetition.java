import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ShortestRepetition {

    public static void main(String[] args) {

        String line;
        Path file = Paths.get(args[0]);

        try(BufferedReader br  = Files.newBufferedReader(file, StandardCharsets.UTF_8)){

            while ((line = br.readLine()) != null){
                printShortestRepetition(line);
            }

        }catch (IOException ex){
            System.err.println("Got error: " + ex.getMessage() + ", exiting");
            System.exit(1);
        }
    }

    private static void printShortestRepetition(String input){

        boolean noleftovers; //if the substring fits perfectly then we know it's a repeating string

        String temp;
        String[] repetitions;

        outer:
        for(int i=1; i<=input.length(); i++){

            temp = input.substring(0,i);
            repetitions = input.split(temp);

            noleftovers = true;
            for (String s : repetitions) {
                if (s.isEmpty()); //if it's empty then the substring fits perfectly into the string
                else {
                    noleftovers = false;
                    break;
                }
            }
            if (noleftovers) { //have to do  a check here otherwise will always print 1
                System.out.println(temp.length());
                break outer;
            }
        }
    }
}
