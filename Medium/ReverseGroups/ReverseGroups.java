import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseGroups {

    public static void main(String[] args) {
        
        String line;
        String[] temp;
        Path file = Paths.get(args[0]);
        
        try(BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)){
            
            while((line = br.readLine()) != null){
                
                temp = line.split(";");
                printReversedGroups(temp[0],Integer.parseInt(temp[1]));
                
            }
        }catch (IOException ex){ex.printStackTrace();}
    }

    private static void printReversedGroups(String input, int skip) {
        
        StringBuilder sb = new StringBuilder();
        List<String> ls = new ArrayList<>();
        ls.addAll(Arrays.asList(input.split(",")));
        
        for(int i=0; i+skip-1 < ls.size(); i+=skip){
            for(int j=0; j< skip/2; j++){
                Collections.swap(ls,i+j, i+skip-j-1);
            }
        }
        for(String s : ls){
            sb.append(s).append(" ");
        }
        System.out.println(sb.toString().trim().replace(" ",","));
    }
}
