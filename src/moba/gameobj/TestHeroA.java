//                              -*- Mode: Java -*- 
// TestHeroA.java --- 
// Filename: TestHeroA.java
// Description: 

// Code:

package moba.gameobj;

/**
 * Game object: TestHeroA
 * @author Zhang Huayan
 * @version 1.0
 * Instance of hero, for testing logic and features.
 */

import moba.gameobj.features.*;
public class TestHeroA extends Hero{
    
    // variables
   
    // constructor
    public TestHeroA(int x,
		int y,
		int hp,
		int hpmax,
		int damage,
		TeamEnum team){
	super(x, y, hp, hpmax, damage, team);
    }

    // methods
    @Override
    public String getType(){
	return (super.getType() + "." + "TestHeroA");
    }

    @Override
    public void death(){
	System.out.println(getType() + " dead.");
    }

}



// 
// TestHeroA.java ends here
