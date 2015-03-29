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
//     Update #: 425
// 

// Code:
package moba.test;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;

import moba.server.*;
import moba.server.logic.*;
import moba.gameobj.*;
import moba.toolkit.*;
import moba.server.communicator.*;
import moba.server.database.*;
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
    @Ignore
    public void test_CommandDecoder() {
	String[] testStrings = {
	    "0@LOGIN abc def",
	    "1@MOVE HeroA 1 0",
            "2@ATTACK HeroB HeroA",
	    "3@ATTACK HeroA HeroB",
	    "2@LOGOUT abc"
	};
        String[] backStrings = {
	    "LOGIN abc def\n",
	    "MOVE HeroA 1 0\n",
            "ATTACK HeroB HeroA\n",
	    "ATTACK HeroA HeroB\n",
	    "LOGOUT abc\n"
        };        
	for(int i = 0; i < testStrings.length; i++){
	    CommandDecoder decoder = new CommandDecoder();
	    Command cmd = decoder.decode(testStrings[i]);
	    assertEquals(cmd.encode(), backStrings[i]);
            // assertEquals(1, 0);
	}

    }

    /**
     * Test the sorting algorithm in Preprocessor.
     * This version is not using client and just testing for 
     * algorithm, should be commented out when testing full
     * version.
     */

    // @Test
    // @Ignore
    // public void test_Preprocessor_sort_algorithm() {
        
    //     // empty list
    //     LinkedList<String> data1 = new LinkedList<String>();
    //     LinkedList<String> data2 = new LinkedList<String>();
    //     LinkedList<Queue<String>> input1 = new LinkedList<Queue<String>>();
    //     input1.add(data1);
    //     input1.add(data2);
    //     Queue<String> output1 = new LinkedList<String>();
    //     Preprocessor test1 = new Preprocessor(null, output1);
    //     test1.sort_algorithm(input1);

    //     assertEquals(output1.isEmpty(), true);

    //     // normal list: all well sequenced 
    //     String[] strarr1 = {
    //         "1@A", "4@D"
    //     };
    //     String[] strarr2 = {
    //         "2@B", "5@E"
    //     };
    //     String[] strarr3 = {
    //         "3@C", "6@F"
    //     };
    //     LinkedList<String> data3 = new LinkedList<String>();
    //     for(int i = 0; i < strarr1.length; i++){ data3.add(strarr1[i]);}
    //     LinkedList<String> data4 = new LinkedList<String>();
    //     for(int i = 0; i < strarr2.length; i++){ data4.add(strarr2[i]);}
    //     LinkedList<String> data5 = new LinkedList<String>();
    //     for(int i = 0; i < strarr3.length; i++){ data5.add(strarr3[i]);}
    //     LinkedList<Queue<String>> input2 = new LinkedList<Queue<String>>();
    //     input2.add(data3);
    //     input2.add(data4);
    //     input2.add(data5);
    //     Queue<String> output2 = new LinkedList<String>();
    //     Preprocessor test2 = new Preprocessor(null, output2);
    //     assertEquals(1, test2.getTime(strarr1[0]));
    //     // assertEquals(1, Integer.parseInt(("1"+Communicator.INFOR_SEPARATOR+ "A").split(Communicator.INFOR_SEPARATOR)[0]));
    //     test2.sort_algorithm(input2);

    //     assertEquals(output2.isEmpty(), false);       
    //     String[] res1 = {
    //         "A", "B", "C", "D", "E", "F"
    //     };

    //     // assertEquals("A", test2.getCommand(strarr1[0]));
    //     for(int i = 0; i < res1.length; i++){
    //         assertEquals(output2.poll(), res1[i]);
    //     }
        
    //     // some time is not sequenced
    //     String[] strarr4 = {
    //         "1@A", "5@E"
    //     };
    //     String[] strarr5 = {
    //         "2@B", "4@D"
    //     };
    //     String[] strarr6 = {
    //         "3@C", "6@F"
    //     };
    //     LinkedList<String> data6 = new LinkedList<String>();
    //     for(int i = 0; i < strarr4.length; i++){ data6.add(strarr4[i]);}
    //     LinkedList<String> data7 = new LinkedList<String>();
    //     for(int i = 0; i < strarr5.length; i++){ data7.add(strarr5[i]);}
    //     LinkedList<String> data8 = new LinkedList<String>();
    //     for(int i = 0; i < strarr6.length; i++){ data8.add(strarr6[i]);}
    //     LinkedList<Queue<String>> input3 = new LinkedList<Queue<String>>();
    //     input3.add(data6);
    //     input3.add(data7);
    //     input3.add(data8);
    //     Queue<String> output3 = new LinkedList<String>();
    //     Preprocessor test3 = new Preprocessor(null, output3);
    //     // assertEquals(1, test3.getTime(strarr1[0]));

    //     test3.sort_algorithm(input3);

    //     assertEquals(output3.isEmpty(), false);       
    //     String[] res2 = {
    //         "A", "B", "C", "D", "E", "F"
    //     };

    //     // assertEquals("A", test2.getCommand(strarr1[0]));
    //     for(int i = 0; i < res2.length; i++){
    //         assertEquals(output3.poll(), res2[i]);
    //     }

    //     // some string is empty

    //     String[] strarr7 = {
    //         "1@A", "5@E"
    //     };
    //     String[] strarr8 = {
          
    //     };
    //     String[] strarr9 = {
    //         "3@C", "6@F"
    //     };
    //     LinkedList<String> data9 = new LinkedList<String>();
    //     for(int i = 0; i < strarr7.length; i++){ data9.add(strarr7[i]);}
    //     LinkedList<String> data10 = new LinkedList<String>();
    //     for(int i = 0; i < strarr8.length; i++){ data10.add(strarr8[i]);}
    //     LinkedList<String> data11 = new LinkedList<String>();
    //     for(int i = 0; i < strarr9.length; i++){ data11.add(strarr9[i]);}
    //     LinkedList<Queue<String>> input4 = new LinkedList<Queue<String>>();
    //     input4.add(data9);
    //     input4.add(data10);
    //     input4.add(data11);
    //     Queue<String> output4 = new LinkedList<String>();
    //     Preprocessor test4 = new Preprocessor(null, output4);

    //     test4.sort_algorithm(input4);

    //     assertEquals(output4.isEmpty(), false);       
    //     String[] res3 = {
    //         "A", "C", "E", "F"
    //     };

    //     for(int i = 0; i < res3.length; i++){
    //         assertEquals(output4.poll(), res3[i]);
    //     }

        
    // }

    @Test
    /**
     * since the system time is a long value,
     * we need to change the `int' from origin method into `Long'
     */
    public void test_Preprocessor_decode() {
        // test changing to long

        CommandDecoder decoder = new CommandDecoder();
        String[] test = {
            "123",
            "9223372036854775807", // 2^63 - 1
            "9223372036854775806"  // 2^63 -2
        };
        Long[] res = {
            new Long(123l),
            new Long(9223372036854775807l),
            new Long(9223372036854775806l),
        };
        for(int i = 0; i < test.length; i++){
            assertEquals(decoder.getTime(test[i]), res[i]);
        }
    }
    // @Rule 
    // public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test_Priority_Queue() {
        Queue<ClientCommand> cmds = new LinkedList<ClientCommand>();
        GameObjectFactory factory = new GameObjectFactory();
        Hero a = factory.createHero("HeroA");
        Hero b = factory.createHero("HeroB");
        Judge judge = new Judge(null, cmds);
        PriorityQueue<ClientCommand> res;


        
        // test for same priority
        ClientCommand[] data1 = {
            new ClientCommand(new Attack(a, b), null, 10l),
            new ClientCommand(new Attack(a, b), null, 10l)
        };                      // id: 0, 1
        for(int i = 0; i < data1.length; i++){
            cmds.add(data1[i]);
        }


        assertEquals(false, cmds.isEmpty());

        res = judge.createPriorityQueue(cmds);

        assertEquals(true, cmds.isEmpty());
        assertEquals(0, res.poll().getID());
        assertEquals(1, res.poll().getID());
        assertEquals(true, res.isEmpty());

        // since there will be an while loop for
        // checking whether the input queue is empty,
        // we needn't check this case. however, if
        // put an empty queue into the method somewhere,
        // it will return NullPointerException.
        try {
            res = judge.createPriorityQueue(cmds);
            fail("Expected a NullPointerException is been thrown");
        }catch (NullPointerException npe) {
            // assertThat(npe.getMessage(), is("null"));

        }

        // test for different priority
        ClientCommand[] data2 = {
            new ClientCommand(new Move(a, 0, 1), null, 10l),
            new ClientCommand(new Attack(a, b), null, 10l),
            new ClientCommand(new Attack(a, b), null, 10l)
        };                      // id: 2,3,4
        assertEquals(true, cmds.isEmpty());
        assertEquals(true, res.isEmpty());
        assertEquals(2, data2[0].getID());
        assertEquals(3, data2[1].getID());
        assertEquals(4, data2[2].getID());
        for(int i = 0; i < data2.length; i++){
            cmds.add(data2[i]);
        }

        assertEquals(false, cmds.isEmpty());
        assertEquals(true, res.isEmpty());
        res = judge.createPriorityQueue(cmds);

        assertEquals(true, cmds.isEmpty());
        assertEquals(3, res.poll().getID());
        assertEquals(4, res.poll().getID());
        assertEquals(2, res.poll().getID());
        assertEquals(true, res.isEmpty());


        // test for system commands
        ClientCommand[] data3 = {
            new ClientCommand(new Move(a, 0, 1), null, 10l),
            new ClientCommand(new Attack(a, b), null, 10l),
            new ClientCommand(new Login("hello", "world"), null, 10l)
        };                      // id: 5,6,7
        assertEquals(true, cmds.isEmpty());
        assertEquals(true, res.isEmpty());
        assertEquals(5, data3[0].getID());
        assertEquals(6, data3[1].getID());
        assertEquals(7, data3[2].getID());
        for(int i = 0; i < data3.length; i++){
            cmds.add(data3[i]);
        }

        assertEquals(false, cmds.isEmpty());
        assertEquals(true, res.isEmpty());
        res = judge.createPriorityQueue(cmds);

        assertEquals(true, cmds.isEmpty());
        assertEquals(7, res.poll().getID());
        assertEquals(6, res.poll().getID());
        assertEquals(5, res.poll().getID());
        assertEquals(true, res.isEmpty());
        
        
    }

    
}
// 
// TestLogic.java ends here
