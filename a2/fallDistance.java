/**
 * file:  fallDistance.java
 * author:  Brian Stamm
 * date:  9.15.15
 * description:  This program will ask user for an input and then plug it
 * into the equation d = 1/2*g*t^2 and return a value to the user.
 * */

import java.util.Scanner;
import static java.lang.Math.*;
import java.text.DecimalFormat;

public class fallDistance
{
   public static void main(String[] args){
      double d, t, g = 9.8;
      Scanner keyboard = new Scanner(System.in);
      DecimalFormat formatter = new DecimalFormat("0.00");

      System.out.println("\nThis program will calculate the distance an object falls");
      System.out.println("after you inform the program the amount of time it has fallen.\n");

      System.out.print("How long has the object has fallen:  ");
      t = keyboard.nextDouble();

      d = Math.pow(t, 2.0) * 0.5 * g;

      System.out.println("\nHere is the distance the object traveled:  " + formatter.format(d) + "\n");
      System.out.println("Thanks!\n");
   }
}
