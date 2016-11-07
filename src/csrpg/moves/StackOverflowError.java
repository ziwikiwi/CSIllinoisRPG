package csrpg.moves;

import csrpg.fighters.Character;

/**
 * @author Ziwei Ba
 *
 */
public class StackOverflowError extends Move {

	public StackOverflowError() {
		name = "Stack Overflow Error";
		description = "Uh oh! You just made your program run out of memory! "
					+ "Better check your recursion! \n"
					+ "Target health down 5%, source health down 3%";
	}

	@Override
	public int effect(Character target, Character source) {
		target.setHealth((int)((double)target.getHealth() * 0.95));
		source.setHealth((int)((double)source.getHealth() * 0.97));
		return target.getHealth();
	}

}
