package com.scg.domain;

/**
* Header for Small Consulting Group Invoices.
* @author Brian Stamm
*/

public class InvoiceHeader{

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
    return "InvoiceHeader string";
  }

}
