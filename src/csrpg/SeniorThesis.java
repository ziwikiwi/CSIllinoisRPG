// **************************************************************
// *		   
// *  SeniorThesis
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the SeniorThesis component of the
 * project.
 */

package csrpg.fighters;
import csrpg.moves.*;

public class SeniorThesis extends Character {

	public SeniorThesis() {
		name = "Senior Thesis";
		description = "Regrettably, this must be written in English and not Python.";
		
		moveset[0] = new NoLateCredit();
		moveset[1] = new Procrastinate();
		moveset[2] = new SchrodingersGrade();
		
		maxHealth = 60;
		health = 60;
	}

}