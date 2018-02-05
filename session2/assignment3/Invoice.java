package com.scg.domain;

import java.awt.List;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Invoice encapsulates the attributes and behavior to create client 
 * invoices for a given time period from time cards. The invoicing business' 
 * name and address are obtained from a properties file. The name of the 
 * property file is specified by the PROP_FILE_NAME static member.
 * @author Brian Stamm
 */
public final class Invoice {
	
	private int invoiceYear;
	private ClientAccount client;
	private java.time.Month invoiceMonth;
	private LocalDate startDate;
	private ArrayList<InvoiceLineItem> lineItemList;
	
	/**
	 * Construct an Invoice for a client. The time period is set from the 
	 * beginning to the end of the month specified.
	 * @param client - Client for this Invoice.
	 * @param invoiceMonth - Month for which this Invoice is being created.
	 * @param invoiceYear - Year for which this Invoice is being created.
	 */
	public Invoice(ClientAccount client, java.time.Month invoiceMonth, int invoiceYear) {
		this.invoiceYear = invoiceYear;
		this.client = client;
		this.invoiceMonth = invoiceMonth;
		this.lineItemList = new ArrayList<InvoiceLineItem>();
		
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
		return invoiceMonth;
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
		return 1;
	}
	
	/**
	 * Get the total charges for this Invoice.
	 * @return Total charges.
	 */
	public int getTotalCharges() {
		return 1;
	}
	
	/**
	 * Add an invoice line item to this Invoice.
	 * @param lineItem - InvoiceLineItem to add.
	 */
	public void addLineItem(InvoiceLineItem lineItem) {
		lineItemList.add(lineItem);
	}
	
	/**
	 * Extract the billable hours for this Invoice's client from the input 
	 * TimeCard and add them to the line items. Only those hours for the client 
	 * and month unique to this invoice will be added.
	 * @param timeCard - the TimeCard potentially containing line items for this Invoices client.

	 */
	public void extractLineItems(TimeCard timeCard) {
		
	}
	
	/**
	 * Create a string representation of this object, suitable for printing.
	 * @return string containing this invoices client name and billing start date
	 */
	@Override
	public String toString() {
		return "hello";
	}

	/**
	 * Create a formatted string containing the printable invoice. Includes a header 
	 * and footer on each page.
	 * @return The formatted invoice as a string.
	 */
	public String toReportString() {
		return "Another hello.";
	}

}
