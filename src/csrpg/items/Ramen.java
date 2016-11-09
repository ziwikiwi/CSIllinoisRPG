// **************************************************************
// *		   
// *  Ramen
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Ramen item of the CS RPG
 * project.
 */

package csrpg.items;

import csrpg.fighters.Character;

public class Ramen extends Item {
	
	public Ramen() {
		name = "Ramen";
		description = "Your bread and butter. Also, the leading cause of heart failure in Korea.\n" +
				"(Heals 10 health)";
	}

	@Override
	public int effect(Character target) {
		return target.heal(10);
	}

}
