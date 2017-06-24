import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;


public class SlangFlavour {

    private static int counter = 0;
    private static Deque<String> phrases = new ArrayDeque<>();
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) {

        String line;
        Path file = Paths.get(args[0]);

        //Add phrases
        phrases.add(". Awesome!"); //add the last phrase first since we will pop it later on hence the first actual phrase will be ", yeah"
        phrases.add(", yeah!");
        phrases.add(", this is crazy, I tell ya.");
        phrases.add(", can U believe this?");
        phrases.add(", eh?");
        phrases.add(", aw yea.");
        phrases.add(", yo.");
        phrases.add("? No way!");


        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            while ((line = br.readLine()) != null) {

                flavour(line);

            }
        } catch (IOException ex) {
            System.err.println("Got error: " + ex.getMessage() + ", exiting");
            System.exit(1);
        }
        System.out.println(sb.toString().trim());

    }

    private static void flavour(String input){

        char[] chars = input.toCharArray();

        for(Character c : chars){
            if( c == '.' || c == '?' || c == '!'){
                counter++;

                if(counter % 2 == 0){  //replace every second  .?! with a phrase
                    phrases.addLast(phrases.pop()); //rotate the array, essential this just cycles the queue
                    sb.append(phrases.peek()); //use peek so we don't exhaust or queue
                }else sb.append(c); //append if its not every second punctuation.
            }
            else{
                sb.append(c); //append which ever character
            }
        }
        sb.append('\n');
    }

}
