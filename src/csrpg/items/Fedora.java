// **************************************************************
// *		   
// *  Fedora
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Fedora item of the CS RPG
 * project.
 */

package csrpg.items;

import csrpg.fighters.Character;

public class Fedora extends Item {
	
	public Fedora() {
		name = "Fedora";
		description = "M'lady.\n" +
				"(Increases DR by 0.1, but decreases REC by 1 per turn.)";
	}

	@Override
	public int effect(Character target) {
		target.setDamageResistance(target.getDamageResistance() + 0.1);
		target.induceEffect(0, 0, 0, 1, 0, 0.0);
		return 1;
	}

}
