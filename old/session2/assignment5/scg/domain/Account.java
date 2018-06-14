package com.scg.domain;

import java.io.Serializable;

/**
 * Interface all accounts must implement
 * @author Brian Stamm
 */
public interface Account extends Serializable {
	
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