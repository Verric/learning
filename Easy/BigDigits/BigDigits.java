import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BigDigits {

    private static final List<List<String>> numbers = new ArrayList<>();
    private static final List<String> Zero = new ArrayList<>();
    private static final List<String> One = new ArrayList<>();
    private static final List<String> Two = new ArrayList<>();
    private static final List<String> Three = new ArrayList<>();
    private static final List<String> Four = new ArrayList<>();
    private static final List<String> Five = new ArrayList<>();
    private static final List<String> Six = new ArrayList<>();
    private static final List<String> Seven = new ArrayList<>();
    private static final List<String> Eight = new ArrayList<>();
    private static final List<String> Nine = new ArrayList<>();

    static {generateBigNumbers();} //generate BigNumbers


    public static void main(String[] args) {

        String line;
        Path file = Paths.get(args[0]);


        try(BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)){

            while ((line = br.readLine())!= null){

                numbers.clear();
                processLine(line);

                for(int i=0;i<6;i++){ //controls height
                    for(List<String> s: numbers){ //loops through each row of each number in list
                        System.out.print(s.get(i));
                    }
                    System.out.println();
                }

            }

        }catch (IOException ex){
            System.out.println("Got error: " + ex.getLocalizedMessage()+ ", exiting");
            System.exit(1);
        }
    }

    private static void generateBigNumbers(){

        Zero.add("-**--");
        Zero.add("*--*-");
        Zero.add("*--*-");
        Zero.add("*--*-");
        Zero.add("-**--");
        Zero.add("-----");

        One.add("--*--");
        One.add("-**--");
        One.add("--*--");
        One.add("--*--");
        One.add("-***-");
        One.add("-----");

        Two.add("***--");
        Two.add("---*-");
        Two.add("-**--");
        Two.add("*----");
        Two.add("****-");
        Two.add("-----");

        Three.add("***--");
        Three.add("---*-");
        Three.add("-**--");
        Three.add("---*-");
        Three.add("***--");
        Three.add("-----");

        Four.add("-*---");
        Four.add("*--*-");
        Four.add("****-");
        Four.add("---*-");
        Four.add("---*-");
        Four.add("-----");

        Five.add("****-");
        Five.add("*----");
        Five.add("***--");
        Five.add("---*-");
        Five.add("***--");
        Five.add("-----");

        Six.add("-**--");
        Six.add("*----");
        Six.add("***--");
        Six.add("*--*-");
        Six.add("-**--");
        Six.add("-----");

        Seven.add("****-");
        Seven.add("---*-");
        Seven.add("--*--");
        Seven.add("-*---");
        Seven.add("-*---");
        Seven.add("-----");

        Eight.add("-**--");
        Eight.add("*--*-");
        Eight.add("-**--");
        Eight.add("*--*-");
        Eight.add("-**--");
        Eight.add("-----");

        Nine.add("-**--");
        Nine.add("*--*-");
        Nine.add("-***-");
        Nine.add("---*-");
        Nine.add("-**--");
        Nine.add("-----");


    }

    private static void processLine(String input){

        char[] chars = input.toCharArray();

        for(char c: chars){

            switch (c){

                case '0' : numbers.add(Zero);
                    break;

                case '1' : numbers.add(One);
                    break;

                case '2' : numbers.add(Two);
                    break;

                case '3' : numbers.add(Three);
                    break;

                case '4' : numbers.add(Four);
                    break;

                case '5' : numbers.add(Five);
                    break;

                case '6' : numbers.add(Six);
                    break;

                case '7' : numbers.add(Seven);
                    break;

                case '8' : numbers.add(Eight);
                    break;

                case '9' : numbers.add(Nine);
                    break;

                default: break;

            }
        }
    }
}
