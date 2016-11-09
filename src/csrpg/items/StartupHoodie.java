// **************************************************************
// *		   
// *  StartupHoodie
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the StartupHoodie item of the CS RPG
 * project.
 */

package csrpg.items;

import csrpg.fighters.Character;

public class StartupHoodie extends Item {
	
	public StartupHoodie() {
		name = "Startup Hoodie";
		description = "A real sign you've had an internship.\n" +
				"I mean, they don't just give these away, right?\n" +
				"(Increases DR by 0.15)";
	}

	@Override
	public int effect(Character target) {
		target.setDamageResistance(target.getDamageResistance() + 0.15);
		return 1;
	}

}
