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
//     Update #: 177
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
import moba.server.communicator.*;
import java.util.*;
/**
 * TestLogic
 * @author Zhang Huayan
 * @version 1.0
 * This part of test is used to test the game logic.
 */


public class TestLogic{

    /**
     * Test CommandDecoder, which changes string into Command,
     * and command encoding. Ideally, the CommandDecoder takes 
     * a string, returns a command, and it's encode() method returns
     * should be exactly the same as the input.
     */
    @Test
    public void test_CommandDecoder() {
	String[] testStrings = {
	    "LOGIN abc abc",
	    "MOVE HeroA 1 0",
            "ATTACK HeroB HeroA",
	    "ATTACK HeroA HeroB",
	    "LOGOUT"
	};
        
	for(int i = 0; i < testStrings.length; i++){
	    CommandDecoder decoder = new CommandDecoder();
	    Command cmd = decoder.decode(testStrings[i]);
	    assertEquals(cmd.encode(), testStrings[i]);
            // assertEquals(1, 0);
	}

    }

    /**
     * Test the sorting algorithm in Preprocessor.
     * This version is not using client and just testing for 
     * algorithm, should be commented out when testing full
     * version.
     */

    @Test
    public void test_Preprocessor_sort() {
        
        // empty list
        LinkedList<String> data1 = new LinkedList<String>();
        LinkedList<String> data2 = new LinkedList<String>();
        LinkedList<Queue<String>> input1 = new LinkedList<Queue<String>>();
        input1.add(data1);
        input1.add(data2);
        Queue<String> output1 = new LinkedList<String>();
        Preprocessor test1 = new Preprocessor(null, output1);
        test1.sort(input1);

        assertEquals(output1.isEmpty(), true);

        // normal list: all well sequenced 
        String[] strarr1 = {
            "1@A", "4@D"
        };
        String[] strarr2 = {
            "2@B", "5@E"
        };
        String[] strarr3 = {
            "3@C", "6@F"
        };
        LinkedList<String> data3 = new LinkedList<String>();
        for(int i = 0; i < strarr1.length; i++){ data3.add(strarr1[i]);}
        LinkedList<String> data4 = new LinkedList<String>();
        for(int i = 0; i < strarr2.length; i++){ data4.add(strarr2[i]);}
        LinkedList<String> data5 = new LinkedList<String>();
        for(int i = 0; i < strarr3.length; i++){ data5.add(strarr3[i]);}
        LinkedList<Queue<String>> input2 = new LinkedList<Queue<String>>();
        input2.add(data3);
        input2.add(data4);
        input2.add(data5);
        Queue<String> output2 = new LinkedList<String>();
        Preprocessor test2 = new Preprocessor(null, output2);
        assertEquals(1, test2.getTime(strarr1[0]));
        // assertEquals(1, Integer.parseInt(("1"+Communicator.INFOR_SEPARATOR+ "A").split(Communicator.INFOR_SEPARATOR)[0]));
        test2.sort(input2);

        assertEquals(output2.isEmpty(), false);       
        String[] res1 = {
            "A", "B", "C", "D", "E", "F"
        };

        // assertEquals("A", test2.getCommand(strarr1[0]));
        for(int i = 0; i < res1.length; i++){
            assertEquals(output2.poll(), res1[i]);
        }

        
    }

}
// 
// TestLogic.java ends here
