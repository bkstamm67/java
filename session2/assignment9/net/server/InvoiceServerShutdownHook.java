package com.scg.net.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;

/**
 * ShutdownHook for the InvoiceServer, writes the current contents of the client and consultants 
 * lists as text to separate files. Also, writes brief messages to console so it is apparent it 
 * is running.
 * 
 * @author Brian Stamm
 */
public class InvoiceServerShutdownHook extends Thread implements Runnable {

	/** The class' logger. */
    private static final Logger log =
            LoggerFactory.getLogger(InvoiceServerShutdownHook.class);
	
    /** The client list */
    private final List<ClientAccount> clientList;

    /** The consultant list  */
    private final List<Consultant> consultantList;

    /** The name of the directory to be used for files output by commands. */
    private String outputDirectoryName = ".";
	
	/**
	 * Construct an InvoiceServerShutDownHook.
	 * 
	 * @param clientList - the ClientList to serialize.
	 * @param consultantList - the ConsultantList to serialize.
	 * @param outputDirectoryName - name of directory to write output to
	 */
	public InvoiceServerShutdownHook(List<ClientAccount> clientList,List<Consultant> consultantList, String outputDirectoryName) {
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
			
			try(PrintStream clientOut = new PrintStream(clientFile);
			    PrintStream consultantOut = new PrintStream(consultantFile);){
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
			catch(FileNotFoundException e) {
				log.error("This was wrong:  " + e);
			}
		}
	}
}
	

