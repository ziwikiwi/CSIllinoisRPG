// **************************************************************
// *		   
// *  Pepe
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Pepe move of the CS RPG
 * project.
 */

package csrpg.moves;

import csrpg.fighters.Character;

public class Pepe extends Move {
	
	public Pepe() {
		name = "Pepe";
		description = "Suddenly you realize that YOU are the crying green frog.\n" +
				"(Reduces ATT, DEF, REC, SPE by 1 each.)";
	}

	@Override
	public int effect(Character target, Character source) {
		target.induceEffect(0, 1, 1, 1, 1, 0.0);
		return 1;
	}

}
