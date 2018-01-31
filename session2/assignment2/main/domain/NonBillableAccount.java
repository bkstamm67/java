package com.scg.domain;

/**
 * Encapsulates the concept of a non-billable account, such as sick leave, vacation, or business development.
 * NEEDS TO UPDATE THE COMMENTS!
 * @author Brian Stamm
 *
 */
public enum NonBillableAccount implements Account {
	BUSINESS_DEVELOPMENT("Business Development"),
	SICK_LEAVE("Sick Leave"),
	VACATION("Vacation");
	
	private String formalName;
	
	private NonBillableAccount(final String formalName) {
		this.formalName = formalName;
	}
	
	@Override
	public String toString() {
		return formalName;
	}

	@Override
	public String getName() {
		return formalName;
	}

	@Override
	public boolean isBillable() {
		return false;
	}

}
