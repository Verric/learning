import java.io.*;

public class RollerCoaster {


    public static void main(String[] args){

        File fn = new File(args[0]);
        String line;

        try(BufferedReader br = new BufferedReader(new FileReader(fn)))
        {
            while((line = br.readLine()) != null){

                testMethod2(line);

            }

        }catch(IOException ex){ //FileNotFoundException is subclass of IO hence the IO catches it :/
            System.out.println("\nGot the error: " + ex.getMessage() + " ,now exitting\n");
            System.exit(1);
        }

    }


    private static void testMethod2(String line){

        boolean swap = false; //explicit declaration but meh
        StringBuilder sb = new StringBuilder();
        char[] letters = line.toCharArray();


        for (Character c : letters){

            if(Character.isLetter(c)){

                swap = !swap; //place this in the isletter check as we only want to swap cases on letters not every char

                if(swap){
                    sb.append(Character.toUpperCase(c));
                }else
                    sb.append(Character.toLowerCase(c));

            }else
                sb.append(c);
        }

        System.out.println(sb.toString());
    }
}
