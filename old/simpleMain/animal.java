/**
 * File:  animal.java
 * Author:  Brian Stamm
 * Date:  9.7.15
 * Description:  This is a basic program that takes input from 
 * user, and prints out to the screen.
 * */

import java.util.Scanner;

public class animal
{

   public static void main(String[] args)
   {
      String userAnim;		//To store user input
      
      //Creates a Scanner object for keyboard input
      Scanner keyboard = new Scanner(System.in);

      //Prints question for user
      System.out.print("What is your favorite animal:  ");
      userAnim = keyboard.nextLine();

      //Prints out user's input
      System.out.println();
      System.out.println("That's really interesting.  My favorite" +
	    " animal is a dog.");
      System.out.println("Here is your favorite animal: " + userAnim);
      System.out.println("Thanks for playing!");
   }
}
