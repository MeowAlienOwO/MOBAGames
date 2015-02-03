//                              -*- Mode: Java -*- 
// SimpleClient.java --- 
// Filename: SimpleClient.java
// Code:
package moba.client;

import java.util.*;
import java.net.*;
import java.io.*;

class SimpleClient implements Runnable{
    String[] data ={
	"LOGIN",
	"HELLO",
	"1",
	"2",
	"3",
	"BYE",
	"LOGOUT"
    };
    int port;
    Socket socket;
    BufferedReader br;
    OutputStreamWriter osw;
    SimpleClient(int port){
	this.port = port;
	
    }
    

    void setup(){	
	try {

	    this.socket = new Socket("localhost", port);
	    this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

	    this.osw = new OutputStreamWriter(socket.getOutputStream());	    
	}
	catch (Throwable e) {
	    System.out.println("Error " + e.getMessage());
	    e.printStackTrace();
	}

    }

    @Override
    public void run(){
	try { 

	    for(int i = 0; i < data.length; i++){
	    
		osw.write(data[i]);
		osw.flush();
	    }
   
	}
	catch (Throwable e) {
	    System.out.println("Error " + e.getMessage());
	    e.printStackTrace();
	}

    }

}


// 
// SimpleClient.java ends here
