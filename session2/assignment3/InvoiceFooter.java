package com.scg.domain;

/**
* Footer for Small Consulting Group Invoices.
* @author Brian Stamm
*/

public final class InvoiceFooter{

  private final String businessName;
  private static int pageNumber = 1;
  
  /**
  * Construct an InvoiceFooter.
  * @param businessName - name of buisness to include in footer
  */
  public InvoiceFooter(String businessName){
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
    //build string
    incrementPageNumber();
    return "Invoice footer string";
  }

}
