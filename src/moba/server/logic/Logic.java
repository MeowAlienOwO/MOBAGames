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
//     Update #: 30
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
    private List<Client> clientLst;
    private Queue<String> commandStrLst;
    private Queue<Command> commandLst;
    // constructor
    public Logic(List<Client> clientLst){
	this.clientLst = clientLst;


    }
    // methods
    public void work(){
	initialize();
	
    }

    private void initialize(){
	
    }

}


// 
// Logic.java ends here
