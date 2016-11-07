



package csrpg.fighters;

import csrpg.moves.*;

/**
 * @author Ziwei Ba
 *
 */
public class CourseCatalog extends Character {

	public CourseCatalog() {
		name = "Course Catalog";
		description = "You have zero incoming AP credits because you were lazy in high school, so your course selection is a month after everyone else's.";
		moveset[0] = new HelloWorld();
		moveset[1] = new ProficiencyExam();
		maxHealth = 50;
		health = 50;
		damageResistance = 0.75;
	}

}
