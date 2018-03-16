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
	
	/** Something about port */
	private int port;
	/** Something */
	String outputDirectoryName;
	/** Something */
	private List<ClientAccount> clientList;
	/** Something */
	private List<Consultant> consultantList;
	/** Something */
	private ServerSocket serverSock;
	
	/**
	 * Construct an InvoiceServer with a port.
	 * @param port - The port for this server to listen on
	 * @param clientList - the initial list of clients
	 * @param consultantList - the initial list of consultants
	 * @param outputDirectoryName - the directory to be used for files output by commands
	 */
	public InvoiceServer(int port, List<ClientAccount> clientList, List<Consultant> consultantList, 
			String outputDirectoryName) {
		this.port = port;
		this.clientList = new ArrayList<>(clientList);
		this.consultantList = new ArrayList<>(consultantList);
		this.outputDirectoryName = outputDirectoryName;
	}

	/**
	 * Run this server, establishing connections, receiving commands, and dispatching
	 * them to the CommandProcesser.
	 */
	public void run() {
		try{
			serverSock = new ServerSocket(port);
			System.out.println("InvoiceServer ready on port " + port + " . . .");
			while(serverSock != null && !serverSock.isClosed()){
				Socket sock = serverSock.accept();
				serviceConnection(sock);
		}
		catch(IOException e){
			System.err.println("InvoiceServer error: " + e);
		}
		finally{
			if(serverSock != null){
				try{
					serverSock.close();
				}
				catch(IOException ioe){
					System.err.println("InvoiceServer error in closing: " + ioe);
				}
			}
		}
	}
	
	/**
	 * Read and process commands from the provided socket.
	 * @param client - the socket to read from
	 */
	void serviceConnection(Socket client) {
		try {
			InputStream inStream = client.getInputStream();
			Reader kindle = new InputStreamReader(inStream);
			BufferedReader br = new BufferedReader(kindle);
			
			while(true){
				String s = br.readLine();
				
				if(s == null || s.equals("quit")){
					System.out.println("InvoiceServer, quiting...");
					break;
				}
				else if(s.equals("exit")){
					System.out.println("InvoiceServer, exiting....");
					serverSock.close();
					serverSock = null;
					break;
				}
				
				System.out.println(s);
			}
			
			br.close();
			client.close();
		}
		catch(IOException ex){
			System.err.println("InvoiceServer error, connection: " + e);
		}
	}
	
	/**
	 * Shutdown the server.
	 */
	void shutdown() {
		
	}
	
	
}
