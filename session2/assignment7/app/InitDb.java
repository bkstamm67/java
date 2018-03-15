package app;

import java.util.ArrayList;
import java.util.List;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;
import com.scg.persistent.DbServer;
import com.scg.util.ListFactory;

/**
 * The initialize/populate the database, creates the client, consultant and time card lists using 
 * ListFactory.populateLists and then populates the database with the data in these lists.
 * @author Brian Stamm
 */
public class InitDb {

	/**
	 * Entry point. Connects to the database and inserts the client, consultant and time card data.
	 * @param args- not used.
	 * @throws Exception - if anything goes awry	 
	 */
	public static void main(String[] args) throws Exception {
		
		//Variables used for connecting to the database
		String url = "jdbc:derby://localhost:1527/memory:scgDb";
		String user = "student";
		String password = "student";
		
		//Lists used to fill the database
		List<ClientAccount> clients = new ArrayList<>();
		List<Consultant> consultants = new ArrayList<>();
		List<TimeCard> timeCards = new ArrayList<>();
		
		//Create an instance of DbServer
		DbServer db = new DbServer(url,user,password);
		//Fill the lists
		ListFactory.populateLists(clients, consultants, timeCards);
		
		//Add values in list to database
		for(ClientAccount ca : clients) {
			db.addClient(ca);
		}
		
		for(Consultant consult : consultants) {
			db.addConsultant(consult);
		}
		
		for(TimeCard tc : timeCards) {
			db.addTimeCard(tc);
		}
		
	}

}
