//                              -*- Mode: Java -*- 
// Main.java --- 
// Filename: Main.java
// Code:

package moba.server;

import moba.server.communicator.*;
import moba.server.logic.*;
import moba.server.database.*;
/**
 * Main
 * 
 * @author Zhang Huayan
 * @version 1.0 This is the main entry of the whole program.
 */

public class Main {

    public static void main(String[] args) {
        Communicator communicator = Communicator.get();
        communicator.startListening();

        try {
            Thread.sleep(1000);
        }
        catch (Throwable e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        }
        // set up database
        DataBase database = DataBase.get();
                
        // setup logic 
        Logic logic = new Logic(communicator.getClients());
        logic.work();

    }

}

//
// Main.java ends here
