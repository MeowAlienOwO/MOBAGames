//                              -*- Mode: Java -*- 
// ClientCommand.java --- 
// Filename: ClientCommand.java
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
//     Update #: 39
// 

// Code:

package moba.server.logic;
import moba.toolkit.*;
import moba.server.communicator.*;
/**
 * ClientCommand
 * @author Zhang Huayan
 * @version 1.0
 * ClientCommand contains both the command information and client information
 * for easier dealing with clients.
 */

public class ClientCommand{
    
    // variables
    private Command command; 
    private Client client;
    private Long time;


    // constructor
    public ClientCommand(Command command, Client client, Long time){
        this.command = command;
        this.client = client;
        this.time = time;
    }

    // methods

    public Command getCommand(){
        return command;
    }

    public Client getClient(){
        return client;
    }

    public Long getTime(){
        return time;
    }
    
}


// 
// ClientCommand.java ends here
