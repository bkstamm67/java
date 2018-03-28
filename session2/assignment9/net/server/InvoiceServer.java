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
 * @author Russ Moul
 */
public class InvoiceServer {
    /** The class' logger. */
    private static final Logger logger =
                         LoggerFactory.getLogger(InvoiceServer.class);

    /** The clients/accounts. */
    private final List<ClientAccount> clientList;

    /** The consultants. */
    private final List<Consultant> consultantList;

    /** The server socket socket. */
    private ServerSocket serverSocket = null;

    /** The server socket port. */
    private final int port;

    /** The name of the directory to be used for files output by commands. */
    private String outputDirectoryName = ".";

    /**
     * Construct an InvoiceServer with a port.
     *
     * @param port The port for this server to listen on
     * @param clientList the initial list of clients
     * @param consultantList the initial list of consultants
     * @param outputDirectoryName the directory to be used for files output by commands
     */
    //Docs have it throw an IO exception
    public InvoiceServer(final int port, final List<ClientAccount> clientList,
                         final List<Consultant> consultantList,
                         final String outputDirectoryName) throws IOException {
        this.port = port;
        this.clientList = clientList;
        this.consultantList = consultantList;
        this.outputDirectoryName = outputDirectoryName;
        this.serverSocket = new ServerSocket(port);
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
                    //commandProcess//.//.setOutput(serverDir.getAbsolutePath());
                    final Thread thread = new Thread(commandProcess,"CommandProcessor_"+processorNum);
                    thread.start();
                    processorNum++;
                }
                else{
                    logger.error("Poop");
                }
            }
            catch (final SocketException sx) {
                    logger.info("Server socket closed.");
            }
            catch (final IOException e1) {
                //there a try block here.
                logger.error("Unable to bind server socket to port " + port);
            }
        }
                
        /*try (ServerSocket serverSocket = new ServerSocket(port)) {
            this.serverSocket = serverSocket;
            logger.info("InvoiceServer started on: "
                      + serverSocket.getInetAddress().getHostName() + ":"
                      + serverSocket.getLocalPort());

            while (!serverSocket.isClosed()) {
                logger.info("InvoiceServer waiting for connection on port " + port);
                try (Socket client = serverSocket.accept()) {
                    serviceConnection(client);
                } catch (final SocketException sx) {
                    logger.info("Server socket closed.");
                }
            }
        } catch (final IOException e1) {
            logger.error("Unable to bind server socket to port " + port);
        }*/
    }

    /**
     * Read and process commands from the provided socket.
     * @param client the socket to read from
     */
    /*void serviceConnection(final Socket client) {
        try {
            client.shutdownOutput();
            InputStream is = client.getInputStream();

            ObjectInputStream in = new ObjectInputStream(is);
            logger.info("Connection made.");
            final CommandProcessor cmdProc =
                new CommandProcessor(client, "name", clientList, consultantList, this);
            cmdProc.setOutPutDirectoryName(outputDirectoryName);
            while (!client.isClosed()) {
                final Object obj = in.readObject();
                if (obj == null) {
                    client.close();
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
    }*/
    
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
