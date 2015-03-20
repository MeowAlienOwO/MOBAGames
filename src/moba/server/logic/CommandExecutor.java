//                              -*- Mode: Java -*- 
// CommandExecutor.java --- 
// Filename: CommandExecutor.java
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
//     Update #: 173
// 

// Code:


package moba.server.logic;
import moba.toolkit.*;
import moba.gameobj.*;
import moba.gameobj.features.*;
import moba.server.communicator.*;
import java.util.*;

/**
 * CommandExecutor
 * @author Zhang Huayan
 * @version 1.0
 * Command Executor execute the command, and change relative datas.
 */

class CommandExecutor {

    // variables
    private List<Client> clientList;
    private Queue<ClientCommand> commandQueue;

    // constructor
    public CommandExecutor(List<Client> clientList,
                           Queue<ClientCommand> commandQueue){
        this.clientList = clientList;
        this.commandQueue = commandQueue;
    }

    // methods
    public void execute(ClientCommand clientCommand){
        Command command = clientCommand.getCommand();
        Client client = clientCommand.getClient();
        if(command == null)
            return;
	// String[] type = command.getCommandType().split("\\" + CmdConstants.TYPE_SEPARATOR);
	String[] type = command.getCommandType().split("\\.");	
	if(type[0].equals(CmdConstants.SYSTEM)){
	    // execute system 
	    if(type[1].equals(CmdConstants.LOGIN)){
		execLogin((Login)command, client);
	    } else if(type[1].equals(CmdConstants.LOGOUT)){
		execLogout((Logout)command, client);
	    }
	}else if (type[0].equals(CmdConstants.GAME)){
	    // execute Game commands
	    if(type[1].equals(CmdConstants.ATTACK)){
		execAttack((Attack)command, client);
	    }else if(type[1].equals(CmdConstants.MOVE)){
		execMove((Move)command, client);
	    }
	}
	
    }

   
    private void execLogin(Login command, Client client){
        client.outputEnqueue("OK");
        for(int i = 0; i < clientList.size(); i++){
            Client tempClient = clientList.get(i);
            if(tempClient.getClientId() != client.getClientId()){
                tempClient.outputEnqueue("Welcome " + command.getUsername());
            }
        }
    }
    
    private void execLogout(Logout command, Client client){
        client.outputEnqueue("Bye");

        for(int i = 0; i < clientList.size(); i++){
            Client tempClient = clientList.get(i);
            if(tempClient.getClientId() != client.getClientId()){
                tempClient.outputEnqueue("Goodbye " + command.getUsername());
            }
        }
        try {
            Thread.sleep(1);            
        }
        catch (Throwable e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        }


        Communicator.get().unregister(client);
    }

    private void execAttack(Attack command, Client client){

        for(int i = 0; i < clientList.size(); i++){
            clientList.get(i).outputEnqueue(command.encode());
        }            

    }

    private void execMove(Move command, Client client){
        Movable object = command.getObject();
        int destination_x = command.getPositionX();
        int destination_y = command.getPositionY();
        client.outputEnqueue("OK");
        while(object.getPositionX() != destination_x ||
              object.getPositionY() != destination_y){
            object.move(destination_x, destination_y);
            Move returnInfor = new Move(object,
                                        object.getPositionX(),
                                        object.getPositionY());
            for(int i = 0; i < clientList.size(); i++){
                clientList.get(i).outputEnqueue(returnInfor.encode());
            }            
         
        }

    }
}
// 
// CommandExecutor.java ends here
