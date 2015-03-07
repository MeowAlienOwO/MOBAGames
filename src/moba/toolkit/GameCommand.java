//                              -*- Mode: Java -*- 
// GameCommand.java --- 
// Filename: GameCommand.java

// Code:

package moba.toolkit;
/**
 * GameCommand
 * @author Zhang Huayan
 * @version 1.0
 * Define GameCommand that is available in the moba project.
 */

public abstract class GameCommand implements Command{

    @Override
    public String getType(){
	return Protocal.GAME;
    }
}

// 
// GameCommand.java ends here
