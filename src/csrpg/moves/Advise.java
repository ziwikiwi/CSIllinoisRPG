// **************************************************************
// *		   
// *  Advise
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Advise move of the CS RPG
 * project.
 */

package csrpg.moves;

import csrpg.fighters.Character;

public class Advise extends Move {
	
	public Advise() {
		name = "Advise";
		description = "Apparently, you shouldn't take 5 CS courses in a semester.\n" +
				"(Does 5 damage)";
	}

	@Override
	public int effect(Character target, Character source) {
		return target.damage(5, source.getATT());
	}

}
