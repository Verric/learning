import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GuessTheNumber {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        String line;
        Path file = Paths.get(args[0]);

        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            while ((line = br.readLine()) != null) {
                sb.append(guess(line)).append('\n');
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.print(sb.toString());
    }

    private static String guess(String input){

        String[] commands = input.split(" ");
        int start = Integer.parseInt(commands[0]);

        double low = 0;
        double high = start;
        double mid = 0;

        for(int i=1; i<commands.length;i++){
            mid = Math.ceil((low+high)/2);
            if (commands[i].equals("Higher")){
                low = mid+1;
            } else if(commands[i].equals("Lower")){
                high = mid-1;
            }else break;

        }
        return String.valueOf((int)mid);
    }
}
