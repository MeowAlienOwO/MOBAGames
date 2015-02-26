//                              -*- Mode: Java -*- 
// GameObject.java --- 
// Filename: GameObject.java

// Code:

package moba.gameobj;
/**
 * Command: GameObject
 * @author Zhang Huayan
 * @version 1.0
 * GameObject defines the basic interface for game.
 * GameObject simulates the architecture of game logic, and could be used by
 * both client and server. 
 * One specified Game Object should have a prototype, which defines a set of
 * interfaces which are the features that the Game Object should have. An 
 * instance of that prototype should implement all the features.
 * example hero:
 *     features:
 *         graphic, team, spell etc.
 *     prototype:
 *         abstract class implements feature interfaces
 *     instance:
 *         class extends prototype{
 *             // methods that implements features
 *         }
 *     
 * 
 */

public interface GameObject{

    public abstract String getType();

}

// 
// GameObject.java ends here
