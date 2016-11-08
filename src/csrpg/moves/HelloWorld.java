// **************************************************************
// *		   
// *  HelloWorld
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the HelloWorld move of the CS RPG
 * project.
 */

package csrpg.moves;

import csrpg.fighters.Character;

public class HelloWorld extends Move {

	public HelloWorld() {
		name = "HelloWorld";
		description = "Proof positive that you took AP CS. Or " +
				"at least went to class the first week.\n" +
				"(Swings at enemy for 10 damage)";
	}
	
	@Override
	public int effect(Character target, Character source) {
		return target.damage(10, source.getATT());
	}

}
