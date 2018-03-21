package com.scg.domain;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import com.scg.util.PersonalName;

/**
 * A consultant.
 * @author Brian Stamm
 */
public class Consultant implements Comparable<Consultant>, Serializable{
	
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
		return name.compareTo(other.getName());
	}
	
	/**
	 * Provides customable Serializable functionality for Consultant
	 */
	private static class SerializationProxy implements Serializable {
		/**
		 * class variables 
		 */
		private static final long serialVersionUID = -2799316872787696645L;  
		private String x, y, z;
		
		/**
		 * Constructor
		 * @param consultant
		 */
		SerializationProxy(final Consultant consultant) {
	        final PersonalName name = consultant.getName();
	        x = name.getFirstName();
	        y = name.getMiddleName();
	        z = name.getLastName();
		}
		
		/**
		 * Returns serialized item
		 * @return Consultant
		 */
		private Object readResolve() { 
			return new Consultant(new PersonalName(x,y,z)); 
		}
	}
	
	/**
	 * Writes serialize item 
	 * @return SerializationProxy
	 */
	private Object writeReplace() {
		return new SerializationProxy(this);
	}
	
	/**
	 * Reads serialize item
	 * @param ois ObjectInputStream
	 * @throws InvalidObjectException
	 */
	private void readObject(ObjectInputStream ois) throws InvalidObjectException {
		throw new InvalidObjectException("Proxy required");
	}
	
}
