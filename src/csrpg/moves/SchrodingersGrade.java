package csrpg.moves;

import csrpg.fighters.Character;

/**
 * @author Ziwei Ba
 *
 */
public class SchrodingersGrade extends Move {

	public SchrodingersGrade() {
		name = "Schrodinger's Grade";
		description = "What do you have in this class? Grades haven't updated for two months." +
					"\n Target damage resistance down 5%";
	}

	@Override
	public int effect(Character target, Character source) {
		target.setDamageResistance(target.getDamageResistance() * 0.95);
		return (int)target.getDamageResistance();
	}

}
