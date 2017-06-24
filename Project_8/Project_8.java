/*Find the greatest product of five consecutive digits in the 1000-digit number.
 * https://projecteuler.net/problem=8
 * Answer: 40824, just looked in the sequence :)
 * took 2 hours for what turned out to be a 6 lined for loop :/
 */

package project_8;

/**
 * @author Verric
 */
public class Project_8 {


    public static void main(String[] args) {
        
        int index;           //loop index
        int accumulate;  //temp var for the number being multipled 
        int highest=0;   //stores the highest accumulate calculated
        int counter=0;   //stores the index to start the loop over the string.
        
        final String num = //read only string
"73167176531330624919225119674426574742355349194934" +
"96983520312774506326239578318016984801869478851843" +
"85861560789112949495459501737958331952853208805511" +
"12540698747158523863050715693290963295227443043557" +
"66896648950445244523161731856403098711121722383113" +
"62229893423380308135336276614282806444486645238749" +
"30358907296290491560440772390713810515859307960866" +
"70172427121883998797908792274921901699720888093776" +
"65727333001053367881220235421809751254540594752243" +
"52584907711670556013604839586446706324415722155397" +
"53697817977846174064955149290862569321978468622482" +
"83972241375657056057490261407972968652414535100474" +
"82166370484403199890008895243450658541227588666881" +
"16427171479924442928230863465674813919123162824586" +
"17866458359124566529476545682848912883142607690042" +
"24219022671055626321111109370544217506941658960408" +
"07198403850962455444362981230987879927244284909188" +
"84580156166097919133875499200524063689912560717606" +
"05886116467109405077541002256983155200055935729725" +
"71636269561882670428252483600823257530420752963450";

        while (counter <995){ // the for loop takes care of last 5 iterations as coutner has to be less than 1000
            accumulate =1; //reset accumulate per for loop
            for(index=counter; index <(counter+5);index++){ //iterate over 5 consecutive numbers and multiply them
                char c =num.charAt(index); //gets the individual char in the string at index
                accumulate = accumulate*Character.getNumericValue(c); //retunrs a numeric version of c
                if(accumulate == 0 || accumulate<highest) //go back to top if iteration has a 0 in it
                    continue;
                highest = accumulate; //new top score if we got this far :)               
            }
        counter++; //pushes counter to the next position in the string
        }
    System.out.println("highest: "+highest);
    }   
}
