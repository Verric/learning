//https://projecteuler.net/problem=20
//Answer: 648
//Find the sum of the digits in the number 100!

import java.math.BigInteger;

public class FactorialDigitSum {

    public static void main(String[] args){

        BigInteger fact = new BigInteger("1");
        long sum = 0;

        for(int i=1; i <=100; i++){
            fact = fact.multiply(new BigInteger(String.valueOf(i)));
        }


        String factSt = fact.toString();
        int[] numbers = new int[factSt.length()];

        for(int i=0; i <numbers.length; i++){
            numbers[i] = Integer.parseInt(String.valueOf(factSt.charAt(i)));
        }

        for(int x : numbers){
            sum+=x;
        }

        System.out.println(sum);
    }
}
