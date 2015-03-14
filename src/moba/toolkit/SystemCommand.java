//                              -*- Mode: Java -*- 
// SystemCommand.java --- 
// Filename: SystemCommand.java
// Code:

package moba.toolkit;

/**
 * SystemCommand
 * 
 * @author Zhang Huayan
 * @version 1.0 Define SystemCommands that is available in the moba project.
 */

public abstract class SystemCommand implements Command {

	@Override
	public String getCommandType() {
		return CmdConstants.SYSTEM;
	}
}

//
// SystemCommand.java ends here
