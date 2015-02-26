//                              -*- Mode: Java -*- 
// Hero.java --- 
// Filename: Hero.java
// Description: 

// Code:
package moba.gameobj;

/**
 * Game object: Hero
 * @author Zhang Huayan
 * @version 1.0
 * Prototype of all kinds of heroes.
 */


import moba.gameobj.features.*;
public abstract class Hero 
    implements GameObject,
	       Movable,
	       Attackable, 
	       Alive,
	       HasTeam{
    // variables
    private int x;
    private int y;
    private int hp;
    private int hpmax;
    private int damage;
    private boolean alive;
    private TeamEnum team;

    // constructor

    public Hero(int x,
		int y,
		int hp,
		int hpmax,
		int damage,
		TeamEnum team){
	this.x = x;
	this.y = y;
	this.hp = hp;
	this.hpmax = hpmax;
	this.damage = damage;
	this.team = team;
	this.alive = true;
    }

    // methods
    @Override 
    public String getType(){
	return "Hero";
    }
    
    @Override
    public int getX(){
	return x;
    }

    @Override
    public int getY(){
	return y;
    }
    
    @Override
    public void move(int x, int y){
	// Algorithm for moving

    }
    
    @Override
    public int getDamage(){
	return damage;
    }

    @Override
    public void damage(int damage){
	if(hp - damage <= 0){
	    this.alive = false;
	    hp = 0;
	}else{
	    hp = hp - damage;
	}
    }

    @Override
    public void recover(int recover){
	hp = hp + recover <  hpmax? hp + recover : hpmax;
    }
    @Override
    public boolean isAlive(){
	return alive;
    }

    @Override
    public TeamEnum getTeam(){
	return team;
    }
    

    @Override
    public boolean isSameTeam(HasTeam obj){
	return team.equals(obj.getTeam());
    }

    
    protected void setX(int x){
	this.x = x;
    }

    
    protected void setY(int y){
	this.y = y;
    }

    // public abstract void levelup();
    public abstract void death();
    
}



// 
// Hero.java ends here
