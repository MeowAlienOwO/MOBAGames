//                              -*- Mode: Java -*- 
// TestCommunicator.java --- 
// Filename: TestCommunicator.java
// Description: 
// Code:
package moba.test;

import java.io.*;
import java.net.*;
import java.util.*;
import junit.framework.TestCase;
import static org.junit.Assert.*;

import moba.server.communicator.*;
import moba.server.*;
/**
 * Test class
 * @author Zhang Huayan
 * @version 1.0
 * Contain test cases for communicator module
 */
public class TestCommunicator{
    @Test
    public void test_running() {
	Communicator communicator = Communicator.get();
	communicator.startListening();

	Thread.sleep(5000);
	communicator.stop();
    }

}

// 
// TestCommunicator.java ends here
