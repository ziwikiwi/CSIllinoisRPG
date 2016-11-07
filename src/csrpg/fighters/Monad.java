package csrpg.fighters;
import csrpg.moves.*;

/*
 * The second enemy you see at UIUC
 * CS225 Autograder
 */
/**
 * @author Ziwei Ba
 *
 */
public class Monad extends Character {
	

	public Monad() {
		name = "Monad";
		description = "CS225 autograder. Not very specific, but at least what you see is what you get.";
		
		moveset[0] = new SchrodingersGrade();
		moveset[1] = new NoLateCredit();
		moveset[2] = new Segfault();
		
		maxHealth = 90;
		health = 90;
		damageResistance = 1.0;
	}

}
