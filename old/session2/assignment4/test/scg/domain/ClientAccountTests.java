package com.scg.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.scg.util.Address;
import com.scg.util.PersonalName;
import com.scg.util.StateCode;

/**
 * These are the tests for the ClientAccount class
 * @author Brian Stamm
 */
public class ClientAccountTests {

	//variables used for testing
	PersonalName actualClient = new PersonalName("Bazelon", "Emily");
	String actualName = "Slate Gabfest";
	//2 15th St NW, Washington, DC 20024
	Address actualAddress = new Address("2 15th St NW", "Washington", StateCode.DC, "20024");
	
	/**
	* Tests the constructor
	*/
	@Test
	public void testConstructor() {
		ClientAccount tester = new ClientAccount(actualName,actualClient,actualAddress);
		assertEquals(tester.getContact(),actualClient);
		assertEquals(tester.getName(),actualName);
	}
	
	/**
	* Tests the method isBillable()
	*/
	@Test
	public void testIsBillable() {
		ClientAccount tester = new ClientAccount(actualName,actualClient,actualAddress);
		assertEquals(tester.isBillable(), true);
	}
	
	/**
	* Tests the method setContact(), passing in a new PersonalName value
	*/
	@Test
	public void testSetContact() {
		ClientAccount tester = new ClientAccount(actualName,actualClient,actualAddress);
		PersonalName newClient = new PersonalName("Dickerson", "John");
		tester.setContact(newClient);
		assertEquals(tester.getContact(),newClient);
	}

}
