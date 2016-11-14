package csrpg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

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
import csrpg.moves.Move;

public class PVPGui {

	JToolBar tools = new JToolBar();
	private final JPanel battleGui = new JPanel(new BorderLayout(3, 3));
	
	private JPanel battleScreen = new JPanel();
	private JTextArea descriptions = new JTextArea();
	private JPanel enemyPanel = new JPanel(new BorderLayout());
	private JTextArea enemyMove = new JTextArea();
	private JTextArea playerMenu = new JTextArea();
	boolean menuvisible = false;
	
	/*Seed*/
	Random r = new Random();
	
	/*Moves*/
	private JButton moveset;
	private JButton move1, move2, move3, move4;
	private static JButton attack, retreat;
	boolean descriptionVisible = false;
	
	
	/*Items*/
	private JTextField items;
	
	/*Enemies*/
	Character[] enemies = {new AllNighter(), new Chara(), new CodingChallenge(), new CourseCatalog(),
			new CS241VM(), new Eclipse(), new ErhanKudeki(), new FinalProject242(), new GRE(), new HackerRank(),
			new Lab(), new LennyPitt(), new MachineProblem(), new MallocMP(), new MastersApplication(), new Memes(),
			new Monad(), new SeniorThesis(), new SteveHerzog(), new Subversion(), new TechnicalInterview(), new Waitlist()};
	
	/*Player*/
	
	Player player;
	String playername;
	private JButton playerButton;
	
	public static void main(String[] args){
		Runnable r = new Runnable() {

			@Override
			public void run() {
				PVPGui cb =
						new PVPGui();

				JFrame f = new JFrame("Chess");
				f.add(cb.getGui());
				addBattleScreenComponents(f.getContentPane());
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.setLocationByPlatform(true);
				f.pack();
				f.setMinimumSize(f.getSize());
				f.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);
	}
	
	public PVPGui() {
		initializeBattle();

	}
	
	public final JComponent getBattleBoard(){
		return battleScreen;
		
	}
	
	public final JComponent getGui() {
		return battleGui;
	}
	
	public static void addBattleScreenComponents(Container pane){
		attack = new JButton("Attack");
		pane.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    c.weighty = 1.0;   //request any extra vertical space
	    c.fill = GridBagConstraints.HORIZONTAL;
	    pane.add(attack, c);
	    retreat = new JButton("Retreat");
	    c.weighty = 1.0;   //request any extra vertical space
	    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
	    c.fill = GridBagConstraints.HORIZONTAL;
	    pane.add(attack, c);
	    
	    
	    
	}
	public void initializeBattle(){
		player = new Player();
		
		battleScreen = new JPanel(new BorderLayout());
		battleScreen.setPreferredSize(new Dimension(640, 480));
		descriptions.setPreferredSize(new Dimension(640, 50));
		descriptions.setBackground(Color.LIGHT_GRAY);
		descriptions.setVisible(descriptionVisible);
		playerMenu.setPreferredSize(new Dimension(100, 50));
		playerMenu.setBackground(Color.LIGHT_GRAY);
		playerMenu.setVisible(menuvisible);
		
		
		battleScreen.setBackground(Color.WHITE);
		battleGui.add(battleScreen);
		battleScreen.add(descriptions, BorderLayout.NORTH);
		ImageIcon fairynico = new ImageIcon("images/fairynico.png");
		JButton enemyIcon = new JButton();
		enemyIcon.setIcon(fairynico);
		enemyPanel.add(enemyMove, BorderLayout.SOUTH);
		enemyPanel.add(enemyIcon, BorderLayout.WEST);
		battleScreen.add(enemyPanel, BorderLayout.SOUTH);
		
		Character enemy = enemies[r.nextInt(enemies.length)];
		enemyMove.setText("Enemy: " + enemy.getName() 
				+ "\nEnemy Uses: " + enemy.getMoveset()[r.nextInt(1)].getName());
		enemyMove.setBorder(BorderFactory.createLineBorder(Color.black));
		battleScreen.add(playerMenu, BorderLayout.WEST);
		
		playerMenu.setText("Health: " + player.getHealth() + "\n"
				+ "Level: " + player.getLevel() + "\n");
		
		
		tools.setFloatable(false);
		battleGui.add(tools, BorderLayout.PAGE_START);
		tools.add(new JButton("Player:"));
		playerButton = new JButton(player.getName());
		tools.add(playerButton);
		tools.addSeparator();
		moveset = new JButton("Moves ");
		tools.add(moveset);
		move1 = new JButton(player.getMoveset()[0].getName());
		tools.add(move1);
		move2 = new JButton(player.getMoveset()[1].getName());
		tools.add(move2);
		move3 = new JButton(player.getMoveset()[2].getName());
		tools.add(move3);
		move4 = new JButton(player.getMoveset()[3].getName());
		tools.add(move4);
		tools.addSeparator();
		
		
		playerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				playerMenu.setVisible(menuvisible);
				menuvisible = !menuvisible;
			}
		});
		moveset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				descriptions.setVisible(descriptionVisible);
				descriptionVisible = !descriptionVisible;
			}
		});
		move1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				descriptions.setText(player.getMoveset()[0].getDescription());
			}
		});
		
		move2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				descriptions.setText(player.getMoveset()[1].getDescription());
			}
		});
		
		move3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				descriptions.setText(player.getMoveset()[2].getDescription());
			}
		});
		
		move4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				descriptions.setText(player.getMoveset()[3].getDescription());
			}
		});
		
		
		
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
