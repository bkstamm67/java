/**
 * title:  tempConvert.java
 * author:  Brian Stamm
 * date:  9.7.15
 * description:  This will take a user inputted number (C degrees), and convert it
 * to Fahr.
 * */

import java.util.Scanner;
import java.text.DecimalFormat;

public class tempConvert
{
   public static void main(String[] args){
      double celsius, fahr;

      Scanner keyboard = new Scanner(System.in);
      DecimalFormat formatter = new DecimalFormat("0.0");

      System.out.println();
      System.out.println("This program will convert Celcius to Fahrenhuit.");
      System.out.println();

      System.out.print("Celsius temperature to convert: ");
      celsius = keyboard.nextDouble();

      fahr = (celsius * 9) / 5 + 32;

      System.out.println();
      System.out.println("Here it is in Fahrenhiut:  " + formatter.format(fahr));
      System.out.println();
   }
}
