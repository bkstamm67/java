/**
 * title:  loanPayments.java
 * author:  Brian Stamm
 * data:  9.11.15
 * description:  This program will take user's input to calculate their loan
 * payment.
 * */

import java.util.Scanner;
import java.text.DecimalFormat;
import static java.lang.Math.*;

public class loanPayments
{
   public static void main(String[] args){
      double monthlyInterest, loan, total, monthly, top, bottom, payments;
      //int payments;
      Scanner keyboard = new Scanner(System.in);
      DecimalFormat formatter = new DecimalFormat("0.00"); //Used for formating $ output

      //Basic instructions.
      System.out.println();
      System.out.println("This program will calculate the amounts of" +
	    " a loan payment.");
      System.out.println("What is the monthly interest: ");
      monthlyInterest = keyboard.nextDouble();

      System.out.println("What is the amount of the loan: ");
      loan = keyboard.nextDouble();

      System.out.println("How many payments do you want to pay: ");
      payments = keyboard.nextInt();

      //Prints out user input
      System.out.println();
      System.out.println("Here is your loan information - ");
      System.out.println("Loan Amount:  $" + formatter.format(loan));
      System.out.println("Interest:  " + monthlyInterest + "%");
      System.out.println("Number of Payments:  " + (int)payments);

      //Starts calculations - using P = (R * (R+1)^N)/((R+1)^N - 1) * L
      monthlyInterest *= 0.01;
      monthly = (monthlyInterest * (Math.pow((monthlyInterest + 1.0), payments))/ (Math.pow((monthlyInterest + 1.0), payments) - 1.0)) * loan;
      //Prints results.
      System.out.println("Monthly Payments: $" + formatter.format(monthly));
      total = monthly * payments;
      System.out.println("Total Payments: $" + formatter.format(total));
      System.out.println("Interest Paid: $" + formatter.format((total - loan)));
      System.out.println();

      System.out.println("Thanks for playing....");
      System.out.println();
   }
}
