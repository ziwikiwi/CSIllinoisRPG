// **************************************************************
// *		   
// *  AllNighter
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the AllNighter component of the
 * project.
 */

package csrpg.fighters;
import csrpg.moves.*;

public class AllNighter extends Character {

	public AllNighter() {
		name = "All Nighter";
		description = "After a few hours you realize you were typing complete gibberish.";
		
		moveset[0] = new Delirium();
		moveset[1] = new DozingOff();
		
		maxHealth = 40;
		health = 40;
	}

}