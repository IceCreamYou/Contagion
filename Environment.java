import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Environment {

	private Rectangle location;

	private static int count = 0;
	private Color color;
	public Environment(Rectangle location) {
		this.location = location;
		if (count % 2 == 0)
			color = Color.GRAY;
		else
			color = Color.WHITE;
		count++;
	}

	public Rectangle getLocation() {
		return location;
	}

	public void draw(Graphics g, int shiftX, int shiftY) {
		g.setColor(color);
		Rectangle bounds = location.getBounds();
		g.fillRect(
				((int) bounds.getX()) + shiftX,
				((int) bounds.getY()) + shiftY,
				(int) bounds.getWidth(),
				(int) bounds.getHeight()
		);
	}

}
