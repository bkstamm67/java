package app;

import java.util.ArrayList;
import java.util.List;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;
import com.scg.net.server.InvoiceServer;
import com.scg.util.ListFactory;

/**
 * The server.
 * 
 * @author Brian Stamm
 */
public final class Assignment09Server {
	
	/** The port for the server to listen on. */
	public static final int DEFAULT_PORT = 10888;

	/** Private constructor to prevent instantiation */
	private Assignment09Server() {
		
	}
	
	/**
	 * Instantiates an InvoiceServer and starts it.
	 * 
	 * @param args - Command line parameters.
	 * @throws Exception - if the server raises any exceptions
	 */
	public static void main(String[] args) throws Exception {
		
		String dirName = "target";
		List<ClientAccount> clientList = new ArrayList<>();
		List<Consultant> consultantList = new ArrayList<>();
		List<TimeCard> unusedTimeCards = new ArrayList<>();
		
		ListFactory.populateLists(clientList, consultantList, unusedTimeCards);
		
		InvoiceServer iServer = new InvoiceServer(DEFAULT_PORT, clientList, consultantList, dirName);
		
		iServer.run();

	}

}
