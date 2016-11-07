
/************************************
 * @author Ziwei Ba
 */

package csrpg.fighters;

import static org.junit.Assert.*;
import csrpg.moves.*;

import org.junit.Test;

import csrpg.moves.HelloWorld;

public class CharacterTest {

	@Test
	public void testPlayerCreation() {
		Player testplayer = new Player();
		assertTrue(testplayer.getName().equals(testplayer.name));
		assertTrue(testplayer.getDescription().equals(testplayer.description));
		assertTrue(testplayer.getMaxHealth() == 100);
		assertTrue(testplayer.getDamageResistance() == 1.0);
		assertTrue(testplayer.getMoveset().length == 4);
	}
	
	
	@Test
	public void testCharaCreation(){
		Chara testchara = new Chara();
		assertTrue(testchara.getName().equals(testchara.name));
		assertTrue(testchara.getDescription().equals(testchara.description));
		assertTrue(testchara.getMaxHealth() == 25);
		assertTrue(testchara.getMoveset()[2] == null);
		assertTrue(testchara.getMoveset()[3] == null);
	}
	
	@Test
	public void testCourseCatalogCreation(){
		CourseCatalog testCourseCatalog = new CourseCatalog();
		assertTrue(testCourseCatalog.getName().equals(testCourseCatalog.name));
		assertTrue(testCourseCatalog.getDescription().equals(testCourseCatalog.description));
		assertTrue(testCourseCatalog.getMaxHealth() == 50);
		assertTrue(testCourseCatalog.getMoveset()[2] == null);
		assertTrue(testCourseCatalog.getMoveset()[3] == null);
	}
	
	@Test
	public void testCS241VMCreation(){
		CS241VM testCS241VM = new CS241VM();
		assertTrue(testCS241VM.getName().equals(testCS241VM.name));
		assertTrue(testCS241VM.getDescription().equals(testCS241VM.description));
		assertTrue(testCS241VM.getMaxHealth() == 150);
		assertTrue(testCS241VM.getMoveset()[3] == null);
	}
	
	@Test
	public void testEclipseCreation(){
		Eclipse testEclipse = new Eclipse();
		assertTrue(testEclipse.getName().equals(testEclipse.name));
		assertTrue(testEclipse.getDescription().equals(testEclipse.description));
		assertTrue(testEclipse.getMaxHealth() == 15);
		assertTrue(testEclipse.getMoveset()[3] == null);
	}
	
	@Test
	public void testHackerRankCreation(){
		HackerRank testHackerRank = new HackerRank();
		assertTrue(testHackerRank.getName().equals(testHackerRank.name));
		assertTrue(testHackerRank.getDescription().equals(testHackerRank.description));
		assertTrue(testHackerRank.getMaxHealth() == 80);
		assertTrue(testHackerRank.getMoveset()[3] == null);
	}
	
	@Test
	public void testLabCreation(){
		Lab testLab = new Lab();
		assertTrue(testLab.getName().equals(testLab.name));
		assertTrue(testLab.getDescription().equals(testLab.description));
		assertTrue(testLab.getMaxHealth() == 25);
		assertTrue(testLab.getMoveset()[3] == null);
	}
	
	@Test
	public void testMachineProblemCreation(){
		MachineProblem testMachineProblem = new MachineProblem();
		assertTrue(testMachineProblem.getName().equals(testMachineProblem.name));
		assertTrue(testMachineProblem.getDescription().equals(testMachineProblem.description));
		assertTrue(testMachineProblem.getMaxHealth() == 50);
	}
	
	@Test
	public void testMallocMPCreation(){
		MallocMP testMallocMP = new MallocMP();
		assertTrue(testMallocMP.getName().equals(testMallocMP.name));
		assertTrue(testMallocMP.getDescription().equals(testMallocMP.description));
		assertTrue(testMallocMP.getMaxHealth() == 150);
	}
	
	@Test
	public void testSubversionCreation(){
		Subversion testSubversion = new Subversion();
		assertTrue(testSubversion.getName().equals(testSubversion.name));
		assertTrue(testSubversion.getDescription().equals(testSubversion.description));
		assertTrue(testSubversion.getMaxHealth() == 100);
	}

}
