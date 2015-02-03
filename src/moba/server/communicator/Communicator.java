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
	    // synchronized(Communicator.communicator){
		Communicator.communicator = new Communicator();
	    // }
	}
	return Communicator.communicator;
    }
        
    // variables
    private int port = 1234;	// default port num
    private SocketListener listener;
    private List<Client> clientLst;
    
    // constructors
    private Communicator(){
	this.clientLst = new LinkedList<Client>();
	this.listener = new SocketListener(port, this);

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
     * Close client whose id matches.
     * @param int id: the id number for the client
     */
    public void closeClient(int id){
	Client client = findClient(id);
	client.close();
	unregister(client);
    }

    /**
     * get the client list for further operation.
     * directly add/delete/modify clients is FORBIDDEN.
     * TODO: redesign this API
     * @return List<Client> Client List
     */
    public List<Client> getClients(){
	return clientLst;
    }


    /**
     * Start the module. this will start the SocketListener thread.
     */


    public void startModule(){
	this.listener.start();
    }

    /**
     * Close the module. this will close the listener, and all the clients in
     * the list, if any.
     */

    public void close(){
	listener.close();
	for(int i = 0; i < clientLst.size(); i++){
	    clientLst.get(i).close();
	}
    }

    /**
     * set port number.
     * @param int port
     */
    public void setPort(int port){
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
    boolean register(Client client){
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
