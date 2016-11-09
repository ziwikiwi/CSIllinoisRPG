// **************************************************************
// *		   
// *  OverrideMove
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the OverrideMove move of the CS RPG
 * project.
 */

package csrpg.moves;

import csrpg.fighters.Character;

public class OverrideMove extends Move {
	
	public OverrideMove() {
		name = "Override";
		description = "With a little help, you get into 500-level courses as a freshman.\n" +
				"(Drains 1 health per turn)";
	}

	@Override
	public int effect(Character target, Character source) {
		target.induceEffect(1, 0, 0, 0, 0, 0.0);
		return 1;
	}

}