package csrpg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
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
	private JLabel enemyImage = new JLabel();
	private JPanel battleScreen = new JPanel();
	private JTextArea descriptions = new JTextArea();
	private JPanel enemyPanel = new JPanel(new BorderLayout());
	private JTextArea enemyMove = new JTextArea();
	private JTextArea playerMenu = new JTextArea();
	private JPanel actionButtonWrapper = new JPanel(new BorderLayout());
	private JPanel actionButtons = new JPanel(new BorderLayout());
	private JTextArea playerInfo = new JTextArea();
	private JTextArea enemyName = new JTextArea();
	JButton attackButton = new JButton("Attack");
	JButton passButton = new JButton("Pass");
	boolean menuvisible = false;
	
	private JPanel healthBarWrapper = new JPanel(new BorderLayout());
	private JPanel playerHealthBarMax = new JPanel(new BorderLayout());
	private JPanel playerHealthBar = new JPanel(new BorderLayout());
	private JPanel enemyHealthBarMax = new JPanel(new BorderLayout());
	private JPanel enemyHealthBar = new JPanel(new BorderLayout());
	
	
	boolean playerTurn = true;
	
	/*Seed*/
	Random r = new Random();
	
	/*Moves*/
	private JButton moveset = new JButton("Moveset:");
	private JButton[] moves = new JButton[4];
	
	boolean descriptionVisible = false;
	Move playerMove;
	
	/*Items*/
	private JTextField items;
	
	/*Enemies*/
	Character[] enemies = {new AllNighter(), new Chara(), new CodingChallenge(), new CourseCatalog(),
			new CS241VM(), new Eclipse(), new ErhanKudeki(), new FinalProject242(), new GRE(), new HackerRank(),
			new Lab(), new LennyPitt(), new MachineProblem(), new MallocMP(), new MastersApplication(), new Memes(),
			new Monad(), new SeniorThesis(), new SteveHerzog(), new Subversion(), new TechnicalInterview(), new Waitlist()};
	String[] enemyURLs = {"http://blog.onlineclock.net/wp-content/uploads/2012/09/anatomy-of-allnighter.gif", 
			"http://i.ytimg.com/vi/PFDczk_f0bg/0.jpg",
			"http://edu.stemjobs.com/wp-content/uploads/2015/05/coding.jpg",
			"http://www.online.uillinois.edu/images/ThreeCampuses8.jpg",
			"http://www.wiu.edu/academics/majors/business_and_technology/images/desktop_computer_512.png",
			"http://weknowyourdreams.com/image.php?pic=/images/eclipse/eclipse-07.jpg",
			"https://pbs.twimg.com/media/BIffabyCcAA7Jhr.jpg",
			"http://fall2015-eng527.jessicapressman.com/wp-content/uploads/2015/12/Keep-Calm_Final-Project.png",
			"http://www.calpolydptcareer.com/wp-content/uploads/2016/02/GRE.jpg",
			"http://blog.hackerrank.com/wp-content/uploads/2015/03/Artificial-intelligence.png",
			"http://bluefletch.com/wp-content/uploads/2016/09/tubitos.jpg",
			"http://news.illinois.edu/WebsandThumbs/Pitt,Lenny/Pitt,Lenny_b.jpg",
			"http://somethingwiki.com/wp-content/uploads/2016/06/Google-study-Coding-is-a-low-priority-in-US-schools.jpg",
			"http://g.oswego.edu/dl/html/malloc2.gif",
			"http://www.scorp.co/wp-content/uploads/2015/02/masters.jpg",
			"http://i2.cdn.cnn.com/cnnnext/dam/assets/160927210830-tk-ah0927-exlarge-169.jpg",
			"http://dailygenius.com/wp-content/uploads/2015/04/coding_my_life_away_by_izzuthug-d4dgn1d.png",
			"http://blogdailyherald.com/wp-content/uploads/2014/04/20080208_SeniorThesis_17.jpg",
			"https://cs.illinois.edu/sites/default/files/images/Herzog_steve.jpg",
			"https://upload.wikimedia.org/wikipedia/en/thumb/9/9f/Subversion_Logo.svg/1280px-Subversion_Logo.svg.png",
			"http://media1.s-nbcnews.com/i/newscms/2016_13/1028606/job-interview-panel-tease-today-160328_85ede3fe3cd79d1b3081227a1dc682db.jpg",
			"http://opentickets.com/wp-content/uploads/2013/06/waitlist.jpg"};
		
	
	Character currEnemy;
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
		gameGUILoop();

	}
	
	public JComponent getBattleBoard(){
		return battleScreen;
		
	}
	
	public final JComponent getGui() {
		return battleGui;
	}
	

	public void initializeBattle(){
		player = new Player();
		int enemyIndex = r.nextInt(enemies.length);
		battleScreen = new JPanel(new BorderLayout());
		
		enemyImage.setPreferredSize(new Dimension(640, 430));
		enemyImage.setBackground(Color.PINK);
		enemyImage.setIcon(new ImageIcon(resize(requestImage(enemyURLs[enemyIndex]),640,430)));
		
		
		
		battleScreen.setPreferredSize(new Dimension(640, 480));
		descriptions.setPreferredSize(new Dimension(640, 50));
		descriptions.setBackground(Color.LIGHT_GRAY);
		descriptions.setVisible(descriptionVisible);
		playerMenu.setPreferredSize(new Dimension(100, 50));
		playerMenu.setBackground(Color.LIGHT_GRAY);
		playerMenu.setVisible(menuvisible);
		
		
		currEnemy = enemies[enemyIndex];
		
		enemyName.setText("You are now fighting: " + currEnemy.getName());
		battleScreen.add(enemyImage, BorderLayout.CENTER);
		
		healthBarWrapper.setPreferredSize(new Dimension(100, 100));
		healthBarWrapper.setBackground(Color.BLUE);
		playerHealthBarMax.setPreferredSize(new Dimension(50, 100));
		playerHealthBarMax.setBackground(Color.RED);
		playerHealthBarMax.add(playerHealthBar, BorderLayout.SOUTH);
		playerHealthBar.setBackground(Color.GREEN);
		playerHealthBar.setPreferredSize(new Dimension(50,100));
		enemyHealthBarMax.setPreferredSize(new Dimension(50,100));
		enemyHealthBarMax.setBackground(Color.BLUE);
		enemyHealthBarMax.add(enemyHealthBar, BorderLayout.SOUTH);
		enemyHealthBar.setBackground(Color.CYAN);
		enemyHealthBar.setPreferredSize(new Dimension(50,100));
		healthBarWrapper.add(playerHealthBarMax, BorderLayout.WEST);
		healthBarWrapper.add(enemyHealthBarMax, BorderLayout.EAST);
		actionButtonWrapper.add(healthBarWrapper, BorderLayout.NORTH);
		
		/* Attack and Retreat Buttons */
		battleScreen.add(actionButtonWrapper, BorderLayout.EAST);
		actionButtonWrapper.add(actionButtons, BorderLayout.SOUTH);
		actionButtonWrapper.setPreferredSize(new Dimension(100, 50));
		actionButtonWrapper.setOpaque(false);
		playerInfo.setEditable(false);
		playerInfo.setBackground(Color.LIGHT_GRAY);
		actionButtonWrapper.add(playerInfo);
		actionButtons.setPreferredSize(new Dimension(50,50));
		actionButtons.setBackground(Color.BLUE);
		
		attackButton.setBackground(Color.RED);
		passButton.setBackground(Color.CYAN);
		actionButtons.add(attackButton, BorderLayout.NORTH);
		actionButtons.add(passButton, BorderLayout.SOUTH);
		
		
		enemyMove.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		battleScreen.setBackground(Color.WHITE);
		battleGui.add(battleScreen);
		battleScreen.add(descriptions, BorderLayout.NORTH);
		battleScreen.add(playerMenu, BorderLayout.WEST);

		
		
		tools.setFloatable(false);
		battleGui.add(tools, BorderLayout.PAGE_START);
		tools.add(new JButton("Player:"));
		playerButton = new JButton(player.getName());
		tools.add(playerButton);
		tools.addSeparator();
		moveset = new JButton("Moves ");
		tools.add(moveset);
		moves[0] = new JButton(player.getMoveset()[0].getName());
		tools.add(moves[0]);
		moves[1] = new JButton(player.getMoveset()[1].getName());
		tools.add(moves[1]);
		moves[2] = new JButton(player.getMoveset()[2].getName());
		tools.add(moves[2]);
		moves[3] = new JButton(player.getMoveset()[3].getName());
		tools.add(moves[3]);
		tools.addSeparator();
		
		moveset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				descriptions.setVisible(descriptionVisible);
				descriptionVisible = !descriptionVisible;
				
			}
		});

		
		
		
	}
	
	
	public void gameGUILoop(){
		System.out.println("In Gameloop");
			
				
		
	
			//player turn
			if (playerTurn){
				ImageIcon pinkenemy = new ImageIcon(resize(requestImage("http://www.sunnyneo.com/plots/RoS/images/ROS_icon_9.jpg"),75,75));
				JButton enemyIcon = new JButton();
				enemyIcon.setPreferredSize(new Dimension(75,75));
				enemyIcon.setIcon(pinkenemy);
				enemyPanel.add(enemyMove, BorderLayout.SOUTH);
				enemyPanel.add(enemyIcon, BorderLayout.WEST);
				enemyMove.setBorder(BorderFactory.createLineBorder(Color.black));
				battleScreen.add(enemyPanel, BorderLayout.SOUTH);
				enemyMove.setText("Choose a move!");
				
				
				attackButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt){
							if (player.getHealth() == 0){
								JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(battleGui), "Game Over");
							}
							if (currEnemy.getHealth() == 0){
								currEnemy = enemies[r.nextInt(enemies.length)];
								enemyName.setText("You are now fighting: " + currEnemy.getName());
							}
							String moveName = JOptionPane.showInputDialog("Enter Move Number:");
							enemyAttack();
							updateHealth();
							int movenum = Integer.parseInt(moveName);
							player.getMoveset()[movenum].effect(currEnemy, player);
							System.out.println("Player health: " + player.getHealth());
							System.out.println("Enemy health: " + currEnemy.getHealth());
							JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(battleGui), "Attacked Enemy");
							playerInfo.setText("Player Health: " + player.getHealth() + "\n Player Level: " + player.getLevel()
										+ "\nEnemy Health: " + currEnemy.getHealth() + "\nEnemy ATK: " + currEnemy.getATT() 
										+ "\nEnemy DEF:" + currEnemy.getDEF());
							
						}
					});
				
				passButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt){
						JOptionPane.showMessageDialog(SwingUtilities.windowForComponent(battleGui), "Passed Turn");
						enemyAttack();
						updateHealth();
						playerInfo.setText("Player Health: " + player.getHealth() + "\n Player Level: " + player.getLevel()
						+ "\nEnemy Health: " + currEnemy.getHealth() + "\nEnemy ATK: " + currEnemy.getATT() 
						+ "\nEnemy DEF:" + currEnemy.getDEF());
						
					}
				});
				
			}
			//enemy turn
			/*
			else{
				ImageIcon pinkenemy = new ImageIcon("pinkenemy.png");
				JButton enemyIcon = new JButton();
				enemyIcon.setPreferredSize(new Dimension(75,75));
				enemyIcon.setIcon(pinkenemy);
				enemyPanel.add(enemyMove, BorderLayout.SOUTH);
				enemyPanel.add(enemyIcon, BorderLayout.WEST);
				enemyMove.setBorder(BorderFactory.createLineBorder(Color.black));
				battleScreen.add(enemyPanel, BorderLayout.SOUTH);
				enemyMove.setText("Enemy: " + currEnemy.getName() 
				+ "\nEnemy Uses: " + currEnemy.getMoveset()[r.nextInt(1)].getName());
				currEnemy.getMoveset()[r.nextInt(1)].effect(player, currEnemy);
				//gameGUILoop();
			}
			*/
	}
	
	public void enemyAttack(){
		Move eneMove = currEnemy.getMoveset()[r.nextInt(4)];
		while (eneMove == null){
			eneMove = currEnemy.getMoveset()[r.nextInt(4)];
		}
		
		eneMove.effect(player, currEnemy);
		enemyMove.setText("Enemy uses " + eneMove.getName() + "\n Make Another Move");
		
	}
	
	public void updateHealth(){
		int playerHeight = (int)(((double)player.getHealth()/player.getMaxHealth()) * 100);
		int enemyHeight = (int)(((double)currEnemy.getHealth()/currEnemy.getMaxHealth()) * 100);
		System.out.print("PlayerHeight: " + playerHeight + " Enemy Height: " + enemyHeight);
		playerHealthBar.setPreferredSize(new Dimension(50, playerHeight));
		enemyHealthBar.setPreferredSize(new Dimension(50, enemyHeight));
		healthBarWrapper.add(playerHealthBarMax, BorderLayout.WEST);
		healthBarWrapper.add(enemyHealthBarMax, BorderLayout.EAST);
	}
	
    private Image requestImage(String url) {
        Image image = null;

        try {
            image = ImageIO.read(new URL(url));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }
    
	public static Image resize(Image image, int w, int h) { 
		Image temp = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		BufferedImage resized = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = resized.createGraphics();
		g2d.drawImage(temp, 0, 0, null);
		g2d.dispose();

		return resized;
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
