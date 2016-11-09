// **************************************************************
// *		   
// *  GRE
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the GRE component of the
 * project.
 */

package csrpg.fighters;
import csrpg.moves.*;

public class GRE extends Character {

	public GRE() {
		name = "GRE";
		description = "Nothing like taking another test to get into a school you already go to.";
		
		moveset[0] = new HardQuestion();
		moveset[1] = new OpenEndedQuestion();
		
		maxHealth = 60;
		health = 60;
	}

}