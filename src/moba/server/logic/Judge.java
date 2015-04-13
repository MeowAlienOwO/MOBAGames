//                              -*- Mode: Java -*- 
// Judge.java --- 
// Filename: Judge.java
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
//     Update #: 217
// 

// Code:

package moba.server.logic;
import moba.toolkit.*;
import moba.gameobj.*;
import moba.server.communicator.*;
import java.util.*;
/**
 * Judge
 * @author Zhang Huayan
 * @version 1.0
 * Judge executes the main logic, including:
 * 1. update the world and send proper information back to client
 * according to command queue. this is mainly done by the command executor
 * 2. check the data in the word and broadcast certain information back, like
 * level up, creation of hero, death of hero, etc.
 * 3. regularly generates the minors, or other related game objects.
 */


public class Judge implements Runnable{

    // variables
    private List<Client> clientList;
    private Queue<ClientCommand> commandQueue;
    private CommandExecutor executor;
    private int gameStartTime; 
    private volatile boolean exit;

    // constructor
    public Judge(List<Client> clientList, 
                 Queue<ClientCommand> commandQueue){
        this.clientList = clientList;
        this.commandQueue = commandQueue;
        this.executor = new CommandExecutor(clientList, commandQueue);
        this.exit = false;
    }

    // methods
    @Override
    public void run(){
        System.out.println("Judge start");
        while(!exit){
            executeCommand();
            updateWorld();
        }

    }

    public void close(){
        this.exit = true;
    }

    public void updateWorld(){
        
    }

    /**
     * execute command
     * firstly put all commands has same time into priority queue
     * according to their priority
     * then execute all the commands which are already inserted into
     * priority queue.
     */

    public void executeCommand(){
        int time;
        PriorityQueue<ClientCommand> priorityQueue;
        while(!commandQueue.isEmpty()){
            // create priority queue
            priorityQueue = createPriorityQueue(commandQueue);
            // execute command
            while(priorityQueue.peek() != null){
                executor.execute(priorityQueue.poll());
            }
        }

    }

    public PriorityQueue<ClientCommand> createPriorityQueue(Queue<ClientCommand> queue){
        PriorityQueue<ClientCommand> priorityQueue
            = new PriorityQueue<ClientCommand>(new Comparator<ClientCommand>() {
                    public int compare(ClientCommand c1, ClientCommand c2){
                        
                        if(c1.getPriority() > c2.getPriority()){
                            return -1;
                        }else if(c1.getPriority() < c2.getPriority()){
                            return 1;
                        }else{
                            return 0;
                        }
                    }
                });
            // priorityQueue.clear(); // initialize
            // create priority queue
            do{
                priorityQueue.offer(commandQueue.poll());
            } while(commandQueue.peek() != null 
                    && isSametime(commandQueue.peek(), priorityQueue.peek()));
            return priorityQueue;
    }

    private boolean isSametime(ClientCommand c1, ClientCommand c2){
        return c1.getTime() == c2.getTime();
    }

    
}

// 
// Judge.java ends here
