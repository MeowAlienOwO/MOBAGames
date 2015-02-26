//                              -*- Mode: Java -*- 
// TestHeroB.java --- 
// Filename: TestHeroB.java
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
//     Update #: 11
// 

// Code:

package moba.gameobj;
import moba.gameobj.features.*;
/**
 * Game object: TestHeroB
 * @author Zhang Huayan
 * @version 1.0
 * Instance of a hero
 */

public class TestHeroB extends Hero{
    
    // variables

    public TestHeroB(int x,
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
	return (super.getType() + "." + "TestHeroB");
    }

    @Override
    public void death(){
	System.out.println(getType() + " dead.");
    }

}





// 
// TestHeroB.java ends here
