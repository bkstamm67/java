/*
 * program:  hailstone
 * author:  Brian Stamm
 * date:  12.3.16
 * description:  This program takes a user entered number and tells
 * the user how many steps it takes to get to one using the hailstone
 * sequence, which is if the number is even, divide by 2.  Else,
 * then you multiple by 3 and add 1.
 */

package hailstone;

import java.util.Scanner;

public class Hailstone {

	public static void main(String[] args) {
		
		int steps, hailstone;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("This program will tell you how "
				+ "many steps it takes to get to reach 1 "
				+ "when using a hailstone sequence.");
		
		System.out.print("Enter a number:  ");
		hailstone = scanner.nextInt();
		
		steps = hailstoneSteps(hailstone);
		
		System.out.println("Here is how many steps:  " + steps);

	}

	private static int hailstoneSteps(int hailstone) {
		int counter = 0;
		while(hailstone != 1){
			if((hailstone%2) == 0){
				hailstone = hailstone/2;
				counter += 1;
			}
			else{
				hailstone = (hailstone * 3) + 1;
				counter +=1;
			}
		}
		return counter;
	}

}
