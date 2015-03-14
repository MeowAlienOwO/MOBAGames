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
	public int getClientId() {
		return clientId;
	}

	public boolean isInputEmpty() {
		return inputQueue.isEmpty();
	}

	public boolean isOutputEmpty() {
		return outputQueue.isEmpty();
	}

	public boolean inputEnqueue(String line) {
		return inputQueue.offer(line);
	}

	public boolean outputEnqueue(String line) {
		return outputQueue.offer(line);
	}

	public String inputDequeue() {
		return inputQueue.poll();
	}

	public String outputDequeue() {
		return outputQueue.poll();
	}

	public String inputExamine() {
		return inputQueue.peek();
	}

	public String outputExamine() {
		return outputQueue.peek();
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
