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
//     Update #: 157
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
    private static int ID = 0;
    private Command command; 
    private Client client;
    private Long time;
    private int priority;
    private int id;
    

    // constructor
    public ClientCommand(Command command, Client client, Long time){
        this.command = command;
        this.client = client;
        this.time = time;
        this.priority = setPriority(command);
        this.id = ID++;
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

    public int getPriority(){
        return priority;
    }

    public int getID(){
        return id;
    }

    /**
     * This method gets a command as argument, and 
     * return the priority that the command should have.
     * @require Command command: the command to be evaluated
     * @return int priority: the priority level of command
     *
     * typical format for command type:
     * [SYS|GAME].[CMD_NAME]
     *     ^           ^
     * splited[0] splited[1]
     *
     * The priority is designed as below:
     * SYSTEM > GAME
     * those will definitely cause state change >
     * those may cause state change >
     * those won't cause state change
     * 
     * e.g. 
     * 1 A attacks B, B is moving happens in same time:
     * ATTACK may cause state change, therefore has higher
     * priority therefore the evaluation sequence should 
     * be first ATTACK, then MOVE.
     *
     * 2 A uses an item to let itself can't be attacked,
     * B attacks A
     * since using an item will definitely cause status
     * changing, using item should be evaluated first
     * therefore the sequence should be first ITEM, then
     * MOVE
     *
     * TODO: It's possible that some of the item/spell
     * definitely changes status(i.e. debuff/buff),
     * and some of them are not. how to set the priority?
     * or changing the priority system is a good idea? 
     */

    
    private int setPriority(Command command){
        String[] splited = command.getCommandType().split("\\"+CmdConstants.TYPE_SEPARATOR);
        int priority = -1;      // not to be executed

        if(splited[0].equals(CmdConstants.SYSTEM)){
            // system command always has highest priority
            priority = Integer.MAX_VALUE; 
        }else if(splited[0].equals(CmdConstants.GAME)){
            // game command should be evaluated according
            // to their causes
            if(splited[1].equals(CmdConstants.ATTACK)){ priority = 1;}
            if(splited[1].equals(CmdConstants.MOVE)){ priority = 0;}
        }
        return priority;
    }

    
}


// 
// ClientCommand.java ends here
