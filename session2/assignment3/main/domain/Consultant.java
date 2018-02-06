package com.scg.domain;

import com.scg.util.PersonalName;

/**
 * A consultant.
 * @author Brian Stamm
 */
public class Consultant {
	
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
	
}
