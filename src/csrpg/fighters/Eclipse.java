package csrpg.fighters;
import csrpg.moves.*;
import csrpg.moves.NullPointerException;
import csrpg.moves.StackOverflowError;
/**
 * @author Ziwei Ba
 *
 */
public class Eclipse extends Character{

	public Eclipse() {
		name = "Eclipse IDE";
		description = "Your first development environment in Java! Not too hard, but as a beginning programmer it might throw you some loops.";
		moveset[0] = new NullPointerException();
		moveset[1] = new HelloWorld();
		moveset[2] = new StackOverflowError();
		maxHealth = 15;
		health = 15;
		damageResistance = 0.50;
	}

}
