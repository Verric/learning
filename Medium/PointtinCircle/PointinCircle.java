import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PointinCircle {


    public static void main(String[] args){

        File fn = new File(args[0]);
        String line;

        try(BufferedReader br = new BufferedReader(new FileReader(fn))){

            while((line = br.readLine()) != null){

                validatePoint(line);

            }

         }catch(IOException ex){
            System.out.println("Error: " + ex.getMessage() + ", exiting");
            System.exit(1);

        }
    }//end main()

    private static void validatePoint(String input){ //butchered the parsing :(


        String temp[];
        double distance;

        input = input.replaceAll("[()]", "");
        input = input.replaceAll(",","");
        input = input.replaceAll(";","");
        temp = input.split(" ");

        double xCircle = Double.parseDouble(temp[1]);
        double  yCircle = Double.parseDouble(temp[2]);
        double radius = Double.parseDouble(temp[4]);
        double xPoint = Double.parseDouble(temp[6]);
        double  yPoint = Double.parseDouble(temp[7]);

        distance = Math.sqrt((Math.pow((xPoint - xCircle),2) + Math.pow((yPoint - yCircle),2))); //logic refined by William Shou, fkin distance formula :/

        if(radius > distance) //if the distance is within the radius, or the radius is greater than the distance, its in the circle
            System.out.println("true");
        else
            System.out.println("false");

    }

}
