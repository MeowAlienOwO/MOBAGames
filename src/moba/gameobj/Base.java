package moba.gameobj;

import moba.gameobj.features.*;

public abstract class Base implements GameObject, Alive, Attacked, Team {

    // variables
    private int positionX;
    private int positionY;
    private int healthPoint;
    private int healthPointMax;
    private TeamEnum team;

    // constructor
    public Base(int x, int y, int hp, int hpmax, TeamEnum team) {
        this.positionX = x;
        this.positionY = y;
        this.healthPoint = hp;
        this.healthPointMax = hpmax;
        this.team = team;
    }

    // methods
    @Override
    public String toString() {
        return "Base";
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
