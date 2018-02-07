package com.scg.domain;

import java.util.List;
import java.util.Properties;

import com.scg.util.Address;
import com.scg.util.StateCode;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;

/**
 * Invoice encapsulates the attributes and behavior to create client 
 * invoices for a given time period from time cards. The invoicing business' 
 * name and address are obtained from a properties file. The name of the 
 * property file is specified by the PROP_FILE_NAME static member.
 * @author Brian Stamm
 */
public final class Invoice {
	//static variables here
	private final static String PROP_LOCATION = "/invoice.properties";
	private final static String BIZ_NAME = "business.name";
	private final static String BIZ_STREET = "business.street";
	private final static String BIZ_CITY = "business.city";
	private final static String BIZ_STATE = "business.state";
	private final static String BIZ_ZIP_CODE = "business.zip";
	private final static String NA = "n/a";
	//private strings to be built from these -
	private static String businessName;
	private static String businessStreet;
	private static String businessCity;
	private static String businessState;
	private static String businessZipCode;
	//static up here
	static {
		final Properties invoiceProperties = new Properties();

		try(InputStream in = Invoice.class.getResourceAsStream(PROP_LOCATION)){
			invoiceProperties.load(in);
			businessName = invoiceProperties.getProperty(BIZ_NAME,NA);
			businessStreet = invoiceProperties.getProperty(BIZ_STREET,NA);
			businessCity = invoiceProperties.getProperty(BIZ_CITY,NA);
			businessState = invoiceProperties.getProperty(BIZ_STATE,NA);
			businessZipCode = invoiceProperties.getProperty(BIZ_ZIP_CODE,NA);
		}
		catch(IOException e){
			System.err.println("Caught IOException: " + e.getMessage());
		}
	}


	//private int invoiceYear;
	private ClientAccount client;
	//private java.time.Month invoiceMonth;
	private LocalDate startDate;
	List<InvoiceLineItem> lineItemList;
	private int totalHours;
	private int totalCharges;

	/**
	 * Construct an Invoice for a client. The time period is set from the 
	 * beginning to the end of the month specified.
	 * @param client - Client for this Invoice.
	 * @param invoiceMonth - Month for which this Invoice is being created.
	 * @param invoiceYear - Year for which this Invoice is being created.
	 */
	public Invoice(ClientAccount client, java.time.Month invoiceMonth, int invoiceYear) {
		//this.invoiceYear = invoiceYear;
		//invoice date = now
		//start date is first of month of year
		startDate = LocalDate.of(invoiceYear,invoiceMonth,1);
		this.client = client;
		//this.invoiceMonth = invoiceMonth;
		this.lineItemList = new ArrayList<>();
		totalHours = 0;
		totalCharges = 0;
	}

	/**
	 * Get the start date for this Invoice, this is the earliest date/time a 
	 * ConsultantTime instance may have and still be billed on this invoice.
	 * @return Start date.
	 */
	public java.time.LocalDate getStartDate(){
		return startDate;
	}

	/**
	 * Get the invoice month. This is the 1-based month number.
	 * @return the invoice month number.
	 */
	public java.time.Month getInvoiceMonth(){
		//return invoiceMonth;
		return startDate.getMonth();
	}

	/**
	 * Get the client for this Invoice.
	 * @return the client.
	 */
	public ClientAccount getClientAccount() {
		return client;
	}

	/**
	 * Get the total hours for this Invoice.
	 * @return Total hours.
	 */
	public int getTotalHours() {
		return totalHours;
	}

	/**
	 * Get the total charges for this Invoice.
	 * @return Total charges.
	 */
	public int getTotalCharges() {
		return totalCharges;
	}

	/**
	 * Add an invoice line item to this Invoice.
	 * @param lineItem - InvoiceLineItem to add.
	 */
	public void addLineItem(InvoiceLineItem lineItem) {
		lineItemList.add(lineItem);
		//then add hours and charges
		totalCharges += lineItem.getCharge();
		totalHours += lineItem.getHours();
	}

	/**
	 * Extract the billable hours for this Invoice's client from the input 
	 * TimeCard and add them to the line items. Only those hours for the client 
	 * and month unique to this invoice will be added.
	 * @param timeCard - the TimeCard potentially containing line items for this Invoices client.
	 */
	public void extractLineItems(TimeCard timeCard) {
		List<ConsultantTime> billableList = timeCard.getBillableHoursForClient(client.getName());
		for(ConsultantTime currentConsultant : billableList){
			LocalDate currentDate = currentConsultant.getDate();
			if((currentDate.getMonth() == startDate.getMonth()) && (currentDate.getYear() == startDate.getYear())){
				InvoiceLineItem newLineItem = new InvoiceLineItem(currentDate, timeCard.getConsultant(),currentConsultant.getSkill(),currentConsultant.getHours());
				addLineItem(newLineItem);
			}
		}

	}

	/**
	 * Create a string representation of this object, suitable for printing.
	 * @return string containing this invoices client name and billing start date
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		ft.format("Business: %s/n Start Date: %2$tB %2$td, %2$tY/n",businessName,startDate);
		ft.close();
		return sb.toString();
	}

	/**
	 * Create a formatted string containing the printable invoice. Includes a header 
	 * and footer on each page.
	 * @return The formatted invoice as a string.
	 */
	public String toReportString() {
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		Address businessAddress = new Address(businessStreet,businessCity,StateCode.valueOf(businessState),businessZipCode);
		InvoiceHeader header = new InvoiceHeader(businessName, businessAddress, client, startDate, startDate);
		InvoiceFooter footer = new InvoiceFooter(businessName);

		ft.format("%s", header.toString());
		ft.format("Invoice Date: %1$tB %1$td, %1$tY\n\n", LocalDate.now());
		ft.format("Date        Consultant          Skill                 Hours     Charge\n");
		ft.format("----------  -----------------   ----------------      -----     ---------\n");
		int itemCount = 0;
		for(InvoiceLineItem lineItem : lineItemList){
			ft.format("%s", lineItem.toString());
			itemCount++;
			if(itemCount%5 == 0){
				ft.format("\n%s", footer);
				footer.incrementPageNumber();
				ft.format("%s", header);
				ft.format("Invoice Date: %1$tB %1$td, %1$tY\n\n", LocalDate.now());
				ft.format("Date        Consultant          Skill                 Hours     Charge\n");
				ft.format("----------  -----------------   ----------------      -----     ---------\n");
			}
		}
		ft.format("\nTotal:  \t\t\t\t\t\t\t%d \t$%,.2f\n",totalHours, (double)totalCharges);
		ft.format("\n%s", footer);
		ft.close();

		return sb.toString();
	}
}
