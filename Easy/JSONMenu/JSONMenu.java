/**
 * Created by rich on 6/26/14.
 *
 * so umm, yeah dunno who JSON is but yeah, regex and repeat
 */

import java.io.*;
import java.util.regex.*;

public class JSONMenu {


    public static void main(String[] args) throws  IOException{

        File fn = new File(args[0]);
        BufferedReader br = null;
        String line;


        try {

            br = new BufferedReader(new FileReader(fn));
        }catch(FileNotFoundException ex) {
            ex.getStackTrace();
        }

         try{
            while((line = br.readLine()) != null){

                findLabel(line);
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }

    } //end main()

    public static void findLabel(String input){

        if(input.isEmpty())
            return;

        String tmp= "0";
        int aggregate = 0;

        String pattern = "Label (\\d{1,})"; // finds "Label" and any following numbers. re{n,}	Matches n or more occurrences of preceding expression.-> \\d{1,}

        Pattern p = Pattern.compile(pattern);

        Matcher m = p.matcher(input);

        while(m.find()) {
            aggregate += Integer.parseInt(m.group(0).substring(5, m.group(0).length()).trim()); //extract number from Label xx and convert to Integer and add it.
        }

        System.out.println(aggregate);

    }
}
