// **************************************************************
// *		   
// *  Treenode
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Treenode component of the CS RPG
 * project. This class serves to represent the nodes in a tree
 * that permits player traversal.
 */

package csrpg.tree;
import csrpg.fighters.*;
import csrpg.fighters.Character;
import csrpg.items.*;

public class Treenode {
	
	/*
	 * Parent of the node.
	 */
	public Treenode parent = null;
	
	/*
	 * Children of the node.
	 */
	public Treenode child1 = null;
	public Treenode child2 = null;
	
	/*
	 * Indicates whether or not the node has been traversed.
	 */
	public boolean traversed = false;
	
	/*
	 * Enemy situated on the node.
	 */
	public Character enemy = null;
	
	/*
	 * Reward situated on the node.
	 */
	public Item reward = null;
	
	/*
	 * Coin reward situated on the node.
	 */
	public int coins = 0;
	
	/*
	 * Default constructor.
	 */
	public Treenode() {
		
	}
	
	/*
	 * Parent/enemy/reward/coins specifying constructor
	 */
	public Treenode(Treenode parent, Character enemy, Item reward, int coins) {
		this.parent = parent;
		if(this.parent != null) {
			if(parent.child1 == null || parent.child2 != null) {
				parent.child1 = this;
			} else {
				parent.child2 = this;
			}
		}
		this.enemy = enemy;
		this.reward = reward;
		this.coins = coins;
	}
	
	
}
