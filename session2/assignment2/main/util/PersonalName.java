package com.scg.util;

/**
 * Encapsulates the first, middle and last name of a person.
 * @author Brian Stamm
 *
 */
public class PersonalName {
	
	private String lastName;
	private String firstName;
	private String middleName;
	
	/**
	 * Creates a new instance of Name
	 */
	public PersonalName() {
		this("","","");
	}
	
	/**
	 * Construct a PersonalName.
	 * @param lastName - Value for the last name.
	 * @param firstName - Value for the first name.
	 */
	public PersonalName(String lastName, String firstName) {
		this(lastName,firstName,"");
	}
	
	/**
	 * Construct a PersonalName.
	 * @param lastName - Value for the last name.
	 * @param firstName - Value for the first name.
	 * @param middleName - Value for the middle name.
	 */
	public PersonalName(String lastName, String firstName, String middleName) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
	}
	
	/**
	 * Getter for property lastName.
	 * @return Value of property lastName.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Setter for property lastName.
	 * @param lastName - New value of property lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Getter for property firstName.
	 * @return Value of property firstName.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Setter for property first.
	 * @param firstName - Setter for property first.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Getter for property middleName.
	 * @return Value of property middleName.
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Setter for property middleName.
	 * @param middleName - New value of property middleName.
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Calculate the hash code.
	 * @return the hash code value
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		return result;
	}

	/**
	 * Compare names for equivalence.
	 * @param other - the name to compare to
	 * @return true if all the name elements have the same value
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonalName other = (PersonalName) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		return true;
	}

	/**
	 * Create string representation of this object in the format:
	 * "LastName, FirstName MiddleName".
	 * @return the formatted name
	 */
	@Override
	public String toString() {
		if(!middleName.equals("")) {
			return lastName + ", " + firstName + " " + middleName;
		}
		else {
			return lastName + ", " + firstName;
		}
	}
	
}
