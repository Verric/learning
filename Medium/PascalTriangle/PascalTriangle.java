import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {


    public static  void main(String[] args){

        File fn  =new File(args[0]);
        String line;
        int value;
        StringBuilder sb = new StringBuilder();

        try(BufferedReader br = new BufferedReader(new FileReader(fn))){

            while((line = br.readLine()) != null){

                value = Integer.parseInt(line);

                for(int i=1; i <=value; i++){
                    sb.append(generateRow(i));
                }

                System.out.println(sb.toString().trim());

                sb.setLength(0); //reset sb after every test case
            }

        }catch(IOException ex){
            System.out.println(" Error: " + ex.getMessage() + ", exiting");
            System.exit(1);
        }
    }


    public static String generateRow(int rows){

        StringBuilder sb = new StringBuilder();

       List<Integer> total = new ArrayList<>();
        total.add(1);// add "1" to the left hand column


        for(int i= 1;i <=rows-1;++i){

            List<Integer> currentRow = new ArrayList<>(); //could put this outside the loop and reset it every iteration instead... i think
            currentRow.add(total.get(0));

            for(int j= 1;j < i;++j){

                currentRow.add(total.get(j - 1) + total.get(j));
            }

            currentRow.add(total.get(0)); // add "1"  to the most right-hand column
            total = currentRow;

        }

        for(Integer x : total){
            sb.append(x).append(" ");
        }
        return sb.toString();

    }
}
