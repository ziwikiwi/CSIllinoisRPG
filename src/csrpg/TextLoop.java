// **************************************************************
// *		   
// *  TextLoop
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the TextLoop component of the CS RPG
 * project. This is the text interface for CS RPG. It pits enemies
 * against the player until he dies.
 */

package csrpg;

import csrpg.fighters.*;
import csrpg.fighters.Character;
import csrpg.items.*;
import csrpg.moves.*;
import csrpg.store.Store;
import csrpg.tree.Tree;

import java.util.*;

public class TextLoop {

	public static void main(String[] args) {
		
		// Initialize utils
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		
		// Initialize tree
		Tree.init();
		
		// Initialize player
		Player player = new Player();
		System.out.println("You are: " + player.getName());
		System.out.println(player.getDescription() + "\n");
		
		// Repeat till player is dead
		while(player.getHealth() > 0) {
			
			// Get player node move choice and start battle
			Character enemy = getMoveChoice();
			Battle.startBattle(player, enemy, true);
			System.out.println();
			
			// Save stats
			player.saveStat();
			
			// Repeat till enemy is dead
			while(true) {
				
				// Print player/enemy info, move options
				printStats(player);
				printStats(enemy);
				System.out.println();
				printOptions(player);
				
				// Prompt for player move
				System.out.print("What would you like to do? (Input a number): ");
				while(!Battle.playerAction(s.nextInt() - 1, true)) {
					System.out.println("Invalid action.");
					System.out.print("What would you like to do? (Input a number): ");
				}
								
				// Check if enemy is dead
				if(enemy.getHealth() == 0) {
					System.out.println(enemy.getName() + " has been destroyed!\n");
					
					// Restore stats
					player.restoreStat();
					
					// Increment level
					if(player.levelIncrement()) {
						System.out.println(player.getName() + " leveled up to " + player.getLevel() + "!\n");
					}
					
					// Nullify enemy
					Tree.clearEnemy();
					
					// Claim rewards
					Tree.claimReward(player);
					Tree.claimCoins(player);
					
					// Let player buy items from store
					browseStore(player);
					
					break;
				}
				
				// Run status effects for enemy
				enemy.statEffect();
				
				// Enemy move
				Battle.enemyAction(true);
				
				// Check if player is dead
				if(player.getHealth() == 0) {
					System.out.println(player.getName() + " has been destroyed!\n");
					break;
				}
				
				// Run status effects for player
				player.statEffect();
				
				System.out.println("__________________________________________________________________________________________________________________________________________");
				
			}
		}
		
	}
	
	/*
	 * Gets player choice for node movement.
	 */
	private static Character getMoveChoice() {
		System.out.println("Input node move choice(0 for up, 1 for left child, 2 for right child): ");
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		boolean canMoveThatWay = Tree.traverse(choice);
		while(!canMoveThatWay || Tree.getEnemy() == null) {
			if(canMoveThatWay) {
				System.out.println("No enemy here. Move again!: ");
			} else {
				System.out.println("Invalid choice, try again: ");
			}
			choice = s.nextInt();
			canMoveThatWay = Tree.traverse(choice);
		}
		return Tree.getEnemy();
	}
	
	/*
	 * Allows player to purchase items from the store.
	 */
	private static void browseStore(Character player) {
		Item[] items = Store.getInventory();
		int[] price = Store.getPrices();
		System.out.println("Your wallet: $" + player.getCoins());
		for(int i = 0; i < items.length; i++) {
			System.out.println(i + ": " + items[i].getName() + " - $" + price[i]);
			System.out.println(items[i].getDescription());
		}
		System.out.println("Enter a number to purchase, or -1 to continue: ");
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		while(choice != -1) {
			int result = Store.purchase(choice, player);
			if(result == 0) {
				System.out.println("Bought 1 " + items[choice].getName() + " at $" + price[choice] + ". Wallet: $" + player.getCoins());
			} else if(result == -1) {
				System.out.println("Invalid selection.");
			} else if(result == -2) {
				System.out.println("Not enough space in inventory.");
			} else if(result == -3) {
				System.out.println("Not enough money.");
			}
			System.out.println("Enter a number: ");
			choice = s.nextInt();
		}
	}

	/*
	 * Helper method to print the status of a character.
	 */
	private static void printStats(Character chr) {
		System.out.println();
		System.out.println(chr.getName());
		System.out.print("HP: " + chr.getHealth() + "/" + chr.getMaxHealth() + "\t| ");
		double dispdmr = Math.floor(chr.getDamageResistance() * 100) / 100;
		System.out.print("DR: " + dispdmr + "\t| ");
		System.out.print("LVL: " + chr.getLevel() + "\t| " + chr.getLevelCounter() + " to next\t| ");
		System.out.print("ATT: " + chr.getATT() + " DEF: " + chr.getDEF() + " REC: " + chr.getREC() + " SPE:" + chr.getSPE() + "\n");
	}
	
	/*
	 * Helper method to print the options that a player has (moves and items)
	 */
	private static void printOptions(Character chr) {
		int option_no = 1;
		Move[] ms = chr.getMoveset();
		Item[] inv = chr.getInventory();
		System.out.println("[Moves]");
		System.out.println("0:\t" + "Do nothing");
		for(int i = 0; i < ms.length; i++) {
			if(ms[i] == null) break;
			System.out.print(Integer.toString(option_no) + ":\t" + ms[i].getName());
			for(int j = 0; j < 24 - ms[i].getName().length(); j++) System.out.print(" ");
			System.out.println(ms[i].getDescription());
			option_no++;
		}
		System.out.println("[Inventory]");
		for(int i = 0; i < inv.length; i++) {
			if(inv[i] == null) break;
			System.out.print(Integer.toString(option_no) + ":\t" + inv[i].getName());
			for(int j = 0; j < 24 - inv[i].getName().length(); j++) System.out.print(" ");
			System.out.println(inv[i].getDescription());
			option_no++;
		}
		
	}

}
