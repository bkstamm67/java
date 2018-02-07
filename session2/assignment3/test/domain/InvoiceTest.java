package com.scg.domain;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.scg.util.ListFactory;

/**
 * @author Brian Stamm
 *
 */
public class InvoiceTest {

	private List<ClientAccount> testClients;
	private List<Consultant> testConsultants;
	private List<TimeCard> testTimeCards;
	private LocalDate aDate;
	private int testHours;
	private int testCharges;
	private Skill testSkill;
	private String businessName;
	private String testString;
	private String testInvoiceReport;

	@Before
	public void setUp() {
		testClients = new ArrayList<>();
		testConsultants = new ArrayList<>();
		testTimeCards = new ArrayList<>();
		ListFactory.populateLists(testClients,testConsultants,testTimeCards);
		aDate = LocalDate.of(2006,2,1);
		testSkill = Skill.PROJECT_MANAGER;
		testHours = 5;
		testCharges = testHours * testSkill.getRate();
		
		final String PROP_LOCATION = "/invoice.properties";
		final Properties invoiceProperties = new Properties();

		try(InputStream in = Invoice.class.getResourceAsStream(PROP_LOCATION)){
			invoiceProperties.load(in);
			businessName = invoiceProperties.getProperty("business.name","n/a");
		}
		catch(IOException e){
			System.err.println("Caught IOException: " + e.getMessage());
		}
		
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		ft.format("Business: %s/n Start Date: %2$tB %2$td, %2$tY/n",businessName,aDate);
		ft.close();
		testString = sb.toString();
		testInvoiceReport = buildInvoice();
		
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
		InvoiceLineItem testLineItem = new InvoiceLineItem(aDate,testConsultants.get(0),testSkill,testHours);
		Invoice testInvoice = new Invoice(testClients.get(0),aDate.getMonth(),aDate.getYear());
		testInvoice.addLineItem(testLineItem);
		
		assertEquals(testInvoice.getTotalHours(),testHours);
		assertEquals(testInvoice.getTotalCharges(),testCharges);
	}
	

	@Test
	public void testToString(){
		Invoice testInvoice = new Invoice(testClients.get(0),aDate.getMonth(),aDate.getYear());

		assertEquals(testInvoice.toString(),testString);
	}
	
	@Test
	public void testToReportString(){
		Invoice testInvoice = new Invoice(testClients.get(0),aDate.getMonth(),aDate.getYear());

		assertEquals(testInvoice.toReportString(),testInvoiceReport);
	}
	
	private String buildInvoice() {
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		ft.format("The Small Consulting Group\n");
		ft.format("1616 Index Ct.\n");
		ft.format("Renton, WA 98058\n\n");
		ft.format("Invoice For:\n");
		ft.format("Acme Industries\n");
		ft.format("1616 Index Ct.\n");
		ft.format("Redmond, WA 98055\n");
		ft.format("Coyote, Wiley\n\n");
		ft.format("Invoice For the Month of:  February 2006\n");
		ft.format("Invoice Date: %1$tB %1$td, %1$tY\n\n", LocalDate.now());
		ft.format("Date        Consultant          Skill                 Hours     Charge\n");
		ft.format("----------  -----------------   ----------------      -----     ---------\n\n");
		ft.format("Total:  							0 	$0.00\n\n");
		ft.format("The Small Consulting Group\n");
		ft.format("Page Number: 1\n");
		ft.format("=========================================================================\n\n");
		ft.close();
		return sb.toString();
	}

}
