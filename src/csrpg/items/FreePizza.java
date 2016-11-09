// **************************************************************
// *		   
// *  FreePizza
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the FreePizza item of the CS RPG
 * project.
 */

package csrpg.items;

import csrpg.fighters.Character;

public class FreePizza extends Item {
	
	public FreePizza() {
		name = "Free Pizza";
		description = "The only reason to go to internship info sessions.\n" +
				"(Heals 50 health)";
	}

	@Override
	public int effect(Character target) {
		return target.heal(50);
	}

}