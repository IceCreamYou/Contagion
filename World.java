import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.Set;


public class World {

	private int xRadius = 800, yRadius = 600;
	private Character player;
	private Rectangle playArea;
	private Set<Environment> environment = new HashSet<Environment>();

	public World(Character player) {
		this.player = player;
		checkerBoard();
	}

	// TODO
	private void checkerBoard() {
		for (int i = -xRadius; i < xRadius; i += 80) {
			for (int j = -yRadius; j < yRadius; j += 80) {
				environment.add(new Environment(new Rectangle(i, j, 80, 80)));
			}
		}
	}

	public World(Character player, int width, int height) {
		this.player = player;
		this.xRadius = width / 2;
		this.yRadius = height / 2;
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
		int tX = player.getX() - width / 2;
		int tY = player.getY() - height / 2;
		playArea = new Rectangle(tX, tY, width, height);
		player.cullLocation(xRadius, yRadius);
		for (Environment env : environment) {
			if (env != null && env.getLocation().intersects(playArea))
				env.draw(g, width/2 - player.getX(), height/2 - player.getY());
		}
	}

}
