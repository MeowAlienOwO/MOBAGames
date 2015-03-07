//                              -*- Mode: Java -*- 
// Move.java --- 
// Filename: Move.java
// Code:

package moba.toolkit;
import moba.gameobj.*;
import moba.gameobj.features.*;
/**
 * Command: Login
 * @author Zhang Huayan
 * @version 1.0
 * Defines the login command.
 * 
 */

public class Move extends GameCommand{

    // variable
    private int x;
    private int y;
    private Movable obj;

    // constructor
    public Move(Movable obj, int x, int y){
	this.obj = obj;
	this.x = x;
	this.y = y;
    }

    // method
    @Override
    public String getType(){
	return (super.getType() 
		+ Protocal.TYPE_SEPARATOR
		+ Protocal.MOVE);
    }

    /**
     * encode move.
     * format: "MOVE obj x y"
     */
    @Override
    public String encode(){
	return (Protocal.MOVE + Protocal.CMD_SEPARATOR
		+ obj.getType() + Protocal.CMD_SEPARATOR
	        + x + y);
    }
    
    
    
}

// 
// Move.java ends here
