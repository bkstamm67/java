package com.scg.domain;

import com.scg.util.PersonalName;

/**
 * Encapsulates the information for a billable client account.
 * DONE
 * @author Brian Stamm
 *
 */
public final class ClientAccount implements Account{
	
	private PersonalName contact;
	private final String name;
	
	/**
	 * Creates a new instance of ClientAccount
	 * @param name - String with the name of the client.
	 * @param contact  - Name of the contact person for this client.
	 */
	public ClientAccount(final String name, PersonalName contact) {
		this.contact = contact;
		this.name = name;
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
}
