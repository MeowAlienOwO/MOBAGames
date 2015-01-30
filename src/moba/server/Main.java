//                              -*- Mode: Java -*- 
// Main.java --- 
// Filename: Main.java
// Code:

package moba.server;


import communicator.*;
/**
 * Main 
 * @author Zhang Huayan
 * @version 1.0
 * This is the main entry of the whole program.
 */


public class Main{
    
    public static void main(String[] args) {
	
	Communicator communicator = Communicator.get();
	communicator.setup();
    }


}



// 
// Main.java ends here
