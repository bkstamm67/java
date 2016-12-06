/*
 * program:  smallSort
 * author:  Brian Stamm
 * date:  12.3.16
 * description:  Write a program that takes three numbers and sorts their 
 * values into ascending order.  Your code in should prompt the user for the 
 * three values, print them out, call the function to sort them, and then 
 * print them again.
 *   
 * For example, if the user enters: 24, -7 and 15, then the output should 
 * look like this: -7, 15, 24.
 */

package smallSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class smallSort {

	public static void main(String[] args) {
		int a, b, c;
		ArrayList<Integer> array = new ArrayList<>();
		
		System.out.println("This program will ask for 3 whole numbers and "
				+ "then print out those numbers sorted from lowest "
				+ "to largest.\n");
		
		a = getNumber(1);
		array.add(a);		
		b = getNumber(2);
		array.add(b);		
		c = getNumber(3);
		array.add(c);
		
		System.out.println("\nPre-sorted list - ");
		printList(array);
		
		Collections.sort(array);
		
		System.out.println("\nPost-sorted list - ");
		printList(array);
		
		System.out.println("\nThanks for playing.");
		
	}

	private static void printList(ArrayList<Integer> array) {
		int i = 1;
		for(int counter: array){
			System.out.println("Number " + i +": " + counter);
			i++;
		}
		
	}

	private static int getNumber(int num) {
		int userNum;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Number " + num + ": " );
		userNum = scanner.nextInt();
		
		return userNum;
		
	}

}
