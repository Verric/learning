import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeltaTime {

    public static void main(String[] args) {

        String line;
        File fn = new File(args[0]);

        try(BufferedReader br = new BufferedReader(new FileReader(fn))){

            while((line = br.readLine()) != null){
                    testMethod1(line);
            }
        }catch(IOException | ParseException ex){ //new multi-catch :)
            System.err.println("Got an error, " + ex.getMessage() + ", now exiting");
            System.exit(1);
        }

    }

    public static void testMethod1(String input) throws ParseException{

        String time1 = input.split(" ")[0];
        String time2 = input.split(" ")[1];

        long secs;
        long mins;
        long hours;

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date1 = format.parse(time1);
        Date date2 = format.parse(time2);
        long difference = date2.getTime() - date1.getTime();

        secs = Math.abs(difference / 1000 % 60);
        mins = Math.abs(difference / (60 * 1000) % 60);
        hours = Math.abs(difference / (60 * 60 * 1000) % 60);

        String asecs = String.format("%02d", secs);
        String amins = String.format("%02d", mins);
        String ahours = String.format("%02d", hours);

        System.out.println(ahours +":" + amins + ":" + asecs);
    }
}
//cant use Joda Time nor Apache commons :(