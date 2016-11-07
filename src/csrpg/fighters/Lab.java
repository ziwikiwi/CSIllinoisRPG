package csrpg.fighters;
import csrpg.moves.*;

/**
 * @author Ziwei Ba
 *
 */
public class Lab extends Character{

	public Lab() {
		name = "Lab";
		description = "Common enemy. Due every week.";
		moveset[0] = new Cram();
		moveset[1] = new Procrastinate();
		moveset[2] = new NoLateCredit();
		
		maxHealth = 25;
		health = 25;
		damageResistance = 0.45;
	}

}
