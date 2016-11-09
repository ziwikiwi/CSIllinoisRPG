// **************************************************************
// *		   
// *  DozingOff
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the DozingOff move of the CS RPG
 * project.
 */

package csrpg.moves;

import csrpg.fighters.Character;

public class DozingOff extends Move {
	
	public DozingOff() {
		name = "Dozing Off";
		description = "You lay your head down in lecture for just a second... next thing you know it's a different lecture." +
				"(Deals 5 damage and reduces speed by 1 per turn.)";
	}

	@Override
	public int effect(Character target, Character source) {
		target.damage(5, source.getATT());
		target.induceEffect(0, 0, 0, 0, 1, 0.00);
		return 1;
	}

}