// **************************************************************
// *		   
// *  FinalProject242
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the FinalProject242 component of the
 * project.
 */

package csrpg.fighters;
import csrpg.moves.*;
import csrpg.moves.StackOverflowError;

public class FinalProject242 extends Character {

	public FinalProject242() {
		name = "CS 242 Final Project";
		description = "Why write a fancy Android app when you can make a nifty RPG?";
		
		moveset[0] = new ForkBomb();
		moveset[1] = new NoLateCredit();
		moveset[2] = new SchrodingersGrade();
		moveset[3] = new StackOverflowError();
		
		maxHealth = 75;
		health = 75;
	}

}