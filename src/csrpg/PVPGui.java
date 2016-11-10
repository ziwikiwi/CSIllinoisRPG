package csrpg;

import java.awt.BorderLayout;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import csrpg.fighters.AllNighter;
import csrpg.fighters.CS241VM;
import csrpg.fighters.Chara;
import csrpg.fighters.Character;
import csrpg.fighters.CodingChallenge;
import csrpg.fighters.CourseCatalog;
import csrpg.fighters.Eclipse;
import csrpg.fighters.ErhanKudeki;
import csrpg.fighters.FinalProject242;
import csrpg.fighters.GRE;
import csrpg.fighters.HackerRank;
import csrpg.fighters.Lab;
import csrpg.fighters.LennyPitt;
import csrpg.fighters.MachineProblem;
import csrpg.fighters.MallocMP;
import csrpg.fighters.MastersApplication;
import csrpg.fighters.Memes;
import csrpg.fighters.Monad;
import csrpg.fighters.Player;
import csrpg.fighters.SeniorThesis;
import csrpg.fighters.SteveHerzog;
import csrpg.fighters.Subversion;
import csrpg.fighters.TechnicalInterview;
import csrpg.fighters.Waitlist;

public class PVPGui {

	JToolBar tools = new JToolBar();
	private final JPanel battleGui = new JPanel(new BorderLayout(3, 3));
	private JPanel battleScreen;
	
	/*Seed*/
	Random r = new Random();
	
	/*Moves*/
	private ButtonGroup moves;
	private JButton move1, move2, move3, move4;
	
	/*Items*/
	private JTextField items;
	
	/*Enemies*/
	Character[] enemies = {new AllNighter(), new Chara(), new CodingChallenge(), new CourseCatalog(),
			new CS241VM(), new Eclipse(), new ErhanKudeki(), new FinalProject242(), new GRE(), new HackerRank(),
			new Lab(), new LennyPitt(), new MachineProblem(), new MallocMP(), new MastersApplication(), new Memes(),
			new Monad(), new SeniorThesis(), new SteveHerzog(), new Subversion(), new TechnicalInterview(), new Waitlist()};
	
	/*Player*/
	
	Player player;
	
	
	public PVPGui() {

	}
	
	public void initializeBattle(){
		player = new Player();
		
	}
	
	public void gameLoop(){
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
				String input = JOptionPane.showInputDialog("What would you like to do? (Input a number): ");
				while(!Battle.playerAction(Integer.parseInt(input) - 1, true)) {
					input = JOptionPane.showInputDialog("Invalid action. What would you like to do? (Input a number): ");
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
	

	public void printOptions(Character chara){
		
	}
	
	public void printStats(Character chara){
		
	}

}
