import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * The Contagion game.
 *
 * Contagion is a game of power and influence. Your goal is to "infect" every
 * character in your world with your own personal virus by moving around the
 * world and interacting with others. Various types of viruses spread in
 * different ways, and various types of characters have different behaviors as
 * well. You can choose how your world will develop, and watch as your virus
 * becomes increasingly contagious!
 *
 * @author Isaac Sukin
 */
public class Contagion {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Contagion();
			}
		});
	}

	public Contagion() {
    	// Set up the window.
    	JFrame frame = new JFrame("Contagion");
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the panel in which the game is actually played.
		JPanel gamePanel = new GamePanel();
		frame.add(gamePanel, BorderLayout.CENTER);

		// Put the frame on the screen
		frame.pack();
        frame.setVisible(true);
	}

}
