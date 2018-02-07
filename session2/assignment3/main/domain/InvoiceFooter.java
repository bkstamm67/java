package com.scg.domain;

import java.util.Formatter;

/**
 * Footer for Small Consulting Group Invoices.
 * @author Brian Stamm
 */
public final class InvoiceFooter {

	private final String businessName;
	private final String dashes = "=========================================================================\n";
	private int pageNumber = 1;
	/**
	 * Construct an InvoiceFooter.
	 * @param businessName - name of business to include in footer
	 */
	public InvoiceFooter(String businessName) {
		this.businessName = businessName;
	}
	
	/**
	 * Increment the current page number by one.
	 */
	public void incrementPageNumber(){
		pageNumber++;
	}
	
	/**
	 * Print the formatted footer.
	 * @returns Formatted footer string.
	 */
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		//(%s%n%s%-69s Page: %3d%n%s%n", businessName, pageNumber, pageBreak);
		ft.format("%s\nPage Number: %d\n%s\n", businessName,pageNumber,dashes);
		ft.close();
	    return sb.toString();
	}
	
}
