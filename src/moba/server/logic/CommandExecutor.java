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
//     Update #: 419
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

    /**
     * method execute
     * this method is the core of CommandExecutor. basically, it test the
     * type of a certain command and execute certain function.
     * 
     */
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
            client.outputEnqueue("ERROR login twice");
            return;
        }
        
        // create new user
        User user = new User(command.getUsername(), command.getPassword(), client);
        // register user to database and client
        database.userRegister(user);
        client.setUser(user);

        // print ok message
        System.out.println("User " + command.getUsername() +"registed.");
        client.outputEnqueue("OK");


        
        Communicator.get().sendToAll(CmdConstants.WELCOME + CmdConstants.CMD_SEPARATOR + user.getUsername());
        // database.addEvent(CmdConstants.WELCOME + CmdConstants.CMD_SEPARATOR + user.getUsername());

        // information for initialization 
        database.broadcastAll();
    }

    
    private void execLogout(Logout command, Client client){

        if(!client.hasUser()){
            // no user login in here
            client.outputEnqueue("ERROR not logged in");
            return;
        }
        // unregister user from database and client
        User user = client.getUser();
        database.userUnregister(user);
        client.setUser(null);
        
        // database.addEvent(CmdConstants.GOODBYE + CmdConstants.CMD_SEPARATOR + user.getUsername());
        Communicator.get().sendToAll(CmdConstants.WELCOME + CmdConstants.CMD_SEPARATOR + user.getUsername());
        client.outputEnqueue("Bye");

        // unregister client
        Communicator.get().unregister(client);
    }

    private void execAttack(Attack command, Client client){
        if(!client.hasUser()){
            // no user login in here
            client.outputEnqueue("ERROR not logged in");
            return;
        }

        // find objects
        Attacking from = command.getAttackFrom();
        Attacked to    = command.getAttackTo();

        if(from == null){
            client.outputEnqueue("ERROR Attack From Not Found ");
            return;
        }else if(to == null){
            client.outputEnqueue("ERROR Attack To Not Found");
            return;
        }

        // perform attack 
        to.attacked(from.attacking());

        client.outputEnqueue("OK ATTACK");

        // send information back
        database.broadcastHeroHP(to.toString());
    }

    
    private void execMove(Move command, Client client){

        if(!client.hasUser()){
            // no user login in here
            client.outputEnqueue("ERROR not logged in");
            return;
        }
        
        // find objects
        Movable object = command.getObject();
        int destination_x = command.getPositionX();
        int destination_y = command.getPositionY();
        client.outputEnqueue("OK MOVE");

        
        // execute move
        while(object.getPositionX() != destination_x ||
              object.getPositionY() != destination_y){
            object.move(destination_x, destination_y);

        }
        // broadcast information
        database.broadcastHeroPosition(object.toString());
            
        
    }

    private void execChooseHero(ChooseHero command, Client client){

        if(!client.hasUser()){
            // no user login in here
            client.outputEnqueue("ERROR not logged in");
            return;
        }


        // find user
        User user = client.getUser();
        if(command.getTeam() == null){
            // case using herocode
            database.chooseHeroByCode(user.getUsername(), command.getHeroname());
        }else{
            database.chooseHero(user.getUsername(), command.getHeroname(), command.getTeam());
        }

        // TODO: maybe need to send user information.
        database.broadcastHeroAll(command.getHeroname());
        client.outputEnqueue("OK");
    }
}
// 
// CommandExecutor.java ends here


















