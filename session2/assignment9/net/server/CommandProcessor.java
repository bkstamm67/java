package com.scg.net.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.Invoice;
import com.scg.domain.TimeCard;
import com.scg.net.cmd.AddClientCommand;
import com.scg.net.cmd.AddConsultantCommand;
import com.scg.net.cmd.AddTimeCardCommand;
import com.scg.net.cmd.Command;
import com.scg.net.cmd.CreateInvoicesCommand;
import com.scg.net.cmd.DisconnectCommand;
import com.scg.net.cmd.ShutdownCommand;

/**
 * The command processor for the invoice server. Implements the receiver role in
 * the Command design pattern, provides the execute method for all of the
 * supported commands.  Is provided with the client and consultant lists from the
 * Invoice server, maintains its own time card list.
 *
 * @author Russ Moul
 */

public final class CommandProcessor implements Runnable {
    /** The class' logger. */
    private static final Logger logger =
                         LoggerFactory.getLogger(CommandProcessor.class);

	/** Character encoding to use. */
	private static final String ENCODING = "ISO-8859-1";

	/** The socket connection. */
    private final Socket clientSocket;

    /** The client list to be maintained by this CommandProcessor. */
    private final List<ClientAccount> clientList;

    /** The consultant list to be maintained by this CommandProcessor. */
    private final List<Consultant> consultantList;

    /** The time card list to be maintained by this CommandProcessor. */
    private final List<TimeCard> timeCardList = new ArrayList<TimeCard>();

    /** The name of the directory to be used for files output by commands. */
    private String outputDirectoryName = ".";

    /** The server this command processor is spawned from. */
    private final InvoiceServer server;
    
    /** The name of the CommandProcess, mostly used for logging */
    private final String name;

    /**
     * Construct a CommandProcessor.
     *
     * @param connection - the Socket connecting the server to the client.
     * @param name - the name assigned to this CommandProcessor by the server; mostly for logging.
     * @param clientList - the ClientList to add Clients to.
     * @param consultantList - the ConsultantList to add Consultants to.
     * @param server - the server that created this command processor
     */
    public CommandProcessor(final Socket connection,
    		                    String name,
                            final List<ClientAccount> clientList,
                            final List<Consultant> consultantList,
                            final InvoiceServer server) {
        this.clientSocket = connection;
        this.clientList = clientList;
        this.consultantList = consultantList;
        this.server = server;
        this.name = name;
    }

    /**
     * Set the output directory name.
     *
     * @param outPutDirectoryName the output directory name.
     */
    public void setOutPutDirectoryName(final String outPutDirectoryName) {
        this.outputDirectoryName = outPutDirectoryName;
    }

    /**
     * Execute and AddTimeCardCommand.
     *
     * @param command the command to execute.
     */
    public void execute(final AddTimeCardCommand command) {
        logger.info("Executing add time card command: "  + command);
	final TimeCard newTimeCard = command.getTarget();
	synchronized(timeCardList){
		if(!timeCardList.contains(newTimeCard)){
			timeCardList.add(newTimeCard);
		}
	}
    }

    /**
     * Execute an AddClientCommand.
     *
     * @param command the command to execute.
     */
    public void execute(final AddClientCommand command) {
        logger.info("Executing add client command: "  + command);
        final ClientAccount newAccount = command.getTarget();
	synchronized(clientList){
		if(!clientList.contains(newAccount)){
			clientList.add(newAccount);
		}
	}
    }

    /**
     * Execute and AddConsultantCommand.
     *
     * @param command the command to execute.
     */
    public void execute(final AddConsultantCommand command) {
        logger.info("Executing add consultant command: "  + command);
        final Consultant newConsultant = command.getTarget();
	synchronized(consultantList){
		if(!consultantList.contains(newConsultant)){
			consultantList.add(newConsultant);
		}
	}
    }

