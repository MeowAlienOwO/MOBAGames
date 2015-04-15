package moba.gameobj.features;

public enum TeamEnum {
	// LAWFUL, NEUTRUAL, CHAOTIC

    ATTACK, NEUTRUAL, DEFENCE;

    @Override
    public String toString(){
        if(this == TeamEnum.ATTACK) return "ATTACK";
        else if(this == TeamEnum.NEUTRUAL) return "NEUTRUAL";
        else return "DEFENCE";
    }

    public static TeamEnum encodeTeam(String s){
        if(s.equals("ATTACK")) return ATTACK;
        else if(s.equals("DEFENCE")) return DEFENCE;
        else return NEUTRUAL;
    }
}
