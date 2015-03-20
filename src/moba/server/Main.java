//                              -*- Mode: Java -*- 
// Main.java --- 
// Filename: Main.java
// Code:

package moba.server;

import moba.server.communicator.*;
import moba.server.logic.*;
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
		// Thread test = new Thread(new SimpleLogic());
		// test.start();
                Logic logic = new Logic(communicator.getClients());
                logic.work();
                try {
                    Thread.sleep(1000000);
                }
                catch (Throwable e) {
                    System.out.println("Error " + e.getMessage());
                    e.printStackTrace();
                }

       
                logic.close();
	}

}

//
// Main.java ends here
