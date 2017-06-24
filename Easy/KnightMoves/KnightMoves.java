import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnightMoves {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        String line;
        Path file = Paths.get(args[0]);

        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            while ((line = br.readLine()) != null) {
                sb.append(findMoves(line.trim())).append('\n');


            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.print(sb.toString());
    }

    private static String findMoves(String input){



        char letter = input.charAt(0);
        short number = (short)Character.getNumericValue(input.charAt(1));

        StringBuilder sb = new StringBuilder();
        List<String> ls = new ArrayList<>();


        ls.add(getTopLeft(letter, number));
        ls.add( getTopRight(letter, number));

        ls.add(getMidTopLeft(letter, number));
        ls.add(getMidTopRight(letter, number));

        ls.add(getMidBotLeft(letter, number));
        ls.add(getMidBotRight(letter, number));

        ls.add(getBotLeft(letter, number));
        ls.add(getBotRight(letter, number));

        Collections.sort(ls);

        for(String s : ls){
            sb.append(s).append(" ");
        }

        return sb.toString().trim();
    }


    private static String getTopLeft(char letter, short number){
        char c = (Character.valueOf((char)(letter-1)));
        short s = (short)(number+2);
        return (c < 'i' && c >='a') && (s > 0 && s < 9) ? c+""+s : "";
    }

    private static String getTopRight(char letter, short number){
        char c = (Character.valueOf((char)(letter+1)));
        short s = (short)(number+2);
        return (c < 'i' && c >='a') && (s > 0 && s < 9) ? c+""+s : "";
    }

    private static String getMidTopLeft(char letter, short number){
        char c = (Character.valueOf((char)(letter-2)));
        short s = (short)(number+1);
        return (c < 'i' && c >='a') && (s > 0 && s < 9) ? c+""+s : "";
    }

    private static String getMidTopRight(char letter, short number){
        char c = (Character.valueOf((char)(letter+2)));
        short s = (short)(number+1);
        return (c < 'i' && c >='a') && (s > 0 && s < 9) ? c+""+s : "";
    }

    private static String getMidBotLeft(char letter, short number){
        char c =(Character.valueOf((char)(letter-2)));
        short s = (short)(number-1);
        return (c < 'i' && c >='a') && (s > 0 && s < 9) ? c+""+s : "";
    }

    private static String getMidBotRight(char letter, short number){
        char c = (Character.valueOf((char)(letter+2)));
        short s = (short)(number-1);
        return (c < 'i' && c >='a') && (s > 0 && s < 9) ? c+""+s : "";
    }

    private static String getBotLeft(char letter, short number){
        char c = (Character.valueOf((char)(letter-1)));
        short s = (short)(number-2);
        return (c < 'i' && c >='a') && (s > 0 && s < 9) ? c+""+s : "";
    }

    private static String getBotRight(char letter, short number){
        char c = (Character.valueOf((char)(letter+1)));
        short s = (short) (number-2);
        return (c < 'i' && c >='a') && (s > 0 && s < 9) ? c+""+s : "";
    }

}
