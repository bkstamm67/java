package com.scg.net.server;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;

/**
 * The server for creating new clients, consultants and time cards as well as
 * creation of account invoices.  Maintains it's own list of clients and
 * consultants, but not time cards.
 *
 * @author Brian Stamm
 */
public class InvoiceServer {
    /** The class' logger. */
    private static final Logger logger =
                         LoggerFactory.getLogger(InvoiceServer.class);

    /** The clients/accounts list. */
    private final List<ClientAccount> clientList;

    /** The consultants list. */
    private final List<Consultant> consultantList;

    /** The server socket socket. */
    private ServerSocket serverSocket = null;

    /** The port. */
    private final int port;

    /** The name of the directory to be used for files output by commands. */
    private String outputDirectoryName = ".";
    
    /** The InvoiceServerShutdownHook instance */
    private InvoiceServerShutdownHook hook;

    /**
     * Construct an InvoiceServer with a port.
     *
     * @param port The port for this server to listen on
     * @param clientList the initial list of clients
     * @param consultantList the initial list of consultants
     * @param outputDirectoryName the directory to be used for files output by commands
     */
    public InvoiceServer(final int port, final List<ClientAccount> clientList,
                         final List<Consultant> consultantList,
                         final String outputDirectoryName) throws IOException {
        this.port = port;
        this.clientList = clientList;
        this.consultantList = consultantList;
        this.outputDirectoryName = outputDirectoryName;
        this.serverSocket = new ServerSocket(port);
        this.hook = new InvoiceServerShutdownHook(clientList,consultantList,outputDirectoryName);
    }

    /**
     * Run this server, establishing connections, receiving commands, and
     * dispatching them to the CommandProcesser.
     */
    public void run() {
        int processorNum = 0;
        
        while (!serverSocket.isClosed()) {
            try{
                logger.info("InvoiceServer waiting for connection on port " + port);
                Socket client = serverSocket.accept();
                final CommandProcessor commandProcess = new CommandProcessor(client, "CommandProcessor_"+processorNum,clientList,consultantList,this);
                final File serverDir = new File(outputDirectoryName,Integer.toString(processorNum));
                
                if(serverDir.exists()||serverDir.mkdirs()){
                    final Thread thread = new Thread(commandProcess,"CommandProcessor_"+processorNum);
                    thread.start();
                    hook.run();
                    processorNum++;
                }
                else{
                    logger.error("Error with the Thread.");
                }
            }
            catch (final SocketException sx) {
                    logger.info("Server socket closed.");
            }
            catch (final IOException e1) {
                logger.error("Unable to bind server socket to port " + port);
            }
        }
    }

    /**
     * Shutdown the server.
     */
    void shutdown() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (final IOException e) {
            logger.error("Shutdown unable to close listening socket.", e);
        }
    }
}
