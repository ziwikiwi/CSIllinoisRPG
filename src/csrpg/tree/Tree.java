// **************************************************************
// *		   
// *  Tree
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Tree component of the CS RPG
 * project. This class serves to handle the structure and
 * functions of the tree.
 */

package csrpg.tree;
import java.util.Random;
import java.util.Scanner;

import csrpg.fighters.*;
import csrpg.fighters.Character;
import csrpg.items.*;

public class Tree{
	
	/*
	 * Current location of the player
	 */
	protected static Treenode location = null;
	
	/*
	 * Sets up the structure of the tree.
	 */
	public static void init() {
		
		 // Prompt player for random seed, in lieu of saving
		System.out.println("Input a random integer seed: ");
		Scanner s = new Scanner(System.in);
		int seed = s.nextInt();
		location = RandomTree.generateNode(null, new Random(seed), 6, 100);
	}
	
	/*
	 * Moves the player up or down in the tree. Returns the 
	 * enemy on that node.
	 * 0 = parent
	 * 1 = child1
	 * 2 = child2
	 */
	public static boolean traverse(int move) {
		if(move == 0 && location.parent != null) {
			location = location.parent;
		} else if(move == 1 && location.child1 != null) {
			location = location.child1;
		} else if(move == 2 && location.child2 != null) {
			location = location.child2;
		} else {
			return false;
		}
		location.traversed = true;
		return true;
	}
	
	/*
	 * Returns the enemy on node.
	 */
	public static Character getEnemy() {
		return location.enemy;
	}
	
	/*
	 * Claims the reward on a node, but only if the enemy
	 * has been destroyed. Returns false if enemy is not
	 * destroyed or player inventory is full.
	 */
	public static boolean claimReward(Character player) {
		if(location.enemy == null) {
			Item[] inv = player.getInventory();
			for(int i = 0; i < 10; i++) {
				if(inv[i] == null) {
					inv[i] = location.reward;
					location.reward = null;
					return true;
				}
			}
		}
		return false;
	}
	
	/*
	 * Claims the coins on a node, but only if the enemy
	 * has been destroyed. Returns false if enemy is not
	 * destroyed.
	 */
	public static boolean claimCoins(Character player) {
		if(location.enemy == null) {
			player.setCoins(player.getCoins() + location.coins);
			location.coins = 0;
			return true;
		}
		return false;
	}
	
	/*
	 * Clears enemy from node.
	 */
	public static void clearEnemy() {
		location.enemy = null;
	}
}
