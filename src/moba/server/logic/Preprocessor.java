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
//     Update #: 307
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
    // private Queue<String> stringQueue;
    
    private volatile boolean exit;
    private CommandDecoder decoder;
    private Queue<ClientCommand> commandQueue;

    // constructor 
    public Preprocessor(List<Client> clientList,
                        Queue<ClientCommand> commandQueue){
        this.decoder = new CommandDecoder();
        this.clientList   = clientList;
        this.commandQueue = commandQueue;
        this.exit = false;
    }
    
    @Override
    public void run(){
        System.out.println("Preprocessor starts");
        while(!exit){
            checkClients();
            sort();
        }
    }

    /**
     * this is the core algorithm at preprocessor.
     * input should be a series of queues which are already been sorted by
     * time,
     * output should be a queue containing all sorted results.
     * @require client listsnn (when testing, using a set of queues)
     * @return a queue of string sorted by time
     */
    public void sort(){
        Long time;
        int id;
        boolean isAllEmpty;
        synchronized(commandQueue){
            synchronized(clientList){
                do{
                    id = Integer.MIN_VALUE;
                    Long mintime = new Long(Long.MAX_VALUE);
                    // check from all queue, find the one has minimal time and 
                    // keep the id
                    isAllEmpty = true;
                    for(int i = 0; i < clientList.size(); i++){
                        Client client = clientList.get(i);
                     
                        isAllEmpty = isAllEmpty && (client.isInputEmpty()); 
                     
                        if(!client.isInputEmpty()) {
                            String command = client.inputExamine();
                     
                            time = decoder.getTime(command.split(Communicator.INFOR_SEPARATOR)[0]); 
                            if(mintime.compareTo(time) > 0){ // compareTo() returns > 0 if time is less than mintime
                                mintime = time;
                                id = client.getClientId();
                            }
                        }
                    } // endfor

                    // get the minimal one, create new ClientCommand and put into command list
                    if(id >= 0){
                        String strIntoQueue = Communicator.get().findClient(id).inputDequeue();

                        try{
                            ClientCommand temp = decoder.createClientCommand(strIntoQueue);
                        commandQueue.offer(temp);
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                            
                        }

                    }

                } while(!isAllEmpty);
            }
        }
    }

    public void close(){

        this.exit = true;
    }

    // public void sort_algorithm(List<Queue<String>> input){

    //     int time;
    //     int id;
    //     boolean isAllEmpty;

    //     do{
    //         id = Integer.MIN_VALUE;
    //         int mintime = Integer.MAX_VALUE;
    //         // check from all queue, find the one has minimal time and 
    //         // keep the id
    //         isAllEmpty = true;
    //         for(int i = 0; i < input.size(); i++){
    //             String command = input.get(i).peek();
    //             isAllEmpty = isAllEmpty && (command == null); // check if all is empty
    //             if(command != null) {
    //                 time = getTime(command); 
    //                 if(time < mintime){
    //                     mintime = time;
    //                     id = i;
    //                 }
    //             }
    //         } // endfor

    //         // put the minimal one into the output queue
    //         if(id >= 0 && id <= 9){
    //             // stringQueue.offer(getCommand(input.get(id).poll()));
    //         }

    //     } while(!isAllEmpty);
    // }


    // check if there is clients not connecting
    private void checkClients(){
        for(int i = 0; i < clientList.size(); i++){
            Client client = clientList.get(i);
            if(client.isClosed()){
                Communicator.get().unregister(client);
            }
        }
    }

    
    public int getTime(String command){
    
        return Integer.parseInt(command.split(Communicator.INFOR_SEPARATOR)[0]);
    }
    
    public String getCommand(String command){

        return command.split(Communicator.INFOR_SEPARATOR)[1];
    }

   
}


// 
// Preprocessor.java ends here
