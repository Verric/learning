//ONLY 85 PERCENT NOT SURE WHY CANT SEE EXPECTED RESULTS


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class NumberPairs {

    private static Scanner sc;


    public static void main(String[] args){

        File fn = new File(args[0]);


    try{

        sc = new Scanner(fn);

    }catch(FileNotFoundException ex){
        System.out.println("Error reading file");
        System.exit(1);
    }

        while(sc.hasNextLine()){

            //printPairs(sc.nextLine());
            printPairs2(sc.nextLine());

        }


    }//end main


    public static void printPairs2(String line) {


        int x;
        int y;

        StringBuilder sb = new StringBuilder();
        String output="";

        Set<Integer> unique = new LinkedHashSet<>();


        String[] temp = line.split(";")[0].split(",");
        int[] numbers = new int[temp.length];
        int result = Integer.parseInt(line.split(";")[1]);

        for(int i=0; i <temp.length; i++){
            numbers[i] = Integer.parseInt(temp[i]);
        }

        for (int i = 0; i < temp.length; i++) {
            numbers[i] = Integer.parseInt(temp[i]);
        }

        //logic to solve problem
        for (int i = 0; i < numbers.length; i++) {

            x = numbers[i];

            for (int j = 0; j < numbers.length; j++) {
                y = numbers[j];

                if((x+y) == result){

                    unique.add(x);
                    unique.add(y);
                }
            }
        }

        Iterator<Integer> iter = unique.iterator();

        while((iter.hasNext())) {

            try {
                sb.append(iter.next() + "," + iter.next() + ";");
            }catch(NoSuchElementException ex){}

        }

        output = sb.toString();

        if(output.isEmpty())
            System.out.println("NULL");

        else
            System.out.println(output.substring(0,output.length()-1));

    }
}
