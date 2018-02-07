package com.scg.domain;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Formatter;

import org.junit.Before;
import org.junit.Test;

import com.scg.util.PersonalName;

/**
 * @author Brian Stamm
 *
 */
public class InvoiceLineItemTest {

	private LocalDate currentDate;
	private Consultant testConsultant;
	private Skill testSkill;
	private int testHours;
	private int testCharge;
	private String testString;
	
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

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNegativeHours(){
		InvoiceLineItem testLineItem = new InvoiceLineItem(currentDate,testConsultant,testSkill,-2);
	}
	
	@Test
	public void testConstructor() {
		InvoiceLineItem testLineItem = new InvoiceLineItem(currentDate,testConsultant,testSkill,testHours);
		
		assertEquals(testLineItem.getDate(),currentDate);
		assertEquals(testLineItem.getConsultant(),testConsultant);
		assertEquals(testLineItem.getSkill(),testSkill);
		assertEquals(testLineItem.getHours(),testHours);
		assertEquals(testLineItem.getCharge(),testCharge);
	}
	
	@Test
	public void testToString() {
		InvoiceLineItem testLineItem = new InvoiceLineItem(currentDate,testConsultant,testSkill,testHours);
		
		assertEquals(testLineItem.toString(),testString);
	}

}
