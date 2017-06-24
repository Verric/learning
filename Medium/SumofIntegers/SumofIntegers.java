import java.io.*;

public class SumofIntegers {

   public static void main(String[] args){

       File fn = new File(args[0]);
       String line;

       try(BufferedReader br = new BufferedReader((new FileReader(fn)))) {

           while((line = br.readLine()) != null){
               findBestOutCome(line);

           }

       }catch(IOException ex){
           System.out.println("Got error: " + ex.getMessage() + ", exiting");
           System.exit(1);
       }
   }


    private static void findBestOutCome(String line){

        int aggregate = 0;
        int highsore = Integer.MIN_VALUE; //set highscore as ,min value. this stops a bug where if the largest total was less than 0 it would not produce the correct answer due to line 41

        String[] temp = line.split(",");
        int[] numbers = new int[temp.length];

        for(int i=0; i<temp.length; i++){
            numbers[i] = Integer.parseInt(temp[i]);
        }

        for(int i=0; i<numbers.length;i++){
            aggregate = 0;
            for(int j=i; j<numbers.length; j++){
                aggregate += numbers[j];

                if(aggregate > highsore)
                    highsore = aggregate;
            }
        }
        System.out.println(highsore);
    }
}
