//                              -*- Mode: Java -*- 
// Preprocessor.java --- 
// Filename: Preprocessor.java
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
//     Update #: 148
// 

// Code:

package moba.server.logic;
import moba.toolkit.*;
import moba.gameobj.*;
import moba.server.communicator.*;
import java.util.*;
/**
 * Preprocessor
 * @author Zhang Huayan
 * @version 1.0
 * Preprocessor check the timestamp, and sort them by time, and then 
 * cut the timestamp and save the result in the list;
 */

public class Preprocessor implements Runnable{

    // variables
    private List<Client> clientList;
    private Queue<String> stringQueue;
    // private Queue<Command> commandQueue;


    // constructor 
    public Preprocessor(List<Client> clientList, 
                        Queue<String> stringQueue){
                        // Queue<Command> commandQueue){
        this.clientList   = clientList;
        this.stringQueue  = stringQueue;
        // this.commandQueue = commandQueue;
        
    }
    
    
    public void run(){
        

    }

    /**
     * this is the core algorithm at preprocessor.
     * input should be a series of queues which are already been sorted by
     * time,
     * output should be a queue containing all sorted results.
     * @require client lists (when testing, using a set of queues)
     * @return a queue of string sorted by time
     */

    // public void sort(List<Client> clientList){
    public void sort(List<Queue<String>> input){

        int time;
        int id;
        boolean isAllEmpty;

        do{
            id = Integer.MIN_VALUE;
            int mintime = Integer.MAX_VALUE;
            // check from all queue, find the one has minimal time and 
            // keep the id
            isAllEmpty = true;
            for(int i = 0; i < input.size(); i++){
                String command = input.get(i).peek();
                isAllEmpty = isAllEmpty && (command == null); // check if all is empty
                if(command != null) {
                    time = getTime(command); 
                    if(time < mintime){
                        mintime = time;
                        id = i;
                    }
                }
            } // endfor

            // put the minimal one into the output queue
            if(id >= 0 && id <= 9){
                stringQueue.offer(getCommand(input.get(id).poll()));
            }

        } while(!isAllEmpty);
    }

    
    public int getTime(String command){
        // return Integer.parseInt(command.split(Communicator.INFOR_SEPARATOR)[0]);
        return Integer.parseInt(command.split(Communicator.INFOR_SEPARATOR)[0]);
    }

    public String getCommand(String command){

        return command.split(Communicator.INFOR_SEPARATOR)[1];
    }

   
}


// 
// Preprocessor.java ends here
