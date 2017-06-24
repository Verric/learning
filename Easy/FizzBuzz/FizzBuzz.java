import java.io.*;

public class FizzBuzz {

    public static void main(String[] args) {

        String line;
        BufferedReader br = null;//higher scope so the "finally" block can se br.

        try {
            br = new BufferedReader(new FileReader(args[0])); //3 lines in 1 :)
            while ((line = br.readLine()) != null) {
                ProcessLine(line);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Could not find the file specified, please check your parameters");
        } catch (IOException ex) {
            System.out.println("Error reading from buffer stream");
        } finally {
            try {
                if (br != null) { //stops stupid derefence null pointer pop ups :/
                    br.close(); //always close br stream
                }   //cant close null object refernce, or so the myth goes
            } catch (IOException ex) {
                System.out.println("Could not close file reader stream :(");
                ex.printStackTrace();
            }
        }

    }

    private static void ProcessLine(String input) { //through main or it doesnt exist

        String[] values;
        int fizz;
        int buzz;
        int stop;
        StringBuilder sb = new StringBuilder();

        values = input.split("\\s");

        fizz = Integer.parseInt(values[0]);
        buzz = Integer.parseInt(values[1]);
        stop = Integer.parseInt(values[2]);

        for (int i = 1; i <= stop; i++) {
            if ((i % fizz == 0) && (i % buzz == 0)) {
                sb.append(" FB");
            } else if (i % buzz == 0) {
                sb.append(" B");
            } else if (i % fizz == 0) {
                sb.append(" F");
            } else {
                sb.append(" " + i);
            }
        }
        sb.append("\n");//append new line after we've reached our limit
        System.out.println(sb);
    }
}
