// **************************************************************
// *		   
// *  Delirium
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Delirium move of the CS RPG
 * project.
 */

package csrpg.moves;

import csrpg.fighters.Character;

public class Delirium extends Move {
	
	public Delirium() {
		name = "Delirium";
		description = "You're on hour 20 of being awake and everything's seems.. fainter." +
				"(Reduces damage resistance by 0.05 per turn)";
	}

	@Override
	public int effect(Character target, Character source) {
		target.induceEffect(0, 0, 0, 0, 0, 0.05);
		return 1;
	}

}