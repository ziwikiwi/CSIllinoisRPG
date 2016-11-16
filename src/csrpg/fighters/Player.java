// **************************************************************
// *		   
// *  Player
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Player component of the CS RPG
 * project. This class serves as a default implementation that
 * can be changed depending on how the game loop is run.
 */

package csrpg.fighters;

import csrpg.moves.*;
import csrpg.items.*;

public class Player extends Character {
	
	/*
	 * Default constructor. Member vars can be changed later.
	 */
	public Player() {
		name = "CS Freshman";
		description = "Fresh out of an elite high school in the " +
				"Chicago suburbs, the CS freshman is full of " +
				"optimisum, low on skills, and can't wait till " +
				"his 'guaranteed first summer Google internship'.";
		moveset[0] = new HelloWorld();
		moveset[1] = new Cram();
		moveset[2] = new Procrastinate();
		moveset[3] = new ProficiencyExam();
		inventory[0] = new Ramen();
		inventory[1] = new MilkTea();
		inventory[2] = new FreePizza();
		inventory[3] = new MealPlan();
	}
}
