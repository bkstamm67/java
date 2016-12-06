/**
 * program:  numGuess.java
 * author:  Brian Stamm
 * date:  9.14.15
 * description:  This will randomly pick a number in a range, and then
 * the user has to guess that number.  Once picked, user wins.
 * */

import java.util.Scanner;
import java.util.Random;

public class numGuess
{
   public static void main(String[] args){
      int number, guess = -1, count = 0;
      Scanner keyboard = new Scanner(System.in);
      Random randomNumbers = new Random();

      number = randomNumbers.nextInt(101);

      System.out.println("\nAnswer:  " + number + "\n");
      
      System.out.println("This is a simple game, where the program will pick a random");
      System.out.println("number between 0 and 100.  If you get it right, you win!\n");
      
      System.out.println("Oh, and we'll help by letting you know if your guess is too");
      System.out.println("high or too low.  Have fun!\n");

      while( guess != number){
	 System.out.print("Your guess:  ");
	 guess = keyboard.nextInt();

	 if(guess > number){
	    System.out.println("Too high, try again!");
	 }
	 if(guess < number){
	    System.out.println("Too low, try again!");
	 }
	 count++;
      }

      System.out.println("\nGreat job, you got it!");
      System.out.println("The winning number is " + number + ".");
      System.out.println("It took you " + count + " tries.\n");
   }
}
