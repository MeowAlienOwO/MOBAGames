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
//     Update #: 376
// 

// Code:

package moba.server.database;


import moba.gameobj.*;
import moba.gameobj.features.*;
import java.util.*;
import moba.toolkit.CmdConstants;
/**
 * Database stores all game object information.
 * Including Heros, Minons, Items...
 * There are also several APIs for changing the data in the world, and put the change into monitor.
 */

public class DataBase{
    // variables
    private static DataBase database;
    /* gameobject db */
    private HashMap<String, Hero> heroMap;
    private List<Minion> minionList;
    private List<User> userList;
    
    /* map */
    private Map map;
    /* event monitor */
    private ChangeMonitor monitor;
    /* factory */
    private GameObjectFactory factory;

    

    // constructors
    private DataBase(){
        this.heroMap = new HashMap<String, Hero>();
        this.minionList = new ArrayList<Minion>();
        this.userList = new ArrayList<User>(10);

        this.map = null;
        this.monitor = new ChangeMonitor();
        this.factory = new GameObjectFactory();
    }
    
    
    
    // method
    public static DataBase get(){
        if(DataBase.database == null){
            DataBase.database = new DataBase();
        }
        return database;
    }

    public void setMap(String path){
        this.map = new Map(path);
    }
    
    public boolean isMapSet(){
        return map == null;
    }

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
        // monitor.addEvent(CmdConstants.WELCOME + CmdConstants.CMD_SEPARATOR + user.getUsername());

    }

    public void userUnregister(User user){
        if(userList.contains(user)){
            userList.remove(user);
        }
        // monitor.addEvent(CmdConstants.GOODBYE + CmdConstants.CMD_SEPARATOR + user.getUsername());

    }

    public GameObject findObject(String name) throws Exception{
        String[] splited = name.split(" ");
        GameObject object = null;
        try{
            if(splited.length > 1){
                // minon, item..etc.
            }else if(splited.length == 1){
                // hero
            
                object = findHero(name);
            }
        }catch(Exception e){
            throw e;
        }
        return object;

    }
    
    public Hero findHero(String name) throws Exception{
        synchronized(heroMap){
            if(!heroMap.containsKey(name)){
                Hero hero = factory.createHero(name);
                if(hero == null){
                    throw new Exception("Invalid Hero");
                }else{
                    heroMap.put(name, hero);
                    return hero;
                }
            
            }
        }
        return heroMap.get(name);
    }
    
    public void chooseHero(String username, String heroname){
        User user = findUser(username);
        Hero hero = factory.createHero(heroname);
        if(!user.hasChosenHero()){
            user.setHero(hero);
            monitor.addEvent(CmdConstants.CHOOSEHERO + CmdConstants.CMD_SEPARATOR + username 
                             + CmdConstants.CMD_SEPARATOR + heroname);

        }

    }

    public List<Minion> getMinions(){
        return minionList;
    }
    
    public void broadcastAll(){
        synchronized(heroMap){
            Set<String> keyset = heroMap.keySet();

            for(String temp : keyset){
                broadcastHeroAll(temp);
            }
        }
    }

    public void broadcastHeroAll(String name){
        broadcastHeroHP(name);
        broadcastHeroPosition(name);
        broadcastHeroAttribute(name);
        broadcastHeroAsset(name);

    }
    
    /**
     * format: HERO HP curr_hp max_hp
     */
    public void broadcastHeroHP(String name){
        try{
            Hero hero = findHero(name);
        
            monitor.addEvent(CmdConstants.HERO + CmdConstants.CMD_SEPARATOR + 
                             CmdConstants.HP + CmdConstants.CMD_SEPARATOR +
                             name + CmdConstants.CMD_SEPARATOR +
                             hero.getHealth() + CmdConstants.CMD_SEPARATOR +
                             hero.getHealthMax());        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void broadcastHeroPosition(String name){
        try{
            Hero hero = findHero(name);
        
            monitor.addEvent(CmdConstants.HERO + CmdConstants.CMD_SEPARATOR + 
                             CmdConstants.POSITION + CmdConstants.CMD_SEPARATOR +
                             name + CmdConstants.CMD_SEPARATOR +
                             hero.getPositionX() + CmdConstants.CMD_SEPARATOR +
                             hero.getPositionY());                
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void broadcastHeroAttribute(String name){
        try{
            Hero hero = findHero(name);
        
            monitor.addEvent(CmdConstants.HERO + CmdConstants.CMD_SEPARATOR + 
                             CmdConstants.ATTRIBUTE + CmdConstants.CMD_SEPARATOR +
                             name + CmdConstants.CMD_SEPARATOR +
                             hero.getAttackDamage());           
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void broadcastHeroAsset(String name){
        try{
            Hero hero = findHero(name);
        
            monitor.addEvent(CmdConstants.HERO + CmdConstants.CMD_SEPARATOR + 
                             CmdConstants.ASSET + CmdConstants.CMD_SEPARATOR +
                             name + CmdConstants.CMD_SEPARATOR +
                             hero.getGold() + CmdConstants.CMD_SEPARATOR +
                             hero.getExperience());                
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void addEvent(String message){
        monitor.addEvent(message);
    }
    
    public ChangeMonitor getMonitor(){
        return monitor;
    }
}

// 

// DataBase.java ends here
