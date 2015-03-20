//                              -*- Mode: Java -*- 
// Attack.java --- 
// Filename: Attack.java

// Code:

package moba.toolkit;

import moba.gameobj.*;
import moba.gameobj.features.*;

/**
 * Command: Attack
 * 
 * @author Zhang Huayan
 * @version 1.0 Defines the attack command.
 * 
 */

public class Attack extends GameCommand {

    // variables
    private Attacking attackFrom;
    private Attacked attackTo;

    // constructor
    public Attack(Attacking from, Attacked to) {
        this.attackFrom = from;
        this.attackTo = to;

    }

    @Override
    public String getCommandType() {
        return (super.getCommandType() + CmdConstants.TYPE_SEPARATOR + CmdConstants.ATTACK);
    }

    /**
     * encode attack. format: "ATTACK from to"
     */
    @Override
    public String encode() {
        return (CmdConstants.ATTACK + CmdConstants.CMD_SEPARATOR + attackFrom.toString()
                + CmdConstants.CMD_SEPARATOR + attackTo.toString());
    }

    public Attacking getAttackFrom(){
        return attackFrom;
    }

    public Attacked getAttackTo(){
        return attackTo;
    }
    
}
