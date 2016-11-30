// **************************************************************
// *		   
// *  Battle
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Battle component of the CS RPG
 * project. This class serves as the framework by which a player
 * can fight an enemy.
 */

package csrpg;

import csrpg.fighters.*;
import csrpg.fighters.Character;
import csrpg.items.*;
import csrpg.moves.*;
import java.util.Random;

public class Battle {
	
	/*
	 * Player instance.
	 */
	private static Player player = null;
	
	/*
	 * Enemy instance.
	 */
	private static Character enemy = null;
	
	/*
	 * Array counting how many times each move has been used.
	 */
	private static int[] moveUses = new int[4];
	
	/*
	 * Starts the battle, with a new enemy if required.
	 */
	public static void startBattle(Player pla, Character ene, boolean printText) {
		player = pla;
		enemy = ene;
		if(printText) {
			System.out.println();
			System.out.println(ene.getName() + " appeared!");
			System.out.println(ene.getDescription());
		}
	}
	
	/*
	 * Chooses an action for the player to perform. n = 1-4 denotes
	 * action, n > 4 denotes the (n-4)th item. Returns true if the
	 * action was successful, false otherwise.
	 */
	public static boolean playerAction(int n, boolean printText) {
		
		// Do nothing
		if(n == -1) return true;
		
		// Calculate what each value of n refers to
		Move[] ms = player.getMoveset();
		int numMoves = 0;
		for(int i = 0; i < ms.length; i++) {
			if(ms[i] == null) break;
			else numMoves++;
		}
		Item[] inv = player.getInventory();
		int numItems = 0;
		for(int i = 0; i < inv.length; i++) {
			if(inv[i] == null) break;
			else numItems++;
		}
				
		if(n >= numMoves && n < numMoves + numItems) {
			
			// Use item on self and remove from inventory
			inv[n - numMoves].effect(player);
			if(printText) {
				System.out.println();
				System.out.println(player.getName() + " used " + inv[n - numMoves].getName() + "!");
			}
			for(int i = n - numMoves; i < inv.length - 1; i++) {
				inv[i] = inv[i + 1];
			}
			inv[inv.length - 1] = null;
			return true;
			
		} else if(n >= 0 && n < numMoves) {
			
			// Use move on enemy
			ms[n].effect(enemy, player);
			if(printText) {
				System.out.println();
				System.out.println(player.getName() + " used " + ms[n].getName() + "!");
			}
			return true;
			
		} else 
			// Invalid move
			return false;
	}
	
	/*
	 * Makes the enemy turn. Chooses randomly from its moveset/inventory.
	 */
	public static void enemyAction(boolean printText) {
		
		// Calculate what each n refers to
		Move[] ms = enemy.getMoveset();
		int numMoves = 0;
		for(int i = 0; i < ms.length; i++) {
			if(ms[i] == null) break;
			else numMoves++;
		}
		Item[] inv = enemy.getInventory();
		int numItems = 0;
		for(int i = 0; i < inv.length; i++) {
			if(inv[i] == null) break;
			else numItems++;
		}
		
		// Do nothing if there's no options
		if(numMoves + numItems == 0) return;
		
		// Pick randomly from possible actions
		Random r = new Random();
		int n = r.nextInt(numMoves + numItems);
		
		if(n >= numMoves && n < numMoves + numItems) {
			
			// Use item on self (enemy) and discard
			inv[n - numMoves].effect(enemy);
			if(printText) {
				System.out.println();
				System.out.println(enemy.getName() + " used " + inv[n - numMoves].getName() + "!");
				System.out.println("\t" + inv[n - numMoves].getDescription());
			}
			inv[n - numMoves] = null;
			
		} else if(n >= 0) {
			
			// Select move while avoiding moves that have been used too much.
			double[] probabilities = new double[4];
			for(int i = 0; i < 4; i++) {
				probabilities[i] = Math.pow(2, -moveUses[i]);
			}
			double[] prob_cutoffs = new double[4];
			prob_cutoffs[0] = probabilities[0];
			for(int i = 1; i < 4; i++) {
				prob_cutoffs[i] = prob_cutoffs[i-1] + probabilities[i];
			}
			double rand = prob_cutoffs[3] * r.nextDouble();
			for(n = 0; n < 4; n++) {
				if(n < 3 && ms[n+1] == null) {
					break;
				}
				if(prob_cutoffs[n] >= rand) {
					break;
				}
			}
			
			// Use move on player
			ms[n].effect(player, enemy);
			moveUses[n]++;
			if(printText) {
				System.out.println();
				System.out.println(enemy.getName() + " used " + ms[n].getName() + "!");
				System.out.println("\t" + ms[n].getDescription());
			}
			
		}
		
	}
	
	/*
	 * Resets moveUses, i.e. when a new enemy spawns.
	 */
	public static void resetMoves() {
		moveUses = new int[4];
	}
}
