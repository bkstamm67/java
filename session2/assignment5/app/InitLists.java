package app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;
import com.scg.util.ListFactory;

/**
 * Initialize client list files, creates the client, consultant and time card lists using 
 * ListFactory.populateLists and serializes the accounts and time card lists to separate 
 * files. NOTE: that the consultant list is not serialized to file.
 * @author Brian Stamm
 */
public class InitLists {
	
	/**
	 * InitLists application method.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		
		//Initialize lists
		List<ClientAccount> clients = new ArrayList<>();
		List<Consultant> consultants = new ArrayList<>();;
		List<TimeCard> timeCards = new ArrayList<>();;
		
		//Use ListFactory to fill those lists
		ListFactory.populateLists(clients, consultants, timeCards);
		
		//Write clients out
		try {ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ClientList.ser"));
		    out.writeObject(clients);
		    out.close();
		 }
		 catch(IOException ex) {
		    ex.printStackTrace();
		 }
		
		//Write timecards out
		try {ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("TimeCardList.ser"));
			out.writeObject(timeCards);
			out.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}

	}

}
