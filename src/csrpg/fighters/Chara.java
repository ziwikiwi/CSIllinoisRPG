/************************************
 * @author Ziwei Ba
 */

package csrpg.fighters;

import csrpg.moves.*;

public class Chara extends Character {
	/**
	 * The third enemy at UIUC
	 * CS225 Gradebook
	 */
	public Chara() {
		name = "Chara Gradebook";
		description = "The 225 gradebook, which never updates, and the slider bars" 
					+ " only serve to create more anxiety.";
		moveset[0] = new NoLateCredit();
		moveset[1] = new SchrodingersGrade();
		maxHealth = 25;
		health = 25;
		damageResistance = 1.5;
	}

}
