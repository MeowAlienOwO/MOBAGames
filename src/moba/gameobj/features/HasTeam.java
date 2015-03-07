//                              -*- Mode: Java -*- 
// Team.java --- 
// Filename: Team.java

// Code:


package moba.gameobj.features;
import moba.gameobj.*;
/**
 * Game feature: Team
 * @author Zhang Huayan
 * @version 1.0
 * Team defines the game objects into different group, like in DOTA
 * we have the Sentinel and the Scourge.
 *
 */

public interface HasTeam extends GameObject{

    public abstract TeamEnum getTeam();

    public abstract boolean isSameTeam(HasTeam obj);
}

// 
// Team.java ends here
