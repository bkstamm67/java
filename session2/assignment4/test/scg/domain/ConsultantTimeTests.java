package com.scg.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Formatter;

import org.junit.Before;
import org.junit.Test;

import com.scg.util.Address;
import com.scg.util.PersonalName;
import com.scg.util.StateCode;

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
	private String answer;
	private Address address = new Address("2439 State Hwy K","Hermann", StateCode.MO, "65041");
	
	/**
	* Initialization of variables to be used throughout the unit tests.
	*/
	@Before
	public void initialize() {
		currentDate = LocalDate.now();
		clientName = new PersonalName("Rateliff", "Nathaniel");
		client = new ClientAccount("The Night Sweats", clientName, address);
		billable = Skill.SOFTWARE_ENGINEER;
		hours = 7;
		//Create answer, used in the toString test
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		ft.format("%-28s %2$tm/%2$td/%2$tY     %3$d    %4$s\n", client.getName(), currentDate, hours, billable.toString());
		ft.close();
		answer = sb.toString();
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
		Address newAddress = new Address("45 Rockefeller Plaza", "New York", StateCode.NY, "10111");
		ClientAccount newClient = new ClientAccount("Friends", newName, newAddress);
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
		assertEquals(test.toString(), answer);
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
		ConsultantTime errorAccount = new ConsultantTime(currentDate,new ClientAccount("Fraiser", new PersonalName("Crane", "Fraiser"), new Address("1406 12th Ave", "Seattle", StateCode.WA, "98122")), billable,hours);
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
