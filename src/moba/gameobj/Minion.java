package moba.gameobj;

import moba.gameobj.features.*;

public abstract class Minion implements GameObject, Movable, Alive, Attacking,
		Attacked, Team {

	// variables
	private int positionX;
	private int positionY;
	private int healthPoint;
	private int healthPointMax;
	private int attackDamage;
	private TeamEnum team;

	// constructor
	public Minion(int x, int y, int hp, int hpmax, int damage, TeamEnum team) {
		this.positionX = x;
		this.positionY = y;
		this.healthPoint = hp;
		this.healthPointMax = hpmax;
		this.attackDamage = damage;
		this.team = team;
	}

	// methods
	@Override
	public String toString() {
		return "Minion";
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
	public int attacking() {
		return attackDamage;
	}

	@Override
	public void attacked(int ad) {
		healthPoint -= ad;
	}

	@Override
	public TeamEnum getTeam() {
		return team;
	}

	@Override
	public boolean isSameTeam(TeamEnum te) {
		return team.equals(te);
	}
}
