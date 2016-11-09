// **************************************************************
// *		   
// *  Espresso
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Espresso item of the CS RPG
 * project.
 */

package csrpg.items;

import csrpg.fighters.Character;

public class Espresso extends Item {
	
	public Espresso() {
		name = "Espresso";
		description = "They say you can count the number of\n" +
				"assignments you have due by the number of shots\n" +
				"of espresso you had.\n" +
				"(Increases SPE by 2 each turn)";
	}

	@Override
	public int effect(Character target) {
		target.induceEffect(0, 0, 0, 0, -2, 0.0);
		return 2;
	}

}