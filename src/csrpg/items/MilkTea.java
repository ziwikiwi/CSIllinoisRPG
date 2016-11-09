// **************************************************************
// *		   
// *  MilkTea
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the MilkTea item of the CS RPG
 * project.
 */

package csrpg.items;

import csrpg.fighters.Character;

public class MilkTea extends Item {
	
	public MilkTea() {
		name = "Milk Tea";
		description = "The only drink that makes your jaw sore from chewing.\n" +
				"(Heals 20 health)";
	}

	@Override
	public int effect(Character target) {
		return target.heal(20);
	}

}