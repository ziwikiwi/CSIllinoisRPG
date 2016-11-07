// **************************************************************
// *		   
// *  ProficiencyExam
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Proficiency Exam move of the CS RPG
 * project.
 */

package csrpg.moves;

import csrpg.fighters.Character;
import java.util.Random;

public class ProficiencyExam extends Move {
	
	public ProficiencyExam() {
		name = "Proficiency Exam";
		description = "You took AP CS in high school but got a " +
				"3 on the exam. Well, second time's the charm.\n" +
				"([50% Chance] Increases damage resistance by " +
				"10% [50% Chance] Decreases damage resistance by 5%)";
	}

	@Override
	public int effect(Character target, Character source) {
		if(new Random().nextBoolean()) {
			int increase = (int)(source.getDamageResistance() * 0.1);
			source.setDamageResistance(source.getDamageResistance() * 1.1);
			return increase;
		} else {
			int decrease = (int)(source.getDamageResistance() * -0.05);
			source.setDamageResistance(source.getDamageResistance() * 0.95);
			return decrease;
		}
	}

}
