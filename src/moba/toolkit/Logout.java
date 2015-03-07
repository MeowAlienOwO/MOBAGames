//                              -*- Mode: Java -*- 
// Logout.java --- 
// Filename: Logout.java

// Code:

package moba.toolkit;
/**
 * Command: Login
 * @author Zhang Huayan
 * @version 1.0
 * Defines the login command.
 * 
 */

public class Logout extends SystemCommand{
    
    
    @Override
    public String getType(){
	return (super.getType() 
		+ Protocal.TYPE_SEPARATOR
		+ Protocal.LOGOUT);
    }

    @Override
    public String encode(){
	return Protocal.LOGOUT;
    }
}


// 
// Logout.java ends here
