import java.awt.Color;
import java.awt.Graphics;


public class Character {

	// ==============================================================PROPERTIES

	// Possible characteristics
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
	// private Map<Virus, Integer> viruses = new HashMap<Virus, Integer>();

	// Maximum attribute values
	static final int MAX_AGGRESSION = 100;
	static final int MAX_ENERGY = 100;
	static final int MAX_ENTHUSIASM = 100;
	static final int MAX_SIZE = 100;
	static final int MAX_SKILL = 100;
	static final int MAX_SPEED = 100;

	public static final int SIZE = 12;

	// Attributes
	private String name;
	private Gender gender;
	private Type type;
	private Virus virus;
	private int aggression;
	private int energy;
	private int enthusiasm;
	private int presence;
	private int skill;
	private int speed;

	// Physics
	private int x = 0, y = 0;

	public Character (
			String name,
			Gender gender,
			Type type,
			Virus virus,
			int x,
			int y,
			int aggression,
			int energy,
			int enthusiasm,
			int presence,
			int skill,
			int speed
			) {
		this.name = name;
		this.gender = gender;
		this.type = type;
		this.virus = virus;
		this.x = x;
		this.y = y;
		this.aggression = aggression;
		this.energy = energy;
		this.enthusiasm = enthusiasm;
		this.presence = presence;
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

	public int getPresence() {
		return presence;
	}

	public boolean changePresence(int delta) {
		int orig = presence;
		presence = change(orig, delta, MAX_SIZE);
		return orig == presence;
	}

	public int getSkill() {
		return skill;
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

	public void move(int xAmount, int yAmount) {
		x += xAmount;
		y += yAmount;
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

	public void draw(Graphics g, int shiftX, int shiftY) {
		// TODO: STUB
		g.setColor(Color.RED);
		g.fillOval(x + shiftX, y + shiftY, 4*SIZE, 4*SIZE);
		g.setColor(Color.BLACK);
		g.drawOval(x + shiftX, y + shiftY, 4*SIZE, 4*SIZE);
	}

}
