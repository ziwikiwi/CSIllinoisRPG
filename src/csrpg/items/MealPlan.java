// **************************************************************
// *		   
// *  MealPlan
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the MealPlan item of the CS RPG
 * project.
 */

package csrpg.items;

import csrpg.fighters.Character;

public class MealPlan extends Item {
	
	public MealPlan() {
		name = "Meal Plan";
		description = "Better use all those cafe credits.\n" +
				"(Heals 100 health)";
	}

	@Override
	public int effect(Character target) {
		return target.heal(100);
	}

}