/**
 * Created by rich on 6/28/14.
 * so stoopid intelliJ usues 1.7 jdk but uses Java 6 for "language level"
 * ctrl-alt-shift+s to set language level
 */

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class HiddenDigits {

    public static void main(String[] args) {

        Map<Character,Integer> map = generateMap();
        File fn = new File(args[0]);
        BufferedReader br =null;
        String line;
        String converted;

        try{
            br = new BufferedReader(new FileReader(fn));

        }catch(FileNotFoundException ex){
            System.out.println("Me no find your file");
            System.exit(1);

        }

        try{
            while((line = br.readLine())!= null){
                converted = letters2digits(line,map);
                findHiddenDigits(converted);
            }

        }catch(IOException ex){
            System.out.println("Error Reading file");
            System.exit(1);
        }

    }//end main

    public static void findHiddenDigits(String input){

        StringBuilder sb = new StringBuilder();
        String pattern = "\\d";
        String built;

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);

        while(m.find()){
            sb.append(m.group(0));
        }
        built = sb.toString().trim();

        if(built.isEmpty())
            System.out.println("NONE");
         else
            System.out.println(built);
    }


    public static String letters2digits(String line,Map<Character,Integer> map){

        StringBuilder sb = new StringBuilder();
        char[] tmp = line.toCharArray();

        for(int i = 0;i<tmp.length;i++) {

            if (map.containsKey(tmp[i])) {
                sb.append(map.get(tmp[i]));

            } else {
                sb.append(tmp[i]);
            }

        }
        return sb.toString();
    }
    public static Map<Character,Integer> generateMap(){

        Map<Character,Integer> map = new HashMap<>();

        map.put('a',0);    map.put('b',1);
        map.put('c',2);    map.put('d',3);
        map.put('e',4);    map.put('f',5);
        map.put('g',6);    map.put('h',7);
        map.put('i',8);    map.put('j',9);

        return map;
    }

}
