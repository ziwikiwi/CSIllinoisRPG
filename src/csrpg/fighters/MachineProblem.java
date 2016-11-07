package csrpg.fighters;

import csrpg.moves.Cram;
import csrpg.moves.NoLateCredit;
import csrpg.moves.Procrastinate;
import csrpg.moves.SchrodingersGrade;

public class MachineProblem extends Character {

	/**
	 * @author Ziwei Ba
	 */
	public MachineProblem() {
		name = "MP";
		description = "Common enemy. Due every week, but harder than a lab.";
		moveset[0] = new Cram();
		moveset[1] = new Procrastinate();
		moveset[2] = new NoLateCredit();
		moveset[3] = new SchrodingersGrade();
		
		maxHealth = 50;
		health = 50;
		damageResistance = 0.75;
	}

}
