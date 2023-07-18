package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;

// Today's topic: testing exceptions
public class Main {

    public static void main(String[] args) {
        // Exceptions: errors that our program may have and how to fix it
        // Checked and unchecked exceptions:
        // Checked - revised by Java's compiler before executing code
        // Unchecked - not revised by Java's compiler before executing code


        //      CHECKED EXCEPTIONS

        readFile("myfile.txt");

        //      UNCHECKED EXCEPTIONS

        String name = null;
        printLength(name);

        System.out.println("The code has reached this line");

        // THROWS

        int[] sampleArray = null;
        try {
            printArray(sampleArray);
        } catch(NullPointerException e){
            System.out.println("Array cannot be null");
        }

        // THROWING EXCEPTIONS

        int a = 9000000;
        int b = 4000000;
        long longProduct = 0;


        try{
            int product = multiply(a,b);
            System.out.println(product);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("Using long version...");
            longProduct = multiply((long) a,(long) b);
            System.out.println(longProduct);
        }

        //  CREATE OUR OWN EXCEPTIONS

        try{
            int result = divide(123,0);
            System.out.println(result);
        } catch (DivideByZeroException e){
            System.out.println(e.getMessage());
        }


    }


    //      CHECKED EXCEPTIONS
    public static void readFile(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            // e is the usual way of naming this error
            System.out.println("That file doesn't exist.");
            // this method prints the print followed to find the error e.printStackTrace();

        } catch (NullPointerException e) {
            System.out.println("Example 2");
        } catch (Exception e) {
            // this is the general exception ("universal exception")
            // not a great practice
            //should be the last exception to be placed
            System.out.println("Something happened");
        }
    }

    public static void printLength(String myString) {
        try {
            System.out.println(myString.length());
        } catch(NullPointerException e) {
            System.out.println("Null Pointer Exception");
        }
    }

    public static void printArray(int [] numArray) throws NullPointerException{
        for (int i = 0; i < numArray.length; i++){
            System.out.println(numArray[i]);
        }
    }

    public static int multiply(int a, int b){
        int product = a * b;
        if (product / a != b){
            throw new IllegalArgumentException("Product of input is too great for int.");
        }
        return a * b;
    }

    public static long multiply(long a, long b){
        long product = a * b;
        return product;
    }

    public static int divide(int a, int b) throws DivideByZeroException {
        if (b == 0){
            throw new DivideByZeroException("You cannot divide by zero.");
        }
        return a / b;
    }
}
