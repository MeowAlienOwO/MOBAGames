//                              -*- Mode: Java -*- 
// ClientReader.java --- 
// Filename: ClientReader.java
// Code:

package moba.server.communicator;

import java.io.*;
import java.net.SocketException;

/**
 * ClientReader
 * @author Zhang Huayan
 * @version 1.0
 * This class is used for read the information from client and check whether
 * them is valid. Those valid information should be put into the client's 
 * message queue, and those not valid should be ignored.
 */
public class ClientReader implements Runnable{
    // variable
    private BufferedReader br;
    private Client client;
    // constructor
    ClientReader(InputStream is, Client client){
	this.client = client;

	this.br = new BufferedReader(new InputStreamReader(is));
    }

    // methods
    @Override
    public void run(){
	String line;
	try {

	    while((line = br.readLine()) != null){
		if(isValid(line)){
		    client.inputEnqueue(addTimeStamp(line));
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
	// return SimpleLogic.checkProtocal(line);
	return true;
    }

    private String addTimeStamp(String line){
	return line;
    }
}



// 
// ClientReader.java ends here
