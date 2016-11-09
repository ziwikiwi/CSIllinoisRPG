// **************************************************************
// *		   
// *  HealthInsuranceWaiver
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the HealthInsuranceWaiver item of the CS RPG
 * project.
 */

package csrpg.items;

import csrpg.fighters.Character;

public class HealthInsuranceWaiver extends Item {
	
	public HealthInsuranceWaiver() {
		name = "Health Insurance Waiver";
		description = "Wave the extra $300 cost goodbye.\n" +
				"(Increases REC by 2 each turn)";
	}

	@Override
	public int effect(Character target) {
		target.induceEffect(0, 0, 0, -2, 0, 0.0);
		return 2;
	}

}
