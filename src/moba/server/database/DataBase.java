//                              -*- Mode: Java -*- 
// DataBase.java --- 
// Filename: DataBase.java
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
//     Update #: 93
// 

// Code:

package moba.server.database;


import moba.gameobj.*;
import java.util.*;
/**
 * Database stores all game object information.
 * Including Heros, Minons, Items...
 */

public class DataBase{
    // variables
    private Map<String, Hero> heroMap;
    private List<Minon> minonList;
    private List<User> userList;
    
    // constructors
    public DataBase(){
        this.heroMap = new HashMap<String, Hero>();
        this.minonList = new ArrayList<Minon>();
        this.userList = new ArrayList<User>(10);
    }
    // methods
    public User findUser(String username){
        for(int i = 0; i < userList.size(); i++){
            User temp = userList.get(i);
            if(temp.getUsername().equals(username)){
                return temp;
            }
        }
        return null;
    }

    public void userRegister(User user){
        if(userList.size() <= 10){
            userList.add(user);
        }
    }

    public void userUnregister(User user){
        if(userList.contains(user)){
            userList.remove(user);
        }
    }

    
}

// 
// DataBase.java ends here
