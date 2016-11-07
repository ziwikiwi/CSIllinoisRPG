// **************************************************************
// *		   
// *  Procrastinate
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Procrastinate move of the CS RPG
 * project.
 */

package csrpg.moves;

import csrpg.fighters.Character;

public class Procrastinate extends Move {

	public Procrastinate() {
		name = "Procrastinate";
		description = "You could do your MP. But League ain't " +
				"gonna play itself.\n" +
				"(Heals 10 health, but reduces damage resistance" +
				"by 10%)";
	}
	
	@Override
	public int effect(Character target, Character source) {
		source.setDamageResistance(source.getDamageResistance() * 0.9);
		return source.heal(10);
	}

}
