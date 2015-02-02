//                              -*- Mode: Java -*- 
// Communicator.java --- 
// Filename: Communicator.java
// Code:


package moba.server.communicator;

import java.util.*;
/**
 * Communicator
 * @author Zhang Huayan
 * @version 1.0
 * This class is used to maintain the communication between server and 
 * client.
 * Communicator holds a list of all registed clients, and provides several 
 * APIs to access the information holds in clients.
 * All clients could only be accessed by ID and certain API.
 */

public class Communicator{

    // static variables
    private static Communicator communicator;

    
    // static methods
    public static Communicator get(){
	if(Communicator.communicator == null){
	    Communicator.communicator = new Communicator();
	}
	return Communicator.communicator;
    }
        
    // variables
    private int port = 1234;	// default port num
    private SocketListener listener;
    private List<Client> clientLst;
    
    // constructors
    private Communicator(){
	clientLst = new LinkedList<Client>();

	this.listener = SocketListener.get();

	Thread t = new Thread(this.listener);
	t.start();
    }

    // methods
    /**
     * find client according to certain ID.
     * @param int id: the id number for client
     * @return Client: the client whose ID is same as given
     */
    
    public Client findClient(int id){
	for(int i = 0; i < clientLst.size(); i++){
	    if(clientLst.get(i).getID() == id){
		return clientLst.get(i);
	    }
	}

	return null;
    }

    /**
     * send a line to client whose id is same as given.
     * @param int id: the id that is used to identify the client
     * @param String line: line to be sent
     */
    public void send2Client(int id, String line){
	Client client = findClient(id);
	if(client != null){
	    client.outputEnqueue(line);
	}
    }
    
    /**
     * send a single line to all registered clients.
     * @param String line: the line to be send
     */

    public void send2All(String line){
	for(int i = 0; i < clientLst.size(); i++){
	    clientLst.get(i).outputEnqueue(line);
	}
    }

    /**
     * get a line from client
     * @param int id: the id of the client to be read
     * @return String: line read from certain client.
     */
    public String getLineFrom(int id){
	Client client = findClient(id);

	return client.inputDequeue();
    }

    /**
     * get all lines from client
     * @param int id: the id of the client to be read
     * @return List\<String\>: the list of all string read from client
     */
    public List<String> getAllFrom(int id){
	Client client = findClient(id);
	List<String> ret = new ArrayList<String>();
	while(!client.isInputEmpty()){
	    ret.add(client.inputDequeue());
	}
	return ret;
    }

    public void closeClient(int id){
	Client client = findClient(id);
	client.close();
	unregister(client);
    }
    
    public List<Client> getClients(){
	return clientLst;
    }

    /**
     * set port number.
     * @param int port
     */
    void setPort(int port){
	// check whether port is valid 
	if(port > 1023 && port < 65536){
	    this.port = port;
	}
    }
    /**
     * @return int port: the port number
     */
    int getPort(){
	return this.port;
    }


    /**
     * register the client into the client list.
     * @param Client client: the client to be registed
     * @return true if register successfully, 
     *         false otherwise.
     */
    public boolean register(Client client){
	if(clientLst.size() > 10){
	    return false;
	} 
	return this.clientLst.add(client);
    }

    /**
     * unregister the client form the client list.
     * @param Client client: the client to be moved
     * @return true if unregister successfully,
     *         false otherwise.
     */
    boolean unregister(Client client){
	return clientLst.remove(client);
    }

    /**
     * unregister the client of certain id
     * @param int id: the id of the client to be moved
     * @return true if unregister successfully,
     *         false otherwise.
     */
    boolean unregister(int id){
	return clientLst.remove(findClient(id));
    }
    
}


// 
// Communicator.java ends here
