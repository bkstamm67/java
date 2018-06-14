/**
 * file:  randNums.java
 * Author:  Brian Stamm
 * Date:  9.7.15
 * Description:  This program will take 2 user numbers and then
 * display 5 random numbers within the range of those two user
 * numbers.
 * */

import java.util.Random;
import java.util.Scanner;

public class randNums
{
   public static void main(String[] args)
   {
   
      int userA, userB, range, output, count = 1;
      Random randomNumbers = new Random();

      System.out.println("This program will ask for two different");
      System.out.println("numbers, and then it will print out 5 random");
      System.out.println("numbers in between those two numbers.");
      System.out.println();
      System.out.println("Enjoy!");
      System.out.println();

      Scanner keyboard = new Scanner(System.in);
      System.out.println("First number: ");
      userA = keyboard.nextInt();
      System.out.println("Second number: ");
      userB = keyboard.nextInt();

      if (userA > userB)
      {
	 range = userA - userB;
	 while (count != 6){
	    output = randomNumbers.nextInt(range);
	    System.out.println("Random Number " + count + ": " + 
		  (output + userB));
	    count++;
	 }
      }
      else if (userB > userA){
	 range = userB - userA;
	 while (count != 6){
	    output = randomNumbers.nextInt(range);
	    System.out.println("Random Number " + count + ": " + 
		  (output + userA));
	    count++;
	 }
      }
      else
	 System.out.println("Sorry, you inputted the same number.");

      System.out.println();
      System.out.println("That's all folks!");
   }
}
