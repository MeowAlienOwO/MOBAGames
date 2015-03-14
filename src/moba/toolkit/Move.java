//                              -*- Mode: Java -*- 
// Move.java --- 
// Filename: Move.java
// Code:

package moba.toolkit;

import moba.gameobj.*;
import moba.gameobj.features.*;

/**
 * Command: Login
 * 
 * @author Zhang Huayan
 * @version 1.0 Defines the login command.
 * 
 */

public class Move extends GameCommand {

	// variable
	private int positionX;
	private int positionY;
	private Movable object;

	// constructor
	public Move(Movable obj, int x, int y) {
		this.object = obj;
		this.positionX = x;
		this.positionY = y;
	}

	// method
	@Override
	public String getCommandType() {
		return (super.getCommandType() + CmdConstants.TYPE_SEPARATOR + CmdConstants.MOVE);
	}

	/**
	 * encode move. format: "MOVE obj x y"
	 */
	@Override
	public String encode() {
		return (CmdConstants.MOVE + CmdConstants.CMD_SEPARATOR + object.toString()
				+ CmdConstants.CMD_SEPARATOR + getPositionX() + CmdConstants.CMD_SEPARATOR + getPositionY());
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

}

//
// Move.java ends here
