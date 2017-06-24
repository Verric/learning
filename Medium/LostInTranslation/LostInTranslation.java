/**
 * Created by rich on 6/27/14.
 */

import java.io.*;
import java.util.*;

public class LostInTranslation {


    public static void main(String[] args){

        File fn = new File(args[0]);
        BufferedReader br = null;
        String line;
        Map<Character,Character> map = generateMap();


        try{
            br = new BufferedReader(new FileReader(fn));

        }catch(FileNotFoundException ex){
            System.out.println("Could not find the specified file, now exiting");
            System.exit(1);
        }

        try{

            while((line = br.readLine())!= null){

                DecodeMessage(line, map);

            }

        }catch(IOException ex){
            System.out.println("Error reading file, now exiting");
            System.exit(1);
        }

    }

    public static Map<Character,Character> generateMap(){

        Map<Character,Character> map = new HashMap<Character, Character>();

        map.put('y','a');    map.put('n','b');
        map.put('f','c');    map.put('i','d');
        map.put('c','e');    map.put('w','f');
        map.put('l','g');    map.put('b','h');
        map.put('k','i');    map.put('u','j');
        map.put('o','k');    map.put('m','l');
        map.put('x','m');    map.put('s','n');
        map.put('e','o');    map.put('v','p');
        map.put('z','q');    map.put('p','r');
        map.put('d','s');    map.put('r','t');
        map.put('j','u');    map.put('g','v');
        map.put('t','w');    map.put('h','x');
        map.put('a','y');    map.put('q','z');
        map.put(' ',' ');


        return map;
    }

    public static void DecodeMessage(String line, Map<Character,Character> map){

        StringBuilder sb = new StringBuilder();
        char[] letters = line.toCharArray();

        for(int i = 0;i< letters.length;i++){

            sb.append(map.get(letters[i]));
        }


        System.out.println(sb.toString().trim());
    }
}
