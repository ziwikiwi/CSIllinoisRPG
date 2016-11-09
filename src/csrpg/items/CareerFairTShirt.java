// **************************************************************
// *		   
// *  CareerFairTShirt
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the CareerFairTShirt item of the CS RPG
 * project.
 */

package csrpg.items;

import csrpg.fighters.Character;

public class CareerFairTShirt extends Item {
	
	public CareerFairTShirt() {
		name = "Career Fair T-Shirt";
		description = "You have 40 different T-Shirts, but only 1 pair of pants.\n" +
				"(Increases DR by 0.05)";
	}

	@Override
	public int effect(Character target) {
		target.setDamageResistance(target.getDamageResistance() + 0.05);
		return 1;
	}

}
