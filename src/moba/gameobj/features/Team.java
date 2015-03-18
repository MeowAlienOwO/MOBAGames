package moba.gameobj.features;

public interface Team {

    public abstract TeamEnum getTeam();

    public abstract boolean isSameTeam(TeamEnum te);
}
