import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;

/**
 * A wrapper class for all the characters in the world.
 */
public class Characters {

	private Set<Character> characters = new HashSet<Character>();

	private static String[] maleNames = {
		"Jacob",
		"Ethan",
		"Michael",
		"Alexander",
		"William",
		"Joshua",
		"Daniel",
		"Jay",
		"Noah",
		"Anthony",
		"Christopher",
		"Andrew",
		"Joseph",
		"David",
		"Ryan",
		"James",
		"John",
		"Noah"
	};
	private static String[] femaleNames = {
		"Isabella",
		"Emma",
		"Olivia",
		"Sophia",
		"Ava",
		"Emily",
		"Madison",
		"Abigail",
		"Chloe",
		"Mia",
		"Samantha",
		"Natalie",
		"Sarah",
		"Hannah",
		"Alexis",
		"Ashley",
		"Grace",
		"Jennifer"
	};

	private static int numAbilities = 6;

	public Characters(World world, int density) {
		int dispersion = Character.SIZE * density;
		int count = (world.getXRadius() * world.getYRadius() * 4) / (dispersion * dispersion);
		for (int i = 0; i < count; i++) {

			// Get a random Gender.
			Character.Gender gender = Character.Gender.MALE;
			if (Math.random() < 0.5)
				gender = Character.Gender.FEMALE;

			// Randomly generate abilities.
			int abilityMean = Utility.getRandomInRange(10, 15);
			int[] abilities = new int[numAbilities];
			for (int j = 0; j < numAbilities; j++)
				abilities[j] = Utility.getRandomInRange(abilityMean - 5, abilityMean + 5);

			// Locate the character randomly on the grid.
			int x = 0, y = 0, loops = 0;
			boolean keepGoing = true;
			while (keepGoing) {
				keepGoing = false;
				x = Utility.getRandomInRange(-world.getXRadius(), world.getXRadius());
				y = Utility.getRandomInRange(-world.getYRadius(), world.getYRadius());
				if (
						Utility.within(0, dispersion, x) &&
						Utility.within(0, dispersion, y)
				) {
					keepGoing = true;
				}
				for (Character c : characters) {
					if (
							Utility.within(c.getX(), dispersion/2, x) &&
							Utility.within(c.getY(), dispersion/2, y)
					) {
						keepGoing = true;
						break;
					}
				}
				loops++;
				if (loops > 6)
					keepGoing = false;
			}

			// Create a new Character.
			characters.add(new Character(
					generateName(gender),										// Name
					gender,														// Gender
					Utility.getRandomArrayElement(Character.Type.values()),		// Type
					Utility.getRandomArrayElement(Character.Virus.values()),	// Virus
					x,															// X-location
					y,															// Y-location
					abilities[0],												// Aggression
					abilities[1],												// Energy
					abilities[2],												// Enthusiasm
					abilities[3],												// Presence
					abilities[4],												// Skill
					abilities[5]												// Speed
			));
		}
	}

	public void draw(Graphics g, int shiftX, int shiftY) {
		for (Character c : characters) {
			c.draw(g, shiftX, shiftY);
		}
	}

	private static String generateName(Character.Gender gender) {
		switch (gender) {
		case FEMALE:
			return Utility.getRandomArrayElement(femaleNames);
		case MALE:
		default:
			return Utility.getRandomArrayElement(maleNames);
		}
	}

}
