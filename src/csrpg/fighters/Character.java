// **************************************************************
// *		   
// *  Character
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Character component of the CS RPG
 * project. This class serves as an abstract class that both the
 * player and the enemies are based on.
 */

package csrpg.fighters;

import csrpg.moves.*;
import csrpg.items.*;
import java.math.*;

public abstract class Character {
	
	/*
	 * The name of the character.
	 */
	protected String name;
	
	/*
	 * The description of the character.
	 */
	protected String description;
	
	/*
	 * The current health of the character.
	 */
	protected int health = 100;
	
	/*
	 * The maximum health of the character.
	 */
	protected int maxHealth = 100;
	
	/*
	 * The damage resistance of the Character. Reduces damage by
	 * the given factor.
	 */
	protected double damageResistance = 1.0;
	
	/*
	 * The possible moves that the character can use. Can have
	 * 4 at most.
	 */
	protected Move[] moveset = new Move[4];
	
	/*
	 * The inventory of the character. Can have 10 items at most.
	 */
	
	protected Item[] inventory = new Item[10];
	
	/*
	 * Causes damage to the character. Health cannot go below zero.
	 * Returns the damage dealt to the character.
	 */
	public int damage(int dam) {
		int actualDam = Math.min(health, (int)((double)dam / damageResistance));
		health -= actualDam;
		return actualDam;
	}
	
	/*
	 * Heals the character. Health cannot go above maxHealth.
	 * Returns the amount character was healed.
	 */
	public int heal(int hea) {
		int actualHea = Math.min(hea, maxHealth - health);
		health += actualHea;
		return actualHea;
	}
	
	/*
	 * Returns the name of the character.
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Returns the description of the character.
	 */
	public String getDescription() {
		return description;
	}
	
	/*
	 * Returns the health of the character.
	 */
	public int getHealth() {
		return health;
	}
	
	/*
	 * Returns the max health of the character.
	 */
	public int getMaxHealth() {
		return maxHealth;
	}
	
	/*
	 * Returns the damage resistance of the character.
	 */
	public double getDamageResistance() {
		return damageResistance;
	}
	
	/*
	 * Returns the moveset of the character.
	 */
	public Move[] getMoveset() {
		return moveset;
	}
	
	/*
	 * Returns the inventory of the character.
	 */
	public Item[] getInventory() {
		return inventory;
	}
	
	/*
	 * Modifies the name of the character.
	 */
	public void setName(String nam) {
		name = nam;
	}
	
	/*
	 * Modifies the description of the character.
	 */
	public void setDescription(String des) {
		description = des;
	}
	
	/*
	 * Modifies the health of the character.
	 */
	public void setHealth(int hea) {
		health = hea;
	}
	
	/*
	 * Modifies the max health of the character.
	 */
	public void setMaxHealth(int mhe) {
		maxHealth = mhe;
	}
	
	/*
	 * Returns the damage resistance of the character.
	 */
	public void setDamageResistance(double dmr) {
		damageResistance = dmr;
	}
}
