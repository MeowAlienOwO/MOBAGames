//                              -*- Mode: Java -*- 
// Alive.java --- 
// Filename: Alive.java

// Code:


package moba.gameobj.features;

/**
 * Game feature: Attackable
 * @author Zhang Huayan
 * @version 1.0
 * Able to perform attack.
 */

public interface Alive{
    
    public abstract void damage(int damage);

    public abstract void recover(int recover);

    public abstract boolean isAlive();

}


// 
// Alive.java ends here
