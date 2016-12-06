/**
 * file:  ticketIncome.java
 * Author:  Brian Stamm
 * Date:  9.7.15
 * Description:  This is a simple program that calculates the total sales of a 
 * baseball game, where there are 3 different sections.
 * */

import java.util.Scanner;
import java.text.DecimalFormat;

public class ticketIncome
{
   public static void main(String[] args){
      
      double total, secA = 15.00, secB = 12.00, secC = 9.00;
      int totA, totB, totC;

      Scanner keyboard = new Scanner(System.in);
      DecimalFormat formatter = new DecimalFormat("00.00");

      System.out.println();
      System.out.println("This program will calculate the total sales of a baseball game.");
      System.out.println("It will ask the total tickets sold in sections A, B, and C, and");
      System.out.println("then it will print out the total in sales.");
      System.out.println();
      System.out.print("Total in Section A: ");
      totA = keyboard.nextInt();
      System.out.print("Total in Section B: ");
      totB = keyboard.nextInt();
      System.out.print("Total in Section C: ");
      totC = keyboard.nextInt();
      System.out.println();

      System.out.println("Total sales in Section A:  $" + formatter.format((totA * secA)));
      System.out.println("Total sales in Section B:  $" + formatter.format((totB * secB)));
      System.out.println("Total sales in Section C:  $" + formatter.format((totC * secC)));

      System.out.println();

      total = (totA * secA) + (totB * secB) + (totC * secC);
      System.out.println("Total sales:  $" + formatter.format(total));

   }
}
