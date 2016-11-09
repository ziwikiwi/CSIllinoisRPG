// **************************************************************
// *		   
// *  NewLaptop
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the NewLaptop item of the CS RPG
 * project.
 */

package csrpg.items;

import csrpg.fighters.Character;

public class NewLaptop extends Item {
	
	public NewLaptop() {
		name = "New Laptop";
		description = "Brand new top-of-the-line MP/League machine.\n" +
				"(Increases ATT by 2 each turn)";
	}

	@Override
	public int effect(Character target) {
		target.induceEffect(0, -2, 0, 0, 0, 0.0);
		return 2;
	}

}
