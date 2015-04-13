//                              -*- Mode: Java -*- 
// Logic.java --- 
// Filename: Logic.java
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
//     Update #: 169
// 

// Code:


package moba.server.logic;

import java.util.*;
import moba.server.communicator.*;
import moba.server.database.*;
import moba.toolkit.*;
/**
 * Logic
 * @author Zhang Huayan
 * @version 1.0
 * This is the main logic of the MOBA game.
 */


public class Logic{

    // variables
    private List<Client> clientList;
    // private volatile Queue<String> stringQueue;
    private volatile Queue<ClientCommand> commandQueue;
    private Preprocessor preprocessor;
    // private CommandDecoder decoder;
    private CommandExecutor executor;
    private Judge judge;
    private DataBase database;
    private ChangeMonitor monitor;
    private boolean exit;
    
    // private boolean gamestart;
    // constructor
    public Logic(List<Client> clientList){
	this.clientList = clientList;
        this.commandQueue = new LinkedList<ClientCommand>();
        this.preprocessor = new Preprocessor(clientList, commandQueue);
        this.executor = new CommandExecutor(clientList, commandQueue);

        this.database = DataBase.get();
        this.monitor = database.getMonitor();
        this.judge = new Judge(clientList, commandQueue);
        this.exit = false;
        // this.gamestart = false;
    }
    // methods
    public void work(){
	initialize();


        while(!exit){
            executeCommand();

            // if(!gamestart) countinue;
            
            updateWorld();
        }
        
        
        // while(!exit){
        //     checkcommands;
        //     while(!gamestart){
        //         sleep(1);
        //     }
        //         if(time= 1/60s)
        //             for all hero : broadcastall()

        // }
    }

    public void initialize(){
        /* preprocessor: thread for putting strings into string list */
        Thread preprocessorThread = new Thread(preprocessor, "Preprocessor");
        preprocessorThread.start();
        Thread monitorThread = new Thread(monitor, "Monitor");
        monitorThread.start();
        /* judge: thread for executing cmd and update world */
        // Thread judgeThread = new Thread(judge, "Judge");
        // judgeThread.start();

    }

    public void close(){
        preprocessor.close();
        
        this.exit = true;
    }

    public void updateWorld(){
        database.broadcastAll();                    
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
                if(commandQueue.peek() == null) continue;
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
// Logic.java ends here
