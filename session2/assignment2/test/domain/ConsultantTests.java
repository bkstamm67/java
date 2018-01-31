package com.scg.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.scg.util.PersonalName;

/**
 * @author Brian Stamm
 *
 */
public class ConsultantTests {

	private String firstName = "Edward";
	private String lastName = "Walls";
	private String fullName = lastName + ", " + firstName;
	private PersonalName name = new PersonalName(lastName,firstName);
	
	/**
	 * 
	 */
	@Test
	public void testConstructor() {
		Consultant tester = new Consultant(name);
		assertEquals(tester.getName(),name);
	}
	
	/**
	 * 
	 */
	@Test
	public void testConsultantToString() {
		Consultant tester = new Consultant(name);
		assertEquals(tester.toString(),fullName);
	}

}
