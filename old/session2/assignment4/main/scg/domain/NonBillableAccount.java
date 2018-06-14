package com.scg.domain;

/**
 * Encapsulates the concept of a non-billable account, such as sick leave, vacation, or business development.
 * @author Brian Stamm
 */
public enum NonBillableAccount implements Account {
	BUSINESS_DEVELOPMENT("Business Development"),
	SICK_LEAVE("Sick Leave"),
	VACATION("Vacation");
	
	//Variable for name
	private String formalName;
	
	/**
	* Constructor for enum, assigns value to formalName
	*/
	private NonBillableAccount(final String formalName) {
		this.formalName = formalName;
	}
	
	/**
	* Creates a string of the enum
	* @return formalName String value of enum
	*/
	@Override
	public String toString() {
		return formalName;
	}
	/**
	* Creates a string of the enum
	* @return formalName String value of enum
	*/
	@Override
	public String getName() {
		return formalName;
	}
	/**
	* Returns false
	* @return boolean false
	*/
	@Override
	public boolean isBillable() {
		return false;
	}

}
