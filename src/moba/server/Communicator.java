//                              -*- Mode: Java -*- 
// Communicator.java --- 
// Filename: Communicator.java
// Code:


package moba.server;

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
    /**
     * Add two integer.
     * @param i
     * @param j
     * Integer
     * @return sum of two int
     */
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
    private CommunicateListener listener;
    // constructors
    private Communicator(){
	this.listener = CommunicateListener.get();
    }
    
    private Communicator(String port){
	
	setPort(Integer.parseInt(port));
	Communicator();

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
     * get port number
     */
    int getPort(){
	return this.port;
    }

    void setup(){
	listener.setPort(port);
	Thread listenerThread = new Thread(listener);

	listenerThread.start();
    }
}


// 
// Communicator.java ends here
