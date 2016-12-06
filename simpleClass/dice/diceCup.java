package dice;

import java.util.Random;

public class diceCup {
	private int numDice;
	private int numFaces;
	
	private Boolean check(int num){
		if(num <= 0){
			numDice = 0;
			numFaces = 0;
			return false;
		}
		else{
			return true;
		}
	}
	
	public diceCup(){
		this(1, 2);
	}
	
	public diceCup(int dice){
		if(check(dice)){
			numDice = dice;
			numFaces = 6;
		}
	}
	
	public diceCup(int dice, int faces){
		if(check(dice) || check(faces)){
			numDice = dice;
			numFaces = faces;
		}
	}
	
	public void setNumDice(int numDice){
		this.numDice = numDice;
	}
	
	public void setNumFaces(int numFaces){
		this.numFaces = numFaces;
	}
	
	public int returnNumFaces(){
		return numFaces;
	}
	
	public int returnNumDice(){
		return numDice;
	}
	
	public int rollDice(){
		int total = 0;
		if(numFaces != 0){
			Random random = new Random();
			for(int i =0; i < numDice; i++){
				total += random.nextInt(numFaces) +1;
				}
		}
		return total;
	}

}
