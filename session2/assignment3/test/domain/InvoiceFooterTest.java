package com.scg.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Brian Stamm
 *
 */
public class InvoiceFooterTest {
	
	private String testDashes = "=========================================================================\n";
	private String testBusiness = "Expeditors";

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
