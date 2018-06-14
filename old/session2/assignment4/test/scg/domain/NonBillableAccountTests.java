package com.scg.domain;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for the NonBillableAccount class
 * @author Brian Stamm
 */
public class NonBillableAccountTests {
	
	//Variables used for testing
	private String sick = "Sick Leave";
	private String vaca = "Vacation";

	/**
	* Tests the toString() method
	*/
	@Test
	public void testToString() {
		assertEquals(NonBillableAccount.SICK_LEAVE.toString(),sick);
	}
	
	/**
	* Tests the getName() method
	*/
	@Test
	public void testGetName() {
		assertEquals(NonBillableAccount.VACATION.getName(),vaca);
	}
	
	/**
	* Tests that NonBillableAccount's method isBillable() returns false
	*/
	@Test
	public void testIsBillable() {
		assertFalse(NonBillableAccount.BUSINESS_DEVELOPMENT.isBillable());
	}

}
