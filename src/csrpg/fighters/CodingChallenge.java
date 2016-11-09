// **************************************************************
// *		   
// *  CodingChallenge
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the CodingChallenge component of the
 * project.
 */

package csrpg.fighters;
import csrpg.moves.*;
import csrpg.moves.StackOverflowError;

public class CodingChallenge extends Character {

	public CodingChallenge() {
		name = "Coding Challenge";
		description = "They won't even give you an interview till you prove you know what code is.";
		
		moveset[0] = new Segfault();
		moveset[1] = new StackOverflowError();
		moveset[2] = new Timeout();
		moveset[3] = new WrongOutput();
		
		maxHealth = 25;
		health = 25;
	}

}