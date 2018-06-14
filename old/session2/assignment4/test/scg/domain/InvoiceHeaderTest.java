package com.scg.domain;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Formatter;

import org.junit.Before;
import org.junit.Test;

import com.scg.util.Address;
import com.scg.util.PersonalName;
import com.scg.util.StateCode;

/**
 * JUnit tests for the InvoiceHeader.java
 * @author Brian Stamm
 */
public class InvoiceHeaderTest {

	//private variables for testing
	private Address testAddress;
	private PersonalName testName;
	private String testBusinessName;
	private ClientAccount testAccount;
	private LocalDate currentDate;
	private String testString;
	
	/**
	 * Set up values for testing used in test
	 */
	@Before
	public void setUp() {
		testAddress = new Address("1616 Index Ct.", "Redmond", StateCode.WA, "98055");
		testName = new PersonalName("Coyote", "Wiley");
		testBusinessName = "Acme Industries";
		testAccount = new ClientAccount(testBusinessName, testName,testAddress);
		currentDate = LocalDate.now();
		
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		ft.format("%s%n%s%n%nInvoice For:%n%s%n%n", testBusinessName,testAddress,testAccount.toString());
		ft.format("Invoice For the Month of:  %tB %d\n", currentDate.getMonth(), currentDate.getYear());
		ft.close();
		testString = sb.toString();
	}

	/**
	* Tests the constructor and toString method
	*/
	@Test
	public void testInvoiceHeader() {
		InvoiceHeader header = new InvoiceHeader(testBusinessName,testAddress,testAccount,currentDate,currentDate);
		assertEquals(header.toString(),testString);
	}
}
