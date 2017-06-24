/*
 * You have received a text encoded with Morse code and want to decode it. 
 * https://www.codeeval.com/open_challenges/116/
 */

//package morsecode;


import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class MorseCode {

    private static Scanner sc;
    
    public static void main(String[] args) {

        
        MorseCode mc = new MorseCode();
        
        try{
            sc = new Scanner(new File(args[0]));
            
        }catch(FileNotFoundException ex){
            System.out.println("Could not find input file");
        }
        
        while(sc.hasNextLine()){
            System.out.println(mc.decodeMessage(sc.nextLine()));
        }
    }
    
    public String decodeMessage(String input){
        
        HashMap<String,String> decoder = this.generateMap();
        StringBuilder sb = new StringBuilder();
        String values [] = input.split(" ");
        
        for(String temp :values){
            sb.append(decoder.get(temp));
        }
        return sb.toString().trim().toUpperCase();
    }    
    
    public HashMap<String,String> generateMap(){
        
        HashMap<String,String> map = new HashMap<>();
        //looks pretty, pretty hardcoded :/
        map.put(".-","a");       map.put("-...","b");
        map.put("-.-.","c");     map.put("-..","d");
        map.put(".","e");        map.put("..-.","f");
        map.put("--.","g");      map.put("....","h");
        map.put("..","i");       map.put(".---","j");
        map.put("-.-","k");      map.put(".-..","l");
        map.put("--","m");       map.put("-.","n");
        map.put("---","o");      map.put(".--.","p");
        map.put("--.-","q");     map.put(".-.","r");
        map.put("...","s");      map.put("-","t");
        map.put("..-","u");      map.put("...-","v");
        map.put(".--","w");      map.put("-..-","x");
        map.put("-.--","y");     map.put("--..","z");
        
        map.put("-----","0");    map.put(".----","1");
        map.put("..---","2");    map.put("...--","3");
        map.put("....-","4");    map.put(".....","5");
        map.put("-....","6");    map.put("--...","7");
        map.put("---..","8");    map.put("----.","9");
        
        map.put ("", " "); // so we dont get nulls :)
        return map;
    }
}
