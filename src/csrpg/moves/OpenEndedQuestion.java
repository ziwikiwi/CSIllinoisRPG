// **************************************************************
// *		   
// *  OpenEndedQuestion
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the OpenEndedQuestion move of the CS RPG
 * project.
 */

package csrpg.moves;

import csrpg.fighters.Character;

public class OpenEndedQuestion extends Move {
	
	public OpenEndedQuestion() {
		name = "Open Ended Question";
		description = "You thought this would be all multiple choice, didn't you?" +
				"(Reduces ATT stat by one each turn.)";
	}

	@Override
	public int effect(Character target, Character source) {
		target.induceEffect(0, 1, 0, 0, 0, 0.0);
		return 1;
	}

}