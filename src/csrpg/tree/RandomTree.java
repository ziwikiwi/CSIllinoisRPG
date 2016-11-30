// **************************************************************
// *		   
// *  RandomTree
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
 * project. This class serves to randomly generate a tree.
 */

package csrpg.tree;

import java.util.Random;
import csrpg.fighters.*;
import csrpg.fighters.Character;
import csrpg.items.*;


public class RandomTree {
	
	/*
	 * Generates a node with random enemy, item, and coin reward, as well
	 * as a certain chance of that node having a child or not (or two).
	 */
	public static Treenode generateNode(Treenode parent, Random r, int depth, int maxCoins) {
		
		// Hit max tree height
		if(depth < 0) return null;
		
		// Pick enemy for node
		Character enemy;
		int selection = r.nextInt(22);
		if(selection == 0) enemy = new AllNighter();
		else if(selection == 1) enemy = new Chara();
		else if(selection == 2) enemy = new CodingChallenge();
		else if(selection == 3) enemy = new CourseCatalog();
		else if(selection == 4) enemy = new CS241VM();
		else if(selection == 5) enemy = new Eclipse();
		else if(selection == 6) enemy = new ErhanKudeki();
		else if(selection == 7) enemy = new FinalProject242();
		else if(selection == 8) enemy = new GRE();
		else if(selection == 9) enemy = new HackerRank();
		else if(selection == 10) enemy = new Lab();
		else if(selection == 11) enemy = new LennyPitt();
		else if(selection == 12) enemy = new MachineProblem();
		else if(selection == 13) enemy = new MallocMP();
		else if(selection == 14) enemy = new MastersApplication();
		else if(selection == 15) enemy = new Memes();
		else if(selection == 16) enemy = new Monad();
		else if(selection == 17) enemy = new SeniorThesis();
		else if(selection == 18) enemy = new SteveHerzog();
		else if(selection == 19) enemy = new Subversion();
		else if(selection == 20) enemy = new TechnicalInterview();
		else enemy = new Waitlist();
		
		// Pick item reward for node
		Item reward;
		selection = r.nextInt(12);
		if(selection == 0) reward = new CareerFairTShirt();
		else if(selection == 1) reward = new Espresso();
		else if(selection == 2) reward = new Fedora();
		else if(selection == 3) reward = new FreePizza();
		else if(selection == 4) reward = new HealthInsuranceWaiver();
		else if(selection == 5) reward = new HomeworkDrop();
		else if(selection == 6) reward = new MealPlan();
		else if(selection == 7) reward = new MilkTea();
		else if(selection == 8) reward = new NewLaptop();
		else if(selection == 9) reward = new Ramen();
		else if(selection == 10) reward = new StartupHoodie();
		else reward = new Suit();
		
		// Pick coin reward for node
		int coins = r.nextInt(maxCoins + 1);
		
		// Create node
		Treenode node = new Treenode(parent, enemy, reward, coins);
		
		// Decide whether to create children
		if(r.nextInt(depth * depth) != 0) generateNode(node, r, depth - 1, maxCoins);
		if(r.nextInt(depth * depth) != 0) generateNode(node, r, depth - 1, maxCoins);
		
		return node;
	}
}
