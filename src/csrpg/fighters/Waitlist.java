// **************************************************************
// *		   
// *  Waitlist
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Waitlist component of the
 * project.
 */

package csrpg.fighters;
import csrpg.moves.*;
import csrpg.moves.StackOverflowError;

public class Waitlist extends Character {

	public Waitlist() {
		name = "Waitlist";
		description = "It's a required course, they have to let you in! Right..?";
		
		moveset[0] = new Segfault();
		moveset[1] = new StackOverflowError();
		moveset[2] = new Timeout();
		moveset[3] = new WrongOutput();
		
		maxHealth = 25;
		health = 25;
	}

}