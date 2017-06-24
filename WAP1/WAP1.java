/*
* posted on https://forum.intern0t.org/general-programming-discussions/3768-wap-write-program-challenge.html, challenge #1
* Notes: No Error handling/input validation :/
 */

//package wap1;

/**
 *
 * @author Verric
 */

import java.util.Scanner;

public class WAP1 {

    static Scanner sc = new Scanner(System.in); //user input
    
    public static void main(String[] args) {
        
        System.out.print("Pleas enter a number:");
        int input = sc.nextInt();
        
        while (input > 0){ //swap out for a second for loop??? (for (int j=input; j>0; j--))
            for (int i=input;i > 0; i--){
            System.out.print("*");
            }
        
        input--;
        System.out.println();
        }   
    }
    
}

