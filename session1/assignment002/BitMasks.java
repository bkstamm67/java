package cp120.assignments.assignment002;

/** 
 * Assignment 2 for class
 * @author Brian Stamm
 * @version 1.0
 */

public class BitMasks {

	private static final int ORIGIN_MASK = 0b0000000000000111;
	private static final int SECURITY_MASK = 0b0000000000011000;
	private static final int DATA_MASK = 0b0000000111100000;
	private static final int COUNT_MASK = 0b0000011000000000;
	private static final int START_MASK = 0b0000100000000000;
	private static final int CONTROL_MASK = 0b1111000000000000;
	
	private static final int ORIGIN_OFFSET = 0;
	private static final int SECURITY_OFFSET = 3;
	private static final int DATA_OFFSET = 5;
	private static final int COUNT_OFFSET = 9;
	private static final int START_OFFSET = 11;
	private static final int CONTROL_OFFSET = 12;
	
	/** 
	 * main method for program, which calls displayResults on bit values
	 * @param args - String array of command line arguments
	 */
	public static void main(String[] args) 
	{
		displayResults(0b0110100100011001);
		displayResults(0b0010101100011101);
		displayResults(0b0110110100011001);
		displayResults(0b0110111100011101);	
	}

	/**
	 * takes in a number and displays its values at specific fields
	 * by passing the constants to a method
	 * @param i - takes an int, with should be a 16 bit number
	 */
	private static void displayResults(int i) 
	{
		System.out.println();
		System.out.println(Integer.toBinaryString(i));
		System.out.println("origin = " + bitFinder(i,ORIGIN_MASK,ORIGIN_OFFSET));
		System.out.println("security = " + bitFinder(i,SECURITY_MASK,SECURITY_OFFSET));
		System.out.println("data = " + bitFinder(i,DATA_MASK,DATA_OFFSET));
		System.out.println("count = " + bitFinder(i,COUNT_MASK,COUNT_OFFSET));
		System.out.println("start = " + bitFinder(i,START_MASK,START_OFFSET));
		System.out.println("control = " + bitFinder(i,CONTROL_MASK,CONTROL_OFFSET));			
	}
	
	/**
	 * takes params and returns the int in a given field of a 16 bit number
	 * @param original - the original bit number
	 * @param mask - the mask used to find the specific bits in a given field
	 * @param offset - the amount the bits need to be shifted to the right
	 * @return the int number located in the field
	 */
	private static int bitFinder(int original, int mask, int offset) 
	{
		int result = original & mask;
		if(offset > 0) {
			result = result >> offset; 
		}
		return result;
	}
}