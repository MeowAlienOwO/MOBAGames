//                              -*- Mode: Java -*- 
// Logic.java --- 
// Filename: Logic.java
// Description: 
// Author: Zhang Huayan
// ID number: 6511043
// E-mail: zy11043@nottingham.edu.cn / MeowAlienOwO@gmail.com
// Version: 
// 

// Commentary: 
// 
// 

// Change Log:
// Status: 
// Table of Contents: 
// 
//     Update #: 111
// 

// Code:


package moba.server.logic;

import java.util.*;
import moba.server.communicator.*;
import moba.server.database.*;
import moba.toolkit.*;
/**
 * Logic
 * @author Zhang Huayan
 * @version 1.0
 * This is the main logic of the MOBA game.
 */


public class Logic{

    // variables
    private List<Client> clientList;
    // private volatile Queue<String> stringQueue;
    private volatile Queue<ClientCommand> commandQueue;
    private Preprocessor preprocessor;
    private CommandDecoder decoder;
    private Judge judge;
    private DataBase database;
    private ChangeMonitor monitor;
    // constructor
    public Logic(List<Client> clientList){
	this.clientList = clientList;
        // this.stringQueue = new LinkedList<String>();
        this.commandQueue = new LinkedList<ClientCommand>();
        this.preprocessor = new Preprocessor(clientList, commandQueue);
        // this.decoder = new CommandDecoder(stringQueue, commandQueue);
        this.judge = new Judge(clientList, commandQueue);
    }
    // methods
    public void work(){
	initialize();
        // preprocessor.sort();
        
        // judge.executeCommand();

        /* preprocessor: thread for putting strings into string list */
        Thread preprocessorThread = new Thread(preprocessor, "Preprocessor");
        preprocessorThread.start();
        /* judge: thread for executing cmd and update world */
        Thread judgeThread = new Thread(judge, "Judge");
        judgeThread.start();
        
    }

    private void initialize(){



        monitor = DataBase.get().getMonitor();
        Thread t = new Thread(monitor);
        t.start();
    }

    public void close(){
        preprocessor.close();
        
        judge.close();
    }
    

}


// 
// Logic.java ends here
