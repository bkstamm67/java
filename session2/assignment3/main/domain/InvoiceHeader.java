package com.scg.domain;

import java.time.LocalDate;
import java.util.Formatter;

import com.scg.util.Address;

/**
 * Header for Small Consulting Group Invoices.
 * @author Brian Stamm
 *
 */
public final class InvoiceHeader {
	private final String businessName;
	private Address businessAddress;
	private ClientAccount client;
	private LocalDate invoiceDate;
	private LocalDate invoiceMonth;
	
	/**
	 * Construct an InvoiceHeader.
	 * @param businessName - name of business issuing invoice
	 * @param businessAddress - address of business issuing invoice
	 * @param client - client for the invoice with this header.
	 * @param invoiceDate - date of the invoice with this header.
	 * @param invoiceForMonth - month of billable charges for invoice with this header.
	 */
	public InvoiceHeader(String businessName, Address businessAddress, ClientAccount client, LocalDate invoiceDate, LocalDate invoiceMonth){
		this.businessName = businessName;
		this.businessAddress = businessAddress;
		this.client = client;
		this.invoiceDate = invoiceDate;
		this.invoiceMonth = invoiceMonth;
	}
	
	/**
	 * Print this InvoiceHeader
	 * Formatted string of the information in this header.
	 */
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		ft.format("%s%n%s%n%n%s%n", businessName,businessAddress,client.toString());
		ft.format("Invoice For the Month of:  %tB %d\n", invoiceMonth.getMonth(), invoiceMonth.getYear());
		//ft.format("Invoice Date:  %tB %d\n", invoiceDate.getMonth(), invoiceDate.getYear());
		ft.close();
		return sb.toString();
	}
	
}
