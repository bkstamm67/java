package com.scg.util;

import java.util.Locale;

/**
* A simple mailing address. Does no validity checking for things like valid states or postal codes. Instances of 
* this class are immutable.
* @author Brian Stamm
*/
public final class Address implements Comparable<Address>{
	private final String streetNumber;
	private final String city;
	private StateCode state;
	private final String postalCode;
	
	/**
	 * Construct an Address.
	 * @param streetNumber - the street number.
	 * @param city - the city.
	 * @param state - the state.
	 * @param postalCode - the postal code.
	 */
	public Address(String streetNumber,String city,StateCode state,String postalCode){
		this.streetNumber = streetNumber;
	    this.city = city;
	    this.state = state;
	    this.postalCode = postalCode;
	}
	
	/**
	 * Get the street number number for this address.
	 * @return the street number.
	 */
	public String getStreetNumber(){
		return streetNumber;
	}
	
	/**
	 * Gets the city for this address.
	 * @return the city.
	 */
	public String getCity(){
		return city;
	}
	
	/**
	 * Get the state for this address.
	 * @return the state.
	 */
	public StateCode getState(){
		return state;
	}
	
	/**
	 * Gets the postal code for this address.
	 * @return the postal code.
	 */
	public String getPostalCode(){
		return postalCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((streetNumber == null) ? 0 : streetNumber.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (state != other.state)
			return false;
		if (streetNumber == null) {
			if (other.streetNumber != null)
				return false;
		} else if (!streetNumber.equals(other.streetNumber))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "%s%n%s, %s %s", streetNumber, city, state, postalCode);
	}

	/**
	 * Orders by state, postalCode, city and streetNumber.
	 * @param other - the Address to be compared.
	 * @return a negative integer, zero, or a positive integer as this object is less than, 
	 * equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(Address other) {
		int answer = 0;
		
		if(this == other) return answer;
		else {
			answer = state.compareTo(other.state);
			if(answer == 0) {
				answer = postalCode.compareTo(other.postalCode);
			}
			if(answer == 0) {
				answer = city.compareTo(other.city);
			}
			if(answer == 0) {
				answer = streetNumber.compareTo(other.streetNumber);
			}
		}
		return answer;
	}
	
}
