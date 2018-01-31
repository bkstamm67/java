/**
 * 
 */
package com.scg.domain;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Brian Stamm
 *
 */
public class NonBillableAccountTests {
	
	private String sick = "Sick Leave";
	private String vaca = "Vacation";

	@Test
	public void testToString() {
		assertEquals(NonBillableAccount.SICK_LEAVE.toString(),sick);
	}
	
	@Test
	public void testGetName() {
		assertEquals(NonBillableAccount.VACATION.getName(),vaca);
	}
	
	@Test
	public void testIsBillable() {
		assertFalse(NonBillableAccount.BUSINESS_DEVELOPMENT.isBillable());
	}

}
