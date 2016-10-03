package lab01;
import java.util.Scanner;

/**
 * FactorialFunctions computes and shows the factorial of the
 * command line argument.
 * 
 * @author CS 140
 */
public class FactorialFunctions {
   /**
    * Compute the factorial of the input value if the
    * input is positive or zero. If the input is negative the    
    * function returns the <em>erroneous</em> value 1.
    * The code uses a loop with the invariant:
    * retVal = (count-1)!
    * @param input positive or 0 value to compute factorial
    * @return the factorial of the input
    */
   public int factorial1(int input) {
      int retVal = 1;
      int count = 1;
      while (count <= input) {
         retVal = count * retVal;
         count = count + 1;
      }
      return retVal;
   }

   /**
    * Compute the factorial of the input value if the
    * input is positive or zero. If the input is negative the
    * function returns the <em>erroneous</em> value 1.
    * The code uses a loop with the invariant:
    * retVal = (count-1)!
    * The code uses abbreviated operators "*=" and "++".
    * @param input positive or 0 value to compute factorial
    * @return the factorial of the input
    */
   public int factorial2(int input) {
      int retVal = 1;
      int count = 1;
      while (count <= input) {
         retVal *= count;
         count++;
      }
      return retVal;
   }

   /**
    * Compute the factorial of the input value if the
    * input is positive or zero. If the input is negative the
    * function returns the <em>erroneous</em> value 1.
    * The code is a recursive form that allows
    * Kieburtz and Shultis recursion removal by the compiler
    * @param input positive or 0 value to compute factorial
    * @return the factorial of the input
    */
   public int factorial3(int input) {
      int retVal = 1;
      if(input > 1) {
         retVal = input * factorial3(input-1);
      }
      return retVal;     
   }

   /**
    * The main method computes and prints the
    * prints the factorial of the command line
    * argument on the screen.
    * @param args command-line argument should be
    * a single non-negative integer
    */
   public static void main(String[] args) {
      FactorialFunctions testInstance = new FactorialFunctions();
      if (args.length == 0) {
         System.out.println("Usage error: you must " +
         "supply a non-negative integer argument");
      } else {
         Scanner input = new Scanner(args[0]);
         if (input.hasNextInt()) {
            int testValue = input.nextInt();
            if (testValue < 0) {
               System.out.println("Usage error: you must " +
               "not provide a negative integer argument");               
               System.out.println(args[0] + " is negative");
            } else {
               System.out.println(testInstance.factorial1(testValue));
               System.out.println(testInstance.factorial2(testValue));
               System.out.println(testInstance.factorial3(testValue));
            }
         } else {
            System.out.println("Usage error: you must " +
            "provide a non-negative integer argument");               
            System.out.println(args[0] + " is not an integer");
         }
      }
   }
} 