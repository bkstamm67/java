package com.scg.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.scg.util.PersonalName;

/**
 * Tests for the Consultant class.
 * @author Brian Stamm
 */
public class ConsultantTests {

	//Variables used for testing
	private String firstName = "Edward";
	private String lastName = "Walls";
	private String fullName = lastName + ", " + firstName;
	private PersonalName name = new PersonalName(lastName,firstName);
	
	/**
	 * Tests the constructor, and secondarily the getName() method
	 */
	@Test
	public void testConstructor() {
		Consultant tester = new Consultant(name);
		assertEquals(tester.getName(),name);
	}
	
	/**
	 * Tests the toString() method
	 */
	@Test
	public void testConsultantToString() {
		Consultant tester = new Consultant(name);
		assertEquals(tester.toString(),fullName);
	}

}
