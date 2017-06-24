import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Locks {

    public static void main(String[] args) {

        String line;
        Path file = Paths.get(args[0]);

        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            while ((line = br.readLine()) != null) {
                findLocks(line.trim());
            }
        } catch (IOException ex) {
            System.err.println("Got an error: " + ex.getMessage() + ", exiting");
            System.exit(1);
        }
    }
    private static void findLocks(String input){

        int counter = 0;
        int numLocks = Integer.parseInt(input.split(" ")[0]);
        int iters = Integer.parseInt(input.split(" ")[1]);

        boolean[] locks = new boolean[numLocks];

        for (int j=0; j<iters-1; j++){ //iterations to iter-1 as the question requests

            for(int i=1; i <numLocks; i+=2){ //close every second door
                locks[i] = true;
            }
            for(int i=2; i<numLocks; i+=3){ //switch state of every third door
                locks[i]= !locks[i];
            }
        }
        locks[numLocks-1] = ! locks[numLocks-1]; // switch the last once once we are finished

        for (boolean b : locks){
            if(!b) counter++; // since true equals locked print all of the non locked lockers
        }
        System.out.println(counter);
    }

}
