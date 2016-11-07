package csrpg.moves;

import csrpg.fighters.Character;

/**
 * @author Ziwei Ba
 *
 */
public class NullPointerException extends Move {

	public NullPointerException() {
		name = "Null Pointer Exception";
		description = "You're programming in Java in 125, and you"
				+ "run into your first error! Don't worry, this is"
				+ "easy to resolve and helps you for next time.\n" 
				+ "Target health reduced by 3%, damage resistance increased by 3%.";
				
	}

	@Override
	public int effect(Character target, Character source) {
		target.setDamageResistance(target.getDamageResistance() * 1.03);
		target.setHealth((int)(target.getHealth() * 0.97));
		return target.getHealth();
	}

}
