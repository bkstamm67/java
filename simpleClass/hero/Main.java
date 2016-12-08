/*
 * program:  Main.java (2 of 2)
 * author:  Brian Stamm
 * date:  12.6.16
 * description:  This uses Hero.java and its methods to create 
 * a hero object from user's input.  From that, a simple game
 * happens.
 */

package hero;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int hp, str, sp, m, damage;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("This is a game.");
		System.out.print("Health:  ");
		hp = scanner.nextInt();
		System.out.print("Strength:  ");
		str = scanner.nextInt();
		System.out.print("Speed:  ");
		sp = scanner.nextInt();
		System.out.print("Money:  ");
		m = scanner.nextInt();
		
		Hero hero = new Hero(hp, str, sp, m);
		boolean alive = hero.takeDamage(0);
		while(alive){
			System.out.print("How much damage:  ");
			damage = scanner.nextInt();
			alive = hero.takeDamage(damage);
			hero.printStats();
		}
		
		System.out.println("Oh no!  Your hero died!");
		}

}
