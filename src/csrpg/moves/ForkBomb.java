package csrpg.moves;

import csrpg.fighters.Character;

/**
 * @author Ziwei Ba
 *
 */
public class ForkBomb extends Move{

	public ForkBomb() {
		// TODO Auto-generated constructor stub
		name = "ForkBomb";
		description = "Created too many processes and broke the VM. \n" +
						"Reduces target health by 10% and source health by 5%";
	}
	

	

	@Override
	public int effect(Character target, Character source) {
		// TODO Auto-generated method stub
		target.setHealth((int)((double)target.getHealth() * 0.90));
		source.setHealth((int)((double)source.getHealth() * 0.95));
		return target.getHealth();
	}

}
