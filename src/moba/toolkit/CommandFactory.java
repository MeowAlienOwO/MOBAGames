//                              -*- Mode: Java -*- 
// CommandFactory.java --- 
// Filename: CommandFactory.java

// Code:
package moba.toolkit;

/**
 * CommandFactory
 * 
 * @author Zhang Huayan
 * @version 1.0 Implement this interface to
 */

public interface CommandFactory {

	public abstract Command decode(String cmd);

}

//
// CommandFactory.java ends here
