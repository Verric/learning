import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MatrixRotation {

    public static void main(String[] args) {

        String line;
        Path file = Paths.get(args[0]);

        try(BufferedReader br = Files.newBufferedReader(file, StandardCharsets.UTF_8)){

            while ((line = br.readLine()) != null){
                rotateMatrix(line);
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private static void rotateMatrix(String input){

        StringBuilder sb = new StringBuilder();
        int len = input.replace(" ","").length();
        int matrixLength =(int)Math.sqrt(len);
        int count = 0;

        String[][] matrix = new String[matrixLength][matrixLength];
        String[][] rotatedMatrix = new String[matrixLength][matrixLength];


        String[] values = input.split(" "); //populate array from input
        for(int i=0; i<matrixLength;i++){
            for(int j = 0; j <matrixLength;j++){
                matrix[i][j] = values[count];
                count++;
            }
        }

        for(int i=0; i<matrixLength; i++){ //rotate matrix
            for(int j=matrixLength-1; j>=0; j--){
                rotatedMatrix[i][matrixLength-1-j] = matrix[j][i];
            }
        }
        for(int i =0; i<matrixLength;i++){ //print array
            for(int j=0; j<matrixLength;j++){
                sb.append(rotatedMatrix[i][j]).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
