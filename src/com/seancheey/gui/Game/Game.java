package com.seancheey.gui.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Date;

import javax.swing.JPanel;

import com.seancheey.creatures.Creature;
import com.seancheey.data.KeyHandling.GameKeyHandler;
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
	public static CurrentLevel map;
	private static final int updateInterval = 10;
	private GameKeyHandler gameKeyHandler;
	/**
	 * the milliseconds of the last time of refresh (used to get the time
	 * difference between two refresh action)
	 */
	private long lastRefreshTime;
	/**
	 * used to calculate how much time was not reduced at last run
	 */
	private int timeMore = 0;
	private Thread creatureMoveThread;

	public Game(GameKeyHandler gameKeyHandler) {
		setSize(GuiTool.fitSize(900, 550));
		setBackground(Color.WHITE);
		setLayout(null);
		lastRefreshTime = new Date().getTime();
		this.gameKeyHandler = gameKeyHandler;
		map = new CurrentLevel(this.gameKeyHandler);
		creatureMoveThread = new Thread() {
			@Override
			public void run() {
				while (true) {
					makeMove();
				}
			}
		};
		creatureMoveThread.start();
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		creatureMoveThread.wait();
	}

	/**
	 * let the creatures' movement synchronized with the time according to the
	 * updateInterval (when the time needed to finish all the movement is longer
	 * that the updateInterval, the movement will be greatly slowed)
	 */
	private void makeMove() {
		timeMore += new Date().getTime() - lastRefreshTime;
		for (int i = 0; i < timeMore / updateInterval; i++) {
			for (Creature c : map.getCreatureList()) {
				c.makeMove();
			}
		}
		timeMore = timeMore % updateInterval;
		lastRefreshTime = new Date().getTime();
	}

	private void paintAllStuff(Graphics g) {
		g.drawImage(background, 0, 0, MainFrame.frameSize.width, MainFrame.frameSize.height, this);
		map.paintMap(g);
		GamePanel.animation.paint(g);
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	/** ESSENTIAL!!!! */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintAllStuff(g);
		repaint();
	}
}
