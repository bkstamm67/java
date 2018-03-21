package com.scg.net.client;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scg.domain.ClientAccount;
import com.scg.domain.TimeCard;
import com.scg.net.cmd.AddClientCommand;
import com.scg.net.cmd.AddConsultantCommand;
import com.scg.net.cmd.Command;
import com.scg.net.cmd.CreateInvoicesCommand;
import com.scg.net.cmd.DisconnectCommand;
import com.scg.net.cmd.ShutdownCommand;
import com.scg.util.Address;
import com.scg.util.PersonalName;
import com.scg.util.StateCode;

/**
 * The client of the InvoiceServer. Connects to the server, sends commands to 
 * add clients, consultants and time cards and then has the server create an invoice.
 * @author Brian Stamm
 *
 */
public class InvoiceClient {
	
	/** Logger */
	private static final Logger log = LoggerFactory.getLogger(InvoiceClient.class);
	
	/** Something */
	private int port;
	
	/** Something */
	private String host;
	
	/** Something */
	private List<TimeCard> timeCardList;
	
	/** Something */
	private Socket socket;
	
	/** Something */
	Month INVOICE_MONTH; 
	
	/** Something */
	int INVOICE_YEAR;
	
	PersonalName nameTest1 = new PersonalName("Roosevelt", "Franklin", "Delano");
	Address addressTest1 = new Address("1 Broad Street", "Hyde Park", StateCode.NY, "12538");
	
	PersonalName nameTest2 = new PersonalName("Knope", "Leslie", "Barbara");
	Address addressTest2 = new Address("2 Narrow Lane", "Pawnee", StateCode.IN, "46220");
	
	//private List<ClientAccount> clientAccountList;

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
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file.txt"));
		try(Socket socket = new Socket(host,port);){
			System.out.println(String.format("Connected to server at:%S%S%dz", socket.getInetAddress().getHostName(), socket.getInetAddress().getHostAddress(), socket.getPort()));
		}
	}
	
	public void sendCommand(ObjectOutputStream out, Command<?> command) {
		try {
			out.writeObject(command);
			out.flush();
		}
		catch(IOException e) {
			log.error("InvoiceClient - Send command:  " + e);
		}
	}
	
	/**
	 * Send some new clients to the server.
	 * @param out - the output stream connecting this client to the server.
	 */
	public void sendClients(ObjectOutputStream out) {
		/*try(Socket socket = new Socket(host,port);
		    OutputStream os = socket.getOutputStream();
		    PrintWriter wtr = new PrintWriter(new OutputStreamWriter(os), true);){
			for(ClientAccount ca : clientAccountList){
				wtr.println(ca);
			}
		}*/
		AddClientCommand command = null;
	    //public ClientAccount(final String name, final PersonalName contact, final Address address) 
		ClientAccount newOne = new ClientAccount("Franklin and Company", nameTest1, addressTest1);
		//command = new AddConsultantCommand();
		ClientAccount newTwo = new ClientAccount("Parks and Rec", nameTest2, addressTest2);
		
		command = new AddClientCommand(newOne);
		sendCommand(out, command);
		/*
		command = new AddClientCommand(newTwo);
		sendCommand(out, command);
		*/
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
		DisconnectCommand command = new DisconnectCommand();
		sendCommand(out, command);
		try {
			server.close();
		}
		catch(IOException e) {
			log.error("InvoiceClient - sendDisconnect:  " + e);
		}
		
	}

	/**
	 * Send the command to the server to create invoices for the specified month.
	 * @param out - the output stream connecting this client to the server.
	 * @param month - the month to create invoice for
	 * @param year - the year to create invoice for
	 */
	public void createInvoices(ObjectOutputStream out,java.time.Month month,int year) {
		LocalDate date = LocalDate.of(year, month, 1);
		CreateInvoicesCommand command = new CreateInvoicesCommand(date);
		sendCommand(out,command);
	}

	/**
	 * Send the shutdown command to the server, this is done on a separate connection to the server.
	 * @param host - the host for the server.
	 * @param port - the port for the server.
	 */
	public static void sendShutdown(String host,int port) {
		try(Socket server = new Socket(host, port);){
			System.out.println();
			ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
			server.getOutputStream();
			server.shutdownInput();
			ShutdownCommand command = new ShutdownCommand();
			sendCommand(out, command);
			server.close();
		}
		catch(IOException e) {
			log.error("InvoiceClient - sendShutdown:  " + e);
		}
		
	}
	
}
