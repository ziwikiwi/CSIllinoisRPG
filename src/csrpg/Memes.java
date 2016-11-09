// **************************************************************
// *		   
// *  Memes
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Memes component of the
 * project.
 */

package csrpg.fighters;
import csrpg.moves.*;

public class Memes extends Character {

	public Memes() {
		name = "Memes";
		description = "Dank.";
		
		moveset[0] = new Pepe();
		moveset[1] = new Harambe();
		
		maxHealth = 25;
		health = 25;
	}

}