/*
* Challenge 2: Run the Fibonacci sequence upto (and including) as user specified number.
* uses a  input prompt rather than argv's (easier and cleaner interaction, imho)
* no error handling, 
* Expected output for an input of 8.
*Please enter a number to stop at:8
* 1
* 2
* 3
* 5
* 8
*/

/*
 * @author Verric
 */

import java.util.Scanner;

public class WAP2 {

    static Scanner sc = new Scanner(System.in); // might as well make it accessible to whole class.
    
    public static void main(String[] args) {
        
        int input;
        int x = 0;
        int y = 1;
        int result = 0;
        
        System.out.print("Please enter a number to stop at:");
        if (sc.hasNextInt()){
            
            input = sc.nextInt();
            sc.close(); // dont really have to but good practice i guess.
            do{
                result = x+y;
                x=y;
                y=result;
                System.out.println(result);
            } while (result <= (input-x));
        }
        
        else{
            System.out.println("You did not enter a number,bye!");
            }
        }
        
    }
