//                              -*- Mode: Java -*- 
// ClientWriter.java --- 
// Filename: ClientWriter.java
// Code:

package moba.server;

import java.io.*;
import java.net.SocketException;
/**
 * ClientWriter
 * @author Zhang Huayan
 * @version 1.0
 * This class is used to write the information to clients according to 
 * the output message queue in the client class.
 * <pre>
 * <h2> Change Log </h2>
 * 
 * </pre>
 */
class ClientWriter implements Runnable{
    // variable
    private OutputStreamWriter osw;
    private Client client;

    // constructor
    ClientWriter(OutputStream os, Client client){
	this.client = client;
	this.osw    = new OutputStreamWriter(os);
    }

    // methods
    @Override
    public void run(){
	String line;
	try {
	    
	    while(true){
		if(!client.isOutputEmpty()){
		    osw.write(client.outputDequeue());
		    osw.flush();
		}
	    }	    

	}catch(SocketException se){
	    // normal end
	}catch(IOException ioe){
	    System.out.println("Error " + ioe.getMessage());

	    ioe.printStackTrace();
	}
    }

    private boolean isValid(String line){
	// TODO: finish the protocal check
	return true;
    }
}
// 
// ClientWriter.java ends here
