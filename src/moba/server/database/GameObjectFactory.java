//                              -*- Mode: Java -*- 
// GameObjectFactory.java --- 
// Filename: GameObjectFactory.java
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
//     Update #: 29
// 


package moba.server.database;

import moba.gameobj.features.*;
import moba.gameobj.*;
/**
 * GameObjectFactory
 * 
 * @author Zhang Huayan
 * @version 1.0 
 * 
 */
public class GameObjectFactory{

    // methods

    public Hero createHero(String name){
        Hero hero = null;
        if(name.equals("HeroA")){
            hero = new Hero(name, 0, 0, 10, 10, 1, TeamEnum.LAWFUL, 100, 0);
        }else if(name.equals("HeroB")){
            hero = new Hero(name, 0, 0, 10, 10, 2, TeamEnum.CHAOTIC, 100, 0);
        }
        
        return hero;
    }

}

// Code:



// 
// GameObjectFactory.java ends here
