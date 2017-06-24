import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StringRotation {

    private static Scanner sc;

    public static void main(String[] args){


        File fn = new File(args[0]);
        String line;
        String input;
        String rotated;
        List<String> results;

        try{

            sc = new Scanner(fn);

        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
            System.exit(1);
        }

        while(sc.hasNextLine()){

            line = sc.nextLine();
            input = line.split(",")[0];
            rotated = line.split(",")[1];

            results = generateRotations(input);

            if(results.contains(rotated)){
                System.out.println("True");
            }
            else{
                System.out.println("False");
            }

        }
    }


    public static List<String> generateRotations(String input){

        List<Character> ls = new ArrayList<>();
        List<String> combinations = new ArrayList<>();
        char[] letters = input.toCharArray();

        for(Character x :letters){ //add charArray to the list
            ls.add(x);
        }

        for(int i=0; i <letters.length; i++){ //played with String.substring() for 20 mins and could not figure it out, so just used charArray :(

            ls.add(ls.size(),letters[i]); //append start of the list to the end of the list
            ls.remove(0); //remove the first element
            combinations.add(_CharList2String(ls));
        }

        return combinations;
    }


    private static String _CharList2String(List<Character> ls){ //probs an inbuilt way of doing this

        StringBuilder sb = new StringBuilder();

        for(Character t : ls){
            sb.append(t);
        }

        return sb.toString();
    }
}
