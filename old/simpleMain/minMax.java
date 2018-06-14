/**
 * program:  minMax.java
 * author:  Brian Stamm
 * date:  9.14.15
 * description:  This program will ask user how many numbers they will input
 * and then display back the min and max of the numbers entered.
 * */

import java.util.Scanner;

public class minMax
{
   public static void main(String[] args){
      int low, hi, total, input, count = 1;
      Scanner keyboard = new Scanner(System.in);

      System.out.println();
      System.out.println("This program will ask you for how many numbers you");
      System.out.println("want to input.  After inputting that many numbers, it");
      System.out.println("will print out the min and max of those inputted.");
      System.out.println();
      
      System.out.print("How many numbers do you have to input:  ");
      total = keyboard.nextInt();
      
      System.out.println();
      System.out.println("Inputted numbers -");
      System.out.print(count + ":  ");
      low = keyboard.nextInt();
      hi = low;
      count++;
      while (count <= total){
	 System.out.print(count + ":  ");
	 input = keyboard.nextInt();
	 if (input < low)
	    low = input;
	 if (input > hi)
	    hi = input;
	 count++;
      }

      System.out.println();
      System.out.println("The smallest number inputted:  " + low);
      System.out.println("The largest number inputted:  " + hi);
      System.out.println();
   }
}
