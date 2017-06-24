import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CardNumberValidation {

   private static List<Integer> numbers = new LinkedList<>();

    public static void main(String[] args) {
        long x = System.nanoTime();

        String line;
        File fn = new File(args[0]);

        try (BufferedReader br = new BufferedReader(new FileReader(fn))) {

            while ((line = br.readLine()) != null) {
                numbers.clear();
                line = line.replace(" ","");
                parseInput(line);
                DoubleUp();
                filterDigits();
                getAnswer();


            }
        } catch (IOException ex) {
            System.err.println("Got an error, " + ex.getMessage() + ", now exiting");
            System.exit(1);
        }
        System.out.println(System.nanoTime() - x);
    }

    private static void parseInput(String input){ //method takes the input converts and adds it to the array;

        for (int i =0; i <input.length(); i++) {
            numbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }
    }

    private static void DoubleUp(){ //goes through the array starting from the end a double the value of every second number

        int doubled;

        for(int index = numbers.size()-2; index >= 0;index-=2){
            doubled =  2*numbers.get(index);
            numbers.set(index,doubled);
        }
    }

    private static void filterDigits(){ //filters out any double digits from the previous operation

        int filtered;

        for(int i=0; i < numbers.size(); i++){
            filtered = addNumbers(numbers.get(i));
            numbers.set(i,filtered);
        }
    }

    private static int addNumbers(int doubleDigit){ //helper method, adds the two individual digits from a double digit number

        int left;
        int right;

        left = doubleDigit/10;
        right = doubleDigit%10;

        return left+right;
    }

    private static void getAnswer(){ //method obtains the processed sequence adds all the numbers and spits out the answer  pending %10 == 0

        int accum = 0;

        for (Integer number : numbers) {
            accum += number;
        }

        if(accum % 10 == 0){
            System.out.println(1);
        }else
            System.out.println(0);
    }

}
