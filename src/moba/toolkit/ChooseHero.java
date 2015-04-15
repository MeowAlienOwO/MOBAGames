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
//     Update #: 40
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
    TeamEnum team;
    public ChooseHero(String heroname, TeamEnum team){
        this.heroname = heroname;
        this.team = team;
    }
    // make it compatible to herocode approach
    public ChooseHero(String herocode){
        this.heroname = herocode;
        this.team = null;
    }

    /**
     * encode ChooseHero. format: "CHOOSEHERO heroname teamname"
     */
    public String getCommandType() {
        return (super.getCommandType() + CmdConstants.TYPE_SEPARATOR + CmdConstants.CHOOSEHERO);
    }


    @Override
    public String encode() {
        return (CmdConstants.CHOOSEHERO + CmdConstants.CMD_SEPARATOR + heroname + CmdConstants.CMD_SEPARATOR + team.toString());
    }

    public String getHeroname(){
        return heroname;
    }

    public TeamEnum getTeam(){
        return team;
    }

    public void setTeam(TeamEnum team){
        this.team = team;
    }
}



// 
// ChooseHero.java ends here
