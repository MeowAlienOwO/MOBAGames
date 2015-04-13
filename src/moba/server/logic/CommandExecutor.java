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
//     Update #: 306
// 

// Code:


package moba.server.logic;
import moba.toolkit.*;
import moba.gameobj.*;
import moba.gameobj.features.*;
import moba.server.communicator.*;
import moba.server.database.*;
import java.util.*;

/**
 * CommandExecutor
 * @author Zhang Huayan
 * @version 1.0
 * Command Executor execute the command, and change relative datas.
 */

class CommandExecutor{

    // variables
    private List<Client> clientList;
    private Queue<ClientCommand> commandQueue;
    private DataBase database;
    // constructor
    public CommandExecutor(List<Client> clientList,
                           Queue<ClientCommand> commandQueue){
        this.clientList = clientList;
        this.commandQueue = commandQueue;
        this.database = DataBase.get();
    }

    // methods
    public void execute(ClientCommand clientCommand){
        if(clientCommand == null){
            return;
        }
        Command command = clientCommand.getCommand();
        Client client = clientCommand.getClient();


	String[] type = command.getCommandType().split("\\.");	

	if(type[0].equals(CmdConstants.SYSTEM)){
	    // execute system 
	    if(type[1].equals(CmdConstants.LOGIN)){
		execLogin((Login)command, client);
	    } else if(type[1].equals(CmdConstants.LOGOUT)){
		execLogout((Logout)command, client);
	    }else if(type[1].equals(CmdConstants.CHOOSEHERO)){
                execChooseHero((ChooseHero)command, client);
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
        // TODO: detect login fail: need to change methods
        // in database.user to throw exception
        if(client.hasUser()){
            // no need to login twice
            return;
        }

        User user = new User(command.getUsername(), command.getPassword(), client);
        database.userRegister(user);
        client.setUser(user);
        client.outputEnqueue("OK");
        database.addEvent(CmdConstants.WELCOME + CmdConstants.CMD_SEPARATOR + user.getUsername());
        database.broadcastAll();

    }
    
    private void execLogout(Logout command, Client client){
        // User user = database.findUser(command.getUsername());
        if(!client.hasUser()){
            return;
        }
        User user = client.getUser();
        database.userUnregister(user);
        database.addEvent(CmdConstants.GOODBYE + CmdConstants.CMD_SEPARATOR + user.getUsername());
        client.outputEnqueue("Bye");
    }

    private void execAttack(Attack command, Client client){
        Attacking from = command.getAttackFrom();
        Attacked to    = command.getAttackTo();

        to.attacked(from.attacking());

        database.broadcastHeroHP(to.toString());
    }

    
    private void execMove(Move command, Client client){
        Movable object = command.getObject();
        int destination_x = command.getPositionX();
        int destination_y = command.getPositionY();
        client.outputEnqueue("OK");
        System.out.println("object == null: " + (object == null));
        while(object.getPositionX() != destination_x ||
              object.getPositionY() != destination_y){
            object.move(destination_x, destination_y);
            // Move returnInfor = new Move(object,
            //                             object.getPositionX(),
            //                             object.getPositionY());
            // for(int i = 0; i < clientList.size(); i++){
            //     clientList.get(i).outputEnqueue(returnInfor.encode());
            // }
            database.broadcastHeroPosition(object.toString());
            
        }
    }

    private void execChooseHero(ChooseHero command, Client client){
        if(client.hasUser()){
            User user = client.getUser();
            database.chooseHero(user.getUsername(), command.getHeroname());
        
            client.outputEnqueue("OK");
        }
    }
}
// 
// CommandExecutor.java ends here


















