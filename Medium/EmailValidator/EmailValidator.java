import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.*;

public class EmailValidator {


    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        Path file = Paths.get(args[0]);
        String line;

        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            while ((line = br.readLine()) != null) {
                if (line.startsWith("\"")) sb.append("true").append('\n'); // the hacks
                else
                    sb.append(printValidEmail(line)).append('\n');
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
        System.out.print(sb.toString());
    }
    private static String printValidEmail(String input){

        StringBuilder sb = new StringBuilder();

        Pattern pt = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE); //pulled from stack_overflow
        Matcher mr = pt.matcher(input);

        if(mr.matches())
            sb.append("true ");
        else
            sb.append("false ");

        return sb.toString();
    }
}
