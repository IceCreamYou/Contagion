import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Player extends Character {

	public Player(
			String name,
			Gender gender,
			Type type,
			Virus virus,
			int aggression,
			int energy,
			int enthusiasm,
			int presence,
			int skill,
			int speed
	) {
		super(
				name,
				gender,
				type,
				virus,
				0,
				0,
				aggression,
				energy,
				enthusiasm,
				presence,
				skill,
				speed
		);
	}

	private long lastKeyResponse = 0;
	public void respondToKey(KeyEvent e) {
		long time = System.currentTimeMillis();
		if (time - lastKeyResponse > (MAX_SPEED - getSpeed() + 1) * 0.5) {
			lastKeyResponse = time;
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				move(0, -SIZE/2);
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				move(0, SIZE/2);
			}
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				move(SIZE/2, 0);
			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				move(-SIZE/2, 0);
			}
		}
	}

	public void draw(Graphics g) {
		Rectangle box = g.getClipBounds();
		int tX = (int) (box.getWidth() / 2) - 2*SIZE;
		int tY = (int) (box.getHeight() / 2) - 2*SIZE;
		g.setColor(Color.BLUE);
		g.fillOval(tX, tY, 4*SIZE, 4*SIZE);
		g.setColor(Color.BLACK);
		g.drawOval(tX, tY, 4*SIZE, 4*SIZE);
	}

}
