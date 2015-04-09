//                              -*- Mode: Java -*- 
// User.java --- 
// Filename: User.java
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
//     Update #: 40
// 

// Code:

package moba.server.database;

import moba.server.communicator.*;
import moba.gameobj.*;

public class User{
    // variables
    private Client client;
    private String username;
    private char[] password;
    private Hero hero = null;
    // constructor
    public User(String username, String password, Client client){
        this.username = username;
        this.password = encode(password);
        this.client = client;
    }
    // methods
    public char[] encode(String password){
        return password.toCharArray();
    }

    public Client getClient(){
        return client;
    }

    public String getUsername(){
        return username;
    }
    
    public boolean hasChosenHero(){
        return hero == null;
    }

    public void setHero(Hero hero){
        this.hero = hero;
    }

    public Hero getHero(){
        return hero;
    }
}

// 
// User.java ends here
