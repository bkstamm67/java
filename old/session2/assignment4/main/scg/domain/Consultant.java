package com.scg.domain;

import com.scg.util.PersonalName;

/**
 * A consultant.
 * @author Brian Stamm
 */
public class Consultant implements Comparable<Consultant>{
	
	private final PersonalName name;
	
	/**
	 * Creates a new instance of Consultant.
	 * @param name - the consultant's name.
	 */
	public Consultant(final PersonalName name) {
		this.name = name;
	}
	
	/**
	 * Getter for property name.
	 * @return Value of property name.
	 */
	public final PersonalName getName() {
		return this.name;
	}

	/**
	 * Returns the string representation of the consultant's name.
	 * @return the consultant name string
	 */
	@Override
	public String toString() {
		return name.toString();
	}

	/**
	 * Compares this Consultant object with the specified object for order. Returns a 
	 * negative integer, zero, or a positive integer as this object is less than, equal to, 
	 * or greater than the specified object, the consultant name is used to perform the comparison.
	 * @param other - the Object to be compared.
	 * @return a negative integer, zero, or a positive integer as this object is less than, 
	 * equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(Consultant other) {
		/*int answer = 0;
		
		String thisName = name.toString();
		String otherName = other.toString();
		
		answer = thisName.compareTo(otherName);
		
		return answer;
		*/
		return name.compareTo(other.getName());
	}
	
}
