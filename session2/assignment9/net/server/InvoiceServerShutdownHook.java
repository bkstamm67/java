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

	/**
	 * Called by the Runtime when a shutdown signal is received. This will write the client and 
	 * consultant lists to file, then shut down after SHUTDOWN_DELAY_SECONDS seconds.
	 * 
	 * @see run in interface Runnable
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
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
		
	}


}
