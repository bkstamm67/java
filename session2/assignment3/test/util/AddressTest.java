package com.scg.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Brian Stamm
 */
public class AddressTest {
	
	private String streetNumber;
	private String city;
	private StateCode state;
	private String postalCode;
	private String testString;
	
	/**
	* Initialize all the variables for testing
	*/
	@Before
	public void initialize() {
		streetNumber = "416 Sid Snyder Avenue";
		city = "Olympia";
		state = StateCode.WA;
		postalCode = "98504";
		
		testString = String.format("%s%n%s, %s %s", streetNumber, city, state, postalCode);
		
	}

	@Test
	public void testConstructor() {
		Address testAddress = new Address(streetNumber, city, state, postalCode);
		assertEquals(testAddress.getStreetNumber(),streetNumber);
		assertEquals(testAddress.getCity(),city);
		assertEquals(testAddress.getState(),state);
		assertEquals(testAddress.getPostalCode(),postalCode);
	}
	
	@Test
	public void testToString() {
		Address testAddress = new Address(streetNumber, city, state, postalCode);
		assertEquals(testAddress.toString(),testString);
	}

}
