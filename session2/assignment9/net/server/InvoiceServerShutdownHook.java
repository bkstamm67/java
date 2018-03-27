package com.scg.net.server;

import java.util.List;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;

/**
 * ShutdownHook for the InvoiceServer, writes the current contents of the client and consultants 
 * lists as text to separate files. Also, writes brief messages to console so it is apparent it 
 * is running.
 * 
 * @author Brian Stamm
 *
 */
public class InvoiceServerShutdownHook extends Thread implements Runnable {

		/** The socket connection. */
    private final Socket clientSocket;

    /** The client list */
    private final List<ClientAccount> clientList;

    /** The consultant list  */
    private final List<Consultant> consultantList;

    /** The time card list to be maintained by this CommandProcessor. */
    private final List<TimeCard> timeCardList = new ArrayList<TimeCard>();

    /** The name of the directory to be used for files output by commands. */
    private String outputDirectoryName = ".";
	
	/**
	 * Construct an InvoiceServerShutDownHook.
	 * 
	 * @param clientList - the ClientList to serialize.
	 * @param consultantList - the ConsultantList to serialize.
	 * @param outputDirectoryName - name of directory to write output to
	 */
	public InvoiceServerShutdownHook(List<ClientAccount> clientList,
            List<Consultant> consultantList,
            String outputDirectoryName) {
		this.clientList = clientList;
		this.consultantList = consultantList;
		this.outputDirectoryName = outputDirectoryName;
	}
	
	/**
	 * Called by the Runtime when a shutdown signal is received. This will write the client and 
	 * consultant lists to file, then shut down after SHUTDOWN_DELAY_SECONDS seconds.
	 * 
	 * @see run in interface Runnable
	 */
	@Override
	public void run() {
		final File serverDir = new File(outputDirectoryName);
		if(serverDir.exists()||serverDir.mkdirs()){
			File clientFile = new File(serverDir, "ClientList.txt");
			File consultantFile = new File(serverDir, "ConsultantList.txt");
			
			try(PrintStream clientOut = new PrintStream(serverDir);
			    PrintStream consultantOut = new PrintStream(serverDir);){
				synchronized(clientList){
					for(ClientAccount client : clientList){
						clientOut.println(client);
					}
				}
				synchronized(consultantList){
					for(Consultant consultant : consultantList){
						consultantOut.println(consultant);
					}
				}
			}
		}
	}
	
}
