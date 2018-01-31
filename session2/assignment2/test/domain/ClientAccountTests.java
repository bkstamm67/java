package com.scg.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.scg.util.PersonalName;

/**
 * @author Brian Stamm
 *
 */
public class ClientAccountTests {

	PersonalName actualClient = new PersonalName("Bazelon", "Emily");
	String actualName = "Slate Gabfest";
	
	@Test
	public void testConstructor() {
		ClientAccount tester = new ClientAccount(actualName,actualClient);
		assertEquals(tester.getContact(),actualClient);
		assertEquals(tester.getName(),actualName);
	}
	
	@Test
	public void testIsBillable() {
		ClientAccount tester = new ClientAccount(actualName,actualClient);
		assertEquals(tester.isBillable(), true);
	}
	
	@Test
	public void testSetContact() {
		ClientAccount tester = new ClientAccount(actualName,actualClient);
		PersonalName newClient = new PersonalName("Dickerson", "John");
		tester.setContact(newClient);
		assertEquals(tester.getContact(),newClient);
	}

}
