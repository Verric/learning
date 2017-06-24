/* 90% not sure what the corner case is :/ */
import java.util.regex.*;
import java.io.*;

public class FindaSquare {

    public static  void main(String[] args){

        StringBuilder sb =new StringBuilder();
        File fn = new File(args[0]);
        BufferedReader br;
        String line;

         Pattern p = Pattern.compile("\\d+");

        try{

            br = new BufferedReader(new FileReader(fn));

            while((line = br.readLine()) != null){

                Matcher m = p.matcher(line); //we just care about the numbers
                sb.setLength(0); //reset sb every iteration

               while(m.find()) {
                   sb.append(m.group());
               }
                checkSquare(sb.toString());

            }

        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
            System.exit(1);

        }catch(IOException ex){
            System.out.println(ex.getMessage());
            System.exit(1);
        }
    }

    public static void checkSquare(String input){

        int x1,x2,x3,x4;
        int y1,y2,y3,y4;
        int total;
        int test1,test2,test3,test4;

        String[] values = input.split("");

        x1 = Integer.parseInt(values[1]);
        y1 = Integer.parseInt(values[2]);
        x2 = Integer.parseInt(values[3]);
        y2 = Integer.parseInt(values[4]);
        x3 = Integer.parseInt(values[5]);
        y3 = Integer.parseInt(values[6]);
        x4 = Integer.parseInt(values[7]);
        y4 = Integer.parseInt(values[8]);


        test1 = xUpper(x1,x4);
        test2 = xLower(x2,x3);
        test3 = yUpper(y1,y4);
        test4 = yLower(y2,y3);

        total = test1 + test2 + test3 + test4;

        if(((test1 == test2) && (test3 == test4)) && (total != 0)) //check if the  sides are the same length and are not zero 90% :/

            System.out.println("true");
        else
            System.out.println("false");
    }


    public static int xUpper(int x1, int x2){
        return Math.abs(x1 - x2);
    }


    public static int xLower(int x3, int x4){
        return Math.abs(x3 -x4);
    }


    public static int yUpper(int y1, int y2){
        return Math.abs(y1 -y2);
    }


    public static int yLower(int y3, int y4){
        return Math.abs(y3 -y4);
    }


}
