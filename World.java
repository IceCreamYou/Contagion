import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.Set;


public class World {

	private int xRadius = 800, yRadius = 600;
	private Player player;
	private Rectangle playArea;
	private Set<Environment> environment = new HashSet<Environment>();
	private Characters characters;

	public World(Player player) {
		this.player = player;
		characters = new Characters(this, 20);
	}

	public World(Player player, int width, int height, int density) {
		this.player = player;
		this.xRadius = width / 2;
		this.yRadius = height / 2;
		characters = new Characters(this, density);
	}

	public int getXRadius() {
		return xRadius;
	}

	public int getYRadius() {
		return yRadius;
	}

	public void addEnvironmentObject(Environment env) {
		environment.add(env);
	}

	public void addEnvironmentObjects(Set<Environment> envs) {
		environment.addAll(envs);
	}

	public void draw(Graphics g) {
		Rectangle box = g.getClipBounds();
		int width = (int) box.getWidth(), height = (int) box.getHeight();
		int shiftX = width / 2 - player.getX(), shiftY = height / 2 - player.getY();
		int tX = player.getX() - width / 2;
		int tY = player.getY() - height / 2;
		playArea = new Rectangle(tX, tY, width, height);
		player.cullLocation(xRadius, yRadius);
		for (Environment env : environment) {
			// Only bother drawing things that fit in the window.
			if (env != null && env.getLocation().intersects(playArea))
				env.draw(g, shiftX, shiftY);
		}
		characters.draw(g, shiftX, shiftY);
	}

}
