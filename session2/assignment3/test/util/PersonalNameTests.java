package com.scg.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This tests PersonalName.
 * @author Brian Stamm
 */
public class PersonalNameTests {
	
	//Private variables used for testing
	private String lastName = "Cicero";
	private String firstName = "Marcus";
	private String middleName = "Tullius";
	private String partName = lastName + ", " + firstName;
	private String fullName = lastName + ", " + firstName + " " + middleName;
	
	/**
	* Tests constructor taking two arguments.
	*/
	@Test
	public void testTwoParameterConstructor() {
		PersonalName tester = new PersonalName(lastName, firstName);
		assertEquals(tester.toString(), partName);
	}
	
	/**
	* Tests constructor taking three arguments.
	*/
	@Test
	public void testThreeParametterConstructor() {
		PersonalName tester = new PersonalName(lastName, firstName, middleName);
		assertEquals(tester.toString(), fullName);
	}
	
	/**
	* Test method getLastName()
	*/
	@Test
	public void testGetLastName() {
		PersonalName tester = new PersonalName(lastName, firstName, middleName);
		assertEquals(tester.getLastName(),lastName);
	}
	
	/**
	* Test method setLastName(), passing new value in
	*/
	@Test
	public void testSetLastName() {
		PersonalName tester = new PersonalName();
		tester.setLastName(lastName);
		assertEquals(tester.getLastName(),lastName);
	}
	
	/**
	* Test method getFirstName()
	*/
	@Test
	public void testGetFirstName() {
		PersonalName tester = new PersonalName(lastName, firstName, middleName);
		assertEquals(tester.getFirstName(),firstName);
	}
	
	/**
	* Test method setFirstName(), passing new value in
	*/
	@Test
	public void testSetFirstName() {
		PersonalName tester = new PersonalName();
		tester.setFirstName(firstName);
		assertEquals(tester.getFirstName(),firstName);
	}
	
	/**
	* Test method getMiddleName()
	*/
	@Test
	public void testGetMiddleName() {
		PersonalName tester = new PersonalName(lastName, firstName, middleName);
		assertEquals(tester.getMiddleName(),middleName);
	}
	
	/**
	* Test method setMiddleName(), passing new value in
	*/
	@Test
	public void testSetMiddleName() {
		PersonalName tester = new PersonalName();
		tester.setMiddleName(middleName);
		assertEquals(tester.getMiddleName(),middleName);
	}
	
	/**
	* Test method equal(), with two PersonalName that are the same and one different
	*/
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
