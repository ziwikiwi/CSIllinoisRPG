// **************************************************************
// *		   
// *  Store
// *		   
// *  CS RPG Project
// *		   
// *  CS 242 - Fall 2016
// *
// *  @author nchan10
// *		   
// **************************************************************

/**
 * Implementation of the Store component of the CS RPG
 * project. This class serves to allow the player to purchase
 * items in between battles.
 */

package csrpg.store;
import csrpg.items.*;
import csrpg.fighters.*;
import csrpg.fighters.Character;

public class Store {
	
	/*
	 * Items the store offers.
	 */
	private static Item[] inventory = {new Ramen(), new MilkTea(), new FreePizza(), new MealPlan()};
	
	/*
	 * Prices of the items.
	 */
	private static int[] prices = {10, 20, 50, 100};
	
	/*
	 * Attempts to purchase an item. Returns true if successful,
	 * returns false if not enough money, not enough space, or
	 * invalid input.
	 */
	public static int purchase(int selection, Character player) {
		if(selection < 0 || selection >= inventory.length) {
			// Invalid selection
			return -1;
		}
		int space = -1;
		Item[] inv = player.getInventory();
		for(int i = 0; i < inventory.length; i++) {
			if(inv[i] == null) {
				space = i;
				break;
			}
		}
		if(space == -1) {
			// No space
			return -2;
		}
		if(prices[selection] > player.getCoins()) {
			// Not enough money
			return -3;
		}
		inv[space] = inventory[selection];
		return 0;
	}
}