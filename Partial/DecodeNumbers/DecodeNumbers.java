import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DecodeNumbers {

    public static void main(String[] args) {
        
        String line;
        Path file = Paths.get(args[0]);
        
        try(BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)){
            
            while((line = br.readLine()) != null){
                printNumPossibilities(line);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    
    private static void printNumPossibilities(String input){
        
        for(int i=0; i < input.length(); i++){
            for(int j = input.length(); j > i;j--){
                System.out.println(input.substring(i,j));
            }
        }
        System.out.println();
    }
}
