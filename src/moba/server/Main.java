//                              -*- Mode: Java -*- 
// Main.java --- 
// Filename: Main.java
// Code:

package moba.server;

/**
 * Main class 
 * @author Zhang Huayan
 * @version 1.0
 * This is the main entry of the whole program.
 * <pre>
 * <h2> Change Log </h2>
 * 
 * </pre>
 */


public class Main{
    
    public static void main(String[] args) {
	
	Communicator communicator = Communicator.get();
	communicator.setup();
    }


}



// 
// Main.java ends here
