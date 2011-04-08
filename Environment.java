import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Environment {

	enum Type {
		CARPET,
		CHECKER,
		DARK_CONCRETE,
		DIRT,
		LIGHT_CONCRETE,
		PEBBLES,
		SHORT_GRASS,
		SNOW,
		STAGE,
		STORE,
		TALL_GRASS,
		TILE,
		WALL,
		WATER,
		WOOD
	}

	private Rectangle location;
	private Type type;

	private static int count = 0;
	private Color color;
	public Environment(Rectangle location) {
		this.location = location;
		type = Type.CHECKER;
		if (count % 2 == 0)
			color = Color.GRAY;
		else
			color = Color.WHITE;
		count++;
	}

	public Environment(Rectangle location, Type type) {
		this.location = location;
		this.type = type;
	}

	public Rectangle getLocation() {
		return location;
	}

	public String getPictureFilepath() {
		// TODO: Create images for each environment type
		switch(type) {
		case CARPET:
		case DARK_CONCRETE:
		case DIRT:
		case LIGHT_CONCRETE:
		case PEBBLES:
		case SHORT_GRASS:
		case SNOW:
		case STAGE:
		case STORE:
		case TALL_GRASS:
		case TILE:
		case WALL:
		case WATER:
		case WOOD:
		case CHECKER:
		default:
			return null;
		}
	}

	public void draw(Graphics g, int shiftX, int shiftY) {
		Rectangle bounds = location.getBounds();
		int x = (int) bounds.getX() + shiftX, y = (int) bounds.getY() + shiftY;
		switch(type) {
		case CARPET:
		case DARK_CONCRETE:
		case DIRT:
		case LIGHT_CONCRETE:
		case PEBBLES:
		case SHORT_GRASS:
		case SNOW:
		case STAGE:
		case STORE:
		case TALL_GRASS:
		case TILE:
		case WALL:
		case WATER:
		case WOOD:
			Picture.draw(g, getPictureFilepath(), x, y);
			break;
		case CHECKER:
		default:
			g.setColor(color);
			g.fillRect(
					x,
					y,
					(int) bounds.getWidth(),
					(int) bounds.getHeight()
			);
		}
	}

}
