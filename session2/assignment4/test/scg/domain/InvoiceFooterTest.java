package com.scg.domain;

import static org.junit.Assert.*;

import java.util.Formatter;

import org.junit.Test;

/**
 * Test the InvoiceFooter.java
 * @author Brian Stamm
 */
public class InvoiceFooterTest {

	//private variables
	private String testDashes = "=========================================================================\n";
	private String testBusiness = "Expeditors";

	/**
	* Tests the constructor and toString method
	*/
	@Test
	public void testConstructorToString() {
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		ft.format("%s\nPage Number: %d\n%s\n", testBusiness,1,testDashes);
		ft.close();
		String testString = sb.toString();
		
		InvoiceFooter footer = new InvoiceFooter(testBusiness);
		assertEquals(footer.toString(),testString);
	}
	
	/**
	* Tests making sure the increment of page works
	*/
	@Test
	public void testIncrementPageNumber(){
		StringBuilder sb = new StringBuilder();
		Formatter ft = new Formatter(sb);
		ft.format("%s\nPage Number: %d\n%s\n", testBusiness,5,testDashes);
		ft.close();
		String testString = sb.toString();
		
		InvoiceFooter footer = new InvoiceFooter(testBusiness);
		
		for(int i =0; i<4;i++){
			footer.incrementPageNumber();
		}
		
		assertEquals(footer.toString(),testString);
	}
}
