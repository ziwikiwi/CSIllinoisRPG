package csrpg.fighters;
import csrpg.moves.*;
/**
 * @author Ziwei Ba
 *
 */
public class Subversion extends Character{

	public Subversion() {
		name = "Subversion Version Control";
		description = "Version control used to submit MPs. Used in every class.";
		moveset[0] = new NoLateCredit();
		
		maxHealth = 100;
		health = 100;
		damageResistance = 1.10;
		
	}

}
