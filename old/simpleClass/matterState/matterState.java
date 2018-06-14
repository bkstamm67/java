/**
 * program:  matterState.java
 * used with:  can use e,o.h2o, and ea objects.  To get user
 * input to see freezing/boiling states.
 * author:  Brian Stamm
 * date:  9.14.15
 * description:  This gets user input and tells whether or not the 
 * substance is boiling / freezing point.
 * */

import java.util.Scanner;

public class matterState
{
   public static void main(String[] args){
      
      int temp;
      String state;
      Scanner keyboard = new Scanner(System.in);
      ea ethy = new ea();
      m mer = new m();
      h2o water = new h2o();
      o oxy = new o();

      System.out.println();
      System.out.println("This program will ask for a temperature in F, and then");
      System.out.println("it will inform you the state of various substances.");
      System.out.println();

      System.out.print("Temperature:  ");
      temp = keyboard.nextInt();
      
      System.out.println();
      System.out.println("States of substances -");
      state = ethy.stateEA(temp);
      System.out.println("Ethyl Alcohol:  " + state);
      state = water.stateH2o(temp);
      System.out.println("H2O:  " + state);
      state = mer.stateM(temp);
      System.out.println("Mercury:  " + state);
      state = oxy.stateO(temp);
      System.out.println("Oxygen:  " + state);
      System.out.println();

   }
}
