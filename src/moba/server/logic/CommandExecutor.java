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
//     Update #: 46
// 

// Code:


package moba.server.logic;
import moba.toolkit.*;

/**
 * CommandExecutor
 * @author Zhang Huayan
 * @version 1.0
 * Command Executor execute the command, and change relative datas.
 */

class CommandExecutor{

    // methods
    public void execute(Command command){
	String[] type = command.getType().split(".");
	
	if(type[0].equals(Protocal.SYSTEM)){
	    // execute system 

	    if(type[1].equals(Protocal.LOGIN)){
		execLogin((Login)command);
	    } else if(type[1].equals(Protocal.LOGOUT)){
		execLogout((Logout)command);
	    }

	}else if (type[0].equals(Protocal.GAME)){
	    // execute Game commands

	    if(type[1].equals(Protocal.ATTACK)){
		execAttack((Attack)command);
	    }else if(type[1].equals(Protocal.MOVE)){
		execMove((Move)command);
	    }
	}
	
    }
    // TODO
    private void execLogin(Login command){
	
    }
    
    private void execLogout(Logout command){
	
    }

    private void execAttack(Attack command){

    }

    private void execMove(Move command){

    }
}
// 
// CommandExecutor.java ends here
