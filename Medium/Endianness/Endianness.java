/*
 * https://www.codeeval.com/open_challenges/15/
 * Write a program to print out the endianness of the system
 */

//package endianness;

/**
 * @author Verric
 */

import java.nio.*;
public class Endianness {

    public static void main(String[] args) {
        

        if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {
            System.out.println("BigEndian");
        }
        
        else {
            System.out.println("LittleEndian");
        }
    }
    
}
