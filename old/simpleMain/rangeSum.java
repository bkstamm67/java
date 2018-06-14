/**
 * program:  rangeSum.java
 * author:  Brian Stamm
 * date:  9.14.15
 * description:  This will take two int's and then add all the ints in between
 * them and then display the total.
 * */

import java.util.Scanner;

public class rangeSum
{
   public static void main(String[] args){
      int a, b, low, hi, total = 0;
      Scanner keyboard = new Scanner(System.in);

      System.out.println();
      System.out.println("This program will ask for two numbers and add those numbers");
      System.out.println("and everything in between.");
      System.out.println();

      System.out.print("First number: ");
      a = keyboard.nextInt();
      System.out.print("Second number: ");
      b = keyboard.nextInt();

      if (a > b){
	 low = b;
	 hi = a;
      }
      else{
	 low = a;
	 hi = b;
      }

      while (hi >= low){
	 total+=low;
	 low++;
      }

      System.out.println();
      System.out.println("The total between " + a + " and " + b + " is:  " + total);
      System.out.println();
   }
}
