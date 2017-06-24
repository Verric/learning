/*
 * https://www.codeeval.com/open_challenges/23/
 * Print out the grade school multiplication table upto 12*12. 
 */

//package multiplicationtables;

/**
 * @author Verric
 */

public class MultiplicationTables {

    public static void main(String[] args) {
        
        for(int i=1; i <=12;i++){
            
            for(int j=1;j<=12;j++){
                System.out.printf("%4d",(i*j)); //jeez this fkin formatting crap,  poorly documented imho for a newb :/
            }
            System.out.println();
        }
    }
    
}
