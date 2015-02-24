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
	return (super.getType() + "." +"Login");
    }

    @Override
    public String encode(){
	return (Protocal.LOGIN + " "
		+ usrname + " "
		+ passwd + " ");
    }

    public String getUsrname(){
	return usrname;
    }
    
}


// 
// Login.java ends here
