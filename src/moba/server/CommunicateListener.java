//                              -*- Mode: Java -*- 
// CommunicateListener.java --- 
// Filename: CommunicateListener.java

// Code:
package moba.server;

import java.net.*;
import java.io.*;
/**
 * CommunicateListener
 * @author Zhang Huayan
 * @version 1.0
 * This class listens to the port, if there is any server connected, establish 
 * the communication and regist the client.
 * <pre>
 * <h2> Change Log </h2>
 * 
 * </pre>
 */

class CommunicateListener implements Runnable{
    
    // variable
    private int port;
    private ServerSocket ss;
        
    // constructor
    CommunicateListener(int port){
	setPort(port);
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
		Socket s = ss.accept();
		// Client client = new Client(s);
		// TODO: deal with new socket.
	    }

	}catch(SocketException se){
	    System.out.println("Listener end");
	}catch(IOException ioe){
	    System.out.println("Error" + ioe.getMessage());
	    ioe.printStackTrace();
	}
	System.out.println("Listener end");
    }

    public void stop(){
	System.out.println("Stoping the Listener...");
	ss.close();
	
    }
    /**
     * set port number.
     * @param int port
     */
    private void setPort(int port){
	if(port > 1023 && port < 65536){
	    this.port = port;
	}
    }

}

// 
// CommunicateListener.java ends here
