import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;

public class FlaviusJosephus {

    private static StringBuilder sb = new StringBuilder();
    private static Deque<Integer> people = new ArrayDeque<>();

    public static void main(String[] args) {

        String line;
        Path file = Paths.get(args[0]);

        try(BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)){

            while ((line=br.readLine()) != null){
                executePrisoners(line);
                clearGlobals();
            }
        }catch (IOException ex){
            System.err.println("Got error: " + ex.getMessage() + ", exiting");
            System.exit(1);
        }
    }

    private static void executePrisoners(String input){

        int prisoners = Integer.parseInt(input.split(",")[0]);
        int skip = Integer.parseInt(input.split(",")[1]);

        for(int i=0; i <prisoners; i++){ //add the people to que to be executed
            people.add(i);
        }
        while (people.size() > 0){ // while there are people still left (alive)

            sb.append(rotateArray(skip, people).pop()).append(" "); // execute the person at the front of the queue
        }
        System.out.println(sb.toString().trim());
    }

    private static Deque<Integer> rotateArray(int skip, Deque<Integer> queue){ //rotates the array to send the ("skip") person to the front

        for(int i=1; i<skip; i++){
            queue.addLast(queue.pop());
        }
        return queue;
    }

    private static void clearGlobals(){ //clears string builder list and Deque
        sb.setLength(0);
        people.clear();
    }
}
