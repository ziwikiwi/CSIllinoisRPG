package csrpg.moves;

import static org.junit.Assert.*;

import org.junit.Test;

import csrpg.fighters.Player;

/**
 * @author Ziwei Ba
 *
 */
public class MoveTest {
	
	/************************************************
	 * PLAYER MOVES: Nick Chan
	 ************************************************/

	@Test
	public void testCram() {
		Player p1 = new Player();
		Player p2 = new Player();
		Cram testCram = new Cram();
		testCram.effect(p2, p1);
		assertTrue(p2.getHealth() == 95);
		assertTrue(p1.getHealth() == 100);
	}
	
	@Test
	public void testHelloWorld() {
		Player p1 = new Player();
		Player p2 = new Player();
		HelloWorld testHelloWorld = new HelloWorld();
		testHelloWorld.effect(p2, p1);
		assertTrue(p2.getHealth() == 90);
		assertTrue(p1.getHealth() == 100);
	}
	
	@Test
	public void testProcrastinate() {
		Player p1 = new Player();
		Player p2 = new Player();
		Procrastinate testProcrastinate = new Procrastinate();
		testProcrastinate.effect(p2, p1);
		assertTrue(p1.getDamageResistance() == 0.90);
		assertTrue(p1.getHealth() == 100);
	}
	
	@Test
	public void testProficiencyExam() {
		Player p1 = new Player();
		Player p2 = new Player();
		ProficiencyExam testProficiencyExam = new ProficiencyExam();
		testProficiencyExam.effect(p2, p1);
	}
	
	/******************************************
	 * ENEMY MOVES: Ziwei Ba
	 ******************************************/
	

}
