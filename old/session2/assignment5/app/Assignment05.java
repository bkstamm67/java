package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scg.domain.ClientAccount;
import com.scg.domain.Invoice;
import com.scg.domain.TimeCard;
import com.scg.util.DateRange;
import com.scg.util.TimeCardListUtil;

/**
 * Assignment 5 application, reads the serialized lists created by InitLists and creates and invoice 
 * from that data and prints it.
 * 
 * createInvoices and printInvoices methods, along with logic for printing out invoices and some variables
 * were taken from Assignment04.java
 * @author Brian Stamm
 */
public class Assignment05 {

	/** Character encoding to use. */
	private static final String ENCODING = "ISO-8859-1";

	/** The invoice month. */
    private static final Month INVOICE_MONTH = Month.MARCH;

    /** The test year. */
    private static final int INVOICE_YEAR = 2006;

    /**
	 * Entry point for Assignment05.
	 * @param args - command line arguments.
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		final Logger log = LoggerFactory.getLogger(Invoice.class);
		
		/*
		 * Reads in the ClientAccounts from file and does error checking
		 * to make sure all are same type
		 */
		final Object aList = readFilesIn("ClientList.ser");
		if(aList instanceof List<?>) {
			for(Object client: (List<?>)aList) {
				if(!(client instanceof ClientAccount)) {
					log.error("Goo.  ClientAccount don't work.");
					throw new IllegalArgumentException();
				}
			}
		}
		
		/* 
		 * Reads in the TimeCards and does error checking to make sure all
		 * objects are of the same type
		 */
		final Object bList = readFilesIn("TimeCardList.ser");
		if(bList instanceof List<?>) {
			for(Object timeCard: (List<?>)bList) {
				if(!(timeCard instanceof TimeCard)) {
					log.error("Goo.  Timecard don't work.");
					throw new IllegalArgumentException();
				}
			}
		}
		
		// Create the Invoices
        final List<Invoice> invoices = createInvoices((List<ClientAccount>)aList, (List<TimeCard>)bList);
        // Print them
        System.out.println();
        System.out.println("==================================================================================");
        System.out.println("=============================== I N V O I C E S ==================================");
        System.out.println("==================================================================================");
        System.out.println();
        
        try {
			printInvoices(invoices, System.out);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        
        //Writes invoices to file
        try (FileOutputStream out = new FileOutputStream("invoices.txt")) {
            printInvoices(invoices, out);
        } catch (final IOException ex) {
            log.error("Unable to print invoice.", ex);
        }

	}
	/**
	 * Takes in a file name to read an object's details from
	 * @param fileName - name of the file
	 * @return object - should return object written on file passed in
	 */
	private static Object readFilesIn(String fileName) {
		Object object = null;
		try {ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			object = in.readObject();
		    in.close();
		 }
		 catch(ClassNotFoundException ex) {
		    ex.printStackTrace();
		 }
		 catch(IOException ex) {
		    ex.printStackTrace();
		 }
		return object;
	}
	
    /**
     * Create invoices for the clients from the timecards.
     * @param accounts the accounts to create the invoices for
     * @param timeCards the time cards to create the invoices from
     * @return the created invoices
     */
    private static List<Invoice> createInvoices(final List<ClientAccount> accounts,
                                            final List<TimeCard> timeCards) {
        final List<Invoice> invoices = new ArrayList<Invoice>();

        final List<TimeCard> timeCardList = TimeCardListUtil
                .getTimeCardsForDateRange(timeCards, new DateRange(INVOICE_MONTH, INVOICE_YEAR));
        for (final ClientAccount account : accounts) {
            final Invoice invoice = new Invoice(account, INVOICE_MONTH, INVOICE_YEAR);
            invoices.add(invoice);
            for (final TimeCard currentTimeCard : timeCardList) {
                invoice.extractLineItems(currentTimeCard);
            }
        }

        return invoices;
    }
    
    /**
     * Print the invoice to a PrintStream.
     * @param invoices the invoices to print
     * @param out the print stream; can be System.out or a text file.
     * @throws UnsupportedEncodingException 
     */
    private static void printInvoices(final List<Invoice> invoices, final OutputStream out)
    	throws UnsupportedEncodingException {
    	    try (PrintStream writer = new PrintStream(out, true, ENCODING)) {
            for (final Invoice invoice : invoices) {
                writer.println(invoice.toReportString());
            }
        }
    }
}
