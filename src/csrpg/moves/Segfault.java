package csrpg.moves;

import csrpg.fighters.Character;

/**
 * @author Ziwei Ba
 *
 */
public class Segfault extends Move {

	public Segfault() {
		name = "Segfault";
		description = "Segmentation Fault: Core Dumped "
					+ "The dreaded segfault. You will never stop getting these, so better prepare yourself. \n"
					+ "Target health down by 7%, damage resistance up by 5%";
		
	}

	@Override
	public int effect(Character target, Character source) {
		target.setDamageResistance(target.getDamageResistance() * 1.05);
		target.setHealth((int)(target.getHealth() * 0.93));
		return target.getHealth();
	}

}
