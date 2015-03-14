//                              -*- Mode: Java -*- 
// Login.java --- 
// Filename: Login.java

// Code:

package moba.toolkit;

/**
 * Command: Login
 * 
 * @author Zhang Huayan
 * @version 1.0 Defines the login command.
 * 
 */

public class Login extends SystemCommand {

	// variables
	private String username;
	private String password;

	// constructor
	public Login(String name, String passwd) {
		this.username = name;
		this.password = passwd;
	}

	// methods
	@Override
	public String getCommandType() {
		return (super.getCommandType() + CmdConstants.TYPE_SEPARATOR + CmdConstants.LOGIN);
	}

	/**
	 * encode for Login command format: "LOGIN username password"
	 */
	@Override
	public String encode() {
		return (CmdConstants.LOGIN + CmdConstants.CMD_SEPARATOR + getUsername()
				+ CmdConstants.CMD_SEPARATOR + getPassword());
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}

//
// Login.java ends here
