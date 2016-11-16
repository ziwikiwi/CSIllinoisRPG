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
		Treenode head = new Treenode(null, new FinalProject242(), new MealPlan(), 100);
		Treenode node1 = new Treenode(head, new MastersApplication(), new NewLaptop(), 50);
		Treenode node2 = new Treenode(head, new Memes(), new HomeworkDrop(), 50);
		Treenode node11 = new Treenode(node1, new TechnicalInterview(), new Espresso(), 25);
		Treenode node12 = new Treenode(node1, new CS241VM(), new Ramen(), 25);
		Treenode node21 = new Treenode(node2, new SteveHerzog(), new HealthInsuranceWaiver(), 25);
		Treenode node22 = new Treenode(node2, new LennyPitt(), new Suit(), 25);
		Treenode node111 = new Treenode(node11, new TechnicalInterview(), new CareerFairTShirt(), 12);
		Treenode node112 = new Treenode(node11, new CS241VM(), new MilkTea(), 12);
		Treenode node121 = new Treenode(node12, new SteveHerzog(), new StartupHoodie(), 12);
		Treenode node122 = new Treenode(node12, new LennyPitt(), new FreePizza(), 12);
		Treenode node211 = new Treenode(node21, new AllNighter(), new Espresso(), 12);
		Treenode node212 = new Treenode(node21, new ErhanKudeki(), new MilkTea(), 12);
		Treenode node221 = new Treenode(node22, new MallocMP(), new HealthInsuranceWaiver(), 12);
		Treenode node222 = new Treenode(node22, new Waitlist(), new Ramen(), 12);
		Treenode node1111 = new Treenode(node111, new Chara(), new Fedora(), 6);
		Treenode node1112 = new Treenode(node111, new CodingChallenge(), new StartupHoodie(), 6);
		Treenode node1121 = new Treenode(node112, new CourseCatalog(), new CareerFairTShirt(), 6);
		Treenode node1122 = new Treenode(node112, new Eclipse(), new Espresso(), 6);
		Treenode node1211 = new Treenode(node121, new GRE(), new FreePizza(), 6);
		Treenode node1212 = new Treenode(node121, new HackerRank(), new MilkTea(), 6);
		Treenode node1221 = new Treenode(node122, new Lab(), new HealthInsuranceWaiver(), 6);
		Treenode node1222 = new Treenode(node122, new MachineProblem(), new HomeworkDrop(), 6);
		location = node1121;
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
}
