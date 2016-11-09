// **************************************************************
// *		   
// *  HomeworkDrop
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the HomeworkDrop item of the CS RPG
 * project.
 */

package csrpg.items;

import csrpg.fighters.Character;

public class HomeworkDrop extends Item {
	
	public HomeworkDrop() {
		name = "Homework Drop";
		description = "Nobody did the last homework.\n" +
				"(Increases DEF by 2 each turn)";
	}

	@Override
	public int effect(Character target) {
		target.induceEffect(0, 0, -2, 0, 0, 0.0);
		return 2;
	}

}
