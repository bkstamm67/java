/*
 * program:  Hero.java (1 of 2)
 * author:  Brian Stamm
 * date:  12.6.16
 * description:  This creates the Hero object that has basic 
 * attributes.  
 */

package hero;

public class Hero {
	private int hitPoints;
	private int strength;
	private int speed;
	private int money;
	
	public Hero(){
		setHitPoints(1);
		setStrength(1);
		setSpeed(1);
		setMoney(1);
	}
	
	public Hero(int hitPoints){
		setHitPoints(hitPoints);
	}
	
	public Hero(int hitPoints, int strength, int speed, int money){
		setHitPoints(hitPoints);
		setStrength(strength);
		setSpeed(speed);
		setMoney(money);
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public boolean takeDamage(int damage){
		int health = this.hitPoints;
		health -= damage;
		if(health > 0){
			this.hitPoints = health;
			return true;
		}
		else {
			this.hitPoints = 0;
			return false;
		}
	}
	
	public void printStats(){
		System.out.println("Health points:  " + this.hitPoints);
		System.out.println("Strength:  " + this.strength);
		System.out.println("Speed:  " + this.speed);
		System.out.println("Money:  " + this.money);
	}

}
