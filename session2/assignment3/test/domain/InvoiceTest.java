package com.scg.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Brian Stamm
 *
 */
public class InvoiceTest {

	private List<ClientAccount> testClients;
	private List<Consultant> testConsultants;
	private List<TimeCard> testTimeCards;
	LocalDate aDate;

	@Before
	public void setUp() {
		testClients = new ArrayList<>();
		testConsultants = new ArrayList<>();
		testTimeCards = new ArrayList<>();
		ListFactory.populateLists(testClients,testConsultants,testTimeCards);
		aDate = LocalDate.of(2009,1,1);
	}

	@Test
	public void testConstructor() {
		Invoice testInvoice = new Invoice(testClients.get(0),aDate.getMonth(),aDate.getYear());
		
		assertEquals(testInvoice.getStartDate(),aDate);
		assertEquals(testInvoice.getInvoiceMonth(),aDate.getMonth());
		assertEquals(testInvoice.getClientAccount(),testClients.get(0));
		assertEquals(testInvoice.getTotalHours(),0);
		assertEquals(testInvoice.getTotalCharges(),0);
	}
	
	@Test
	public void testAddLineItem(){
	}
	
	//test extractLineItems
	//test toString
	//test toReportString

}
