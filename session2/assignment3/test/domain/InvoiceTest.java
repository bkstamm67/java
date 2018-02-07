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
	private int testHours;
	private int testCharges;
	private Skill testSkill;
	private String businessName;
	private String testString;

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
		
		private final static String PROP_LOCATION = "/invoice.properties";
		final Properties invoiceProperties = new Properties();

		try(InputStream in = Invoice.class.getResourceAsStream(PROP_LOCATION)){
			invoiceProperties.load(in);
			businessName = invoiceProperties.getProperty(BIZ_NAME,NA);
		}
		catch(IOException e){
			System.err.println("Caught IOException: " + e.getMessage());
		}
		
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		ft.format("Business: %s/n Start Date: %2$tB %2$td, %2$tY/n",businessName,startDate);
		ft.close();
		testString = sb.toString();
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

		assertEquals(testInvoice.toReportString(),"");
	}

}
