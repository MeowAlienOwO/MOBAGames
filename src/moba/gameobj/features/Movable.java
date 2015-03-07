//                              -*- Mode: Java -*- 
// Movable.java --- 
// Filename: Movable.java
// Code:

package moba.gameobj.features;
import moba.gameobj.*;
/**
 * Game feature: Movable
 * @author Zhang Huayan
 * @version 1.0
 * Movable defines how to move.
 */

public interface Movable extends GameObject{
    
    public abstract void move(int x, int y);

    public abstract int getX();
    
    public abstract int getY();

   
}

// 
// Movable.java ends here
