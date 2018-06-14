package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;
import com.scg.net.client.InvoiceClient;
import com.scg.util.ListFactory;

/**
 * The Client for Solution09. 
 * 
 * @author Brian Stamm
 */
public class Assignment09 {

	public static final String LOCAL_HOST = "127.0.0.1";
	
	/**
	 * Private constructor to prevent instantiation 
	 */
	private Assignment09() {
		
	}
	
	/**
	 * Test the Solution 09 Client.
	 * 
	 * @param args - Command line parameters - not used.
	 * @throws Exception - if any occur
	 */
	public static void main(String[] args) throws Exception {
        List<ClientAccount> clientList = new ArrayList<ClientAccount>();
        List<Consultant> consultantList = new ArrayList<Consultant>();
        List<TimeCard> timeCardList = new ArrayList<TimeCard>();
        
        ListFactory.populateLists(clientList, consultantList, timeCardList);
        
        final List<TimeCard> immutableTimeCardList = Collections.unmodifiableList(timeCardList);
        
        InvoiceClient invoiceClientOne = new InvoiceClient(LOCAL_HOST, Assignment09Server.DEFAULT_PORT, immutableTimeCardList);
        InvoiceClient invoiceClientTwo = new InvoiceClient(LOCAL_HOST, Assignment09Server.DEFAULT_PORT, immutableTimeCardList);
        InvoiceClient invoiceClientThree = new InvoiceClient(LOCAL_HOST, Assignment09Server.DEFAULT_PORT, immutableTimeCardList);
        InvoiceClient invoiceClientFour = new InvoiceClient(LOCAL_HOST, Assignment09Server.DEFAULT_PORT, immutableTimeCardList);
        
        invoiceClientOne.run();
        invoiceClientTwo.run();
        invoiceClientThree.run();
        invoiceClientFour.run();
        
        invoiceClientOne.join();
        invoiceClientTwo.join();
        invoiceClientThree.join();
        invoiceClientFour.join();
        
        InvoiceClient.sendShutdown(LOCAL_HOST, Assignment09Server.DEFAULT_PORT);

	}

}
