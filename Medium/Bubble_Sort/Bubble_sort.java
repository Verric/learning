import java.io.*;

public class Bubble_sort {

    public static void main(String[] args) {

        File fn = new File(args[0]);
        String line;

        try(BufferedReader br = new BufferedReader(new FileReader(fn))){

            while((line = br.readLine()) != null){
                sort(line);
            }

        }catch(IOException ex){
            System.err.println("Got error: " + ex.getMessage() + ", exiting");
            System.exit(1);
        }
    }

    static void sort(String input){

        int n, c, d, swap, counter =0;
        String temp = input.split("\\|")[0];
        int[] num = new int[temp.length()];
        long iterations = Long.parseLong(input.split("\\|")[1].trim());
        StringBuilder sb = new StringBuilder();

        num = convertArray(temp.split(" "));

        for (c = 0; c < ( num.length - 1 ); c++) {
            if (counter == iterations){break;}
            for (d = 0; d < num.length - c - 1; d++) {
                if (num[d] > num[d+1]) /* For descending order use < */
                {
                    swap     = num[d];
                    num[d]   = num[d+1];
                    num[d+1] = swap;
                }
            }
            counter++;
        }
        for(int i=0; i <num.length;i++){
            sb.append(num[i]+" ");
        }
        System.out.println(sb.toString().trim());

    }

    private static int[] convertArray(String[] input){

        int[] nums = new int[input.length];
        for(int i=0; i <input.length;i++){
            nums[i] = Integer.parseInt(input[i]);
        }
        return nums;
    }
}
