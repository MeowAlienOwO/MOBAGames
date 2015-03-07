//                              -*- Mode: Java -*- 
// Attackable.java --- 
// Filename: Attackable.java

// Code:

package moba.gameobj.features;

import moba.gameobj.*;
/**
 * Game feature: Attackable
 * @author Zhang Huayan
 * @version 1.0
 * Able to perform attack.
 */

public interface Attackable extends GameObject{
    
    // public void attack(Alive enermy);

    public int getDamage();
    

}


// 
// Attackable.java ends here
