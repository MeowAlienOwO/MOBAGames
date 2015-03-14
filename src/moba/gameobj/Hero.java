package moba.gameobj;

import moba.gameobj.features.*;

public abstract class Hero implements GameObject, Movable, Attacking, Attacked,
		Alive, Team, Gold, Experience {

	// variables
	private String heroName;
	private int positionX;
	private int positionY;
	private int healthPoint;
	private int healthPointMax;
	private int attackDamage;
	private TeamEnum team;
	private int gold;
	private int experience;

	// constructor
	public Hero(String name, int x, int y, int hp, int hpmax, int damage, TeamEnum team,
			int gold, int exp) {
		this.heroName = name;
		this.positionX = x;
		this.positionY = y;
		this.healthPoint = hp;
		this.healthPointMax = hpmax;
		this.attackDamage = damage;
		this.team = team;
		this.gold = gold;
		this.experience = exp;
	}

	// methods

	@Override
	public String toString() {
		return heroName;
	}
	
	@Override
	public int getPositionX() {
		return positionX;
	}

	@Override
	public int getPositionY() {
		return positionY;
	}

	@Override
	public void move(int x, int y) {
		// Algorithm for moving

	}

	@Override
	public int attacking(int hp) {
		return hp - attackDamage;
	}

	@Override
	public void attacked(int ad) {
		healthPoint -= ad;
	}

	@Override
	public void recover(int recover) {
		healthPoint = healthPoint + recover < healthPointMax ? healthPoint
				+ recover : healthPointMax;
	}

	@Override
	public TeamEnum getTeam() {
		return team;
	}

	@Override
	public boolean isSameTeam(TeamEnum te) {
		return team.equals(te);
	}

	@Override
	public void gainGold(int g) {
		gold += g;
	}
	
	@Override
	public void gainExperience(int e) {
		experience += e;
	}

	public abstract void death();

}
