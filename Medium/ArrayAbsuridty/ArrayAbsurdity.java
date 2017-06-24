import java.io.*;
import java.util.*;

public class ArrayAbsurdity {

   public static void main(String[] args){

       File fn = new File(args[0]);
       BufferedReader br = null;
       String line;

       try{

           br = new BufferedReader(new FileReader(fn));

           while((line = br.readLine()) != null){

               findDuplicate(Integer.parseInt(line.split(";")[0]),line.split(";")[1]);

           }

       }catch(FileNotFoundException ex){
           System.out.println(ex.getMessage());
           System.exit(1);

       }catch(IOException ex){
           System.out.println(ex.getMessage());
           System.exit(1);
       }

   }

    public static void findDuplicate(int number,String array){

        Set<String> st = new HashSet<>();

       final String[] temp = array.split(",");

        for(String x :temp){

            if(st.add(x)) //returns true if successfully added to the set which cannot hold duplicates by it's nature;
                ; //same as "continue;"

            else //only exactly one incorrect entry per line
                System.out.println(x);
        }
    }
}
