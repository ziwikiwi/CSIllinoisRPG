// **************************************************************
// *		   
// *  Suit
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Suit item of the CS RPG
 * project.
 */

package csrpg.items;

import csrpg.fighters.Character;

public class Suit extends Item {
	
	public Suit() {
		name = "Suit";
		description = "Wear one of these, and they won't notice you don't know what an array is." +
				"(Increases DR by 0.3)";
	}

	@Override
	public int effect(Character target) {
		target.setDamageResistance(target.getDamageResistance() + 0.3);
		return 1;
	}

}
