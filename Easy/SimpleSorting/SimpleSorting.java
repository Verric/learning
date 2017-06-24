/**
 * Created by Verric on 7/10/14.
 */

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class SimpleSorting {

    private static  Scanner sc;
    private static List<BigDecimal> ls;

    public static void main(String[] args){

        File fn = new File(args[0]);
        BufferedReader br = null;
        String line;

        try{
            br = new BufferedReader(new FileReader(fn));

        }catch(FileNotFoundException ex){
            System.out.println("Error finding file");
            System.exit(1);
        }
        try{
            while((line = br.readLine()) != null){
            sortLine(line);
            }
        }catch(IOException ex){}

    }

    public static void sortLine(String input){

        StringBuilder sb = new StringBuilder();
        ls = new ArrayList<BigDecimal>();
        sc = new Scanner(input).useDelimiter(" ");

        while(sc.hasNextDouble()){

            ls.add(sc.nextBigDecimal());
        }

        Collections.sort(ls);

        for(BigDecimal x: ls){
            sb.append(x+" ");
        }

        System.out.println(sb.toString().trim());
    }
}
