//                              -*- Mode: Java -*- 
// SocketListener.java --- 
// Filename: SocketListener.java

// Code:
package moba.server.communicator;

import java.net.*;
import java.io.*;
/**
 * SocketListener
 * @author Zhang Huayan
 * @version 1.0
 * This class listens to the port, if there is any server connected, establish 
 * the communication and regist the client.
 */

public class SocketListener extends Thread{
    // variable
    private int port;
    private ServerSocket ss;
    private Communicator communicator;
    
    // constructor
    SocketListener(int port, Communicator communicator){
	this.port = port;
	this.communicator = communicator;
	// this.communicator = Communicator.get();
	try {
	    ss = new ServerSocket(port);
	}catch(IOException ioe){
	    System.out.println("Error " + ioe.getMessage());
	    ioe.printStackTrace();
	}
    }
    

    // method
    @Override
    public void run(){
	System.out.println("Listener start");
	try {

	    while(true){
		Client client = new Client(ss.accept());
		communicator.register(client);
	    }
	}catch(SocketException se){
	    System.out.println("Listener end");
	}catch(IOException ioe){
	    System.out.println("Error" + ioe.getMessage());
	    ioe.printStackTrace();
	}

    }

    public void close(){
	System.out.println("Stoping the Listener...");
	try {
	    ss.close();	    
	}
	catch (IOException ioe) {
	    System.out.println("Error " + ioe.getMessage());
	    ioe.printStackTrace();
	}


    }
}

// 
// SocketListener.java ends here