    /**
     * Execute a CreateInvoicesCommand.
     *
     * @param command the command to execute.
     */
    public void execute(final CreateInvoicesCommand command) {
        logger.info("Executing invoice command: " + command);
        Invoice invoice = null;
        LocalDate date = command.getTarget();
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMMyyyy");
        final String monthString = formatter.format(date);
        synchronized(clientList){
	for (final ClientAccount client : clientList) {
            invoice = new Invoice(client, date.getMonth(), date.getYear());
            for (final TimeCard currentTimeCard : timeCardList) {
                invoice.extractLineItems(currentTimeCard);
            }
            if (invoice.getTotalHours() > 0) {
                final File serverDir = new File(outputDirectoryName);
                if (!serverDir.exists()) {
                    if (!serverDir.mkdirs()) {
                        logger.error("Unable to create directory, " + serverDir.getAbsolutePath());
                        return;
                    }
                }
                final String outFileName = String.format("%s%sInvoice.txt",
                                           client.getName().replaceAll(" ", ""),
                                           monthString);
                final File outFile = new File(outputDirectoryName, outFileName);
                try (PrintStream printOut = new PrintStream(new FileOutputStream(outFile), true, ENCODING);) {
                    printOut.println(invoice.toReportString());
                } catch (final FileNotFoundException e) {
                    logger.error("Can't open file " + outFileName, e);
                } catch (UnsupportedEncodingException e) {
                    logger.error("Can't write to file, bad encoding.", e);
				}
            }
        }
	}
    }

    /**
     * Execute a DisconnectCommand.
     *
     * @param command the input DisconnectCommand.
     */
    public void execute(final DisconnectCommand command) {
        logger.info("Executing disconnect command: " + command);
        try {
            clientSocket.close();
        } catch (final IOException e) {
            logger.warn("Disconnect unable to close client connection.", e);
        }
    }

    /**
     * Execute a ShutdownCommand.  Closes any current connections, stops
     * listening for connections and then terminates the server, without
     * calling System.exit.
     *
     * @param command the input ShutdownCommand.
     */
    public void execute(final ShutdownCommand command) {
        logger.info("Executing shutdown command: " + command);
        try {
            clientSocket.close();
        } catch (final IOException e) {
            logger.warn("Shutdown unable to close client connection.", e);
        } finally {
            server.shutdown();
        }
    }

    /**
     * Run this CommandProcessor, reads Commands from the connection and executes them.
     * @see run in interface Runnable
     */
	@Override
	public void run() {
		/*try (ServerSocket serverSocket = new ServerSocket(port)) {
			this.serverSocket = serverSocket;
			logger.info("InvoiceServer started on: "
				    + serverSocket.getInetAddress().getHostName() + ":"
				    + serverSocket.getLocalPort());
			
			while (!serverSocket.isClosed()) {
				logger.info("InvoiceServer waiting for connection on port " + port);
				try (Socket client = serverSocket.accept()) {
					serviceConnection(client);
				} 
				catch (final SocketException sx) {
					logger.info("Server socket closed.");
				}
			}
		}
		catch (final IOException e1) {
			logger.error("Unable to bind server socket to port " + port);
		}*/
		ObjectInputStream in = null;
	    try {
	    		clientSocket.shutdownOutput();
            InputStream is = clientSocket.getInputStream();
	        in = new ObjectInputStream(is);
	        
	        final CommandProcessor cmdProc =
	                new CommandProcessor(clientSocket, "name", clientList, consultantList, server);
	        
	        cmdProc.setOutPutDirectoryName(outputDirectoryName);
	        while (!clientSocket.isClosed()) {
	                final Object obj = in.readObject();
	                if (obj == null) {
	                	clientSocket.close();
	                } else if (obj instanceof Command<?>) {
	                    final Command<?> command = (Command<?>)obj;
	                    logger.info("Received command: "
	                              + command.getClass().getSimpleName());
	                    command.setReceiver(cmdProc);
	                    command.execute();
	                } else {
	                    logger.warn(String.format("Received non command object, %s, discarding.",
	                            obj.getClass().getSimpleName()));
	                }
	            }
	        } catch (final IOException ex) {
	            logger.error("IO failure.", ex);
	        } catch (final ClassNotFoundException ex) {
	            logger.error("Unable to resolve read object.", ex);
	        }
	}
}
