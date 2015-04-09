//                              -*- Mode: Java -*- 
// ChangeMonitor.java --- 
// Filename: ChangeMonitor.java
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
//     Update #: 63
// 

// Code:

package moba.server.database;

import moba.server.communicator.*;
import java.util.*;
/**
 * Class Monitor
 * Monitor maintains a queue of events that reflects the world changing.
 * For simplification, the event will be in text form.
 */


public class ChangeMonitor implements Runnable{
    
    // variables
    private Queue<String> eventList;
    private volatile boolean exit;
    
    // constructor
    ChangeMonitor(){
        this.eventList = new LinkedList<String>();
        this.exit = false;
    }

    // methods

    @Override
    public void run(){
        while(!exit){
            broadcast();
        }
    }
    
    public void addEvent(String s){
        synchronized(eventList){
            eventList.offer(s);
        }
    }

    public void broadcast(){
        synchronized(eventList){
            if(!eventList.isEmpty()){
                Communicator.get().sendToAll(eventList.poll());
            }
        }
    }
    
}
// 
// ChangeMonitor.java ends here
