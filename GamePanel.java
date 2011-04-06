import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements MouseMotionListener {

	private static final int WIDTH = 800, HEIGHT = 600, TIMER_INTERVAL = 30;

	private Timer timer;

	private Character player;

	private World world;

	/**
	 * Required for subclasses of Swing components.
	 */
	private static final long serialVersionUID = 1552746400473185110L;

	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setFocusable(true);
		setBackground(Color.BLACK);

		// Instantiate the game timer that will run the main action loop.
		timer = new Timer(TIMER_INTERVAL, new ActionListener() {
			public void actionPerformed(ActionEvent e) { tick(); }
		});

		// TODO: The game should start with a dialog that allows setting these properties.
		player = new Character(
				"You",							// Name
				Character.Gender.MALE,			// Gender
				Character.Type.ENTREPRENEUR,	// Type
				Character.Virus.SKILL,			// Virus
				10,								// Aggression
				12,								// Energy
				12,								// Enthusiasm
				8,								// Size
				15,								// Skill
				10								// Speed
		);
		world = new World(player);
		
		// React when the player presses keys.
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				player.respondToKey(e);
			}
		});
	
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO: react to click by showing a dialog of interaction options
			}
		});
		
		// Keep track of the mouse when editing.
		addMouseMotionListener(this);

		grabFocus();
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		world.draw(g);
		player.draw(g);
	}

	protected void tick() {
		// TODO: Process all the other characters

		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO: Show information in a side panel about hovered characters
	}

}
