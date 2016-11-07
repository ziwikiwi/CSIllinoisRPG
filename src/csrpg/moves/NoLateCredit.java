package csrpg.moves;

import csrpg.fighters.Character;

/**
 * @author Ziwei Ba
 *
 */
public class NoLateCredit extends Move {

	public NoLateCredit() {
		// TODO Auto-generated constructor stub
		name = "No Late Credit";
		description = "You can't finish your assignment in the next two hours" +
					"but there is no late credit, so you're pretty screwed. \n" + 
					"Target damage resistance down 10%, health 5%";
		
	}

	@Override
	public int effect(Character target, Character source) {
		target.setDamageResistance(target.getDamageResistance() * 0.90);
		target.setHealth((int)(target.getHealth() * 0.95));
		return target.getHealth();
	}

}
