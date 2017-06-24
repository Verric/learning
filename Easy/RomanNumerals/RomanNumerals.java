import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


public class RomanNumerals {

    private static final Map<Integer, String> CARDINAL_RNUMERAL_TABLE = new LinkedHashMap<>();



    public static void main(String[] args){

        File fn = new File(args[0]);
        String line;


        generateMap();

        try(BufferedReader br = new BufferedReader(new FileReader(fn))){

            while((line = br.readLine()) != null){


                convert2Numerals(Integer.parseInt(line));

            }

        }catch(IOException ex){
            System.out.println("Error: " + ex.getMessage() + ", exiting...");
            System.exit(1);
        }

    }


    private static void convert2Numerals(int number){

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, String> convert  : CARDINAL_RNUMERAL_TABLE.entrySet()) { // use iterator ???

            while(number >= convert.getKey()){
                number -= convert.getKey();
                sb.append(convert.getValue());
            }
        }

        System.out.println(sb.toString());
    }

    private static void generateMap(){

        CARDINAL_RNUMERAL_TABLE.put(1000,"M");
        CARDINAL_RNUMERAL_TABLE.put(900,"CM");
        CARDINAL_RNUMERAL_TABLE.put(500,"D");
        CARDINAL_RNUMERAL_TABLE.put(400,"CD");
        CARDINAL_RNUMERAL_TABLE.put(100,"C");
        CARDINAL_RNUMERAL_TABLE.put(90,"XC");
        CARDINAL_RNUMERAL_TABLE.put(50,"L");
        CARDINAL_RNUMERAL_TABLE.put(40,"XL");
        CARDINAL_RNUMERAL_TABLE.put(10,"X");
        CARDINAL_RNUMERAL_TABLE.put(9,"IX");
        CARDINAL_RNUMERAL_TABLE.put(5,"V");
        CARDINAL_RNUMERAL_TABLE.put(4,"IV");
        CARDINAL_RNUMERAL_TABLE.put(1,"I");

    }
}
