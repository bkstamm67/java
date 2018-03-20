package com.scg.net.client;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.scg.domain.ClientAccount;
import com.scg.domain.TimeCard;

/**
 * The client of the InvoiceServer. Connects to the server, sends commands to 
 * add clients, consultants and time cards and then has the server create an invoice.
 * @author Brian Stamm
 *
 */
public class InvoiceClient {
	
	/** Something */
	private int port;
	
	/** Something */
	private String host;
	
	/** Something */
	private List<TimeCard> timeCardList;
	
	/** Something */
	private Socket socket;
	
	private List<ClientAccount> clientAccountList;

	/**
	 * Construct an InvoiceClient with a host and port for the server.
	 * @param host - the host for the server.
	 * @param port - the port for the server.
	 * @param timeCardList - the list of timeCards to send to the server
	 */
	public InvoiceClient(String host,int port, List<TimeCard> timeCardList) {
		this.host = host;
		this.port = port;
		this.timeCardList = new ArrayList<>(timeCardList);
		//socket = new Socket(host,port);
	}
	
	/**
	 * Runs this InvoiceClient, sending clients, consultants, and time cards 
	 * to the server, then sending the command to create invoices for a specified 
	 * month.
	 */
	public void run() {
		
	}
	
	/**
	 * Send some new clients to the server.
	 * @param out - the output stream connecting this client to the server.
	 */
	public void sendClients(ObjectOutputStream out) {
		try(Socket socket = new Socket(host,port);
		    OutputStream os = socket.getOutputStream();
		    PrintWriter wtr = new PrintWriter(new OutputStreamWriter(os), true);){
			for(ClientAccount ca : clientAccountList){
				wtr.println(ca);
			}
		}
	}
	
	/**
	 * Send some new consultants to the server.
	 * @param out - the output stream connecting this client to the server.
	 */
	public void sendConsultants(ObjectOutputStream out) {
		
	}

	/**
	 * Send the time cards to the server.
	 * @param out - the output stream connecting this client to the server.
	 */
	public void sendTimeCards(ObjectOutputStream out) {
		
	}
	
	/**
	 * Send the disconnect command to the server.
	 * @param out - the output stream connecting this client to the server.
	 * @param server - the connection to be closed after sending disconnect
	 */
	public void sendDisconnect(ObjectOutputStream out,Socket server) {
		/*
		wtr.println("quit");
		wtr.close();
		try{
			socket.close();
		catch(IOException e){
			e.printStackTrace();
		}
		*/
	}

	/**
	 * Send the command to the server to create invoices for the specified month.
	 * @param out - the output stream connecting this client to the server.
	 * @param month - the month to create invoice for
	 * @param year - the year to create invoice for
	 */
	public void createInvoices(ObjectOutputStream out,java.time.Month month,int year) {
		
	}

	/**
	 * Send the shutdown command to the server, this is done on a separate connection to the server.
	 * @param host - the host for the server.
	 * @param port - the port for the server.
	 */
	public static void sendShutdown(String host,int port) {
		
	}
	
}
