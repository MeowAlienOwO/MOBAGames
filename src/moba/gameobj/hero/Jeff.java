package moba.gameobj.hero;

import moba.gameobj.Hero;
import moba.gameobj.features.TeamEnum;

public class Jeff extends Hero {

	public Jeff(TeamEnum team) {
	// 	setHeroName("Jeff");
	// 	if (team.equals(TeamEnum.ATTACK)) {
	// 		setPositionX(117);
	// 		setPositionY(10);
	// 	} else {
	// 		setPositionX(7);
	// 		setPositionY(193);
	// 	}
	// 	setHealthPoint(100);
	// 	setHealthPointMax(100);
	// 	setAttackDamage(5);
	// 	setTeam(team);
	// 	setGold(0);
	// 	setExperience(0);
	// }
        super("Jeff",
              117,
              10,
              100,
              100,
              5,
              team,
              0,
              0,
              3);

        if(!team.equals(TeamEnum.ATTACK)){
            setPositionX(7);
            setPositionY(193);
        }


    }

}
