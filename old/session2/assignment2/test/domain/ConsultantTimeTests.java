package com.scg.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Formatter;

import org.junit.Before;
import org.junit.Test;
import com.scg.util.PersonalName;

/**
 * Test cases for ConsultantTime class
 * @author Brian Stamm
 */
public class ConsultantTimeTests {
	
	//variables used for testing
	private LocalDate currentDate;
	private PersonalName clientName;
	private ClientAccount client;
	private Skill billable;
	private int hours;
	private String answer = "The Night Sweats             01/30/2018     7    Software Engineer";
	
	/**
	* Initialization of variables to be used throughout the unit tests.
	*/
	@Before
	public void initialize() {
		currentDate = LocalDate.now();
		clientName = new PersonalName("Rateliff", "Nathaniel");
		client = new ClientAccount("The Night Sweats", clientName);
		billable = Skill.SOFTWARE_ENGINEER;
		hours = 7;
	}
	
	/**
	* Test of constructor, passing in invalid negative hours amount.  Expected is a
	* thrown IllegalArgumentException
	*/
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegativeHours() {
		ConsultantTime error = new ConsultantTime(currentDate,client, billable,-2);
	}
	
	/**
	* Test of constructor, passing in invalid zero hours amount.  Expected is a
	* thrown IllegalArgumentException
	*/
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorZeroHours() {
		ConsultantTime error = new ConsultantTime(currentDate,client, billable,0);
	}
	
	/**
	* Test of constructor, passing in correct parameters.
	*/
	@Test
	public void testConstructor() {
		ConsultantTime test = new ConsultantTime(currentDate,client, billable,hours);
		assertEquals(test.getAccount(),client);
		assertEquals(test.getHours(),hours);
		assertEquals(test.getDate(),currentDate);
		assertEquals(test.getSkill(),billable);
	}
	
	/**
	* Test of setDate() method, passing in new date
	*/
	@Test
	public void testSetDate() {
		ConsultantTime test = new ConsultantTime(currentDate,client, billable,hours);
		LocalDate aDate = LocalDate.now().plusDays(1);
		test.setDate(aDate);
		assertEquals(test.getDate(),aDate);
	}
	
	/**
	* Test of setHours() method, passing new value in
	*/
	@Test
	public void testSetHours() {
		ConsultantTime test = new ConsultantTime(currentDate,client, billable,hours);
		int newHours = 1234;
		test.setHours(newHours);
		assertEquals(test.getHours(),newHours);
	}
	
	/**
	* Test of setHours() method, passing in invalid negative hours amount.  Expected is a
	* thrown IllegalArgumentException
	*/
	@Test(expected = IllegalArgumentException.class)
	public void testSetHourError() {
		ConsultantTime error = new ConsultantTime(currentDate,client, billable,hours);
		int newHours = -12;
		error.setHours(newHours);
	}
	
	/**
	* Test of setAccount() method, passing new account in
	*/
	@Test
	public void testSetAccount() {
		ConsultantTime test = new ConsultantTime(currentDate,client, billable,hours);
		PersonalName newName = new PersonalName("Bing", "Chandler");
		ClientAccount newClient = new ClientAccount("Friends", newName);
		test.setAccount(newClient);
		assertEquals(test.getAccount(),newClient);
	}
	
	/**
	* Test method isBillable()
	*/
	@Test
	public void testIsBillable() {
		ConsultantTime test = new ConsultantTime(currentDate,client, billable,hours);
		assertEquals(test.isBillable(),client.isBillable());
	}
	
	/**
	* Test method toString()
	*/
	@Test
	public void testToString() {
		ConsultantTime test = new ConsultantTime(currentDate,client, billable,hours);
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		ft.format("%s\n",answer);
		ft.close();
		assertEquals(test.toString(), sb.toString());
	}
	
	/**
	*  Tests equal() method, passing in two ConsultantTime objects that have the same values
	*/
	@Test
	public void testEqualsTrue() {
		ConsultantTime test = new ConsultantTime(currentDate,client, billable,hours);
		ConsultantTime anotherTest = new ConsultantTime(currentDate,client, billable,hours);
		assertTrue(test.equals(anotherTest));
		assertTrue(test.equals(test));
	}
	
	/**
	* Tests equal() method when values are not equal, attempting to hit each branch
	*/
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testEqualsFalse() {
		ConsultantTime test = new ConsultantTime(currentDate,client, billable,hours);
		ConsultantTime errorHours = new ConsultantTime(currentDate,client, billable,1234);
		ConsultantTime errorAccount = new ConsultantTime(currentDate,new ClientAccount("Fraiser", new PersonalName("Crane", "Fraiser")), billable,hours);
		ConsultantTime errorAccountNull = new ConsultantTime(currentDate,null, billable,hours);
		ConsultantTime errorDateNull = new ConsultantTime(null,client, billable,hours);
		ConsultantTime errorSkill = new ConsultantTime(currentDate,client, Skill.UNKNOWN_SKILL,hours);		
		
		assertFalse(test.equals(null));
		assertFalse(test.equals(errorHours));
		assertFalse(test.equals(client));
		assertFalse(errorAccountNull.equals(test));
		assertFalse(test.equals(errorAccount));
		assertFalse(test.equals(errorDateNull));
		assertFalse(errorDateNull.equals(test));
		assertFalse(test.equals(errorSkill));
		
	}
	
}
