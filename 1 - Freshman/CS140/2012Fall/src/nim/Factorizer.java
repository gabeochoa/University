package nim;
import java.util.Scanner; 
import java.io.File; 
import java.io.FileOutputStream; 
import java.io.PrintWriter; 
import java.io.FileNotFoundException; 
/** 
* A class that illustrates reading from the keyboard and 
* writing to a text file. It also factorizes an integer 
* * @author Gabriel Ochoa
*/ 
public class Factorizer { 
   /** 
    * This method finds the prime factorization of a number 
    * and returns the answer as a String. It uses a StringBuffer 
    * to assemble the string and converts it at the end [this is * the Sun Developers recommended way to build strings] 
    * @param num the number to be factorized 
    * @return a String describing the factorization of the number 
    */ 
   public String factorize (int num) { 
      StringBuffer buff = null; 
      if (num >= 0) { 
         buff = new StringBuffer(); 
      } else { 
         buff = new StringBuffer("-"); 
      } 
      long remaining = Math.abs(num); 
      long divisor = 2; 
      while (divisor < remaining) { 
         while (remaining % divisor == 0) { 
            buff.append(divisor + "x"); 
            remaining /= divisor; 
         } 
         divisor++; 
      } 
      if(remaining > 1) { 
         buff.append(remaining); 
      } else { 
         int length = buff.length(); 
         // remove the last "x" 
         buff.setLength(length - 1); 
      } 
      return buff.toString(); 
   } 
   /** 
    * This is a program that reads integers (of type int). 
    * It also reports in the text file out.txt a description 
    * of what the user did as well as the factorization of the 
    * integer input. 
    * @param args not used 
    * @throws FileNotFoundException 
    */ 
   public static void main(String[] args) throws FileNotFoundException { 
      // open a file in "append mode" -- we can keep adding to it 
      FileOutputStream outfile = new FileOutputStream("out.txt", true); 
      // use a PrintWriter "wrapper" to make the file easier to use 
      PrintWriter output = new PrintWriter(outfile); 
      Factorizer test = new Factorizer(); 
      Scanner keyboard = new Scanner(System.in); 
      String invalidInput = ""; 
      // ----- read an int 
      int inputInt; 
         System.out.print("Enter an int: "); 
         if (keyboard.hasNextInt()) { 
         inputInt = keyboard.nextInt(); 
         System.out.println("You entered " + inputInt + "\n" 
            + "which has the following factorization:\n" 
            + test.factorize(inputInt)); 
         output.println("User entered " + inputInt 
            + "\nwhich has the following factorization:\n" 
            + test.factorize(inputInt)); 
         keyboard.nextLine(); 
      } else { 
         System.out.println("That was not a valid input"); 
         invalidInput = keyboard.nextLine(); 
         output.println("User input \"" + invalidInput + "\" is not an int"); 
      } 
      // ----- end of reading an int 
      output.close(); 
   } 
} 