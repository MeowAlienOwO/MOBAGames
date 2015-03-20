//                              -*- Mode: Java -*- 
// Logout.java --- 
// Filename: Logout.java

// Code:

package moba.toolkit;

/**
 * Command: Login
 * 
 * @author Zhang Huayan
 * @version 1.0 Defines the login command.
 * 
 */

public class Logout extends SystemCommand {
    // variables
    private String username;
    // constructors
    public Logout(String username){
        this.username = username;
    }
    // methods
    @Override
    public String getCommandType() {
        return (super.getCommandType() + CmdConstants.TYPE_SEPARATOR + CmdConstants.LOGOUT);
    }

    @Override
    public String encode() {
        return CmdConstants.LOGOUT + CmdConstants.CMD_SEPARATOR + username;
    }

    public String getUsername(){
        return username;
    }
}

//
// Logout.java ends here
