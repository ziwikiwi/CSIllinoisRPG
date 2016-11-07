package csrpg.moves;

import csrpg.fighters.Character;

/**
 * @author Ziwei Ba
 *
 */
public class WrongOutput extends Move {

	public WrongOutput() {
		name = "Wrong Output";
		description = "You fixed all your errors, everything compiles, no segfaults... "
					+ "but you still don't pass the autograder! \n"
					+ "Target health reduced by 7%, damage resistance reduced by 3%";
	}

	@Override
	public int effect(Character target, Character source) {
		target.setDamageResistance(target.getDamageResistance() * 0.97);
		target.setHealth((int)(target.getHealth()*0.93));
		return target.getHealth();
	}

}
