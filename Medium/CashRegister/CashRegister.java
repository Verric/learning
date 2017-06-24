/**
 * Created by rich on 6/23/14.
 */


import java.io.*;
import java.math.*;
import java.util.*;

public class CashRegister {


    private static final BigDecimal[] denominations = new BigDecimal[]
            {new BigDecimal(100.00),new BigDecimal(50.00),
            new BigDecimal(20.00),new BigDecimal(10.00), new BigDecimal(5.00),new BigDecimal(2.00),
            new BigDecimal(1.00), new BigDecimal(0.50),new BigDecimal(0.25), new BigDecimal(0.10).setScale(2,BigDecimal.ROUND_HALF_UP),
            new BigDecimal(0.05).setScale(2,BigDecimal.ROUND_HALF_UP), new BigDecimal(0.01).setScale(2,BigDecimal.ROUND_HALF_UP)};

    private static final int len = (int)denominations.length;


    public static void main(String[] args){



        File fn = new File(args[0]);
        BufferedReader br = null;
        String line;
        Map<Double,String> map = generateMap();


        double amount = 0;
        double tender = 0;
//---------------------------------------------------------------------
        try{
            br = new BufferedReader(new FileReader(fn));

        }catch(FileNotFoundException ex){
            System.out.println("Nope no,file no exsist");
        }
//--------------------------------------------------------------------------
        try{
            while((line = br.readLine())!= null){

                amount = Double.parseDouble(line.split(";")[0]);
                tender = Double.parseDouble(line.split(";")[1]);

                if( amount == tender)
                    System.out.println("ZERO");

                if(amount > tender)
                    System.out.println("ERROR");

                if(tender > amount)
                    printChange(amount, tender, map);

            }
//-----------------------------------------------------------------------------

        }catch(IOException ex){
            System.out.println("Something a gonna  wrong reading dis file");
        }

    } //end main()


    public static Map<Double,String> generateMap(){

        Map<Double,String> map = new HashMap<Double, String>();


        map.put(0.01,"PENNY");       map.put(0.05,"NICKEL");
        map.put(0.10,"DIME");        map.put(0.25,"QUARTER");
        map.put(0.50,"HALF DOLLAR"); map.put(1.00,"ONE");
        map.put(2.0,"TWO");          map.put(5.00,"FIVE");
        map.put(10.0,"TEN");         map.put(20.0,"TWENTY");
        map.put(50.00,"FIFTY");      map.put(100.00,"ONE HUNDRED");

        return map;
    }


    public static void printChange(double pamount,double ptender,Map<Double,String> map){



        StringBuilder sb = new StringBuilder();
        BigDecimal amount = new BigDecimal(pamount);
        BigDecimal tender = new BigDecimal(ptender);
        BigDecimal temp = new BigDecimal(0.00);
        BigDecimal change = new BigDecimal(0.00);

        change = tender.subtract(amount).setScale(2,BigDecimal.ROUND_HALF_UP);
        //double change = Math.floor(1000 * rounded + 0.5) / 1000;

        while(change.doubleValue() > 0) {
            temp = change.setScale(2,BigDecimal.ROUND_HALF_UP);

            for(int i = 0; i < len;i++) {

                if (temp.subtract(denominations[i]).doubleValue() < 0) //test the waters
                    continue;
                else{
                    change = change.subtract(denominations[i].setScale(2,BigDecimal.ROUND_HALF_UP));
                    sb.append(map.get(denominations[i].doubleValue()) + ",");
                    break;
                }
            }

        }
        String res = sb.toString();
        res = res.substring(0,res.length()-1);
        System.out.println(res);

    }
}
