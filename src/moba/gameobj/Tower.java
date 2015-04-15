package moba.gameobj;

import java.awt.Color;
import java.awt.Graphics;

import moba.gameobj.features.*;

public abstract class Tower implements GameObject, Alive, Attacking, Attacked,
		Team {

	// variables
	private int positionX;
	private int positionY;
	private int healthPoint;
	private int healthPointMax;
	private int attackDamage;
	private TeamEnum team;

	// constructor
	public Tower(int x, int y, int hp, int hpmax, int damage, TeamEnum team) {
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
		return "Tower";
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
	public TeamEnum getTeam() {
		return team;
	}

	@Override
	public boolean isSameTeam(TeamEnum te) {
		return team.equals(te);
	}

	public void draw(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 40, 40);
	}
}
