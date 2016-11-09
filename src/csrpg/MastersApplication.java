// **************************************************************
// *		   
// *  MastersApplication
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the MastersApplication component of the
 * project.
 */

package csrpg.fighters;
import csrpg.moves.*;

public class MastersApplication extends Character {

	public MastersApplication() {
		name = "Masters Application";
		description = "3.2? Welcome to the CS Master's program. 3.19? Better fill out a long application...";
		
		moveset[0] = new HardQuestion();
		moveset[1] = new OpenEndedQuestion();
		
		maxHealth = 25;
		health = 25;
	}

}