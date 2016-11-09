// **************************************************************
// *		   
// *  HardQuestion
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the HardQuestion move of the CS RPG
 * project.
 */

package csrpg.moves;

import csrpg.fighters.Character;

public class HardQuestion extends Move {
	
	public HardQuestion() {
		name = "Hard Question";
		description = "How do you sort an array in O(1) time?" +
				"(Does 10 damage and reduces health by 5 per turn.)";
	}

	@Override
	public int effect(Character target, Character source) {
		target.induceEffect(5, 0, 0, 0, 0, 0.0);
		return target.damage(5, source.getATT());
	}

}
