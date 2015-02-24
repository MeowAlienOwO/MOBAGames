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
    private GameObject obj;

    // constructor
    public Move(GameObject obj, int x, int y){
	this.obj = obj;
	this.x = x;
	this.y = y;
    }

    // method
    @Override
    public String getType(){
	return (super.getType() + "." + "Move");
    }

    @Override
    public String encode(){
	return (Protocal.MOVE + " "
		+ obj.getType() + " "
		+ "(" + x + "," + y + ")"
		);
    }
    
    
    
}

// 
// Move.java ends here
