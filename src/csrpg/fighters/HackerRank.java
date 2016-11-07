package csrpg.fighters;
import csrpg.moves.*;
import csrpg.moves.NullPointerException;

public class HackerRank extends Character{

	/**
	 * @author Ziwei Ba
	 */
	public HackerRank() {
		name = "HackerRank";
		description = "You got your first job interview! Just kidding- it's a Hackerrank, which is ten times worse.";
		moveset[0] = new NullPointerException();
		moveset[1] = new Timeout();
		moveset[2] = new Procrastinate();
		
		maxHealth = 80;
		health = 80;
		damageResistance = 1.15;
	}

}
