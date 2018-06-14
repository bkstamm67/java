/*
 * program:  main.java (2 of 2)
 * author:  Brian Stamm
 * date:  12.6.16
 * description:  This uses Box.java and its methods to create 
 * a box object from user's input and return surface area and
 * volume of the object.
 */

package box;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		double h, w, len;
		Scanner scanner = new Scanner(System.in);
		
		//Descriptor for user
		System.out.println("This program will give the volume and "
				+ "surface area of a box.  User will be asked "
				+ "for the box's measurements.\n");
		
		//Get user input
		System.out.print("Height: ");
		h = scanner.nextDouble();
		System.out.print("Width: ");
		w = scanner.nextDouble();
		System.out.print("Length: ");
		len = scanner.nextDouble();
		
		//Create object
		Box box = new Box(h, w, len);
		
		//Report back to user
		System.out.println("\nHere are its measurements - \n");
		System.out.println("Volume:  " + box.getVolume());
		System.out.println("Surface Area:  " + box.getSurfaceArea());
		System.out.println("Thanks!");
		

	}

}
