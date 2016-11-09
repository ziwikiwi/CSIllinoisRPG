// **************************************************************
// *		   
// *  Harambe
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Harambe move of the CS RPG
 * project.
 */

package csrpg.moves;

import csrpg.fighters.Character;

public class Harambe extends Move {
	
	public Harambe() {
		name = "Harambe";
		description = "Is it better that Harambe died, or Harambe didn't die and no one cared?\n" +
				"(Deals 20 damage)";
	}

	@Override
	public int effect(Character target, Character source) {
		return target.damage(20, source.getATT());
	}

}
