package moba.gameobj.hero;

import moba.gameobj.Hero;
import moba.gameobj.features.TeamEnum;

public class Anthony extends Hero {

	// public Anthony(TeamEnum team) {
	// 	setHeroName("Anthony");
	// 	if (team.equals(TeamEnum.ATTACK)) {
	// 		setPositionX(500);
	// 		setPositionY(500);
	// 	} else {

	// 	}
	// 	setHealthPoint(100);
	// 	setHealthPointMax(100);
	// 	setAttackDamage(5);
	// 	setTeam(TeamEnum.ATTACK);
	// 	setGold(0);
	// 	setExperience(0);
	// 	setSpeed(3);
	// }
    public Anthony(TeamEnum team){
        super("Anthony",
              500,
              500,
              100,
              100,
              5,
              team,
              0,
              0,
              3);
    }

}
