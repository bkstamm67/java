package com.scg.net.server;

import java.net.Socket;
import java.util.List;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;

/**
 * The server for creating new clients, consultants and time cards as well as 
 * creation of account invoices. Maintains it's own list of clients and consultants, 
 * but not time cards.
 * 
 * @author Brian Stamm
 */
public class InvoiceServer {

	/**
	 * Construct an InvoiceServer with a port.
	 * @param port - The port for this server to listen on
	 * @param clientList - the initial list of clients
	 * @param consultantList - the initial list of consultants
	 * @param outputDirectoryName - the directory to be used for files output by commands
	 */
	public InvoiceServer(int port, List<ClientAccount> clientList, List<Consultant> consultantList, 
			String outputDirectoryName) {
		
	}

	/**
	 * Run this server, establishing connections, receiving commands, and dispatching
	 * them to the CommandProcesser.
	 */
	public void run() {
		
	}
	
	/**
	 * Read and process commands from the provided socket.
	 * @param client - the socket to read from
	 */
	void serviceConnection(Socket client) {
		
	}
	
	/**
	 * Shutdown the server.
	 */
	void shutdown() {
		
	}
	
	
}
