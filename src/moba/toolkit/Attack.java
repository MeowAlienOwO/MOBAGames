//                              -*- Mode: Java -*- 
// Attack.java --- 
// Filename: Attack.java

// Code:

package moba.toolkit;
/**
 * Command: Attack
 * @author Zhang Huayan
 * @version 1.0
 * Defines the attack command.
 * 
 */


import moba.gameobj.*;
public class Attack extends GameCommand{
    
    // variables
    private GameObject attack4m;
    private GameObject attack2;
    private int damage;

    // constructor
    public Attack(GameObject attack4m,
		  GameObject attack2,
		  int damage){
	this.attack4m = attack4m;
	this.attack2  = attack2;
	this.damage   = damage;

    }
    @Override 
    public String getType(){

	return (super.getType() + "." +"Attack");
    }

    @Override
    public String encode(){
	return (Protocal.ATTACK + " " 
		+ attack4m.getType() + " "
		+ attack2.getType() + " "
		+ damage);
    }

    public GameObject getAttack4m(){
	return attack4m;
    }
    
    public GameObject getAttack2(){
	return attack2;
    }

    public int getDamage(){
	return damage;
    }
}

// 
// Attack.java ends here
