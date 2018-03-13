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
	  
	   Driver class: org.apache.derby.jdbc.ClientDriver (usage optional)
  URL:          jdbc:derby://localhost:1527/memory:scgDb
  Username:     student
  Password:     student 
	 
	 */
	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:derby://localhost:1527/memory:scgDb";
		String user = "student";
		String password = "student";
		
		List<ClientAccount> clients = new ArrayList<>();
		List<Consultant> consultants = new ArrayList<>();
		List<TimeCard> timeCards = new ArrayList<>();
		
		DbServer db = new DbServer(url,user,password);
		ListFactory.populateLists(clients, consultants, timeCards);
		
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
