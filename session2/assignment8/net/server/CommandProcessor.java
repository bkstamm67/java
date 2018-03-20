package com.scg.net.server;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;
import com.scg.net.cmd.AddClientCommand;
import com.scg.net.cmd.AddConsultantCommand;
import com.scg.net.cmd.AddTimeCardCommand;

/**
 * The command processor for the invoice server. Implements the receiver role in the 
 * Command design pattern, provides the execute method for all of the supported commands. 
 * Is provided with the client and consultant lists from the Invoice server, maintains 
 * its own time card list.
 * 
 * @author Brian Stamm
 */
public class CommandProcessor {
	
	/** Something */
	Socket connection;
	/** Something */
	List<ClientAccount> clientList;
	/** Something */
	List<Consultant> consultantList;
	/** Something */
	List<TimeCard> timeCardList;
	/** Something */
	InvoiceServer server;
	/** Something */
	private String outPutDirectoryName;
	
	/**
	 * Construct a CommandProcessor.
	 * @param connection - the Socket connecting the server to the client.
	 * @param clientList - the ClientList to add Clients to.
	 * @param consultantList - the ConsultantList to add Consultants to.
	 * @param server - the server that created this command processor
	 */
	public CommandProcessor(Socket connection,List<ClientAccount> clientList,List<Consultant> consultantList, 
			InvoiceServer server) {
		this.connection = connection;
		this.clientList = new ArrayList<>(clientList);
		this.consultantList = new ArrayList<>(consultantList);
		this.timeCardList = new ArrayList<>();
		this.server = server;
	}
	
	/**
	 * Set the output directory name.
	 * @param outPutDirectoryName - the output directory name.
	 */
	public void setOutPutDirectoryName(String outPutDirectoryName) {
		this.outPutDirectoryName = outPutDirectoryName;
	}
	
	/**
	 * Execute and AddTimeCardCommand.
	 * @param command - the command to execute.
	 */
	public void execute(AddTimeCardCommand command) {
		timeCardList.add(command.getTarget());
	}
	
	/**
	 * Execute an AddClientCommand.
	 * @param command - the command to execute.
	 */
	public void execute(AddClientCommand command) {
		clientList.add(command.getTarget());
	}
	
	/**
	 * Execute and AddConsultantCommand.
	 * @param command - the command to execute.
	 */
	public void execute(AddConsultantCommand command) {
		consultantList.add(command.getTarget());
	}
	
	/**
	 * Execute a CreateInvoicesCommand.
	 * @param command - the command to execute.
	 */
	public void execute(CreateInvoicesCommand command) {
		
	}
	
	/**
	 * Execute a DisconnectCommand.
	 * @param command - the input DisconnectCommand.
	 */
	public void execute(DisconnectCommand command) {
		
	}
	
	/**
	 * 	Execute a ShutdownCommand. Closes any current connections, stops listening for 
	 * connections and then terminates the server, without calling System.exit.
	 * @param command- the input ShutdownCommand.
	 */
	public void execute(ShutdownCommand command) {
		
	}

}
