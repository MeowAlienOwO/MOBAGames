//                              -*- Mode: Java -*- 
// Login.java --- 
// Filename: Login.java

// Code:

package moba.toolkit;

/**
 * Command: Login
 * @author Zhang Huayan
 * @version 1.0
 * Defines the login command.
 * 
 */


public class Login extends SystemCommand{

    // variables
    private String usrname;
    private String passwd;

    // constructor
    public Login(String usrname, String passwd){
	this.usrname = usrname;
	this.passwd  = passwd;
    }
    
    // methods
    @Override
    public String getType(){
	return (super.getType() 
		+ Protocal.TYPE_SEPARATOR
		+ Protocal.LOGIN);
    }

    /**
     * encode for Login command 
     * format: "LOGIN usrname passwd"
     */
    @Override
    public String encode(){
	return (Protocal.LOGIN + Protocal.CMD_SEPARATOR
		+ usrname + Protocal.CMD_SEPARATOR
		+ passwd + Protocal.CMD_SEPARATOR);
    }

    public String getUsrname(){
	return usrname;
    }
    
}


// 
// Login.java ends here
