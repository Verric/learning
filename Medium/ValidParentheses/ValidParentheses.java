import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ValidParentheses {

    public static void main(String[] args) {

        String line;
        Path input = Paths.get(args[0]);

        try(BufferedReader br = Files.newBufferedReader(input, StandardCharsets.UTF_8)){

            while ((line = br.readLine()) != null){
                System.out.println(validateParentheses(line));

            }
        }catch (IOException ex){
            System.err.println("Got Error:" + ex.getMessage() + ", exiting");
            System.exit(1);
        }
    }

    private static String validateParentheses(String input){

        String temp = "";
        while (input.length() != temp.length()){ //loop over until input.len == 0 or we hit temp length(other wise infinite loop :( )
            temp = input; //set temp to input to get new length
            input = input.replace("()","").trim().replace("[]","").trim().replace("{}", "".trim()); //replace any well form brackets with nothing
        }

        return (input.length() == 0 ? "True":"False"); //if the brackets are not well formed we will have leftovers
    }
}
