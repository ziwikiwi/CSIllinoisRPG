package csrpg.moves;

import csrpg.fighters.Character;

/**
 * @author Ziwei Ba
 *
 */
public class Timeout extends Move {

	public Timeout() {
		name = "Time Out";
		description = "Better check the big O runtime of your program! The autograder is impatient with you. \n"
				+	"Target health down 5%, damage resistance down 5%";
	}

	@Override
	public int effect(Character target, Character source) {
		target.setDamageResistance(target.getDamageResistance() * 0.95);
		target.setHealth((int)(target.getHealth()*0.95));
		return target.getHealth();
	}

}
