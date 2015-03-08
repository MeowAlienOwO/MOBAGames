//                              -*- Mode: Java -*- 
// TestLogic.java --- 
// Filename: TestLogic.java
// Description: 
// Author: Zhang Huayan
// ID number: 6511043
// E-mail: zy11043@nottingham.edu.cn / MeowAlienOwO@gmail.com
// Version: 
// 

// Commentary: 
// 
// 

// Change Log:
// Status: 
// Table of Contents: 
// 
//     Update #: 49
// 

// Code:
package moba.test;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.*;

import moba.server.*;
import moba.server.logic.*;
import moba.gameobj.*;
import moba.toolkit.*;

/**
 * TestLogic
 * @author Zhang Huayan
 * @version 1.0
 * This part of test is used to test the game logic.
 */


public class TestLogic{
    @Test
    public void test_CommandExecutor() {
	String[] testStrings = {
	    "LOGIN abc abc",
	    "MOVE HeroA 1 0",
	    "ATTACK HeroA HeroB",
	    "LOGOUT"
	};

	for(int i = 0; i < testStrings.length; i++){
	    CommandDecoder decoder = new CommandDecoder();
	    Command cmd = decoder.decode(testStrings[i]);
	    assertEquals(cmd.encode(), testStrings[i]);
	}

    }

}
// 
// TestLogic.java ends here
