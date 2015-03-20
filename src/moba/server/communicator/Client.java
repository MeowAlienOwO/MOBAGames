//                              -*- Mode: Java -*- 
// Client.java --- 
// Filename: Client.java
// Code:

package moba.server.communicator;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Client
 * 
 * @author Zhang Huayan
 * @version 1.0 This class is used to communicate with the client and get
 *          message. It runs a reader thread and a writer thread to talk with
 *          the client. All valid information, according to the protocal, will
 *          be kept here separately. The register method is used to register the
 *          client to the client list.
 */

public class Client {
    // static variables
    private static int ID = 0; // id is the key to identify a certain client

    // variables
    private int clientId;
    private Socket socket;
    private ClientReader reader;
    private ClientWriter writer;
    private volatile Queue<String> inputQueue; // to store the information from client
    private volatile Queue<String> outputQueue; // to store the information to be sent

    // constructor
    Client(Socket socket) {
        try {
            this.clientId = Client.ID;
            this.socket = socket;
            inputQueue = new LinkedList<String>();
            outputQueue = new LinkedList<String>();
            reader = new ClientReader(socket.getInputStream(), this);
            writer = new ClientWriter(socket.getOutputStream(), this);

            Thread readerThrd = new Thread(reader);
            Thread writerThrd = new Thread(writer);

            readerThrd.start();
            writerThrd.start();
            Client.ID++;

        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.getMessage());
            ioe.printStackTrace();
        }

    }

    // methods
    /**
     * get ID from this Client.
     * 
     * @return int id
     */
    public synchronized int getClientId() {
        return clientId;
    }

    public synchronized boolean isInputEmpty() {
        return inputQueue.isEmpty();
    }

    public synchronized boolean isOutputEmpty() {
        return outputQueue.isEmpty();
    }

    public synchronized boolean inputEnqueue(String line) {
        return inputQueue.offer(line);
    }

    public synchronized boolean outputEnqueue(String line) {
        return outputQueue.offer(line);
    }

    public synchronized String inputDequeue() {
        return inputQueue.poll();
    }

    public synchronized String outputDequeue() {
        return outputQueue.poll();
    }

    public synchronized String inputExamine() {
        return inputQueue.peek();
    }

    public synchronized String outputExamine() {
        return outputQueue.peek();
    }

    public synchronized boolean isClosed(){
        return socket.isClosed();
    }

    void close() {
        try {
            socket.close();
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe.getMessage());
            ioe.printStackTrace();
        }

    }

}
//
// Client.java ends here
