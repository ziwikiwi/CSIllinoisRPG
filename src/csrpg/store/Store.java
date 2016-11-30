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
import csrpg.moves.*;
import csrpg.moves.NullPointerException;
import csrpg.moves.StackOverflowError;
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
	private static int[] prices = {5, 10, 20, 50};
	
	/*
	 * Purchaseable moves.
	 */
	private static Move[] moveinv = {new ForkBomb(), new NullPointerException(), new Pepe(), new StackOverflowError()};
	
	/*
	 * Move price.
	 */
	private static int moveprice = 100;
	
	/*
	 * Attempts to purchase an item. Returns true if successful,
	 * returns false if not enough money, not enough space, or
	 * invalid input.
	 */
	public static int purchase(int selection, Character player) {
		if(selection < 0 || selection >= inventory.length + moveinv.length) {
			// Invalid selection
			return -1;
		}
		int space = -1;
		Item[] inv = player.getInventory();
		for(int i = 0; i < inv.length; i++) {
			if(inv[i] == null) {
				space = i;
				break;
			}
		}
		if(space == -1) {
			// No space
			return -2;
		}
		if(selection < inventory.length && prices[selection] > player.getCoins()) {
			// Not enough money
			return -3;
		} else if(moveprice > player.getCoins()) {
			return -3;
		}
		if(selection < inventory.length) {
			inv[space] = inventory[selection];
			player.setCoins(player.getCoins() - prices[selection]);
			return 0;
		} else {
			player.getMoveset()[3] = moveinv[selection - moveinv.length];
			player.setCoins(player.getCoins() - moveprice);
			return 1;
		}
		
	}
	
	/*
	 * Returns store inventory.
	 */
	public static Item[] getInventory() {
		return inventory;
	}
	
	/*
	 * Returns store prices
	 */
	public static int[] getPrices() {
		return prices;
	}
	
	/*
	 * Returns store move inventory
	 */
	public static Move[] getMoveInventory() {
		return moveinv;
	}
	
	/*
	 * Return move price
	 */
	public static int getMovePrice() {
		return moveprice;
	}
}