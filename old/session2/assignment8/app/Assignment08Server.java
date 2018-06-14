package app;

import java.util.ArrayList;
import java.util.List;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;
import com.scg.net.server.InvoiceServer;
import com.scg.util.ListFactory;

/**
 * The server application for assignment 08, create an InvoiceServer instance and starts it.
 * @author Brian Stamm
 *
 */
public class Assignment08Server {

	/** The port for the server to listen on. */
	public static final int	DEFAULT_PORT = 10888;
	
	/**
	 * Instantiates an InvoiceServer,initializes its account and consultant lists and starts it.
	 * @param args - Command line parameters.
	 * @throws Exception - if the server raises any exceptions
	 */
	public static void main(String[] args) throws Exception {
		
		String dirName = "";
		
		List<ClientAccount> clients = new ArrayList<>();
		List<Consultant> consultants = new ArrayList<>();
		List<TimeCard> unusedTimeCards = new ArrayList<>();
		
		ListFactory.populateLists(clients, consultants, unusedTimeCards);
		
		InvoiceServer iServer = new InvoiceServer(DEFAULT_PORT, clients, consultants, dirName);

	}

}
