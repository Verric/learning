import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args) {

        String line;
        int temp;
        Path file = Paths.get(args[0]);
        int[][] squares;

        try (BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {

            while ((line = br.readLine()) != null) {

                temp = Integer.parseInt(line.split(";")[0]);
                squares =  populateArray(line.split(";")[1], temp);
                
               // printArray(squares);

                System.out.println((!checkRows(squares,4) && !checkColumns(squares,4)) ? "False" : "True");
                //if(!checkSubSquare(fourSquare)); System.out.println("invalid subSquares");

            }
        } catch (IOException ex) {ex.printStackTrace();}
    }

    private static int[][] populateArray(String input, int size) {

        int counter = 0;
        String[] temp = input.split(",");
        int[] numbers = new int[temp.length];
        int[][] sudoku;
        
        if (size == 4)
            sudoku = new int[4][4];
        else 
        sudoku = new int[9][9];
        
        for(int i=0; i <temp.length;i++){
            numbers[i] = Integer.parseInt(temp[i]);
        }
        
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    sudoku[i][j] = numbers[counter];
                    counter++;
                }
            }
        return  sudoku;
    }
    
   /* private static void printArray(int[][] sudoku) {

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }*/
    
    private static boolean checkRows(int[][] squares, int rows){
        boolean isValid = true;
        Set<Integer> hs = new LinkedHashSet<>();

        for(int i=0; i<rows; i++){
            hs.clear();
            for (int j=0; j<rows;j++){
                hs.add(squares[i][j]);
            }
            if(hs.size() != rows){
                isValid = false;
                break;
            }
        }

        return isValid;
    }
    private static boolean checkColumns(int[][] squares, int rows) {
        boolean isValid = true;
        Set<Integer> hs = new LinkedHashSet<>();

        for(int i=0; i<rows; i++){
            hs.clear();
            for (int j=0; j<rows;j++){
                hs.add(squares[j][i]);
            }
            if(hs.size() != rows){
                isValid = false;
                break;
            }
        }

        return isValid;
    }
    
   /* private static boolean checkSubSquare(int[][] squares){
        
        boolean isValid = true;
        int len = (int) Math.sqrt(squares.length);
        boolean rows = true;
        boolean cols = true;
        
        for(int i=0; i <Math.sqrt(squares.length);i++){
            
            for (int j=0; j<Math.sqrt(squares.length);j++){
              rows =  checkRows(squares,len);
              cols  = checkColumns(squares,len);
            }
        }

        return (rows && cols);
    }*/
}
