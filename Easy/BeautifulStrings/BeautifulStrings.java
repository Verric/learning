/**
 * Created by Verric on 18/06/2014.
 * You found the string that Johnny considered most beautiful. What is the maximum possible beauty of this string?
 * https://www.codeeval.com/open_challenges/83/
 * This one seemed like a lot of work for the "Easy" category
 */

import java.io.*;
import java.util.*;

public class BeautifulStrings {


    public static void main(String[] args) {

        File fn = new File(args[0]);
        BufferedReader br = null;

        List<Integer> ls = new ArrayList<>();

        String line;
        String clean;


        try {
            br = new BufferedReader(new FileReader(fn));

        } catch (FileNotFoundException ex) {
            ex.getStackTrace();
        }

        try {
            while ((line = br.readLine()) != null) {

                clean = getCleanString(line);
                ls.clear();//clear the Collections<Integer> after each iteration so as not to add previous values
                ls.addAll(getSortedMap(clean)); //add only the sorted amount of times a number appeared, we don't care about the char anymore
                System.out.println(printBeautifulResultResult(ls));

            }
        }catch(IOException ex){
            ex.getStackTrace();
            System.exit(1);
        }
    }

    public static int printBeautifulResultResult(List<Integer> ls){

        int max = 26;
        int aggregate = 0;

        for(Integer index : ls){

            aggregate += index*max;
            max--;
        }
        return aggregate;
    }

    public static String getCleanString(String input){

        char[] tmp = input.toLowerCase().toCharArray();

        for (int i = 0;i<tmp.length;i++){

            if(!(Character.isLetter(tmp[i]))){ //if its not a letter replace it with  a space UNICODE default 0020 or %20 (urlencoded)
                tmp[i] = '\u0020';
            }
        }

        String result = new String(tmp).replace(" ", "").trim();

        return result;
    }


    public static Collection<Integer> getSortedMap(String line){

//------------------------------------------------------------------
        List<Character> ls = new ArrayList<>();//easier to add a list to map than char[]
        char[] tmp = line.toCharArray();

        for(Character z : tmp) {
            ls.add(z);
        }
        //System.out.println(ls); //debug output
//-----------------------------------------------------------------
        Map<Character,Integer> basicMap = new HashMap<Character,Integer>();
        sorter srt = new sorter(basicMap);
        Map<Character,Integer> sortedMap = new TreeMap<Character,Integer>(srt);


        for(Character x :ls){ //basic loop to increment number of times a Character appears

            Integer repetitions = basicMap.get(x);

            if(repetitions == null) //could use  new Optional stuff??? meh
                basicMap.put(x,1);

            else
                basicMap.put(x,++repetitions);
        }

        sortedMap.putAll(basicMap); //dump map into sorted map putAll will apply the sorter class that is passed to Treemap
        // System.out.println(sortedMap.values()); //debug output

        return sortedMap.values();
    }



    static class sorter implements Comparator<Character>{ //static class since we reference it from a static environment (getSortedMap)

        private Map<Character,Integer> map;

        public sorter(Map<Character,Integer> map){
            this.map = map;
        }

        public int compare(Character c0, Character c1){

            if (map.get(c0) == map.get(c1))
                return map.get(c0);

            else if(map.get(c0) != map.get(c1))
                return (map.get(c1) - map.get(c0)); //returns largest -> smallest

            else
                return 0 ;
        }
    }
}
