//                              -*- Mode: Java -*- 
// Communicator.java --- 
// Filename: Communicator.java
// Code:

package moba.server.communicator;

import java.util.*;

/**
 * Communicator
 * 
 * @author Zhang Huayan
 * @version 1.0 This class is used to maintain the communication between server
 *          and client. Communicator holds a list of all registed clients, and
 *          provides several APIs to access the information holds in clients.
 *          All clients could only be accessed by ID and certain API.
 */

public class Communicator {

	// static variables
	private static final int PORT_MIN = 1023;
	private static final int PORT_MAX = 65536;
	private static Communicator communicator;

	// static methods
	public static Communicator get() {
		if (Communicator.communicator == null) {
			// synchronized(Communicator.communicator){
			Communicator.communicator = new Communicator();
			// }
		}
		return Communicator.communicator;
	}

	// variables
	private int port = 1234; // default port num
	private SocketListener listener;
	private List<Client> clientList;

	// constructors
	private Communicator() {
		this.clientList = new LinkedList<Client>();
		this.listener = new SocketListener(port, this);
	}

	// methods
	/**
	 * find client according to certain ID.
	 * 
	 * @param int id: the id number for client
	 * @return Client: the client whose ID is same as given
	 */

	public Client findClient(int id) {
		for (int i = 0; i < clientList.size(); i++) {
			if (clientList.get(i).getClientId() == id) {
				return clientList.get(i);
			}
		}
		return null;
	}

	/**
	 * send a line to client whose id is same as given.
	 * 
	 * @param int id: the id that is used to identify the client
	 * @param String
	 *            line: line to be sent
	 */
	public void sendToClient(int id, String line) {
		Client client = findClient(id);
		if (client != null) {
			client.outputEnqueue(line);
		}
	}

	/**
	 * send a single line to all registered clients.
	 * 
	 * @param String
	 *            line: the line to be send
	 */

	public void sendToAll(String line) {
		for (int i = 0; i < clientList.size(); i++) {
			clientList.get(i).outputEnqueue(line);
		}
	}

	/**
	 * get a line from client
	 * 
	 * @param int id: the id of the client to be read
	 * @return String: line read from certain client.
	 */
	public String getMessageFrom(int id) {
		Client client = findClient(id);
		return client.inputDequeue();
	}

	/**
	 * get all lines from client
	 * 
	 * @param int id: the id of the client to be read
	 * @return List\<String\>: the list of all string read from client
	 */
	public List<String> getAllFrom(int id) {
		Client client = findClient(id);
		List<String> result = new ArrayList<String>();
		while (!client.isInputEmpty()) {
			result.add(client.inputDequeue());
		}
		return result;
	}

	public void closeClient(int id) {
		Client client = findClient(id);
		client.close();
		unregister(client);
	}

	public List<Client> getClients() {
		return clientList;
	}

	public void startListening() {
		this.listener.start();
	}

	/**
	 * set port number.
	 * 
	 * @param int port
	 */
	void setPort(int port) {
		// check whether port is valid
		if (port > PORT_MIN && port < PORT_MAX) {
			this.port = port;
		}
	}

	/**
	 * @return int port: the port number
	 */
	int getPort() {
		return port;
	}

	/**
	 * register the client into the client list.
	 * 
	 * @param Client
	 *            client: the client to be registed
	 * @return true if register successfully, false otherwise.
	 */
	boolean register(Client client) {
		if (clientList.size() >= 10) {
			return false;
		}
		return this.clientList.add(client);
	}

	/**
	 * unregister the client form the client list.
	 * 
	 * @param Client
	 *            client: the client to be moved
	 * @return true if unregister successfully, false otherwise.
	 */
	boolean unregister(Client client) {
		return clientList.remove(client);
	}

	/**
	 * unregister the client of certain id
	 * 
	 * @param int id: the id of the client to be moved
	 * @return true if unregister successfully, false otherwise.
	 */
	boolean unregister(int id) {
		return clientList.remove(findClient(id));
	}

}

//
// Communicator.java ends here
