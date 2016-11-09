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
import java.util.*;

public class TextLoop {

	public static void main(String[] args) {
		
		// Initialize utils
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		
		// List of enemies we have so far
		Character[] enemies = {new AllNighter(), new Chara(), new CodingChallenge(), new CourseCatalog(),
				new CS241VM(), new Eclipse(), new ErhanKudeki(), new FinalProject242(), new GRE(), new HackerRank(),
				new Lab(), new LennyPitt(), new MachineProblem(), new MallocMP(), new MastersApplication(), new Memes(),
				new Monad(), new SeniorThesis(), new SteveHerzog(), new Subversion(), new TechnicalInterview(), new Waitlist()};
		
		// Initialize player
		Player player = new Player();
		System.out.println("You are: " + player.getName());
		System.out.println(player.getDescription() + "\n");
		
		// Repeat till player is dead
		while(player.getHealth() > 0) {
			
			// Choose random enemy and start battle
			Character enemy = enemies[r.nextInt(enemies.length)];
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
			}
		}
		
	}
	
	
	/*
	 * Helper method to print the status of a character.
	 */
	private static void printStats(Character chr) {
		System.out.print(chr.getName() + " | ");
		System.out.print("HP: " + chr.getHealth() + "/" + chr.getMaxHealth() + " ");
		System.out.print("DR: " + chr.getDamageResistance() + "\n");
		System.out.print("LVL: " + chr.getLevel() + " | " + chr.getLevelCounter() + " to next | ");
		System.out.print("ATT: " + chr.getATT() + " DEF: " + chr.getDEF());
		System.out.print(" REC: " + chr.getREC() + " SPE:" + chr.getSPE() + "\n");
	}
	
	/*
	 * Helper method to print the options that a player has (moves and items)
	 */
	private static void printOptions(Character chr) {
		int option_no = 1;
		Move[] ms = chr.getMoveset();
		Item[] inv = chr.getInventory();
		System.out.println("[Moves]\n");
		System.out.println("0: Do nothing\n");
		for(int i = 0; i < ms.length; i++) {
			if(ms[i] == null) break;
			System.out.println(Integer.toString(option_no) + ":\t" + ms[i].getName());
			System.out.println(ms[i].getDescription() + "\n");
			option_no++;
		}
		System.out.println("[Inventory]\n");
		for(int i = 0; i < inv.length; i++) {
			if(inv[i] == null) break;
			System.out.println(Integer.toString(option_no) + ":\t" + inv[i].getName());
			System.out.println(inv[i].getDescription() + "\n");
			option_no++;
		}
		
	}

}
