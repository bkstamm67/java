/**
 * 
 */
package com.scg.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Brian Stamm
 *
 */
public class PersonalNameTests {

	private String lastName = "Cicero";
	private String firstName = "Marcus";
	private String middleName = "Tullius";
	private String partName = lastName + ", " + firstName;
	private String fullName = lastName + ", " + firstName + " " + middleName;
	
	
	@Test
	public void testTwoParameterConstructor() {
		PersonalName tester = new PersonalName(lastName, firstName);
		assertEquals(tester.toString(), partName);
	}

	@Test
	public void testThreeParametterConstructor() {
		PersonalName tester = new PersonalName(lastName, firstName, middleName);
		assertEquals(tester.toString(), fullName);
	}
	
	@Test
	public void testGetLastName() {
		PersonalName tester = new PersonalName(lastName, firstName, middleName);
		assertEquals(tester.getLastName(),lastName);
	}
	
	@Test
	public void testSetLastName() {
		PersonalName tester = new PersonalName();
		tester.setLastName(lastName);
		assertEquals(tester.getLastName(),lastName);
	}
	
	@Test
	public void testGetFirstName() {
		PersonalName tester = new PersonalName(lastName, firstName, middleName);
		assertEquals(tester.getFirstName(),firstName);
	}
	
	@Test
	public void testSetFirstName() {
		PersonalName tester = new PersonalName();
		tester.setFirstName(firstName);
		assertEquals(tester.getFirstName(),firstName);
	}
	
	@Test
	public void testGetMiddleName() {
		PersonalName tester = new PersonalName(lastName, firstName, middleName);
		assertEquals(tester.getMiddleName(),middleName);
	}
	
	@Test
	public void testSetMiddleName() {
		PersonalName tester = new PersonalName();
		tester.setMiddleName(middleName);
		assertEquals(tester.getMiddleName(),middleName);
	}
	
	@Test
	public void testEquals() {
		PersonalName testerOne = new PersonalName(lastName, firstName, middleName);
		PersonalName testerTwo = new PersonalName(lastName, firstName, middleName);
		PersonalName testerThree = new PersonalName(firstName, lastName);
		boolean answerOne = testerOne.equals(testerTwo);
		assertEquals(answerOne,true);
		boolean answerTwo = testerOne.equals(testerThree);
		assertEquals(answerTwo,false);
		
	}

}
