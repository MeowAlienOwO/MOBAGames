//                              -*- Mode: Java -*- 
// CommandDecoder.java --- 
// Filename: CommandDecoder.java
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
//     Update #: 68
// 

// Code:

package moba.server.logic;
import moba.toolkit.*;
import moba.gameobj.*;
import moba.gameobj.features.*;
/**
 * CommandDecoder
 * @author Zhang Huayan
 * @version 1.0
 * 
 */

public class CommandDecoder implements CommandFactory{

    @Override
    public Command decode(String cmd){
	String[] splited = cmd.split(" ");
	Command command = null;
        GameObjectFactory factory = new GameObjectFactory();
	if(splited[0].equals(Protocal.LOGIN)){
	    String usrname = splited[1];
	    String passwd  = splited[2];
	    command = new Login(usrname, passwd);
	}else if(splited[0].equals(Protocal.LOGOUT)){
	    command = new Logout();
	}else if(splited[0].equals(Protocal.ATTACK)){
	    Attacking from = factory.createHero(splited[1]);
	    Attacked to = factory.createHero(splited[2]);
	    command = new Attack(from, to);
	}else if(splited[0].equals("MOVE")){
	    Movable obj;
	    int x, y;
            obj = factory.createHero(splited[1]);
	    x = Integer.parseInt(splited[2]);
	    y = Integer.parseInt(splited[3]);
	    command = new Move(obj, x, y);
	}
	return command;

    }
}
// 
// CommandDecoder.java ends here
