

package csrpg.fighters;
import csrpg.moves.*;
import csrpg.moves.StackOverflowError;
/**
 * @author Ziwei Ba
 *
 */
public class CS241VM extends Character{

	public CS241VM() {
		name = "CS 241 Virtual Machine";
		description = "Your first virtual machine! Ever since someone screwed up the EWS lab for three days with a fork bomb, the TAs created these with their own set of problems.";
		moveset[0] = new ForkBomb();
		moveset[1] = new StackOverflowError();
		moveset[2] = new Timeout();
		maxHealth = 150;
		health = 150;
		damageResistance = 1.35;
	}

}
