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
//     Update #: 53
// 

// Code:


package moba.server.logic;

import java.util.*;
import moba.server.communicator.*;
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
    private volatile Queue<String> stringQueue;
    private volatile Queue<Command> commandQueue;
    // constructor
    public Logic(List<Client> clientList){
	this.clientList = clientList;
        this.stringQueue = new LinkedList<String>();
        this.commandQueue = new LinkedList<Command>();

    }
    // methods
    public void work(){
	initialize();
        /* preprocessor: thread for putting strings into string list */
        /* decoder: thread for changing string into cmd */
        /* mainlogic: thread for executing cmd and update world*/
    }

    public void getString(){
        
    }

    private void initialize(){
	
    }

    

}


// 
// Logic.java ends here
