//                              -*- Mode: Java -*- 
// Client.java --- 
// Filename: Client.java
// Code:

package moba.server.communicator;

import java.io.*;
import java.net.*;
import java.util.*;
import moba.server.database.*;
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
    private User user;          // user information. if it is null, then is not logged in
    private ClientReader reader;
    private ClientWriter writer;
    private volatile Queue<String> inputQueue; // to store the information from client
    private volatile Queue<String> outputQueue; // to store the information to be sent

    // constructor
    Client(Socket socket) {
        try {
            this.clientId = Client.ID;
            this.socket = socket;
            this.user = null;
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
    public  int getClientId() {
        return clientId;
    }

    public boolean isInputEmpty() {
        synchronized(inputQueue){
            return inputQueue.isEmpty();
        }
    }

    public boolean isOutputEmpty() {
        synchronized(outputQueue){
            return outputQueue.isEmpty();
        }
    }

    public boolean inputEnqueue(String line) {
        synchronized(inputQueue){
            return inputQueue.offer(line);
        }
    }

    public boolean outputEnqueue(String line) {
        synchronized(outputQueue){
            return outputQueue.offer(line);
        }
    }

    public String inputDequeue() {
        synchronized(inputQueue){
            return inputQueue.poll();
        }
    }

    public String outputDequeue() {
        synchronized(outputQueue){
            return outputQueue.poll();
        }
    }

    public String inputExamine() {
        synchronized(inputQueue){
            return inputQueue.peek();
        }
    }

    public String outputExamine() {
        synchronized(outputQueue){
            return outputQueue.peek();
        }
    }

    public boolean isClosed(){
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

    public void setUser(User user){
        this.user = user;
    } 

    public User getUser(){

        return user;
    }

    public boolean hasUser(){
        return user != null;
    }

}
//
// Client.java ends here
