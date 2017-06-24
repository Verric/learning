/**
 * Created by rich on 7/3/14.
 * https://www.codeeval.com/open_challenges/124/
 */


import java.io.*;
import java.util.*;
import java.util.regex.*;

public class RoadTrip {


    public static void main(String[] args){


        File fn = new File(args[0]);
        BufferedReader br = null;
        List<Integer> ls = new ArrayList<>();
        String line;

        try{

            br = new BufferedReader(new FileReader(fn));

        }catch(FileNotFoundException ex){

            System.out.println("Me no find your file");
            System.exit(1);
        }

        try{

            while((line = br.readLine())!= null){

               ls = getSortedValues(line);
               printDistances(ls);
            }

        }catch(IOException ex){
            System.out.println("Error reading file");
            System.exit(1);
        }
    }//end main();


    public static  List<Integer> getSortedValues(String input){

        List<Integer> tmp = new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        String pattern;
        String numbers;

        pattern = "\\d{1,5}"; //only want numbers 1=5 digits long

        Pattern numbersonly = Pattern.compile(pattern);
        Matcher matches = numbersonly.matcher(input);

        while(matches.find()){
            sb.append(matches.group()+ " ");
        }

        numbers = sb.toString().trim();

        for(String x : numbers.split(" ")){

            tmp.add(Integer.parseInt(x));
        }

        Collections.sort(tmp); //sort lowest to highest

        return tmp;
    }


    public static void printDistances(List<Integer> distances){

        StringBuilder sb = new StringBuilder();

        for(int i = 0;i <distances.size();i++){

            if(!(i == 0)){ //place check here as it will only fail once, instead of having to check if i==0 everytime just to fail

                sb.append((distances.get(i)) - distances.get(i-1)+" "); //get current distance subtract the previous
            }

            else
                sb.append(distances.get(0)+" ");
        }

        System.out.println(sb.toString().trim().replace(" ",","));
    }
}
