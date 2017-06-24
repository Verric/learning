/**
 * Hence the difference between the sum of the squares of the first ten 
 *natural numbers and the square of the sum is 3025 − 385 = 2640.
 *Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 *https://projecteuler.net/problem=6
 * Answer:25164150
 */

/**
 * a fairly beat around the bush way, just practicing method calls,
 * more of a "functional procedural" style than OOP :(
 * Could of done it in 1 for loop, to save some time.
 */

/**
 * @author Verric
 */

public class Project_6 {

    
    public static void main(String[] args) {
        
        long f1;
        long f2;
        long f3;
        long t1;
        long t2;
        
        t1 = gettime();
        f1 = sumofthesquares();
        f2 = squareofthesums();
        f3 = diff(f1,f2);
        t2 = gettime();
        
        System.out.println(f2+"-"+f1+"="+f3);
        System.out.println((t2-t1)+"ms");
    }
    public static long sumofthesquares(){
        int i;
        long counter = 0;
        
        for(i =1;i<=100;i++){
            counter+=(i*i);
        }
     return counter;   
    }
    
    public static long squareofthesums(){
        
        int i;
        long counter = 0;
        
        for(i=1;i<=100;i++){
            counter+=i;
        }
    return (counter*counter);    
    }
    
    public static long diff(long v1,long v2){
        return (v2-v1);
    }
    
    public static long gettime(){
        return System.currentTimeMillis();
    }
}
