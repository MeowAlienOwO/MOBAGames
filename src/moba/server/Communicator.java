//                              -*- Mode: Java -*- 
// Communicator.java --- 
// Filename: Communicator.java
// Code:


package moba.server;

import java.util.*;
/**
 * Communicator
 * @author Zhang Huayan
 * @version 1.0
 * This class is used to maintain the communication between server and 
 * client.
 * <pre>
 * <h2> Change Log </h2>
 * 
 * </pre>
 */

class Communicator{

    // static variables
    private static Communicator communicator;

    
    // static methods
    static Communicator get(){
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
    }

    // methods
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
	for(int i = 0; i < clientLst.size(); i++){
	    if(clientLst.get(i).getID() == id){
		return clientLst.remove(clientLst.get(i));
	    }
	}
	return false;
    }

    void setup(){
	listener.start();
    }
}


// 
// Communicator.java ends here
