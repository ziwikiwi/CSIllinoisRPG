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
import java.util.*;

public abstract class Character {
	
	
	// ESSENTIAL INFO AND STATISTICS **********************************************
	
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
	
	
	// MODIFIER STATISTICS ********************************************************
	
	/*
	 * The attack stat of the character. Influences how much damage it can do.
	 */
	
	protected int ATT = 1;
	
	/*
	 * The defense stat of the character. Influences how much resistance it
	 * has to damage.
	 */
	
	protected int DEF = 1;
	
	/*
	 * The recovery stat of the character. Influences how much health it recovers
	 * per turn.
	 */
	
	protected int REC = 1;
	
	/*
	 * The speed stat of the character. Influences the probability that an
	 * attack misses.
	 */
	
	protected int SPE = 1;
	
	// LEVELING ******************************************************************
	
	/*
	 * The current level of the character.
	 */
	
	protected int level = 1;
	
	/*
	 * Progress towards next level for character.
	 */
	
	protected int levelCounter = 0;
	
	// STATUS EFFECTS ************************************************************
	
	/*
	 * Variables dictating the change in stats from turn to turn. 
	 */
	protected int deltaHealth = 0;
	protected int deltaATT = 0;
	protected int deltaDEF = 0;
	protected int deltaREC = 0;
	protected int deltaSPE = 0;
	protected double deltaDMR = 0.0;
	
	/*
	 * Variables containing the original values of stats.
	 */
	protected int origATT = ATT;
	protected int origDEF = DEF;
	protected int origREC = REC;
	protected int origSPE = SPE;
	protected double origDMR = damageResistance;
	
	// COINS *********************************************************************
	
	/*
	 * Coin purse of the character
	 */
	private int coins = 0;
	
	// COMPLEX STAT MODIFIERS ****************************************************
	
	/*
	 * Causes damage to the character. Health cannot go below zero.
	 * Returns the damage dealt to the character.
	 */
	public int damage(int dam, int att) {
		
		// Dodge the attack maybe?
		Random r = new Random();
		if(r.nextInt(50 + SPE) < SPE && r.nextBoolean()) return 0;
		double attemptedDam = (double)dam;
		System.out.println(attemptedDam);
		attemptedDam /= damageResistance;
		System.out.println(attemptedDam);
		attemptedDam /= 1.0 + (0.01 * (((double)DEF)/((double)att)));
		System.out.println(attemptedDam);
		double actualDam = Math.min(health, attemptedDam);
		System.out.println(actualDam);
		health -= actualDam;
		return (int)actualDam;
	}
	
	/*
	 * Heals the character. Health cannot go above maxHealth.
	 * Returns the amount character was healed.
	 */
	public int heal(int hea) {
		double attemptedHeal = (double)hea;
		attemptedHeal *= (1.0 + (((double)REC)*0.01));
		double actualHea = Math.min(maxHealth - health, attemptedHeal);
		health += actualHea;
		return (int)actualHea;
	}
	
	/*
	 * Induces a status effect in the character.
	 */
	public void induceEffect(int dH, int dATT, int dDEF, int dREC, int dSPE, double dDMR) {
		deltaHealth += dH;
		deltaATT += dATT;
		deltaDEF += dDEF;
		deltaREC += dREC;
		deltaSPE += dSPE;
		deltaDMR += dDMR;
	}
	
	/*
	 * Runs status effect changes.
	 */
	public void statEffect() {
		health = Math.max(health - deltaHealth, 0);
		ATT = Math.max(ATT - deltaATT, 0);
		DEF = Math.max(DEF - deltaDEF, 0);
		REC = Math.max(REC - deltaREC, 0);
		SPE = Math.max(SPE - deltaSPE, 0);
		damageResistance = Math.max(damageResistance - deltaDMR, 0.25);
	}
	
	/*
	 * Saves original stats.
	 */
	public void saveStat() {
		origATT = ATT;
		origDEF = DEF;
		origREC = REC;
		origSPE = SPE;
		origDMR = damageResistance;
	}
	
	/*
	 * Restores original stats and clears all status effects.
	 */
	public void restoreStat() {
		ATT = origATT;
		DEF = origDEF;
		REC = origREC;
		SPE = origSPE;
		damageResistance = origDMR;
		
		deltaHealth = 0;
		deltaATT = 0;
		deltaDEF = 0;
		deltaREC = 0;
		deltaSPE = 0;
		deltaDMR = 0.0;
	}
	
	/*
	 * Increments level counter. When it reaches the threshold, reset to 0
	 * and increment modifier stats. Returns true if leveled.
	 */
	
	public boolean levelIncrement() {
		levelCounter++;
		if(levelCounter >= level) {
			levelCounter = 0;
			level++;
			ATT++;
			DEF++;
			REC++;
			SPE++;
			return true;
		}
		return false;
	}
	
	// GETTERS AND SETTERS
	
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
	 * Returns the attack of the character.
	 */
	public int getATT() {
		return ATT;
	}
	
	/*
	 * Returns the defense of the character.
	 */
	public int getDEF() {
		return DEF;
	}
	
	/*
	 * Returns the recovery of the character.
	 */
	public int getREC() {
		return REC;
	}
	
	/*
	 * Returns the speed of the character.
	 */
	public int getSPE() {
		return SPE;
	}
	
	/*
	 * Returns the level of the character.
	 */
	public int getLevel() {
		return level;
	}
	
	/*
	 * Returns the level progress counter of the character.
	 */
	public int getLevelCounter() {
		return levelCounter;
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

	/*
	 * Returns the coin purse of the character
	 */
	public int getCoins() {
		return coins;
	}

	/*
	 * Modifies the coin purse of the character
	 */
	public void setCoins(int coins) {
		this.coins = coins;
	}
}
