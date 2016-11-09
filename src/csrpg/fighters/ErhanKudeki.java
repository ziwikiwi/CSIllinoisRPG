// **************************************************************
// *		   
// *  ErhanKudeki
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the ErhanKudeki component of the
 * project.
 */

package csrpg.fighters;
import csrpg.moves.*;
import csrpg.moves.NullPointerException;
import csrpg.moves.StackOverflowError;

public class ErhanKudeki extends Character {

	public ErhanKudeki() {
		name = "Erhan Kudeki";
		description = "What are you doing in an ECE course? You're a CS major!";
		
		moveset[0] = new NoLateCredit();
		moveset[1] = new NullPointerException();
		moveset[2] = new Segfault();
		moveset[3] = new StackOverflowError();
		
		maxHealth = 70;
		health = 70;
	}

}