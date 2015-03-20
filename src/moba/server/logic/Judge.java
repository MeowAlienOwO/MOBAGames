//                              -*- Mode: Java -*- 
// Judge.java --- 
// Filename: Judge.java
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
//     Update #: 94
// 

// Code:

package moba.server.logic;
import moba.toolkit.*;
import moba.gameobj.*;
import moba.server.communicator.*;
import java.util.*;
/**
 * Judge
 * @author Zhang Huayan
 * @version 1.0
 * Judge executes the main logic, including:
 * 1. update the world and send proper information back to client
 * according to command queue. this is mainly done by the command executor
 * 2. check the data in the word and broadcast certain information back, like
 * level up, creation of hero, death of hero, etc.
 * 3. regularly generates the minors, or other related game objects.
 */


public class Judge implements Runnable{

    // variables
    private List<Client> clientList;
    private Queue<ClientCommand> commandQueue;
    private CommandExecutor executor;
    private int gameStartTime; 
    private volatile boolean exit;

    // constructor
    public Judge(List<Client> clientList, 
                 Queue<ClientCommand> commandQueue){
        this.clientList = clientList;
        this.commandQueue = commandQueue;
        this.executor = new CommandExecutor(clientList, commandQueue);
        this.exit = false;
    }

    // methods
    @Override
    public void run(){
        System.out.println("Judge start");
        while(!exit){

     

            executeCommand();
            

            updateWorld();

            
        }

    }

    public void close(){
        this.exit = true;
    }

    public void updateWorld(){
        
    }

    public void executeCommand(){
            while(!commandQueue.isEmpty()){
                executor.execute(commandQueue.poll());
            }

    }

    
}

// 
// Judge.java ends here
