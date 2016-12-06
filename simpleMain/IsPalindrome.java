/*
 * program:  isPalindrome
 * author:  Brian Stamm
 * date:  12.3.16
 * description:  This program takes a user entered word and checks if
 * it is a palindrome or not.
 */
package isPalindrome;

import java.util.Scanner;

public class IsPalindrome {

	public static void main(String[] args) {
		String palindrome, check = "";
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("This program will take a word and "
				+ "let you know if it is a palindrome or not.\n");
		System.out.println("Please enter a string: ");
		palindrome = scanner.nextLine();
		
		palindrome.toLowerCase();
		
		for(int i = palindrome.length()-1; i>=0;i--){
			check = check + palindrome.charAt(i);
		}

		if (palindrome.equals(check)){
			System.out.println("It's a palindrome!");
		}
		else{
			System.out.println("Nope, try again.");
		}

	}

}
