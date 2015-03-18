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
//     Update #: 98
// 

// Code:

package moba.server.logic;

import moba.toolkit.*;
import moba.gameobj.*;
import moba.gameobj.features.*;

/**
 * CommandDecoder
 * 
 * @author Zhang Huayan
 * @version 1.0
 * 
 */

public class CommandDecoder implements CommandFactory {

    @Override
    public Command decode(String cmd) {
        String[] splited = cmd.split(" ");

        
        Command command = null;
        if (splited[0].equals(CmdConstants.LOGIN)) {
            String usrname = splited[1];
            String passwd = splited[2];
            command = new Login(usrname, passwd);
        } else if (splited[0].equals(CmdConstants.LOGOUT)) {
            command = new Logout();
        } else if (splited[0].equals(CmdConstants.ATTACK)) {
            Attacking from = findHero(splited[1]);
            Attacked to =  findHero(splited[2]);
            command = new Attack(from, to);
        } else if (splited[0].equals("MOVE")) {
            Movable obj;
            int x, y;
            obj = findHero(splited[1]);
            x = Integer.parseInt(splited[2]);
            y = Integer.parseInt(splited[3]);
            command = new Move(obj, x, y);
        }
        return command;

    }

    public Hero findHero(String name){
        GameObjectFactory factory = new GameObjectFactory();
        return factory.createHero(name);
    }
}
//
// CommandDecoder.java ends here
