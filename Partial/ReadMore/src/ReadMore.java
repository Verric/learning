import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadMore {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        File fn = new File(args[0]);
        String line;

        try(BufferedReader br = new BufferedReader(new FileReader(fn))){

            while((line = br.readLine()) != null){

                if(line.length() <= 55){
                    sb.append(line.concat("\n"));
                   // System.out.println(line+ " " + line.length());
                }

                else {
                    sb.append(filterLine(line));
                    //System.out.println(filterLine(line) + " " + line.length());
                }
            }

        }catch(IOException ex){
            System.err.println("Error: " + ex.getMessage() + " exiting");
            System.exit(1);
        }

        System.out.print(sb);
    }

    public static String filterLine(String line){

        return line.substring(0,41).trim().concat("... <Read More>\n");
    }
}
