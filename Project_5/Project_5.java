/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * https://projecteuler.net/problem=5
 * Answer:232792560
 */



/**
 * @author Verric
 */

public class Project_5 {


    public static void main(String[] args) {
	
        long t1 = gettime();
        long t2;
        boolean keepgoing = true;
        int i = 1;
        
        while(keepgoing){
            for(int j =2; j<=20;j++){
                if ((i%j == 0)){
				
                   //System.out.println("i is:" +i+"j is:"+j); debug liner
                }else{break;}
				
                if(j==20){
                    keepgoing=false;
                    System.out.println(i);
                }
            }i++;  
        }
        t2=gettime();
        System.out.println(((t2-t1)/100)+"ms");
    }
    public static long gettime(){
       return System.currentTimeMillis();
    }
    
}
