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
 * 
 * @author Brian Stamm
 */
public class ConsultantTimeTests {
	
	private LocalDate currentDate;
	private PersonalName clientName;
	private ClientAccount client;
	private Skill billable;
	private int hours;
	private String answer = "The Night Sweats             01/30/2018     7    Software Engineer";
	

	@Before
	public void initialize() {
		currentDate = LocalDate.now();
		clientName = new PersonalName("Rateliff", "Nathaniel");
		client = new ClientAccount("The Night Sweats", clientName);
		billable = Skill.SOFTWARE_ENGINEER;
		hours = 7;
	}
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegativeHours() {
		ConsultantTime error = new ConsultantTime(currentDate,client, billable,-2);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorZeroHours() {
		ConsultantTime error = new ConsultantTime(currentDate,client, billable,0);
	}
	
	
	@Test
	public void testConstructor() {
		ConsultantTime test = new ConsultantTime(currentDate,client, billable,hours);
		assertEquals(test.getAccount(),client);
		assertEquals(test.getHours(),hours);
		assertEquals(test.getDate(),currentDate);
		assertEquals(test.getSkill(),billable);
	}
	
	@Test
	public void testSetDate() {
		ConsultantTime test = new ConsultantTime(currentDate,client, billable,hours);
		LocalDate aDate = LocalDate.now().plusDays(1);
		test.setDate(aDate);
		assertEquals(test.getDate(),aDate);
	}
	
	@Test
	public void testSetHours() {
		ConsultantTime test = new ConsultantTime(currentDate,client, billable,hours);
		int newHours = 1234;
		test.setHours(newHours);
		assertEquals(test.getHours(),newHours);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetHourError() {
		ConsultantTime error = new ConsultantTime(currentDate,client, billable,hours);
		int newHours = -12;
		error.setHours(newHours);
	}
	
	@Test
	public void testSetAccount() {
		ConsultantTime test = new ConsultantTime(currentDate,client, billable,hours);
		PersonalName newName = new PersonalName("Bing", "Chandler");
		ClientAccount newClient = new ClientAccount("Friends", newName);
		test.setAccount(newClient);
		assertEquals(test.getAccount(),newClient);
	}
	
	@Test
	public void testIsBillable() {
		ConsultantTime test = new ConsultantTime(currentDate,client, billable,hours);
		assertEquals(test.isBillable(),client.isBillable());
	}
	
	@Test
	public void testToString() {
		ConsultantTime test = new ConsultantTime(currentDate,client, billable,hours);
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		ft.format("%s\n",answer);
		ft.close();
		assertEquals(test.toString(), sb.toString());
	}
	
	@Test
	public void testEqualsTrue() {
		ConsultantTime test = new ConsultantTime(currentDate,client, billable,hours);
		ConsultantTime anotherTest = new ConsultantTime(currentDate,client, billable,hours);
		assertTrue(test.equals(anotherTest));
		assertTrue(test.equals(test));
	}
	
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
