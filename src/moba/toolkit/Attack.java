//                              -*- Mode: Java -*- 
// Attack.java --- 
// Filename: Attack.java

// Code:

package moba.toolkit;


import moba.gameobj.*;
import moba.gameobj.features.*;
/**
 * Command: Attack
 * @author Zhang Huayan
 * @version 1.0
 * Defines the attack command.
 * 
 */


public class Attack extends GameCommand{
    
    // variables
    private Attackable attack4m;
    private Alive attack2;

    // constructor
    public Attack(Attackable attack4m,
		  Alive attack2){
	this.attack4m = attack4m;
	this.attack2  = attack2;

    }
    @Override 
    public String getType(){

	return (super.getType() 
		+ Protocal.TYPE_SEPARATOR
		+Protocal.ATTACK);
    }

    /**
     * encode attack.
     * format: "ATTACK from to"
     */
    @Override
    public String encode(){
	return (Protocal.ATTACK + Protocal.CMD_SEPARATOR 
		+ attack4m.getType() + Protocal.CMD_SEPARATOR
		+ attack2.getType() + Protocal.CMD_SEPARATOR);
    }

    public GameObject getAttack4m(){
	return attack4m;
    }
    
    public GameObject getAttack2(){
	return attack2;
    }

}

// 
// Attack.java ends here
