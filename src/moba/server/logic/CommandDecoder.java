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
//     Update #: 60
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
	if(splited[0].equals(Protocal.LOGIN)){
	    String usrname = splited[1];
	    String passwd  = splited[2];
	    command = new Login(usrname, passwd);
	}else if(splited[0].equals(Protocal.LOGOUT)){
	    command = new Logout();
	}else if(splited[0].equals(Protocal.ATTACK)){
	    Attackable from;
	    Alive to;
	    // those if-else blocks should then be replaced by find object
	    if(splited[1].equals("HeroA")){
		from = new TestHeroA(0, 0, 10, 10, 1, TeamEnum.LAWFUL);
	    }else{
		from = new TestHeroB(0, 0, 10, 10, 1, TeamEnum.CHAOTIC);
	    }
	    if(splited[2].equals("HeroB")){
		to = new TestHeroB(0, 0, 10, 10, 1, TeamEnum.CHAOTIC);
	    }else{
		to = new TestHeroA(0, 0, 10, 10, 1, TeamEnum.LAWFUL);
	    }
	    command = new Attack(from, to);
	}else if(splited[0].equals("MOVE")){
	    Movable obj;
	    int x, y;
	    if(splited[1].equals("HeroA")){
		obj = new TestHeroA(0, 0, 10, 10, 1, TeamEnum.LAWFUL);
	    }else{
		obj = new TestHeroB(0, 0, 10, 10, 1, TeamEnum.CHAOTIC);
	    }
	    
	    x = Integer.parseInt(splited[2]);
	    y = Integer.parseInt(splited[3]);
	    command = new Move(obj, x, y);
	}
	return command;

    }
}
// 
// CommandDecoder.java ends here
