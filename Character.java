import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;


public class Character {

	// ==============================================================PROPERTIES

	// Specification of possible characteristics
	enum Gender {
		MALE,
		FEMALE
	}
	enum Type {
		ADVENTURER,
		ANIMAL,
		ARTIST,
		ATHLETE,
		COUNTERCULTURE,
		ENTREPRENEUR,
		MARKETER,
		POLITICIAN,
		SPIRITUAL,
		STREET,
		WORKER
	}
	enum Virus {
		DISEASE,
		FASHION,
		INTEREST,
		RELIGION,
		SKILL
	}

	// TODO: Figure out how to use this.
	private Map<Virus, Integer> viruses = new HashMap<Virus, Integer>();

	// Maximum attribute values
	private static final int MAX_AGGRESSION = 100;
	private static final int MAX_ENERGY = 100;
	private static final int MAX_ENTHUSIASM = 100;
	private static final int MAX_SIZE = 100;
	private static final int MAX_SKILL = 100;
	private static final int MAX_SPEED = 100;

	// Attributes
	private String name;
	private Gender gender;
	private Type type;
	private Virus virus;
	private int aggression;
	private int energy;
	private int enthusiasm;
	private int size;
	private int skill;
	private int speed;

	// Physics
	private int x = 0, y = 0;

	public Character (
			String name,
			Gender gender,
			Type type,
			Virus virus,
			int aggression,
			int energy,
			int enthusiasm,
			int size,
			int skill,
			int speed
			) {
		this.name = name;
		this.gender = gender;
		this.type = type;
		this.virus = virus;
		this.aggression = aggression;
		this.energy = energy;
		this.enthusiasm = enthusiasm;
		this.size = size;
		this.skill = skill;
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	public Gender getGender() {
		return gender;
	}

	public String maleTypeName() {
		return "male";
	}

	public String femaleTypeName() {
		return "female";
	}

	// Do not override
	public String getGenderTypeName() {
		switch (gender) {
		case FEMALE:
			return femaleTypeName();
		case MALE:
		default:
			return maleTypeName();
		}
	}

	public Virus getVirus() {
		return virus;
	}

	public void setVirus(Virus virus) {
		this.virus = virus;
	}

	public int getAgression() {
		return aggression;
	}

	public boolean changeAgression(int delta) {
		int orig = aggression;
		aggression = change(orig, delta, MAX_AGGRESSION);
		return orig == aggression;
	}

	public int getEnergy() {
		return energy;
	}

	public boolean changeEnergy(int delta) {
		int orig = energy;
		energy = change(orig, delta, MAX_ENERGY);
		return orig == energy;
	}

	public int getEnthusiasm() {
		return enthusiasm;
	}

	public boolean changeEnthusiasm(int delta) {
		int orig = enthusiasm;
		enthusiasm = change(orig, delta, MAX_ENTHUSIASM);
		return orig == enthusiasm;
	}

	public int getSkill() {
		return skill;
	}

	public int getSize() {
		return size;
	}

	public boolean changeSize(int delta) {
		int orig = size;
		size = change(orig, delta, MAX_SIZE);
		return orig == size;
	}

	public boolean changeSkill(int delta) {
		int orig = skill;
		skill = change(orig, delta, MAX_SKILL);
		return orig == skill;
	}

	private int change(int value, int delta, int max) {
		if (value + delta > 0 && value < max) {
			value += delta;
			if (value > max)
				value = max;
		}
		return value;
	}

	public int getSpeed() {
		return speed;
	}

	public boolean changeSpeed(int delta) {
		int orig = speed;
		speed = change(orig, delta, MAX_SPEED);
		return orig == speed;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void cullLocation(int xRadius, int yRadius) {
		if (x < -xRadius)
			x = -xRadius;
		else if (x > xRadius)
			x = xRadius;
		if (y < -yRadius)
			y = -yRadius;
		else if (y > yRadius)
			y = yRadius;
	}

	// Do not override
	public String getPictureLocation() {
		// TODO: Fill in picture locations
		switch (type) {
		case ADVENTURER:
		case ANIMAL:
		case ARTIST:
		case ATHLETE:
		case COUNTERCULTURE:
		case ENTREPRENEUR:
		case MARKETER:
		case POLITICIAN:
		case SPIRITUAL:
		case STREET:
		case WORKER:
		default:
			return null;
		}
	}

	// Do not override
	public String getTypeDescription() {
		// TODO: Fill in descriptions
		switch (type) {
		case ADVENTURER:
		case ANIMAL:
		case ARTIST:
		case ATHLETE:
		case COUNTERCULTURE:
		case ENTREPRENEUR:
		case MARKETER:
		case POLITICIAN:
		case SPIRITUAL:
		case STREET:
		case WORKER:
		default:
			return null;
		}
	}

	// =================================================================ACTIONS

	private long lastKeyResponse = 0;
	public void respondToKey(KeyEvent e) {
		// TODO: Don't move outside world boundaries
		long time = System.currentTimeMillis();
		if (time - lastKeyResponse > (MAX_SPEED - speed + 1) * 0.5) {
			lastKeyResponse = time;
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				y -= size/2;
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				y += size/2;
			}
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				x += size/2;
			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				x -= size/2;
			}
		}
	}

	public void collaborate(Character c) {
		// TODO: STUB
	}

	public void fight(Character c) {
		// TODO: STUB
	}

	public void talk(Character c) {
		// TODO: STUB
	}

	public void watch(Character c) {
		// TODO: STUB
	}

	public void draw(Graphics g) {
		// TODO: STUB
		Rectangle box = g.getClipBounds();
		int tX = (int) (box.getWidth() / 2) - 2*size;
		int tY = (int) (box.getHeight() / 2) - 2*size;
		g.setColor(Color.BLACK);
		g.drawOval(tX, tY, 4*size, 4*size);
		g.setColor(Color.BLUE);
		g.fillOval(tX, tY, 4*size, 4*size);
	}

}
