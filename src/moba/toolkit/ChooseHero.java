//                              -*- Mode: Java -*- 
// ChooseHero.java --- 
// Filename: ChooseHero.java
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
//     Update #: 21
// 

// Code:

package moba.toolkit;

import moba.gameobj.*;
import moba.gameobj.features.*;

/**
 * Command: ChooseHero
 * 
 * @author Zhang Huayan
 * @version 1.0 Defines the ChooseHero command.
 * 
 */

public class ChooseHero extends SystemCommand {

    String heroname;

    public ChooseHero(String heroname){
        this.heroname = heroname;
    }

    /**
     * encode ChooseHero. format: "CHOOSEHERO heroname"
     */
	public String getCommandType() {
		return (super.getCommandType() + CmdConstants.TYPE_SEPARATOR + CmdConstants.CHOOSEHERO);
	}
    @Override
    public String encode() {
        return (CmdConstants.CHOOSEHERO + CmdConstants.CMD_SEPARATOR + heroname);
    }

    public String getHeroname(){
        return heroname;
    }
}



// 
// ChooseHero.java ends here
