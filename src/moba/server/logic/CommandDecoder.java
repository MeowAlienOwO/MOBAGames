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
//     Update #: 193
// 

// Code:

package moba.server.logic;

import moba.toolkit.*;
import moba.gameobj.*;
import moba.gameobj.features.*;
import moba.server.database.*;
import moba.server.communicator.*;
import java.util.*;

/**
 * CommandDecoder
 * 
 * @author Zhang Huayan
 * @version 1.0
 * 
 */

public class CommandDecoder{

    // variables

    // constructor

    // method
    public ClientCommand createClientCommand(String cmd) {

        String[] splited = cmd.split(Communicator.INFOR_SEPARATOR);
        Long time = getTime(splited[0]);
        Client client = findClient(splited[1]);
        Command command = decode(splited[2]);
        return new ClientCommand(command, client, time);
    }

    public Client findClient(String command){
        int id = Integer.parseInt(command);

        return Communicator.get().findClient(id);
    }

    public Command decode(String cmd){
        String[] splited = cmd.split(" ");
        Command command = null;
        if (splited[0].equals(CmdConstants.LOGIN) 
            && splited.length == 3) {
            String username = splited[1];
            String passwd = splited[2];
            command = new Login(username, passwd);
        } else if (splited[0].equals(CmdConstants.LOGOUT) 
                   && splited.length == 2) {
            String username = splited[1];
            
            command = new Logout(username);
        } else if (splited[0].equals(CmdConstants.ATTACK)
                   && splited.length == 3) {
            Attacking from = findHero(splited[1]);
            Attacked to =  findHero(splited[2]);
            command = new Attack(from, to);
        } else if (splited[0].equals("MOVE")
                   && splited.length == 4) {
            Movable obj;
            int x, y;
            obj = findHero(splited[1]);
            x = Integer.parseInt(splited[2]);
            y = Integer.parseInt(splited[3]);
            command = new Move(obj, x, y);
        }
        return command;

    }
    public Long getTime(String command){

        return new Long(command);
    }
    public Hero findHero(String name){
        GameObjectFactory factory = new GameObjectFactory();
        return factory.createHero(name);
    }
}
//
// CommandDecoder.java ends here
