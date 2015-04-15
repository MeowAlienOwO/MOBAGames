//                              -*- Mode: Java -*- 
// ClientWriter.java --- 
// Filename: ClientWriter.java
// Code:

package moba.server.communicator;

import java.io.*;
import java.net.SocketException;

/**
 * ClientWriter
 * 
 * @author Zhang Huayan
 * @version 1.0 This class is used to write the information to clients according
 *          to the output message queue in the client class.
 */
public class ClientWriter implements Runnable {
    // variable
    private OutputStreamWriter writer;
    private Client client;

    // constructor
    ClientWriter(OutputStream os, Client client) {
        this.client = client;
        this.writer = new OutputStreamWriter(os);
    }

    // methods
    @Override
    public void run() {
        String output;
        
        try {
            while (true) {
                if (!client.isOutputEmpty()) {
                    writer.write(client.outputDequeue() + "\n");
                    writer.flush();
                }
            }

        } catch (SocketException se) {
            // normal end
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.getMessage());
            ioe.printStackTrace();
        } 
    }

    private boolean isValid(String line) {
        // TODO: finish the protocal check
        return true;
    }
}
//
// ClientWriter.java ends here
