package dice;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int face, dice, roll, times;
		
		System.out.println("This is a simple dice game.");
		System.out.print("How many dice:  ");
		dice = scanner.nextInt();
		System.out.print("How many faces:  ");
		face = scanner.nextInt();
		System.out.print("How many rolls:  ");
		times = scanner.nextInt();
		
		diceCup cup = new diceCup(dice, face);
		
		for(int i= 0; i < times; i++){
			roll = cup.rollDice();
			System.out.println("Here's roll " + (i+1) + ":  " + roll);
		}
		
		System.out.println("\nThanks for playing!");

	}

}
