// **************************************************************
// *		   
// *  ProficiencyExam
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Proficiency Exam move of the CS RPG
 * project.
 */

package csrpg.moves;

import csrpg.fighters.Character;

public class Cram extends Move {
	
	public Cram() {
		name = "Cram";
		description = "Lock your door, close Facebook, and " +
				"study. Mind-numbing, but effective.\n" +
				"(Drains 5 damange from your opponent and adds " +
				"it to your own health)";
	}

	@Override
	public int effect(Character target, Character source) {
		int drain = target.damage(5, source.getATT());
		source.heal(drain);
		return drain;
	}

}
