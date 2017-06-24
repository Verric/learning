import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SumToZero {

    public static void main(String[] args) {
        
        String line;
        Path file = Paths.get(args[0]);
        
        try(BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)){
            
            while((line = br.readLine())!= null){
                printSums(line);
                
                
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    private static void printSums(String input){

        List<Integer> numbers = parseInput(input);
        int score = 0;
        
        for(int a = 0; a < numbers.size(); a++){
            for(int b = a+1; b < numbers.size(); b++){
                for(int c = b+1;  c < numbers.size(); c++){
                    for(int d = c+1; d < numbers.size(); d++){
                        if (numbers.get(a) + numbers.get(b) + numbers.get(c) + numbers.get(d) == 0) score++;
                    }
                }
            }
        }

        System.out.println(score);
    }
    
    private static List<Integer> parseInput(String input){
        
        String[] temp = input.split(",");
        List<Integer> ls = new ArrayList<>();
        
        for(String s : temp){
            ls.add(Integer.parseInt(s));
        }
        return ls;
    }
}
