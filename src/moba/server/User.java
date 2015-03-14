//                              -*- Mode: Java -*- 
// User.java --- 
// Filename: User.java
// Description: 
// Code:

package moba.server;

/**
 * User
 * 
 * @author Zhang Huayan
 * @version 1.0 This class holds all information about users.
 */

class User {
	// variables
	private int id;
	private String usrname;
	private String passwd;

	// constructors
	User(int id) {
		this.id = id;
	}

	// method
	public void setName(String name) {
		this.usrname = name;
	}

}

//
// User.java ends here
