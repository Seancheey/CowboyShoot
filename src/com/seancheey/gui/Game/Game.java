package com.seancheey.gui.Game;

import javax.swing.*;
import java.util.Date;
import java.awt.*;

import com.seancheey.creatures.Creature;
import com.seancheey.gui.GuiTool;
import com.seancheey.gui.MainFrame;
import com.seancheey.levels.CurrentLevel;

/**
 * 
 * @author Seancheey This class contains a paintComponent method that is
 *         essential to the whole game Vertical synchronization of animation and
 *         action is used all actions of entities should be executed every 20ms
 *         (i.e. the max fps should be 50)
 */
public class Game extends JPanel {
	private static final long serialVersionUID = 1L;
	private static Image background = Toolkit.getDefaultToolkit().getImage("resource/Background/meadow.jpg");
	public static CurrentLevel map = new CurrentLevel();
	/**
	 * the milliseconds of the last time of refresh (used to get the time
	 * difference between two refresh action)
	 */
	private long lastRefreshTime;
	/**
	 * used to calculate how much time was not reduced at last run
	 */
	private int timeMore = 0;

	public Game() {
		setSize(GuiTool.fitSize(900, 550));
		setBackground(Color.WHITE);
		setLayout(null);
		lastRefreshTime = new Date().getTime();
	}

	/** ESSENTIAL!!!! */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintAllStuff(g);
		timeMore += new Date().getTime() - lastRefreshTime;
		for (int i = 0; i < timeMore / 20; i++) {
			for (Creature c : map.getCreatureList()) {
				c.makeMove();
			}
		}
		timeMore = timeMore % 20;
		lastRefreshTime = new Date().getTime();
		repaint();
	}

	private void paintAllStuff(Graphics g) {
		g.drawImage(background, 0, 0, MainFrame.frameSize.width, MainFrame.frameSize.height, this);
		map.paintMap(g);
		GamePanel.animation.paint(g);
	}
}
