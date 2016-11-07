package csrpg.fighters;
import csrpg.moves.*;
/**
 * @author Ziwei Ba
 */
public class MallocMP extends Character{


	public MallocMP() {
		name = "Malloc MP";
		description = "The bane of 241. Ruthless grading and no sleep.";
		
		moveset[0] = new NoLateCredit();
		moveset[1] = new Segfault();
		moveset[2] = new ForkBomb();
		moveset[3] = new Timeout();
		
		maxHealth = 150;
		health = 150;
		damageResistance = 1.60;
	}

}
