//                              -*- Mode: Java -*- 
// Move.java --- 
// Filename: Move.java
// Code:

package moba.toolkit;
/**
 * Command: Login
 * @author Zhang Huayan
 * @version 1.0
 * Defines the login command.
 * 
 */

public class Move{

    // variable
    private int origin_x;
    private int origin_y;
    private int destination_x;
    private int destination_y;
    private GameObject obj;

    // constructor
    public Move(GameObject obj, 
		int origin_x,
		int origin_y,
		int destination_x,
		int destination_y){
	this.obj = obj;

	this.origin_x = origin_x;
	this.origin_y = origin_y;

	this.destination_x = destination_x;
	this.destination_y = destination_y;
    }

    // method
    @Override
    public String getType(){
	return (super.getType() + "." + "Move");
    }

    @Override
    public String encode(){
	return (Protocal.MOVE + " "
		+ obj.getName() + " "
		+ "(" + origin_x + "," + origin_y + ")" + " "
		+ "(" + destination_x +destination_y ")"
		);
    }

    public int getOriginX(){
	return origin_x;
    }
    public int getOriginY(){
	return origin_y;
    }

    public int getDestX(){
	return destination_x;
    }

    public int getDestY(){
	return destination_y;
    }

    public int getObject(){
	return obj;
    }
}

// 
// Move.java ends here
