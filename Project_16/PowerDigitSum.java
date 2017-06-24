/*2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
What is the sum of the digits of the number 2^1000?
https://projecteuler.net/problem=16
Answer:1366*/

import java.math.BigInteger;

public class PowerDigitSum {

    public static void main(String[] args) {

        BigInteger bi = new BigInteger("2");
        BigInteger num = bi.pow(1000);

        int answer = 0;

        String s1 = num.toString();
        int[] numbers = new int[s1.length()];

        for(int i=0; i < s1.length(); i++){
            numbers[i] = Integer.parseInt(String.valueOf(s1.charAt(i)));
        }

        for(int x : numbers){
            answer+= x;
        }

        System.out.println(answer);
    }
}
