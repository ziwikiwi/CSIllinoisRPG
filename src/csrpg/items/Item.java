// **************************************************************
// *		   
// *  Item
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Item component of the CS RPG
 * project. This class serves as an abstract class that all items
 * are based on.
 */

package csrpg.items;

import csrpg.fighters.Character;

public abstract class Item {
	
	/*
	 * Name of the item.
	 */
	protected String name;
	
	/*
	 * Description of the item.
	 */
	protected String description;
	
	/*
	 * The effect of the item. Must be implemented on a
	 * per-item basis. Returns an int whose meaning varies
	 * by context.
	 */
	public abstract int effect(Character target);
	
	/*
	 * Returns the name of the item.
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Returns the description of the item.
	 */
	public String getDescription() {
		return description;
	}
	
	/*
	 * Modifies the name of the item.
	 */
	public void setName(String nam) {
		name = nam;
	}
	
	/*
	 * Modifies the description of the item.
	 */
	public void setDescription(String des) {
		description = des;
	}
}
