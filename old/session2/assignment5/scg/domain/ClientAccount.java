package com.scg.domain;

import java.util.Formatter;

import com.scg.util.Address;
import com.scg.util.PersonalName;

/**
 * Encapsulates the information for a billable client account.
 * @author Brian Stamm
 */
public final class ClientAccount implements Account, Comparable<ClientAccount>{

	private static final long serialVersionUID = -6449774237712483374L;
	private PersonalName contact;
	private final String name;
	private Address address;
	
	/**
	 * Creates a new instance of ClientAccount
	 * @param name - String with the name of the client.
	 * @param contact  - Name of the contact person for this client.
	 * @param address - Address of this client.
	 */
	public ClientAccount(final String name, PersonalName contact,Address address) {
		this.contact = contact;
		this.name = name;
		this.address = address;
	}
	/**
	 * Getter for property address.
	 * @return value of property address.
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * Setter for property address
	 * @param address - New value of property address.
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * Gets the contact for this account.
	 * @return Value of property contact.
	 */
	public PersonalName getContact() {
		return contact;
	}
	
	/**
	 * Gets the account name.
	 * @see in interface Account
	 * @return Value of property name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Determines if this account is billable
	 * @see isBillable in interface Account
	 * @return always true.
	 */
	public boolean isBillable() {
		return true;
	}
	
	/**
	 * Setter for property contact.
	 * @param contact - New value of property contact.
	 */
	public void setContact(PersonalName contact) {
		this.contact = contact;
	}
	
	/**
	* String representation for this Client.
	* @return Formatted string of ClientAccount
	*/
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		ft.format("%s\n%s\n%s\n", name,address.toString(),contact.toString());
		ft.close();
		return sb.toString();
	}

	/**
	 * Compares this Client with the specified Client for order, ordering by name, contact, 
	 * and finally address. Returns a negative integer, zero, or a positive integer as this 
	 * Client is less than, equal to, or greater than the specified Client.
	 * @param other - the Client to be compared.
	 * @return a negative integer, zero, or a positive integer as this Client is less than, 
	 * equal to, or greater than the specified Client.
	 */
	@Override
	public int compareTo(ClientAccount other) {
		int answer = 0;
		if(this == other) return answer;
		else {
			answer = name.compareTo(other.getName());
			if(answer == 0) {
				answer = contact.compareTo(other.getContact());
			}
			if(answer == 0) {
				answer = address.compareTo(other.getAddress());
			}
		}
		return answer;
	}

}
