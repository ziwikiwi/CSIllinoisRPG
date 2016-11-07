// **************************************************************
// *		   
// *  Move
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Move component of the CS RPG
 * project. This class serves as an abstract class that all moves
 * are based on.
 */

package csrpg.moves;

import csrpg.fighters.Character;

public abstract class Move {
	
	/*
	 * Name of the move.
	 */
	protected String name;
	
	/*
	 * Description of the move.
	 */
	protected String description;
	
	/*
	 * The effect of the move. Must be implemented on a
	 * per-move basis. Returns an int whose meaning varies
	 * by context.
	 */
	public abstract int effect(Character target, Character source);
	
	/*
	 * Returns the name of the move.
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Returns the description of the move.
	 */
	public String getDescription() {
		return description;
	}
	
	/*
	 * Modifies the name of the move.
	 */
	public void setName(String nam) {
		name = nam;
	}
	
	/*
	 * Modifies the description of the move.
	 */
	public void setDescription(String des) {
		description = des;
	}
}
