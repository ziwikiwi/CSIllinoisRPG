// **************************************************************
// *		   
// *  TechnicalInterview
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the TechnicalInterview component of the
 * project.
 */

package csrpg.fighters;
import csrpg.moves.*;

public class TechnicalInterview extends Character {

	public TechnicalInterview() {
		name = "Technical Interview";
		description = "You'd better hope you remember everything from 225.";
		
		moveset[0] = new HardQuestion();
		moveset[1] = new OpenEndedQuestion();
		
		maxHealth = 50;
		health = 50;
	}

}
