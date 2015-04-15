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
//     Update #: 77
// 

// Code:


package moba.server.database;

import moba.gameobj.features.*;
import moba.gameobj.hero.*;
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

    public Hero createHeroByCode(String heroCode){
        Hero hero = null;

        if (heroCode.equals("A1")) {
            hero = new Anthony(TeamEnum.ATTACK);
        } else if (heroCode.equals("A2")) {
            hero = new Cynthia(TeamEnum.ATTACK);
        } else if (heroCode.equals("A3")) {
            hero = new Jeff(TeamEnum.ATTACK);
        } else if (heroCode.equals("A4")) {
            hero = new Otis(TeamEnum.ATTACK);
        } else if (heroCode.equals("A5")) {
            hero = new Saga(TeamEnum.ATTACK);
        } else if (heroCode.equals("D1")) {
            hero = new Anthony(TeamEnum.DEFENCE);
        } else if (heroCode.equals("D2")) {
            hero = new Cynthia(TeamEnum.DEFENCE);
        } else if (heroCode.equals("D3")) {
            hero = new Jeff(TeamEnum.DEFENCE);
        } else if (heroCode.equals("D4")) {
            hero = new Otis(TeamEnum.DEFENCE);
        } else if (heroCode.equals("D5")) {
            hero = new Saga(TeamEnum.DEFENCE);
        }
        return hero;
    }


    public Hero createHero(String heroName, TeamEnum team){
        Hero hero = null;
        
        if (heroName.equals("Anthony")) {
            hero = new Anthony(team);
        } else if (heroName.equals("Cynthia")) {
            hero = new Cynthia(team);
        } else if (heroName.equals("Jeff")) {
            hero = new Jeff(team);
        } else if (heroName.equals("Otis")) {
            hero = new Otis(team);
        } else if (heroName.equals("Saga")) {
            hero = new Saga(team);
        } 

        return hero;
    }
    public boolean isHeroValid(String name){
        return(name.equals("Anthony")||
               name.equals("Cynthia")||
               name.equals("Jeff")||
               name.equals("Otis")||
               name.equals("Saga"));

    }
}





// 
// GameObjectFactory.java ends here
