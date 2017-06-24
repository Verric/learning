import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class DataRecovery {

    public static void main(String[] args) {

        String line;
        Path file = Paths.get(args[0]);

        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            while ((line = br.readLine()) != null) {
                recoverData(line);


            }
        } catch (IOException ex) {
            System.err.println("Got error: " + ex.getMessage() + ", exiting");
            System.exit(1);
        }
    }

    private static void recoverData(String line) {

        Map<Integer,String> mp = new TreeMap<>(); //use TreepMap it sorts K in <K,V> automatically, use Integer first since integers have a natural order in java collections
        StringBuilder sb = new StringBuilder();

        String[] message = line.split(";")[0].split(" "); //scrambled message
        String[] temp = line.split(";")[1].split(" "); //numbers

        int[] numbers = new int[temp.length]; //create an int array


        for(int i=0;i<temp.length; i++){ //convert the numbers from type String to type int
            numbers[i] = Integer.parseInt(temp[i]);
        }

        int missing = findMissingOne(numbers.clone()); //there is a sort in the method called as such if we pass the actual refence,
        //it will fk up our loop next hence we pass a shallow copy so we dont alter our original numbers[];

        mp.put(missing,message[message.length-1]); //insert the missing index,it is always mapped to the final string in message[]

        for(int i=0; i<numbers.length;i++){ //inserts the numbers[i] and their respective message[i], the fact its a TreeMap, means
            // it is automatically sorted
            mp.put(numbers[i],message[i]);
        }

        //iterate over the map and print out the values
        for (Map.Entry<Integer, String> entry : mp.entrySet()) {
            sb.append(entry.getValue() + " ");
        }
        System.out.println(sb.toString().trim());

    }

    private static int findMissingOne(int[] missing){

        /*Due to that nature of the question the array numbers will always be from 1,2,3,4,... index.length*/
        Arrays.sort(missing); //sort from lowest to highest

        for(int i=0; i<missing.length;i++){ //missing[0] should equal 1 missing[1] should equal 2 etc.
            if(missing[i] != i+1){ //since i is always 1 behind the value returned from missing[i] we return i +1
                return i+1;
            }
        }
        return missing.length+1; //if we didnt hit a break in the loop, it must be the last value.
    }

}
