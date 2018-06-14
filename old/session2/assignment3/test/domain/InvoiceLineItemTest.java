package com.scg.domain;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Formatter;

import org.junit.Before;
import org.junit.Test;

import com.scg.util.PersonalName;

/**
 * Tests the InvoiceLineItem.java
 * @author Brian Stamm
 */
public class InvoiceLineItemTest {

	//variables used for testing
	private LocalDate currentDate;
	private Consultant testConsultant;
	private Skill testSkill;
	private int testHours;
	private int testCharge;
	private String testString;
	
	/**
	* Set up the variables used for testing
	*/
	@Before
	public void setUp(){
		currentDate = LocalDate.now();
		testConsultant = new Consultant(new PersonalName("Miklasz","Bernie"));
		testSkill = Skill.PROJECT_MANAGER;
		testHours = 13;
		testCharge = testHours * testSkill.getRate();
		
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		ft.format("%1$tm/%1$td/%1$tY  %2$s\t%3$s\t\t%4$d\t$%5$,.2f\n", currentDate, testConsultant.toString(),testSkill.toString(),testHours,(double)testCharge);
		ft.close();
		testString = sb.toString();
	}

	/**
	* Tests constructor throws error with invalid hour variable
	*/
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegativeHours(){
		InvoiceLineItem testLineItem = new InvoiceLineItem(currentDate,testConsultant,testSkill,-2);
	}
	
	/**
	* Tests the constructor and getter methods
	*/
	@Test
	public void testConstructor() {
		InvoiceLineItem testLineItem = new InvoiceLineItem(currentDate,testConsultant,testSkill,testHours);
		
		assertEquals(testLineItem.getDate(),currentDate);
		assertEquals(testLineItem.getConsultant(),testConsultant);
		assertEquals(testLineItem.getSkill(),testSkill);
		assertEquals(testLineItem.getHours(),testHours);
		assertEquals(testLineItem.getCharge(),testCharge);
	}
	
	/**
	* Tests the toString method
	*/
	@Test
	public void testToString() {
		InvoiceLineItem testLineItem = new InvoiceLineItem(currentDate,testConsultant,testSkill,testHours);
		
		assertEquals(testLineItem.toString(),testString);
	}

}
