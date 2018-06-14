package app;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.Invoice;
import com.scg.domain.TimeCard;
import com.scg.persistent.DbServer;
import com.scg.util.ListFactory;

/**
 * Instantiate the DbServer, and retrieve the list of clients from the database. Using the 
 * getInvoice method create and print the invoice for each client.
 * @author Brian Stamm
 */
public class Assignment07 {

	/**
	 * Connects to the database and create and invoice to the test month and year and prints it.
	 * @param args - not used
	 * @throws - if anything goes awry
	 */
	public static void main(String[] args) throws Exception {
		//Variables used to connect to the database
		String url = "jdbc:derby://localhost:1527/memory:scgDb";
		String user = "student";
		String password = "student";
		
		//Variables used for the invoice
	    final Month INVOICE_MONTH = Month.MARCH;
	    final int INVOICE_YEAR = 2006;
	    
	    //Lists used to create invoices, and a list of invoices to save those that are created
		List<ClientAccount> clients = new ArrayList<>();
		List<Consultant> consultants = new ArrayList<>();
		List<TimeCard> timeCards = new ArrayList<>();
		List<Invoice> invoices = new ArrayList<>();
		
		//Create instance of DbServer
		DbServer db = new DbServer(url,user,password);
		
		//Fill lists, only need the clients' list
		ListFactory.populateLists(clients, consultants, timeCards);
		
		//Add invoices for each client, using the getInvoice method from DbServer
		for(ClientAccount ca : clients) {
			invoices.add(db.getInvoice(ca, INVOICE_MONTH, INVOICE_YEAR));
		}
		
		//Prints out invoices
		for(Invoice i : invoices) {
			System.out.println(i.toReportString());
		}

	}

}
