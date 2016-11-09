// **************************************************************
// *		   
// *  LennyPitt
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the LennyPitt component of the
 * project.
 */

package csrpg.fighters;
import csrpg.moves.*;

public class LennyPitt extends Character {

	public LennyPitt() {
		name = "Lenny Pitt";
		description = "Need to get into a course? He might let you in...";
		
		moveset[0] = new Advise();
		moveset[1] = new OverrideMove();
		
		maxHealth = 25;
		health = 25;
	}

}