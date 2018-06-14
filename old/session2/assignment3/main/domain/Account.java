package com.scg.domain;

/**
 * Interface all accounts must implement
 * @author Brian Stamm
 */
public interface Account {
	
	/**
	 * Getter for the name of this account.
	 * @return name of the account
	 */
	String getName();
	
	/**
	 * Determines if this account is billable.
	 * @return true if account is billable, false if not
	 */
	boolean isBillable();

}