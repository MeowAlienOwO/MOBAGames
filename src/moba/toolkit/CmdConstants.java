//                              -*- Mode: Java -*- 
// Protocal.java --- 
// Filename: Protocal.java
// 

// Code:
package moba.toolkit;

/**
 * Protocal
 * 
 * @author Zhang Huayan
 * @version 1.0 This part defines the protocal and provide a set of methods for
 *          creating and checking methods. Both server and client should behave
 *          according to this definition.
 */

public class CmdConstants {
    // constants
    public static final String VERSION = "1.0";
    public static final String LOGIN   = "LOGIN";
    public static final String LOGOUT  = "LOGOUT";
    public static final String MOVE = "MOVE";
    public static final String ATTACK = "ATTACK";
    public static final String SYSTEM = "SYS";
    public static final String GAME = "GAME";
    public static final String TYPE_SEPARATOR = "."; // need to use "\\." to split
    public static final String CMD_SEPARATOR = " ";
    public static final String WELCOME = "WELCOME";
    public static final String GOODBYE = "GOODBYE";
    public static final String CHOOSEHERO = "CHOOSEHERO";
    public static final String HERO = "HERO";
    public static final String HP   = "HP";
    public static final String POSITION = "POSITION";
    public static final String ATTRIBUTE = "ATTRIBUTE";
    public static final String ASSET = "ASSET";

}

//
// Protocal.java ends here
